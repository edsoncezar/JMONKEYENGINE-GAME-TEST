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

package jmetest.renderer;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Logger;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.image.Texture;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.AlphaState;
import com.jme.scene.state.TextureState;
import com.jme.util.TextureManager;
import com.jme.util.resource.MultiFormatResourceLocator;
import com.jme.util.resource.ResourceLocatorTool;
import com.jme.util.resource.SimpleResourceLocator;

/**
 * <code>TestSphere</code>
 * @author Mark Powell
 * @version $Id: TestSphere.java,v 1.16 2007/08/17 20:39:07 nca Exp $
 */
public class TestSphere extends SimpleGame {
    private static final Logger logger = Logger.getLogger(TestSphere.class
            .getName());

  private Quaternion rotQuat = new Quaternion();
  private float angle = 0;
  private Vector3f axis = new Vector3f(1, 1, 0);
  private Sphere s;

  /**
   * Entry point for the test,
   * @param args
   */
  public static void main(String[] args) {
    TestSphere app = new TestSphere();
    app.setDialogBehaviour(ALWAYS_SHOW_PROPS_DIALOG);
    app.start();
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

  /**
   * builds the trimesh.
   * @see com.jme.app.SimpleGame#initGame()
   */
  protected void simpleInitGame() {
    display.setTitle("jME - Sphere");

    s = new Sphere("Sphere", 63, 50, 25);
    s.setLocalTranslation(new Vector3f(0,0,-40));
    s.setModelBound(new BoundingBox());
    s.updateModelBound();
    rootNode.attachChild(s);

    
    try {
        MultiFormatResourceLocator loc2 = new MultiFormatResourceLocator(new File("c:/").toURI(), ".jpg", ".png", ".tga");
        ResourceLocatorTool.addResourceLocator(ResourceLocatorTool.TYPE_TEXTURE, loc2);
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    URL u = ResourceLocatorTool.locateResource(ResourceLocatorTool.TYPE_TEXTURE, "/model/grass.gif");
    System.err.println("FOUND URL: "+u);
    
    TextureState ts = display.getRenderer().createTextureState();
    ts.setEnabled(true);
    ts.setTexture(
        TextureManager.loadTexture(u,
        Texture.MM_LINEAR_LINEAR,
        Texture.FM_LINEAR));

    rootNode.setRenderState(ts);
    
    AlphaState alpha = display.getRenderer().createAlphaState();
    alpha.setBlendEnabled(true);
    alpha.setSrcFunction(AlphaState.SB_SRC_ALPHA);
    alpha.setDstFunction(AlphaState.DB_ONE_MINUS_SRC_ALPHA);
    alpha.setTestEnabled(true);
    alpha.setTestFunction(AlphaState.TF_GREATER);
    alpha.setEnabled(true);
    rootNode.setRenderState(alpha);
  }
}
