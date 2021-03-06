/*
 * Copyright (c) 2003-2007 jMonkeyEngine
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

package com.jmex.awt;

import com.jme.math.Vector3f;
import com.jme.renderer.Camera;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.pass.BasicPassManager;
import com.jme.renderer.pass.RenderPass;
import com.jme.scene.Node;
import com.jme.scene.state.ZBufferState;
import com.jme.system.DisplaySystem;
import com.jme.util.Timer;

/**
 * <code>SimpleCanvasImpl</code>
 * 
 * @author Joshua Slack
 * @version $Id: SimplePassCanvasImpl.java,v 1.4 2007/09/21 15:45:30 nca Exp $
 */

public class SimplePassCanvasImpl extends JMECanvasImplementor {

    // Items for scene
    protected Node rootNode;
    protected BasicPassManager manager;
    protected Timer timer;
    protected float tpf;
    protected Camera cam;
    protected int width, height;

    /**
     * This class should be subclasses - not directly instantiated.
     * @param width canvas width
     * @param height canvas height
     */
    protected SimplePassCanvasImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void doSetup() {
        
        DisplaySystem display = DisplaySystem.getDisplaySystem();
        display.initForCanvas(width, height);
        renderer = display.getRenderer();

        /**
         * Create a camera specific to the DisplaySystem that works with the
         * width and height
         */
        cam = renderer.createCamera(width, height);

        /** Set up how our camera sees. */
        cam.setFrustumPerspective(45.0f, (float) width / (float) height, 1,
                1000);
        Vector3f loc = new Vector3f(0.0f, 0.0f, 25.0f);
        Vector3f left = new Vector3f(-1.0f, 0.0f, 0.0f);
        Vector3f up = new Vector3f(0.0f, 1.0f, 0.0f);
        Vector3f dir = new Vector3f(0.0f, 0f, -1.0f);
        /** Move our camera to a correct place and orientation. */
        cam.setFrame(loc, left, up, dir);
        /** Signal that we've changed our camera's location/frustum. */
        cam.update();
        /** Assign the camera to this renderer. */
        renderer.setCamera(cam);

        /** Set a black background. */
        renderer.setBackgroundColor(ColorRGBA.black.clone());

        /** Get a high resolution timer for FPS updates. */
        timer = Timer.getTimer();

        /** Create pass manager and pass*/
        manager = new BasicPassManager();
        RenderPass rPass = new RenderPass();
        manager.add(rPass);
        
        /** Create rootNode */
        rootNode = new Node("rootNode");
        rPass.add(rootNode);
        
        /**
         * Create a ZBuffer to display pixels closest to the camera above
         * farther ones.
         */
        ZBufferState buf = renderer.createZBufferState();
        buf.setEnabled(true);
        buf.setFunction(ZBufferState.CF_LEQUAL);

        rootNode.setRenderState(buf);

        simpleSetup();
        
        /**
         * Update geometric and rendering information for both the rootNode and
         * fpsNode.
         */
        rootNode.updateGeometricState(0.0f, true);
        rootNode.updateRenderState();

        setup = true;
    }

    public void doUpdate() {
        timer.update();
        /** Update tpf to time per frame according to the Timer. */
        tpf = timer.getTimePerFrame();

        simpleUpdate();

        manager.updatePasses(tpf);

        rootNode.updateGeometricState(tpf, true);
    }

    public void doRender() {
        renderer.clearBuffers();
        manager.renderPasses(renderer);
        simpleRender();
        renderer.displayBackBuffer();
    }

    public void simpleSetup() {        
    }

    public void simpleUpdate() {
    }
    
    public void simpleRender() {
    }

    public Camera getCamera() {
        return cam;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public float getTimePerFrame() {
        return tpf;
    }

    public BasicPassManager getManager() {
        return manager;
    }
}
