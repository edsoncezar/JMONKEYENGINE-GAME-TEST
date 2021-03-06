package com.jme.util;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.IdentityHashMap;

import com.jme.light.DirectionalLight;
import com.jme.light.Light;
import com.jme.light.PointLight;
import com.jme.light.SpotLight;
import com.jme.math.FastMath;
import com.jme.math.Matrix3f;
import com.jme.math.Quaternion;
import com.jme.math.Vector2f;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.Controller;
import com.jme.scene.Geometry;
import com.jme.scene.Node;
import com.jme.scene.Spatial;
import com.jme.scene.batch.GeomBatch;
import com.jme.scene.batch.SharedBatch;
import com.jme.scene.batch.TriangleBatch;
import com.jme.scene.state.LightState;
import com.jme.scene.state.RenderState;
import com.jme.util.export.JMEExporter;
import com.jme.util.export.JMEImporter;
import com.jme.util.geom.BufferUtils;

public class BumpMapColorController extends Controller {

    private static final long serialVersionUID = 1L;

    private transient IdentityHashMap<TriangleBatch, BumpStore> store;
    private Spatial attachedTo = null;
    private boolean usePerVertex = true;
    private boolean invertY = true;

    private static Vector3f vert = new Vector3f();
    
    public BumpMapColorController() { 
        store = new IdentityHashMap<TriangleBatch, BumpStore>();        
    }
    
    public BumpMapColorController(Spatial attachedTo) {
        this.attachedTo = attachedTo;
        store = new IdentityHashMap<TriangleBatch, BumpStore>();
    }
    
    protected void add(TriangleBatch toManage) {
        if (toManage == null) return;
        if (store.get(toManage) == null) {
            BumpStore bs = generateBumpStore(toManage);
            store.put(toManage, bs);
        }
    }
    
    protected void updateBatchList() {
        if (attachedTo instanceof Node) {
            addChildrensBatches((Node)attachedTo);
        } else if (attachedTo instanceof Geometry) {
            addBatches((Geometry)attachedTo);
        }
    }
    
    protected void addChildrensBatches(Node parent) {
        if (parent == null) return;
        for (int x = parent.getQuantity(); --x >= 0; ) {
            Spatial child = parent.getChild(x);
            if (child instanceof Node) {
                addChildrensBatches((Node)child);
            } else if (child instanceof Geometry) {
                addBatches((Geometry)child);
            }
        }
    }

    protected void addBatches(Geometry geom) {
        if (geom == null) return;
        
        for (int x = geom.getBatchCount(); --x >= 0; ) {
            GeomBatch batch = geom.getBatch(x);
            if (batch instanceof TriangleBatch)
                add((TriangleBatch)batch);
        }
    }

    public void update(float time) {
        updateBatchList(); // XXX: would be nice to do this reactively
        
        for (TriangleBatch batch : store.keySet()) {
                        
            boolean keepGoing = false;
            BumpStore bs = store.get(batch);
            if (bs.verts.length != batch.getVertexCount()) {
                BumpStore newBS = generateBumpStore(batch);
                bs.verts = newBS.verts;
                
            }
            
            if (!bs.oldTrans.equals(batch.getParentGeom().getWorldTranslation()) || 
                    !bs.oldRot.equals(batch.getParentGeom().getWorldRotation()) ||
                    !bs.oldScale.equals(batch.getParentGeom().getWorldScale())) {
                keepGoing = true;
                bs.oldTrans.set(batch.getParentGeom().getWorldTranslation());
                bs.oldRot.set(batch.getParentGeom().getWorldRotation());
                bs.oldScale.set(batch.getParentGeom().getWorldScale());
            }
            
            // Ok, grab the first light on the batch:
            LightState ls = (LightState)batch.states[RenderState.RS_LIGHT];
            if (ls == null || ls.getQuantity() < 1 || ls.get(0) == null) continue;
            
            Light l = ls.get(0);
            
            if (!keepGoing) {
                Light oldLight = store.get(batch).oldLight;
                if (oldLight != null && l.getType() == oldLight.getType()) {
                    switch (l.getType()) {
                        case Light.LT_DIRECTIONAL:
                            if (((DirectionalLight) oldLight).getDirection()
                                    .equals(((DirectionalLight) l).getDirection())) {
                                continue;
                            }
                            break;
                        case Light.LT_SPOT:
                            if (((SpotLight) oldLight).getDirection()
                                    .equals(((SpotLight) l).getDirection()) &&
                                    ((SpotLight) oldLight).getLocation()
                                    .equals(((SpotLight) l).getLocation())) {
                                continue;
                            }
                            break;
                        case Light.LT_POINT:
                            if (((PointLight) oldLight).getLocation()
                                    .equals(((PointLight) l).getLocation())) {
                                continue;
                            }
                            break;
                    }
                } else {
                    Light newLight;
                    switch (l.getType()) {
                        case Light.LT_DIRECTIONAL:
                            newLight = new DirectionalLight();
                            ((DirectionalLight) newLight).getDirection().set(
                                    ((DirectionalLight) l).getDirection());
                            break;
                        case Light.LT_SPOT:
                            newLight = new SpotLight();
                            ((SpotLight) newLight).getLocation().set(
                                    ((SpotLight) l).getLocation());
                            ((SpotLight) newLight).getDirection().set(
                                    ((SpotLight) l).getDirection());
                            break;
                        case Light.LT_POINT:
                        default:
                            newLight = new PointLight();
                            ((PointLight) newLight).getLocation().set(
                                    ((PointLight) l).getLocation());
                            break;
                    }
                    store.get(batch).oldLight = newLight;
                }
            }

            FloatBuffer verts = batch.getVertexBuffer();
            FloatBuffer colors = batch.getColorBuffer();
            if (colors == null) {
                if (batch instanceof SharedBatch)
                    ((SharedBatch)batch).getTarget().setSolidColor(ColorRGBA.white.clone());
                else
                    batch.setSolidColor(ColorRGBA.white.clone());
                colors = batch.getColorBuffer();
            }

            // now we need to go through each vertex in the batch and replace the
            // color component with the light vector.
            Vector3f lVect = null;
            switch (l.getType()) {
                case Light.LT_DIRECTIONAL:
                    lVect = new Vector3f(((DirectionalLight)l).getDirection());
                    lVect.negateLocal();
                    break;
                case Light.LT_POINT:
                    lVect = new Vector3f(((PointLight)l).getLocation());
                    lVect.subtractLocal(batch.getParentGeom().getWorldTranslation());
                    break;
                case Light.LT_SPOT:
                    lVect = new Vector3f(((SpotLight)l).getLocation());
                    lVect.subtractLocal(batch.getParentGeom().getWorldTranslation());
                    break;
            }

            if (l.getType() != Light.LT_DIRECTIONAL) {
                batch.getParentGeom().worldToLocal(lVect, lVect);
            } else {
                lVect.divideLocal(batch.getParentGeom().getWorldScale());
                batch.getParentGeom().getWorldRotation().inverse().mult(lVect, lVect);
            }
            
            vert.set(lVect);
            for (int y = 0, maxY = batch.getVertexCount(); y < maxY; y++) {
                if (l.getType() != Light.LT_DIRECTIONAL) {
                    BufferUtils.populateFromBuffer(vert, verts, y);
                    batch.getParentGeom().localToWorld(vert, vert);
                    vert.negateLocal();
                    vert.addLocal(lVect);
                } else {
                    vert.set(lVect);                    
                }
                toModelSpace(vert, bs, y);
                setWorkingColor(vert);
                BufferUtils.setInBuffer(workingColor, colors, y);
            }
        }
    }

    private void toModelSpace(Vector3f vertex, BumpStore bs, int y) {
        vertex.normalizeLocal();
        Matrix3f rot = bs.verts[y].tbnMatrix;
        rot.multLocal(vertex);
    }

    private static ColorRGBA workingColor = new ColorRGBA();
    private void setWorkingColor(Vector3f lightVector) {
        workingColor.r = 0.5f*(lightVector.x+1.0f);
        workingColor.g = 0.5f*(lightVector.y+1.0f);
        workingColor.b = 0.5f*(lightVector.z+1.0f);
    }

    public Spatial getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(Spatial attachedTo) {
        this.attachedTo = attachedTo;
    }
    
    @Override
    public void write(JMEExporter e) throws IOException {
        super.write(e);
        e.getCapsule(this).write(attachedTo, "attachedTo", null);
    }
    
    @Override
    public void read(JMEImporter e) throws IOException {
        super.read(e);
        e.getCapsule(this).readSavable("attachedTo", null);
    }

    private BumpStore generateBumpStore(TriangleBatch batch) {
        if (batch == null) return null;
        
        BumpStore rVal = new BumpStore();
        
        rVal.verts = new BumpVert[batch.getVertexCount()];
        
        Vector3f tangent;
        Vector3f binormal;
        
        
        Vector3f[] norms = BufferUtils.getVector3Array(batch.getNormalBuffer());
        Vector3f[] tangents = new Vector3f[norms.length];
        Vector3f[] binorms = new Vector3f[norms.length];
        int[] counts = new int[norms.length];

        int[] triVerts = new int[3];
        for (int i = 0; i < batch.getTriangleCount(); i++) {
            batch.getTriangle(i, triVerts);
            for (int x = 0; x < 3; x++) {
                
                int x2 = (x == 0) ? 2 : x - 1;
                int x1 = (x + 1) % 3;
                
                int index = triVerts[x];
                int index1 = triVerts[x1];
                int index2 = triVerts[x2];
                counts[index]++;
                tangent = generateTangent(getTexCoord(index, batch),
                        getTexCoord(index1, batch), getTexCoord(index2, batch),
                        getVertex(index, batch), getVertex(index1, batch),
                        getVertex(index2, batch));
                if (tangent != null) {
                    tangent.subtractLocal(norms[index].mult(norms[index].dot(tangent)));
                    tangent.normalizeLocal();
                    binormal = norms[index].cross(tangent);
    
                    if (tangents[index] == null) tangents[index] = new Vector3f();
                    else {
                        tangents[index].multLocal(counts[index]-1);
                    }
                    tangents[index].addLocal(tangent).divideLocal(counts[index]);
    
                    if (binorms[index] == null) binorms[index] = new Vector3f();
                    else {
                        binorms[index].multLocal(counts[index]-1);
                    }
                    binorms[index].addLocal(binormal).divideLocal(counts[index]);
                }
            }
        }
        
        for (int x = 0; x < rVal.verts.length; x++) {
            rVal.verts[x] = new BumpVert();
            Matrix3f tbn = rVal.verts[x].tbnMatrix;
            tbn.setRow(0, tangents[x]);
            if (binorms[x] != null) {
            	if (invertY) {
            		tbn.setRow(1, binorms[x].negateLocal());
            	} else {
            		tbn.setRow(1, binorms[x]);
            	}
            }
            tbn.setRow(2, norms[x]);
        }
        
        return rVal;
    }
    
    private Vector3f getVertex(int index, TriangleBatch batch) {
        Vector3f vert = new Vector3f();
        BufferUtils.populateFromBuffer(vert, batch.getVertexBuffer(), index);
        return vert;
    }

    private Vector2f getTexCoord(int index, TriangleBatch batch) {
        Vector2f tc = new Vector2f();
        BufferUtils.populateFromBuffer(tc, batch.getTextureBuffer(0), index);
        return tc;
    }

    private Vector3f generateTangent(Vector2f uv0, Vector2f uv1, Vector2f uv2, Vector3f p0, Vector3f p1, Vector3f p2) {
        Vector3f result = new Vector3f();
        Vector3f temp = new Vector3f();
        
        result.set(p2).subtractLocal(p0);
        temp.set(p1).subtractLocal(p0);
        
        boolean degen = false;
        
        if (FastMath.abs(result.length()) < FastMath.ZERO_TOLERANCE
                || FastMath.abs(temp.length()) < FastMath.ZERO_TOLERANCE) {
            degen = true;
        } else {
            float v1m0 = uv1.y - uv0.y;
            float u1m0 = uv1.x - uv0.x;

            if (FastMath.abs(v1m0) < FastMath.ZERO_TOLERANCE) {
                // The triangle effectively has no variation in the v
                // texture coordinate.
                if (FastMath.abs(u1m0) < FastMath.ZERO_TOLERANCE) {
                    // The triangle effectively has no variation in the u
                    // coordinate. Since the texture coordinates do not
                    // effectively vary on this triangle, treat it as a
                    // degenerate parametric surface.
                    degen = true;
                } else {
                    // The variation is effectively all in u, so set the
                    // tangent T = dP/du.
                    return temp.divideLocal(u1m0);
                }
            } else {
                // difference of surface parameters along triangle edge
                float v2m0 = uv2.y - uv0.y;
                float u2m0 = uv2.x - uv0.x;
                float det = (v1m0*u2m0) - (v2m0*u1m0);
                
                if (FastMath.abs(det) >= FastMath.ZERO_TOLERANCE) {
                    // The triangle vertices form three collinear points
                    // in parameter space, so
                    // dP/du = (dv1*dP2-dv2*dP1)/(dv1*du2-dv2*du1)
                    result.multLocal(v1m0);
                    temp.multLocal(v2m0);
                    result.subtractLocal(temp).divideLocal(det);
                    return result;
                } 
                    
                // The triangle vertices are collinear in parameter
                // space.
                degen = true;                
            }
        }

        if (degen) {
            return null;
        }
                
        return result;
    }

    class BumpStore {
        Light oldLight = null;
        BumpVert[] verts = null;
        Vector3f oldTrans = new Vector3f();
        Quaternion oldRot = new Quaternion();
        Vector3f oldScale = new Vector3f();
    }
    
    class BumpVert {
        Matrix3f tbnMatrix = new Matrix3f();
    }

    public boolean isUsePerVertex() {
        return usePerVertex;
    }

    public void setUsePerVertex(boolean usePerVertex) {
        this.usePerVertex = usePerVertex;
    }
    
    /**
	 * @return <code>true</code>, if the Y axis of the bump map texture
	 *         (green channel) is interpreted as inverted
	 */
    public boolean isInvertY() {
    	return invertY;
    }
    
    /**
	 * Defines whether the Y axis of the bump map texture (green channel) should
	 * be interpreted as inverted. Default is <code>true</code>
	 * 
	 * @param invertY
	 *            <code>true</code> to invert the Y axis
	 */
    public void setInvertY(boolean invertY) {
    	this.invertY = invertY;
    }
}
