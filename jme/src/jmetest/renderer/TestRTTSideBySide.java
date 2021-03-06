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

package jmetest.renderer;

import java.util.logging.Logger;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.image.Texture;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.TextureRenderer;
import com.jme.scene.shape.Quad;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.LightState;
import com.jme.scene.state.TextureState;
import com.jme.util.TextureManager;

/**
 * <code>TestRTTSideBySide</code>
 * @author Mark Powell
 * @version $Id: TestRTTSideBySide.java,v 1.10 2007/08/02 23:54:48 nca Exp $
 */
public class TestRTTSideBySide extends SimpleGame {
    private static final Logger logger = Logger
            .getLogger(TestRTTSideBySide.class.getName());

  private Quaternion rotQuat = new Quaternion();
  private float angle = 0;
  private Vector3f axis = new Vector3f(1, 1, 0);
  private Sphere s;
  private Quad q;
  private TextureRenderer tRenderer;
  private Texture fakeTex;

  /**
   * Entry point for the test,
   * @param args
   */
  public static void main(String[] args) {
    TestRTTSideBySide app = new TestRTTSideBySide();
    app.setDialogBehaviour(ALWAYS_SHOW_PROPS_DIALOG);
    app.start();
  }

  protected void cleanup() {
    super.cleanup();
    tRenderer.cleanup();
  }

  protected void simpleUpdate() {
      
      
    if (tpf < 1) {
      angle = angle + (tpf * 1);
      if (angle > 360) {
        angle = 0;
      }
    }
    rotQuat.fromAngleAxis(angle, axis);
    s.setLocalRotation(rotQuat);
  
  }
  
  protected void simpleRender() {
      tRenderer.render(s, fakeTex);
  }

  /**
   * builds the trimesh.
   * @see com.jme.app.SimpleGame#initGame()
   */
  protected void simpleInitGame() {
    display.setTitle("jME - RTT Side By Side");
    
    tRenderer = display.createTextureRenderer(512, 512, TextureRenderer.RENDER_TEXTURE_2D);
    
    s = new Sphere("Sphere", 25, 25, 5);
    s.setLocalTranslation(new Vector3f(-10,0,0));
    s.setModelBound(new BoundingBox());
    s.updateModelBound();
    rootNode.attachChild(s);
    
    q = new Quad("Quad", 15, 13f);
    q.setLocalTranslation(new Vector3f(10,0,0));
    q.setModelBound(new BoundingBox());
    q.updateModelBound();
    q.setLightCombineMode(LightState.OFF);
    rootNode.attachChild(q);
    
    tRenderer.setBackgroundColor(new ColorRGBA(0f, 0f, 0f, 1f));
    fakeTex = new Texture();
    tRenderer.setupTexture(fakeTex);
    TextureState screen = display.getRenderer().createTextureState();
    screen.setTexture(fakeTex);
    screen.setEnabled(true);
    
    tRenderer.getCamera().setLocation(new Vector3f(-10, 0, 15f));
    q.setRenderState(screen);

    TextureState ts = display.getRenderer().createTextureState();
    ts.setEnabled(true);
    ts.setTexture(
        TextureManager.loadTexture(
        TestBoxColor.class.getClassLoader().getResource(
        "jmetest/data/images/Monkey.jpg"),
        Texture.MM_LINEAR_LINEAR,
        Texture.FM_LINEAR));

    rootNode.setRenderState(ts);
  }
}
