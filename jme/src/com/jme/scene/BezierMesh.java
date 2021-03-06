/*
 * Copyright (c) 2003-2006 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors 
 *   may be used to endorse or promote products derived from this software 
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jme.scene;

import java.io.IOException;
import java.nio.FloatBuffer;

import com.jme.math.Vector3f;
import com.jme.scene.batch.TriangleBatch;
import com.jme.system.JmeException;
import com.jme.util.export.InputCapsule;
import com.jme.util.export.JMEExporter;
import com.jme.util.export.JMEImporter;
import com.jme.util.export.OutputCapsule;
import com.jme.util.geom.BufferUtils;

/**
 * <code>BezierMesh</code> is defined by a collection of
 * <code>BezierPatch</code> objects that define a 4x4 patch of control
 * anchors. These anchors define the curve the surface of the mesh will take.
 * The patch also contains information about it's detail level, which defines
 * how smooth the mesh will be.
 * 
 * @author Mark Powell
 * @version $Id: BezierMesh.java,v 1.20 2006/06/21 20:33:03 nca Exp $
 */
public class BezierMesh extends TriMesh {

	private static final long serialVersionUID = 1L;

	private BezierPatch patch;
    
    public BezierMesh() {}

	/**
	 * Constructor creates a default <code>BezierMesh</code> object.
	 * 
	 * @param name
	 *            the name of the scene element. This is required for
	 *            identification and comparision purposes.
	 */
	public BezierMesh(String name) {
		super(name);
	}

	/**
	 * Constructor creates a new <code>BezierMesh</code> object with the given
	 * <code>BezierPatch</code>. The mesh is then automatically tessellated.
	 * 
	 * @param name
	 *            the name of the scene element. This is required for
	 *            identification and comparision purposes.
	 * @param patch
	 *            the <code>BezierPatch</code> used to define this mesh.
	 */
	public BezierMesh(String name, BezierPatch patch) {
		super(name);
		this.patch = patch;
		tessellate();
	}

	/**
	 * 
	 * <code>setPatch</code> sets the <code>BezierPatch</code> of the mesh.
	 * It is then tessellated.
	 * 
	 * @param patch
	 *            the patch to use for this mesh.
	 */
	public void setPatch(BezierPatch patch) {
		this.patch = patch;
		tessellate();
	}

	/**
	 * 
	 * <code>tessellate</code> generates the <code>BezierMesh</code>
	 * vertices from the supplied patch and detail level. This method is called
	 * when patch is set, and therefore, should normally have to be called.
	 * However, if patch is changed externally, and you wish to update the mesh,
	 * a call to <code>tessellate</code> is appropriate.
	 *  
	 */
	public void tessellate() {
		if (patch == null) {
			return;
		}
        TriangleBatch tb = getBatch(0);

        int u = 0, v;
		float py, px, pyold;
		int detailLevel = patch.getDetailLevel();

		Vector3f[] temp = new Vector3f[4];
		Vector3f[] last = new Vector3f[detailLevel + 1];

		temp[0] = patch.getAnchor(0, 3);
		temp[1] = patch.getAnchor(1, 3);
		temp[2] = patch.getAnchor(2, 3);
		temp[3] = patch.getAnchor(3, 3);

		for (v = 0; v <= detailLevel; v++) {
			px = ((float) v) / ((float) detailLevel);
			last[v] = calcBerstein(px, temp);
		}

		u = 1;
		tb.setVertexCount(((detailLevel * 2) + 2) * detailLevel);
		tb.setVertexBuffer(BufferUtils.createVector3Buffer(tb.getVertexCount()));
		tb.getTextureBuffers().set(0,BufferUtils.createVector2Buffer(tb.getVertexCount()));
		tb.setNormalBuffer(BufferUtils.createVector3Buffer(tb.getVertexCount()));

		tb.setTriangleQuantity(detailLevel * detailLevel * 6);
		tb.setIndexBuffer(BufferUtils.createIntBuffer(tb.getTriangleCount() * 3));

		tb.getVertexBuffer().clear();
        FloatBuffer src = tb.getTextureBuffers().get(0);
		src.clear();
		for (u = 1; u <= detailLevel; u++) {
			py = ((float) u) / ((float) detailLevel);
			pyold = (u - 1.0f) / (detailLevel);
			temp[0] = calcBerstein(py, patch.getAnchors()[0]);
			temp[1] = calcBerstein(py, patch.getAnchors()[1]);
			temp[2] = calcBerstein(py, patch.getAnchors()[2]);
			temp[3] = calcBerstein(py, patch.getAnchors()[3]);

			for (v = 0; v <= detailLevel; v++) {
				px = ((float) v) / ((float) detailLevel);
				src.put(pyold).put(px);
				tb.getVertexBuffer().put(last[v].x).put(last[v].y).put(last[v].z);
				last[v] = calcBerstein(px, temp);
				src.put(py).put(px);
				tb.getVertexBuffer().put(last[v].x).put(last[v].y).put(last[v].z);
			}

		}

		int index = -1;
		for (int i = 0; i < tb.getTriangleCount(); i = i + 6) {

			index++;
			if (i > 0 && i % (detailLevel * 6) == 0) {
				index += 1;
			}

			tb.getIndexBuffer().put(2 * index);
			tb.getIndexBuffer().put((2 * index) + 1);
			tb.getIndexBuffer().put((2 * index) + 2);

			tb.getIndexBuffer().put((2 * index) + 3);
			tb.getIndexBuffer().put((2 * index) + 2);
			tb.getIndexBuffer().put((2 * index) + 1);
		}

        tb.setNormalBuffer(BufferUtils.createVector3Buffer(tb.getVertexCount()));
        Vector3f oppositePoint = new Vector3f();
        Vector3f adjacentPoint = new Vector3f();
        Vector3f rootPoint = new Vector3f();
        Vector3f tempNorm = new Vector3f();
        int adj = 0, opp = 0, normalIndex = 0;
		for (int i = 0; i < detailLevel; i++) {
			for (int j = 0; j < (detailLevel * 2) + 2; j++) {
                BufferUtils.populateFromBuffer(rootPoint, tb.getVertexBuffer(), normalIndex);
				if (j % 2 == 0) {
					if (i == 0) {
						if (j < (detailLevel * 2)) {
							//right cross up
	                        adj = normalIndex+1;
	                        opp = normalIndex+2;
						} else {
							//down cross right
	                        adj = normalIndex-1;
	                        opp = normalIndex+1;
						}
					} else {
					    int ind = normalIndex - (detailLevel * 2 + 1);
					    tb.getNormalBuffer().rewind();
					    tempNorm.x = tb.getNormalBuffer().get(ind*3);
					    tempNorm.y = tb.getNormalBuffer().get(ind*3+1);
					    tempNorm.z = tb.getNormalBuffer().get(ind*3+2);
					    tempNorm.normalizeLocal();
					    BufferUtils.setInBuffer(tempNorm, tb.getNormalBuffer(), normalIndex);
						normalIndex++;
					    continue;
					}
				} else {
					if (j < (detailLevel * 2) + 1) {
						//up cross left
                        adj = normalIndex+2;
                        opp = normalIndex-1;
					} else {
						//left cross down
                        adj = normalIndex-1;
                        opp = normalIndex-2;
					}
				}
                BufferUtils.populateFromBuffer(adjacentPoint, tb.getVertexBuffer(), adj);
                BufferUtils.populateFromBuffer(oppositePoint, tb.getVertexBuffer(), opp);
                tempNorm.set(adjacentPoint)
	                .subtractLocal(rootPoint)
	                .crossLocal(oppositePoint.subtractLocal(rootPoint))
	                .normalizeLocal();
			    BufferUtils.setInBuffer(tempNorm, tb.getNormalBuffer(), normalIndex);
				normalIndex++;
			}
		}
	}

	/**
	 * 
	 * <code>calcBerstein</code> calculates the Berstein number for the given
	 * u and control points.
	 * 
	 * @param u
	 *            the u value.
	 * @param p
	 *            the control points.
	 * @return the Berstein number.
	 */
	private Vector3f calcBerstein(float u, Vector3f[] p) {
		if (p.length != 4) {
			throw new JmeException("Point parameter must be length 4.");
		}
		Vector3f a = p[0].mult((float) Math.pow(u, 3));
		Vector3f b = p[1].mult(3 * (float) Math.pow(u, 2) * (1 - u));
		Vector3f c = p[2].mult(3 * u * (float) Math.pow((1 - u), 2));
		Vector3f d = p[3].mult((float) Math.pow((1 - u), 3));

		return (a.addLocal(b)).addLocal((c.addLocal(d)));
	}
    
    public void write(JMEExporter e) throws IOException {
        super.write(e);
        OutputCapsule capsule = e.getCapsule(this);
        capsule.write(patch, "patch", null);
    }

    public void read(JMEImporter e) throws IOException {
        super.read(e);
        InputCapsule capsule = e.getCapsule(this);
        patch = (BezierPatch)capsule.readSavable("patch", null);
    }
}