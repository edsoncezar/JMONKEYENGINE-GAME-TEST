/*
 * Copyright (c) 2003-2008 jMonkeyEngine
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

package com.jme.renderer.lwjgl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.ARBDrawBuffers;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import com.jme.image.Texture;
import com.jme.math.FastMath;
import com.jme.math.Vector3f;
import com.jme.renderer.Camera;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.RenderContext;
import com.jme.renderer.TextureRenderer;
import com.jme.scene.Spatial;
import com.jme.scene.state.RenderState;
import com.jme.scene.state.lwjgl.LWJGLTextureState;
import com.jme.scene.state.lwjgl.records.TextureRecord;
import com.jme.scene.state.lwjgl.records.TextureStateRecord;
import com.jme.system.DisplaySystem;
import com.jme.util.TextureManager;
import com.jme.util.geom.BufferUtils;

/**
 * This class is used by LWJGL to render textures. Users should <b>not </b>
 * create this class directly. Instead, allow DisplaySystem to create it for
 * you.
 * 
 * @author Joshua Slack, Mark Powell
 * @version $Id: LWJGLTextureRenderer.java,v 1.53 2008/04/19 16:49:19 renanse Exp $
 * @see com.jme.system.DisplaySystem#createTextureRenderer
 */
public class LWJGLTextureRenderer implements TextureRenderer {
    private static final Logger logger = Logger.getLogger(LWJGLTextureRenderer.class.getName());

    private LWJGLCamera camera;

    private ColorRGBA backgroundColor = new ColorRGBA(1, 1, 1, 1);

    private int active, fboID, depthRBID, width, height;

    private static boolean inited = false;
    private static boolean isSupported = true;
    private static boolean supportsMultiDraw = false;
    private static int maxDrawBuffers = 1;
    private static IntBuffer attachBuffer = null;
    private int currentReadBuffer = EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT; // GL default
    private int currentDrawBuffer = EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT; // GL default
	private int drawBuffers = 1;
	private boolean usingDepthRB = false;

    private LWJGLRenderer parentRenderer;


    public LWJGLTextureRenderer(int width, int height,
            LWJGLRenderer parentRenderer) {
        
    	if (!inited) {
    		isSupported = GLContext.getCapabilities().GL_EXT_framebuffer_object;
    		supportsMultiDraw = GLContext.getCapabilities().GL_ARB_draw_buffers;
    		if (supportsMultiDraw) {
    			IntBuffer buf = BufferUtils.createIntBuffer(16);
                GL11.glGetInteger(EXTFramebufferObject.GL_MAX_COLOR_ATTACHMENTS_EXT, buf);
                maxDrawBuffers = buf.get(0);
                if (maxDrawBuffers > 1) {
                	attachBuffer = BufferUtils.createIntBuffer(maxDrawBuffers);
                    for (int i = 0; i < maxDrawBuffers; i++) {
                    	attachBuffer.put(EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT+i);
                    }

                } else {
                	maxDrawBuffers = 1;
                }
    		}
	        if (!isSupported) {
	            logger.warning("FBO not supported.");
	            return;
	        } else {
	            logger.info("FBO support detected.");
	        }
    	}

        if (!GLContext.getCapabilities().GL_ARB_texture_non_power_of_two) {
            // Check if we have non-power of two sizes. If so,
            // find the smallest power of two size that is greater than
            // the provided size.
            if (!FastMath.isPowerOfTwo(width)) {
                int newWidth = 2;
                do {
                    newWidth <<= 1;
    
                } while (newWidth < width);
                width = newWidth;
            }
    
            if (!FastMath.isPowerOfTwo(height)) {
                int newHeight = 2;
                do {
                    newHeight <<= 1;
    
                } while (newHeight < height);
                height = newHeight;
            }
        }
        
        IntBuffer buffer = BufferUtils.createIntBuffer(1);
        EXTFramebufferObject.glGenFramebuffersEXT( buffer ); // generate id
        fboID = buffer.get(0);
        
        if (fboID <= 0) {
            logger.severe("Invalid FBO id returned! " + fboID);
            isSupported = false;
            return;
        }

        EXTFramebufferObject.glGenRenderbuffersEXT( buffer ); // generate id
        depthRBID = buffer.get(0);
        EXTFramebufferObject.glBindRenderbufferEXT(
                EXTFramebufferObject.GL_RENDERBUFFER_EXT, depthRBID);
        EXTFramebufferObject.glRenderbufferStorageEXT(
                EXTFramebufferObject.GL_RENDERBUFFER_EXT,
                GL11.GL_DEPTH_COMPONENT, width, height);
        
        this.width = width;
        this.height = height;
        
        this.parentRenderer = parentRenderer;
        initCamera();
    }

    /**
     * 
     * <code>isSupported</code> obtains the capability of the graphics card.
     * If the graphics card does not have pbuffer support, false is returned,
     * otherwise, true is returned. TextureRenderer will not process any scene
     * elements if pbuffer is not supported.
     * 
     * @return if this graphics card supports pbuffers or not.
     */
    public boolean isSupported() {
        return isSupported;
    }

    /**
     * <code>getCamera</code> retrieves the camera this renderer is using.
     * 
     * @return the camera this renderer is using.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * <code>setCamera</code> sets the camera this renderer should use.
     * 
     * @param camera
     *            the camera this renderer should use.
     */
    public void setCamera(Camera camera) {

        this.camera = (LWJGLCamera) camera;
    }

    /**
     * <code>setBackgroundColor</code> sets the OpenGL clear color to the
     * color specified.
     * 
     * @see com.jme.renderer.TextureRenderer#setBackgroundColor(com.jme.renderer.ColorRGBA)
     * @param c
     *            the color to set the background color to.
     */
    public void setBackgroundColor(ColorRGBA c) {
        // if color is null set background to white.
        if (c == null) {
            backgroundColor.a = 1.0f;
            backgroundColor.b = 1.0f;
            backgroundColor.g = 1.0f;
            backgroundColor.r = 1.0f;
        } else {
            backgroundColor = c;
        }
    }

    /**
     * <code>getBackgroundColor</code> retrieves the clear color of the
     * current OpenGL context.
     * 
     * @see com.jme.renderer.Renderer#getBackgroundColor()
     * @return the current clear color.
     */
    public ColorRGBA getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * <code>setupTexture</code> initializes a new Texture object for use with
     * TextureRenderer. Generates a valid gl texture id for this texture and
     * inits the data type for the texture.
     */
    public void setupTexture(Texture tex) {
        
        if (!isSupported) {
            return;
        }

        IntBuffer ibuf = BufferUtils.createIntBuffer(1);

        if (tex.getTextureId() != 0) {
            ibuf.put(tex.getTextureId());
            GL11.glDeleteTextures(ibuf);
            ibuf.clear();
        }

        // Create the texture
        GL11.glGenTextures(ibuf);
        tex.setTextureId(ibuf.get(0));
        TextureManager.registerForCleanup(tex.getTextureKey(), tex.getTextureId());

        LWJGLTextureState.doTextureBind(tex.getTextureId(), 0);
        
        int format = GL11.GL_RGBA;
        switch (tex.getRTTSource()) {
            case Texture.RTT_SOURCE_RGBA: break;
            case Texture.RTT_SOURCE_RGB: format = GL11.GL_RGB; break;
            case Texture.RTT_SOURCE_ALPHA: format = GL11.GL_ALPHA; break;
            case Texture.RTT_SOURCE_DEPTH: format = GL11.GL_DEPTH_COMPONENT; break;
            case Texture.RTT_SOURCE_INTENSITY: format = GL11.GL_INTENSITY; break;
            case Texture.RTT_SOURCE_LUMINANCE: format = GL11.GL_LUMINANCE; break;
            case Texture.RTT_SOURCE_LUMINANCE_ALPHA: format = GL11.GL_LUMINANCE_ALPHA; break;
        }
        
        int components = GL11.GL_RGBA8;
        switch (tex.getRTTSource()) {
            case Texture.RTT_SOURCE_RGBA: break;
            case Texture.RTT_SOURCE_RGB: components = GL11.GL_RGB8; break;
            case Texture.RTT_SOURCE_ALPHA: components = GL11.GL_ALPHA8; break;
            case Texture.RTT_SOURCE_DEPTH: components = GL11.GL_DEPTH_COMPONENT; break;
            case Texture.RTT_SOURCE_INTENSITY: components = GL11.GL_INTENSITY8; break;
            case Texture.RTT_SOURCE_LUMINANCE: components = GL11.GL_LUMINANCE8; break;
            case Texture.RTT_SOURCE_LUMINANCE_ALPHA: components = GL11.GL_LUMINANCE_ALPHA; break;
        }

        // Initialize our texture with some default data.
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, components, width, height, 0,
                format, GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);

        // Initialize mipmapping for this texture, if requested
        if (tex.getMipmap() != Texture.MM_NONE && tex.getMipmap() != Texture.MM_LINEAR && tex.getMipmap() != Texture.MM_NEAREST) {
            EXTFramebufferObject.glGenerateMipmapEXT(GL11.GL_TEXTURE_2D);
        }

        // Setup filtering and wrap
        RenderContext context = DisplaySystem.getDisplaySystem().getCurrentContext();
        TextureStateRecord record = (TextureStateRecord) context.getStateRecord(RenderState.RS_TEXTURE);
        TextureRecord texRecord = record.getTextureRecord(tex.getTextureId());

        LWJGLTextureState.applyFilter(tex, texRecord, 0, record);
        LWJGLTextureState.applyWrap(tex, texRecord, 0, record);

        logger.info("setup fbo tex with id " + tex.getTextureId() + ": " + width + ","
                + height);
    }

    /**
	 * <code>render</code> renders a scene. As it receives a base class of
	 * <code>Spatial</code> the renderer hands off management of the scene to
	 * spatial for it to determine when a <code>Geometry</code> leaf is
	 * reached. The result of the rendering is then copied into the given
	 * texture(s). What is copied is based on the Texture object's rttSource
	 * field.
	 * 
	 * @param toDraw
	 *            the scene to render.
	 * @param tex
	 *            the Texture to render it to.
	 */
    public void render(Spatial toDraw, Texture tex) {
        render(toDraw, tex, true);
    }
    
    /**
	 * <code>render</code> renders a scene. As it receives a base class of
	 * <code>Spatial</code> the renderer hands off management of the scene to
	 * spatial for it to determine when a <code>Geometry</code> leaf is
	 * reached. The result of the rendering is then copied into the given
	 * texture(s). What is copied is based on the Texture object's rttSource
	 * field.
	 * 
	 * @param toDraw
	 *            the scene to render.
	 * @param tex
	 *            the Texture to render it to.
	 */
    public void render(Spatial toDraw, Texture tex, boolean doClear) {
        if (!isSupported) {
            return;
        }

        try {
        	activate();
        	
            setupForSingleTexDraw(tex, doClear);

            doDraw(toDraw);

            takedownForSingleTexDraw(tex);

            deactivate();
        } catch (Exception e) {
            logger.logp(Level.SEVERE, this.getClass().toString(),
                    "render(Spatial, Texture, boolean)", "Exception", e);
        }
    }

    public void render(ArrayList<? extends Spatial> toDraw, ArrayList<Texture> texs) {
        render(toDraw, texs, true);
    }

    public void render(ArrayList<? extends Spatial> toDraw, ArrayList<Texture> texs, boolean doClear) {
        if (!isSupported) {
            return;
        }

        // if we only support 1 draw buffer at a time anyway, we'll have to render to each texture individually...
        if (maxDrawBuffers == 1 || texs.size() == 1) {
        	try {
                activate();
        		for (int i = 0; i < texs.size(); i++) {
                    Texture tex = texs.get(i);
                	
                    setupForSingleTexDraw(tex, doClear);

                    doDraw(toDraw);

                    takedownForSingleTexDraw(tex);
        		}
            } catch (Exception e) {
                logger.logp(Level.SEVERE, this.getClass().toString(),
                        "render(Spatial, Texture, boolean)", "Exception", e);
            } finally {
                deactivate();
            }
    		return;
        }
        try {
            activate();

            // Otherwise, we can streamline this by rendering to multiple textures at once.
	        // first determine how many groups we need
	        LinkedList<Texture> depths = new LinkedList<Texture>();
	        LinkedList<Texture> colors = new LinkedList<Texture>();
	        for (int i = 0; i < texs.size(); i++) {
	            Texture tex = texs.get(i);
	            if (tex.getRTTSource() == Texture.RTT_SOURCE_DEPTH) {
	            	depths.add(tex);
	            } else {
	            	colors.add(tex);
	            }
	        }
	        // we can only render to 1 depth texture at a time, so # groups is at minimum == numDepth
	        int groups = Math.max(depths.size(), (int)(0.999f + (colors.size() / (float)maxDrawBuffers)));
	        for (int i = 0; i < groups; i++) {
	        	// First take care of depth.
	        	if (!depths.isEmpty()) {
	        		Texture tex = depths.removeFirst();
	        		// Set up our depth texture
	                EXTFramebufferObject.glFramebufferTexture2DEXT(
	                        EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
	                        EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT,
	                        GL11.GL_TEXTURE_2D, tex.getTextureId(), 0);
	                usingDepthRB = false;
	        	} else if (!usingDepthRB) {
	        		// setup our default depth render buffer if not already set
	                EXTFramebufferObject.glFramebufferRenderbufferEXT(
	                        EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
	                        EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT,
	                        EXTFramebufferObject.GL_RENDERBUFFER_EXT, depthRBID);
	                usingDepthRB = true;
	        	}
	        	
	        	int colorsAdded = 0;
	        	while (colorsAdded < maxDrawBuffers && !colors.isEmpty()) {
	        		Texture tex = colors.removeFirst();
	        		EXTFramebufferObject.glFramebufferTexture2DEXT(
	                        EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
	                        EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT + colorsAdded,
	                        GL11.GL_TEXTURE_2D, tex.getTextureId(), 0);
	        		colorsAdded++;
	        	}
	        	
	        	setDrawBuffers(colorsAdded);
	        	setReadBuffer(colorsAdded != 0 ? EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT : GL11.GL_NONE);
	        	
	            // Check FBO complete
	            checkFBOComplete();
	            
	            switchCameraIn(doClear);
	            
	            doDraw(toDraw);
	            
	            switchCameraOut();
	        }
        
            // automatically generate mipmaps for our textures.
            for (int x = 0, max = texs.size(); x < max; x++) {
                if (texs.get(x).getMipmap() != Texture.MM_NONE && texs.get(x).getMipmap() != Texture.MM_LINEAR && texs.get(x).getMipmap() != Texture.MM_NEAREST) {
                    LWJGLTextureState.doTextureBind(texs.get(x).getTextureId(), 0);
                    EXTFramebufferObject.glGenerateMipmapEXT(GL11.GL_TEXTURE_2D);
                }
            }
            
        } catch (Exception e) {
            logger.logp(Level.SEVERE, this.getClass().toString(),
                    "render(Spatial, Texture)", "Exception", e);
        } finally {
            deactivate();
        }
    }

	private void setupForSingleTexDraw(Texture tex, boolean doClear) {

		LWJGLTextureState.doTextureBind(tex.getTextureId(), 0);

		if (tex.getRTTSource() == Texture.RTT_SOURCE_DEPTH) {
		    // Setup depth texture into FBO
		    EXTFramebufferObject.glFramebufferTexture2DEXT(
		            EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
		            EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT,
		            GL11.GL_TEXTURE_2D, tex.getTextureId(), 0);

		    setDrawBuffer(GL11.GL_NONE);
		    setReadBuffer(GL11.GL_NONE);
		} else {
		    // setup depth RB
		    EXTFramebufferObject.glFramebufferRenderbufferEXT(
		            EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
		            EXTFramebufferObject.GL_DEPTH_ATTACHMENT_EXT,
		            EXTFramebufferObject.GL_RENDERBUFFER_EXT, depthRBID);
   
		    // Set textures into FBO
		    EXTFramebufferObject.glFramebufferTexture2DEXT(
		            EXTFramebufferObject.GL_FRAMEBUFFER_EXT,
		            EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT,
		            GL11.GL_TEXTURE_2D, tex.getTextureId(), 0);

		    setDrawBuffer(EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT);
		    setReadBuffer(EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT);
		}

		// Check FBO complete
		checkFBOComplete();

		switchCameraIn(doClear);
	}

	private void setReadBuffer(int attachVal) {
		if (currentReadBuffer != attachVal) {
			GL11.glReadBuffer(attachVal);
			currentReadBuffer = attachVal;
		}
	}

	private void setDrawBuffer(int attachVal) {
		if (currentDrawBuffer != attachVal || drawBuffers != 1) {
			GL11.glDrawBuffer(attachVal);
			currentDrawBuffer = attachVal;
			drawBuffers = 1;
		}
	}

	private void setDrawBuffers(int maxEntry) {
		if (maxEntry <= 1) {
			setDrawBuffer(maxEntry != 0 ? EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT : GL11.GL_NONE);
		} else {
			currentDrawBuffer = EXTFramebufferObject.GL_COLOR_ATTACHMENT0_EXT;
			
			if (drawBuffers != maxEntry) {
				// We should only get to this point if we support ARBDrawBuffers.
				attachBuffer.clear();
				attachBuffer.limit(maxEntry);
				ARBDrawBuffers.glDrawBuffersARB(attachBuffer);
				drawBuffers = maxEntry;
			}
		}
	}

	private void takedownForSingleTexDraw(Texture tex) {
		switchCameraOut();

		// automatically generate mipmaps for our texture.
		if (tex.getMipmap() != Texture.MM_NONE && tex.getMipmap() != Texture.MM_LINEAR && tex.getMipmap() != Texture.MM_NEAREST) {
		    LWJGLTextureState.doTextureBind(tex.getTextureId(), 0);
		    EXTFramebufferObject.glGenerateMipmapEXT(GL11.GL_TEXTURE_2D);
		}
	}

    private void checkFBOComplete() {
        int framebuffer = EXTFramebufferObject.glCheckFramebufferStatusEXT( EXTFramebufferObject.GL_FRAMEBUFFER_EXT ); 
        switch ( framebuffer ) {
            case EXTFramebufferObject.GL_FRAMEBUFFER_COMPLETE_EXT:
                break;
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT exception" );
            case EXTFramebufferObject.GL_FRAMEBUFFER_UNSUPPORTED_EXT:
                throw new RuntimeException( "FrameBuffer: " + fboID
                        + ", has caused a GL_FRAMEBUFFER_UNSUPPORTED_EXT exception" );
            default:
                throw new RuntimeException( "Unexpected reply from glCheckFramebufferStatusEXT: " + framebuffer );
        }
    }

    /**
     * <code>copyToTexture</code> copies the FBO contents to
     * the given Texture. What is copied is up to the Texture object's rttSource
     * field.
     * 
     * @param tex
     *            The Texture to copy into.
     * @param width
     *            the width of the texture image
     * @param height
     *            the height of the texture image
     */
    public void copyToTexture(Texture tex, int width, int height) {
        LWJGLTextureState.doTextureBind(tex.getTextureId(), 0);

        int source = GL11.GL_RGBA;
        switch (tex.getRTTSource()) {
            case Texture.RTT_SOURCE_RGBA: break;
            case Texture.RTT_SOURCE_RGB: source = GL11.GL_RGB; break;
            case Texture.RTT_SOURCE_ALPHA: source = GL11.GL_ALPHA; break;
            case Texture.RTT_SOURCE_DEPTH: source = GL11.GL_DEPTH_COMPONENT; break;
            case Texture.RTT_SOURCE_INTENSITY: source = GL11.GL_INTENSITY; break;
            case Texture.RTT_SOURCE_LUMINANCE: source = GL11.GL_LUMINANCE; break;
            case Texture.RTT_SOURCE_LUMINANCE_ALPHA: source = GL11.GL_LUMINANCE_ALPHA; break;
        }
        GL11.glCopyTexImage2D(GL11.GL_TEXTURE_2D, 0, source, 0, 0, width, height, 0);
    }

    private Camera oldCamera;
    private int oldWidth, oldHeight;
    public void switchCameraIn(boolean doClear) {
        // grab non-rtt settings
        oldCamera = parentRenderer.getCamera();
        oldWidth = parentRenderer.getWidth();
        oldHeight = parentRenderer.getHeight();
        parentRenderer.setCamera(getCamera());

        // swap to rtt settings
        parentRenderer.getQueue().swapBuckets();
        parentRenderer.reinit(width, height);

        // clear the scene
        if (doClear) {
            parentRenderer.clearBuffers();
        }

        getCamera().update();
        getCamera().apply();
    }
    
    public void switchCameraOut() {
        parentRenderer.setCamera(oldCamera);
        parentRenderer.reinit(oldWidth, oldHeight);

        // back to the non rtt settings
        parentRenderer.getQueue().swapBuckets();
        oldCamera.update();
        oldCamera.apply();
    }
    
    private void doDraw(Spatial spat) {
        // Override parent's last frustum test to avoid accidental incorrect
        // cull
        if (spat.getParent() != null)
        	spat.getParent().setLastFrustumIntersection(
                    Camera.INTERSECTS_FRUSTUM);

        // do rtt scene render
        spat.onDraw(parentRenderer);
        parentRenderer.renderQueue();
    }
    
    private void doDraw(ArrayList<? extends Spatial> toDraw) {
    	for (int x = 0, max = toDraw.size(); x < max; x++) {
            Spatial spat = toDraw.get(x);
            doDraw(spat);
        }
    }

    public void activate() {
        if (!isSupported) {
            return;
        }
        if (active == 0) {
            GL11.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
            EXTFramebufferObject.glBindFramebufferEXT( EXTFramebufferObject.GL_FRAMEBUFFER_EXT, fboID );
        }
        active++;
    }

    public void deactivate() {
        if (!isSupported) {
            return;
        }
        if (active == 1) {
            GL11.glClearColor(parentRenderer.getBackgroundColor().r,
                    parentRenderer.getBackgroundColor().g, parentRenderer
                            .getBackgroundColor().b, parentRenderer
                            .getBackgroundColor().a);
            EXTFramebufferObject.glBindFramebufferEXT( EXTFramebufferObject.GL_FRAMEBUFFER_EXT, 0 );
        }
        active--;
    }

    private void initCamera() {
        if (!isSupported) {
            return;
        }
        logger.info("Init RTT camera");
        camera = new LWJGLCamera(width, height, this, true);
        camera.setFrustum(1.0f, 1000.0f, -0.50f, 0.50f, 0.50f, -0.50f);
        Vector3f loc = new Vector3f(0.0f, 0.0f, 0.0f);
        Vector3f left = new Vector3f(-1.0f, 0.0f, 0.0f);
        Vector3f up = new Vector3f(0.0f, 1.0f, 0.0f);
        Vector3f dir = new Vector3f(0.0f, 0f, -1.0f);
        camera.setFrame(loc, left, up, dir);
        camera.setDataOnly(false);
    }

    public void cleanup() {
        if (!isSupported) {
            return;
        }

        if (fboID > 0) {
            IntBuffer id = BufferUtils.createIntBuffer(1);
            id.put(fboID);
            EXTFramebufferObject.glDeleteFramebuffersEXT(id);
        }
    }

    public LWJGLRenderer getParentRenderer() {
        return parentRenderer;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setMultipleTargets(boolean multi) {
        ; // ignore.  Does not matter to FBO.
    }
}