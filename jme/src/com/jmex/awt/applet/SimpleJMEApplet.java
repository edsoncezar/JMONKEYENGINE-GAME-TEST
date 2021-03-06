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

package com.jmex.awt.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jme.input.FirstPersonHandler;
import com.jme.input.InputHandler;
import com.jme.input.InputSystem;
import com.jme.input.KeyBindingManager;
import com.jme.input.KeyInput;
import com.jme.input.MouseInput;
import com.jme.light.PointLight;
import com.jme.math.Vector3f;
import com.jme.renderer.Camera;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.Renderer;
import com.jme.scene.Node;
import com.jme.scene.SceneElement;
import com.jme.scene.Text;
import com.jme.scene.state.LightState;
import com.jme.scene.state.RenderState;
import com.jme.scene.state.TextureState;
import com.jme.scene.state.WireframeState;
import com.jme.system.DisplaySystem;
import com.jme.util.GameTaskQueue;
import com.jme.util.GameTaskQueueManager;
import com.jme.util.TextureManager;
import com.jmex.awt.JMECanvas;
import com.jmex.awt.SimpleCanvasImpl;
import com.jmex.awt.input.AWTKeyInput;
import com.jmex.awt.input.AWTMouseInput;

public class SimpleJMEApplet extends Applet {
    private static final Logger logger = Logger.getLogger(SimpleJMEApplet.class
            .getName());
    
    private static final long serialVersionUID = 1L;

    private Canvas glCanvas;
    private SimpleAppletCanvasImplementor impl;

    protected long repaintSleepTime = 2;
    private static final String INIT_LOCK = "INIT_LOCK";

    protected static final int STATUS_INITING = 0;
    protected static final int STATUS_RUNNING = 1;
    protected static final int STATUS_DESTROYING = 2;
    protected static final int STATUS_DEAD = 3;
    
    private static final String USE_APPLET_CANVAS_SIZE = "useAppletCanvasSize";
    private static final int DEFAULT_JME_CANVAS_WIDTH = 640;
    private static final int DEFAULT_JME_CANVAS_HEIGHT = 480;

    protected int status = STATUS_INITING;

    /**
     * Alpha bits to use for the renderer. Must be set in the constructor.
     */
    protected int alphaBits = 0;

    /**
     * Depth bits to use for the renderer. Must be set in the constructor.
     */
    protected int depthBits = 8;

    /**
     * Stencil bits to use for the renderer. Must be set in the constructor.
     */
    protected int stencilBits = 0;

    /**
     * Number of samples to use for the multisample buffer. Must be set in the constructor.
     */
    protected int samples = 0;

    @Override
    public void init() {

        synchronized (INIT_LOCK) {

            TextureManager.clearCache();
            Text.resetFontTexture();

            try {
                DisplaySystem.getSystemProvider().installLibs();
            } catch (Exception le) {
                /* screwed */
                logger.logp(Level.SEVERE, this.getClass().toString(), "init()", "Exception", le);
            }

            DisplaySystem display = DisplaySystem.getDisplaySystem();
            display.setMinDepthBits( depthBits );
            display.setMinStencilBits( stencilBits );
            display.setMinAlphaBits( alphaBits );
            display.setMinSamples( samples );

            int canvasWidth;
            int canvasHeight;
            /**
             * Check if we're using the applet's specified dimensions or the
             * default.
             */
            if (Boolean.parseBoolean(this.getParameter(USE_APPLET_CANVAS_SIZE))) {
                canvasWidth = getWidth();
                canvasHeight = getHeight();
            } else {
                canvasWidth = DEFAULT_JME_CANVAS_WIDTH;
                canvasHeight = DEFAULT_JME_CANVAS_HEIGHT;
            }
            glCanvas = DisplaySystem.getDisplaySystem().createCanvas(canvasWidth, canvasHeight);
            // Important! Here is where we add the guts to the canvas:
            impl = new SimpleAppletCanvasImplementor(getWidth(), getHeight());

            ((JMECanvas) glCanvas).setImplementor(impl);
            setLayout(new BorderLayout());
            add(glCanvas, BorderLayout.CENTER);

            glCanvas.addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent ce) {
                    if (impl != null) {
                        impl.resizeCanvas(glCanvas.getWidth(), glCanvas
                                .getHeight());
                        if (impl.getCamera() != null) {
                            Callable<?> exe = new Callable() {
                                public Object call() {
                                    impl.getCamera().setFrustumPerspective(
                                            45.0f,
                                            (float) glCanvas.getWidth()
                                                    / (float) glCanvas
                                                            .getHeight(), 1,
                                            1000);
                                    return null;
                                }
                            };
                            GameTaskQueueManager.getManager().getQueue(GameTaskQueue.RENDER).enqueue(exe);
                        }
                    }
                }
            });

            glCanvas.setFocusable(true);
            glCanvas.addFocusListener(new FocusListener() {

                public void focusGained(FocusEvent arg0) {
                    ((AWTKeyInput) KeyInput.get()).setEnabled(true);
                    ((AWTMouseInput) MouseInput.get()).setEnabled(true);
                }

                public void focusLost(FocusEvent arg0) {
                    ((AWTKeyInput) KeyInput.get()).setEnabled(false);
                    ((AWTMouseInput) MouseInput.get()).setEnabled(false);
                }

            });

            // We are going to use jme's Input systems, so enable updating.
            ((JMECanvas) glCanvas).setUpdateInput(true);

            if (!KeyInput.isInited())
                KeyInput.setProvider(InputSystem.INPUT_SYSTEM_AWT);
            ((AWTKeyInput) KeyInput.get()).setEnabled(false);
            KeyListener kl = (KeyListener) KeyInput.get();

            glCanvas.addKeyListener(kl);

            if (!MouseInput.isInited())
                MouseInput.setProvider(InputSystem.INPUT_SYSTEM_AWT);
            ((AWTMouseInput) MouseInput.get()).setEnabled(false);
            ((AWTMouseInput) MouseInput.get()).setDragOnly(true);
            glCanvas.addMouseListener((MouseListener) MouseInput.get());
            glCanvas.addMouseWheelListener((MouseWheelListener) MouseInput
                    .get());
            glCanvas.addMouseMotionListener((MouseMotionListener) MouseInput
                    .get());
            glCanvas.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    if (!glCanvas.hasFocus())
                        glCanvas.requestFocus();
                };
            });

            new Thread() {

                {
                    setDaemon(true);
                }

                public void run() {
                    while (true) {
                        if (isVisible() || status == STATUS_DESTROYING || status == STATUS_INITING)
                            glCanvas.repaint();
                        try {
                            Thread.sleep(repaintSleepTime);
                        } catch (InterruptedException e) { }
                    }
                }
            }.start();
        }

    }
    
    public void simpleAppletSetup() {
    }

    public void simpleAppletUpdate() {
    }

    public void simpleAppletRender() {
    }

    public Camera getCamera() {
        return impl.getCamera();
    }

    public Renderer getRenderer() {
        return impl.getRenderer();
    }

    public Node getRootNode() {
        return impl.getRootNode();
    }

    public Node getFPSNode() {
        return impl.getFPSNode();
    }

    public float getTimePerFrame() {
        return impl.getTimePerFrame();
    }

    public LightState getLightState() {
        return impl.getLightState();
    }

    public WireframeState getWireframeState() {
        return impl.getWireframeState();
    }
    
    public InputHandler getInputHandler() {
        return impl.getInputHandler();
    }
    
    public void setInputHandler(InputHandler input) {
        impl.setInputHandler(input);
    }

    class SimpleAppletCanvasImplementor extends SimpleCanvasImpl {

        /**
         * True if the renderer should display the depth buffer.
         */
        protected boolean showDepth = false;

        /**
         * True if the renderer should display bounds.
         */
        protected boolean showBounds = false;

        /**
         * True if the rnederer should display normals.
         */
        protected boolean showNormals = false;

        protected boolean pause;

        /**
         * A wirestate to turn on and off for the rootNode
         */
        protected WireframeState wireState;

        private InputHandler input;

        /**
         * A lightstate to turn on and off for the rootNode
         */
        protected LightState lightState;

        /**
         * The root node of our text.
         */
        protected Node fpsNode;

        /**
         * Displays all the lovely information at the bottom.
         */
        protected Text fps;
        
        /**
         * This is used to recieve getStatistics calls.
         */
        protected StringBuffer tempBuffer = new StringBuffer();

        /**
         * This is used to display print text.
         */
        protected StringBuffer updateBuffer = new StringBuffer( 30 );

        protected SimpleAppletCanvasImplementor(int width, int height) {
            super(width, height);
        }

        public Node getFPSNode() {
            return fpsNode;
        }

        public LightState getLightState() {
            return lightState;
        }

        public WireframeState getWireframeState() {
            return wireState;
        }
        
        public InputHandler getInputHandler() {
            return input;
        }
        
        public void setInputHandler(InputHandler input) {
            this.input = input;
        }

        public void simpleUpdate() {
            
            input.update(tpf);
            
            simpleAppletUpdate();
            
            updateBuffer.setLength( 0 );
            updateBuffer.append( "FPS: " ).append( (int) timer.getFrameRate() ).append(
                    " - " );
            updateBuffer.append( renderer.getStatistics( tempBuffer ) );
            /** Send the fps to our fps bar at the bottom. */
            fps.print( updateBuffer );
            renderer.clearStatistics();

            /** If toggle_pause is a valid command (via key p), change pause. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_pause", false ) ) {
                pause = !pause;
            }

            /** If toggle_wire is a valid command (via key T), change wirestates. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_wire", false ) ) {
                wireState.setEnabled( !wireState.isEnabled() );
                rootNode.updateRenderState();
            }
            /** If toggle_lights is a valid command (via key L), change lightstate. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_lights", false ) ) {
                lightState.setEnabled( !lightState.isEnabled() );
                rootNode.updateRenderState();
            }
            /** If toggle_bounds is a valid command (via key B), change bounds. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_bounds", false ) ) {
                showBounds = !showBounds;
            }
            /** If toggle_depth is a valid command (via key F3), change depth. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_depth", false ) ) {
                showDepth = !showDepth;
            }

            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "toggle_normals", false ) ) {
                showNormals = !showNormals;
            }
            /** If camera_out is a valid command (via key C), show camera location. */
            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "camera_out", false ) ) {
                logger.info( "Camera at: "
                        + renderer.getCamera().getLocation() );
            }

            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "screen_shot", false ) ) {
                renderer.takeScreenShot( "SimpleAppletScreenShot" );
            }

            if ( KeyBindingManager.getKeyBindingManager().isValidCommand(
                    "mem_report", false ) ) {
                long totMem = Runtime.getRuntime().totalMemory();
                long freeMem = Runtime.getRuntime().freeMemory();
                long maxMem = Runtime.getRuntime().maxMemory();
                
                logger.info("|*|*|  Memory Stats  |*|*|");
                logger.info("Total memory: "+(totMem>>10)+" kb");
                logger.info("Free memory: "+(freeMem>>10)+" kb");
                logger.info("Max memory: "+(maxMem>>10)+" kb");
            }
        }

        public void simpleSetup() {
            synchronized (INIT_LOCK) {
                input = new FirstPersonHandler(getCamera(), 50, 1);

                /**
                 * Create a wirestate to toggle on and off. Starts disabled with
                 * default width of 1 pixel.
                 */
                wireState = renderer.createWireframeState();
                wireState.setEnabled(false);
                rootNode.setRenderState(wireState);

                // ---- LIGHTS
                /** Set up a basic, default light. */
                PointLight light = new PointLight();
                light.setDiffuse(new ColorRGBA(0.75f, 0.75f, 0.75f, 0.75f));
                light.setAmbient(new ColorRGBA(0.5f, 0.5f, 0.5f, 1.0f));
                light.setLocation(new Vector3f(100, 100, 100));
                light.setEnabled(true);

                /**
                 * Attach the light to a lightState and the lightState to
                 * rootNode.
                 */
                lightState = renderer.createLightState();
                lightState.setEnabled(true);
                lightState.attach(light);
                rootNode.setRenderState(lightState);

                // Then our font Text object.
                /** This is what will actually have the text at the bottom. */
                fps = Text.createDefaultTextLabel("FPS label");
                fps.setCullMode(SceneElement.CULL_NEVER);
                fps.setTextureCombineMode(TextureState.REPLACE);

                // Finally, a stand alone node (not attached to root on purpose)
                fpsNode = new Node("FPS node");
                fpsNode
                        .setRenderState(fps
                                .getRenderState(RenderState.RS_ALPHA));
                fpsNode.setRenderState(fps
                        .getRenderState(RenderState.RS_TEXTURE));
                fpsNode.attachChild(fps);
                fpsNode.setCullMode(SceneElement.CULL_NEVER);

                renderer.enableStatistics(true);

                fpsNode.updateGeometricState(0, true);
                fpsNode.updateRenderState();

                try {
                    simpleAppletSetup();
                } catch (Exception e) {
                    // Had issues setting up. We'll catch it and go on so it
                    // doesn't
                    // try setting up over and over.
                    logger.logp(Level.SEVERE, this.getClass().toString(),
                            "simpleSetup()", "Exception", e);
                }

                /** Assign key P to action "toggle_pause". */
                KeyBindingManager.getKeyBindingManager().set("toggle_pause",
                        KeyInput.KEY_P);
                /** Assign key T to action "toggle_wire". */
                KeyBindingManager.getKeyBindingManager().set("toggle_wire",
                        KeyInput.KEY_T);
                /** Assign key L to action "toggle_lights". */
                KeyBindingManager.getKeyBindingManager().set("toggle_lights",
                        KeyInput.KEY_L);
                /** Assign key B to action "toggle_bounds". */
                KeyBindingManager.getKeyBindingManager().set("toggle_bounds",
                        KeyInput.KEY_B);
                /** Assign key N to action "toggle_normals". */
                KeyBindingManager.getKeyBindingManager().set("toggle_normals",
                        KeyInput.KEY_N);
                /** Assign key C to action "camera_out". */
                KeyBindingManager.getKeyBindingManager().set("camera_out",
                        KeyInput.KEY_C);
                KeyBindingManager.getKeyBindingManager().set("screen_shot",
                        KeyInput.KEY_F1);
                KeyBindingManager.getKeyBindingManager().set("exit",
                        KeyInput.KEY_ESCAPE);
                KeyBindingManager.getKeyBindingManager().set("mem_report",
                        KeyInput.KEY_R);

                status = STATUS_RUNNING;
            }
        }

        public void simpleRender() {
            simpleAppletRender();
            fpsNode.draw(renderer);
        }
    }
}
