package com.jmex.font3d.effects;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.jme.math.Vector2f;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.util.geom.BufferUtils;
import com.jmex.font3d.Font3D;
import com.jmex.font3d.Glyph3D;
import com.jmex.font3d.math.PlanarEdge;
import com.jmex.font3d.math.PlanarVertex;
import com.jmex.font3d.math.TriangulationVertex;

/**
 * This effect will add borders to all the glyphs.
 * 
 * Please be aware that this changes the geometry
 * by adding more vertices to every glyph, it does
 * not check if it has already been applied, hence
 * you can add the border multiple times.
 * 
 * After this effect has been applied we add the following
 * to the existing buffers according to enabled/disabled 
 * drawing in the font.
 * <h4>Vertices/Normals/Texcoords/VertexColors</h4>
 * <ul>
 * 	<li><i>n</i>*2 vertices used for the sides
 * 	<li><i>n</i>*2 vertices used for the front
 * 	<li><i>n</i>*2 vertices used for the back
 * </ul>
 * <h4>Indices</h4>
 * <ul>
 * 	<li><i>n</i>*6 indices for the sides (<i>n</i>*2 triangles)
 * 	<li><i>n</i>*6 indices for the front (<i>n</i>*2 triangles)
 * 	<li><i>n</i>*6 indices for the back (<i>n</i>*2 triangles)
 * </ul>
 * 
 * 
 * @author emanuel
 *
 */
public class Font3DBorder implements Font3DEffect
{	
	private ColorRGBA inner_color, outer_color;
	private float width;
	private boolean drawSides;
	private boolean drawFront;
	private boolean drawBack;

	/**
	 * The constructor.
	 * 
	 * @param width
	 * @param inner_color
	 * @param outer_color
	 * @param drawSides
	 * @param drawFront
	 * @param drawBack
	 */
	public Font3DBorder(float width, ColorRGBA inner_color, ColorRGBA outer_color, boolean drawSides, boolean drawFront, boolean drawBack)
	{
		this.inner_color = inner_color;
		this.outer_color = outer_color;
		this.width = width;
		this.drawSides = drawSides;
		this.drawFront = drawFront;
		this.drawBack  = drawBack;
	}

	/**
	 * Just a short-cut constructor, grabbing the side/front/back from the font.
	 * 
	 * @param width
	 * @param inner_color
	 * @param outer_color
	 * @param font
	 */
	public Font3DBorder(float width, ColorRGBA inner_color, ColorRGBA outer_color, Font3D font)
	{
		this(width, inner_color, outer_color, font.drawSides(), font.drawFront(), font.drawBack());
	}

	public void applyEffect(Font3D font)
	{
		boolean mesh_locked = font.isMeshLocked();
		if(mesh_locked)
		{
    		font.unlockMesh();
		}
		
		// Add the border to all the glyphs
		for(Glyph3D glyph : font.getGlyphs())
		{
			if(glyph != null && glyph.getBatch() != null && glyph.getBatch().getVertexCount() > 0)
			{
				applyEffect(font, glyph);
			}
		}
		
		// If any of the colors had alpha, add an alpha-state
		if(inner_color.a != 1 || outer_color.a != 1)
		{
			font.enableAlphaState();
		}
		
		if(mesh_locked)
		{
    		font.lockMesh();
		}
	}

	private void applyEffect(Font3D font, Glyph3D glyph3D)
	{
		// Calculate how much space we need
		int vcount = 0;
		int icount = 0;
		int numverts = glyph3D.getVertices().size();
		boolean has_vertex_colors = (glyph3D.getBatch().getColorBuffer() != null);
		if(drawSides)
		{
			vcount += numverts * 2;
			icount += numverts * 6;
		}
		if(drawFront)
		{
			vcount += numverts * 2;
			icount += numverts * 6;
		}
		if(drawBack)
		{
			vcount += numverts * 2;
			icount += numverts * 6;
		}
		// Allocate the buffers
		Vector3f verts[] = new Vector3f[vcount];
		Vector3f norms[] = new Vector3f[vcount];
		Vector2f texco[] = new Vector2f[vcount];
        IntBuffer triangles = BufferUtils.createIntBuffer(icount);
        ColorRGBA colors[] = has_vertex_colors ? new ColorRGBA[vcount] : null;
		
		// Set up some offsets
		int src_i_offset = glyph3D.getBatch().getVertexCount();
		int dst_v_offset = 0;
		
		if(drawSides)
		{
            for (TriangulationVertex v : glyph3D.getVertices()) {
            	Vector3f normal = glyph3D.getOutlineNormals()[v.getIndex()];
                norms[dst_v_offset + v.getIndex()] = normal;
                verts[dst_v_offset + v.getIndex()] = new Vector3f(normal).multLocal(width).addLocal(v.getPoint());
                verts[dst_v_offset + v.getIndex()].z += 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex()] = outer_color;
                }
                
                norms[dst_v_offset + v.getIndex() + numverts] = normal;
                verts[dst_v_offset + v.getIndex() + numverts] = new Vector3f(normal).multLocal(width).addLocal(v.getPoint());
                verts[dst_v_offset + v.getIndex() + numverts].z -= 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex() + numverts] = outer_color;
                }
            }
            dst_v_offset += numverts * 2;

            // Add indices
            for (PlanarEdge e : glyph3D.getOutline()) {
                if (!e.isRealEdge())
                    continue;
                PlanarVertex src = e.getOrigin();
                PlanarVertex dst = e.getDestination();
                int v1 = src_i_offset + src.getIndex();
                int v2 = src_i_offset + dst.getIndex();
                int v3 = src_i_offset + dst.getIndex() + numverts;
                int v4 = src_i_offset + src.getIndex() + numverts;
                triangles.put(new int[] { v1, v3, v2, v3, v1, v4 });
            }
            src_i_offset += numverts * 2;
		}
		if(drawFront)
		{
            Vector3f frontnormal = new Vector3f(0, 0, 1);
            for (TriangulationVertex v : glyph3D.getVertices()) {
            	Vector3f normal = glyph3D.getOutlineNormals()[v.getIndex()];
                norms[dst_v_offset + v.getIndex()] = frontnormal;
                verts[dst_v_offset + v.getIndex()] = new Vector3f(v.getPoint());
                verts[dst_v_offset + v.getIndex()].z += 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex()] = inner_color;
                }
                
                // The extruded point
                norms[dst_v_offset + v.getIndex() + numverts] = frontnormal; 
                verts[dst_v_offset + v.getIndex() + numverts] = new Vector3f(normal).multLocal(width).addLocal(v.getPoint());
                verts[dst_v_offset + v.getIndex() + numverts].z += 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex() + numverts] = outer_color;
                }
            }
            dst_v_offset += numverts * 2;
            
            // Add indices
            for (PlanarEdge e : glyph3D.getOutline()) {
                if (!e.isRealEdge())
                    continue;
                PlanarVertex src = e.getOrigin();
                PlanarVertex dst = e.getDestination();
                int v1 = src_i_offset + src.getIndex();
                int v2 = src_i_offset + dst.getIndex();
                int v3 = src_i_offset + dst.getIndex() + numverts;
                int v4 = src_i_offset + src.getIndex() + numverts;
                triangles.put(new int[] { v1, v3, v2, v3, v1, v4 });
            }
            src_i_offset += numverts * 2;
		}
		if(drawBack)
		{
            Vector3f frontnormal = new Vector3f(0, 0, 1);
            for (TriangulationVertex v : glyph3D.getVertices()) {
            	Vector3f normal = glyph3D.getOutlineNormals()[v.getIndex()];
                norms[dst_v_offset + v.getIndex()] = frontnormal;
                verts[dst_v_offset + v.getIndex()] = new Vector3f(v.getPoint());
                verts[dst_v_offset + v.getIndex()].z -= 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex()] = inner_color;
                }
                
                // The extruded point
                norms[dst_v_offset + v.getIndex() + numverts] = frontnormal; 
                verts[dst_v_offset + v.getIndex() + numverts] = new Vector3f(normal).multLocal(width).addLocal(v.getPoint());
                verts[dst_v_offset + v.getIndex() + numverts].z -= 0.5f;
                if(has_vertex_colors)
                {
                	colors[dst_v_offset + v.getIndex() + numverts] = outer_color;
                }
            }
            dst_v_offset += numverts * 2;
            
            // Add indices
            for (PlanarEdge e : glyph3D.getOutline()) {
                if (!e.isRealEdge())
                    continue;
                PlanarVertex src = e.getOrigin();
                PlanarVertex dst = e.getDestination();
                int v1 = src_i_offset + src.getIndex();
                int v2 = src_i_offset + dst.getIndex();
                int v3 = src_i_offset + dst.getIndex() + numverts;
                int v4 = src_i_offset + src.getIndex() + numverts;
                triangles.put(new int[] { v1, v2, v3, v1, v3, v4 });
            }
            src_i_offset += numverts * 2;
		}
		
        // Set the texture coords to the vertex coords (in X/Y plane)
        for(int i = 0;i < verts.length; i++)
        {
            texco[i] = new Vector2f(verts[i].x, verts[i].y);
        }

		// Extend the current buffers with our additions.
        {
        	// Indexes
        	IntBuffer indexbuffer = BufferUtils.createIntBuffer(glyph3D.getBatch().getIndexBuffer().capacity() + icount);
        	indexbuffer.rewind();
        	glyph3D.getBatch().getIndexBuffer().rewind();
        	triangles.rewind();
        	indexbuffer.put(glyph3D.getBatch().getIndexBuffer());
        	indexbuffer.put(triangles);
        	glyph3D.getBatch().setIndexBuffer(indexbuffer);
        	
        	// Vertices
        	FloatBuffer vertbuffer = BufferUtils.createFloatBuffer(glyph3D.getBatch().getVertexBuffer().capacity() + vcount * 3);
        	vertbuffer.rewind();
        	glyph3D.getBatch().getVertexBuffer().rewind();
        	vertbuffer.put(glyph3D.getBatch().getVertexBuffer());
        	putInBuffer(vertbuffer, verts);
        	glyph3D.getBatch().setVertexBuffer(vertbuffer);
        	
        	// Normals
        	FloatBuffer normbuffer = BufferUtils.createFloatBuffer(glyph3D.getBatch().getNormalBuffer().capacity() + vcount * 3);
        	normbuffer.rewind();
        	glyph3D.getBatch().getNormalBuffer().rewind();
        	normbuffer.put(glyph3D.getBatch().getNormalBuffer());
        	putInBuffer(normbuffer, norms);
        	glyph3D.getBatch().setNormalBuffer(normbuffer);
        	
        	// Texture Coordinates
        	FloatBuffer texbuffer = BufferUtils.createFloatBuffer(glyph3D.getBatch().getTextureBuffer(0).capacity() + vcount * 2);
        	texbuffer.rewind();
        	glyph3D.getBatch().getTextureBuffer(0).rewind();
        	texbuffer.put(glyph3D.getBatch().getTextureBuffer(0));
        	putInBuffer(texbuffer, texco);
        	glyph3D.getBatch().setTextureBuffer(texbuffer, 0);
        	
        	// Vertex Colors
        	if(has_vertex_colors)
        	{
            	FloatBuffer colorbuffer = BufferUtils.createFloatBuffer(glyph3D.getBatch().getColorBuffer().capacity() + vcount * 4);
            	colorbuffer.rewind();
            	glyph3D.getBatch().getColorBuffer().rewind();
            	colorbuffer.put(glyph3D.getBatch().getColorBuffer());
        		putInBuffer(colorbuffer, colors);
            	glyph3D.getBatch().setColorBuffer(colorbuffer);
        	}
        }
	}

	private static void putInBuffer(FloatBuffer buffer, ColorRGBA[] colors)
	{
		for(ColorRGBA color : colors)
		{
			buffer.put(color.r);
			buffer.put(color.g);
			buffer.put(color.b);
			buffer.put(color.a);
		}
	}

	private static void putInBuffer(FloatBuffer buffer, Vector2f[] vecs)
	{
		for(Vector2f v : vecs)
		{
			buffer.put(v.x);
			buffer.put(v.y);
		}
	}

	private static void putInBuffer(FloatBuffer buffer, Vector3f[] vecs)
	{
		for(Vector3f v : vecs)
		{
			buffer.put(v.x);
			buffer.put(v.y);
			buffer.put(v.z);
		}
	}
}
