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

package jmetest.intersection;

import java.util.logging.Logger;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingCapsule;
import com.jme.image.Texture;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.Spatial;
import com.jme.scene.shape.Box;
import com.jme.scene.shape.Capsule;
import com.jme.scene.shape.Teapot;
import com.jme.scene.state.LightState;
import com.jme.scene.state.RenderState;
import com.jme.scene.state.TextureState;
import com.jme.scene.state.WireframeState;
import com.jme.util.TextureManager;

/**
 * <code>TestBoundingCapsule</code>
 * 
 * @author Mark Powell
 * @version $Id: TestBoundingCapsule.java,v 1.3 2007/08/17 20:40:29 nca Exp $
 */
public class TestBoundingCapsule extends SimpleGame {
    private static final Logger logger = Logger
            .getLogger(TestBoundingCapsule.class.getName());
    
	private Quaternion rotQuat = new Quaternion();

	private float angle = 0;

	private Vector3f axis = new Vector3f(0, 1, 0);
	private Spatial s;
	private Box t;
	private float tInc = -40.0f;
	private Capsule c;

	/**
	 * Entry point for the test,
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestBoundingCapsule app = new TestBoundingCapsule();
		app.setDialogBehaviour(ALWAYS_SHOW_PROPS_DIALOG);
		app.start();
	}

	protected void simpleUpdate() {
		if (timer.getTimePerFrame() < 1) {
			angle = angle + (timer.getTimePerFrame() * 1);
			if (angle > 360) {
				angle = 0;
			}
		}

		rotQuat.fromAngleAxis(angle, axis);

		t.setLocalRotation(rotQuat);
		t.getLocalTranslation().y += tInc * timer.getTimePerFrame();
		
		if (t.getLocalTranslation().y > 40) {
			t.getLocalTranslation().y = 40;
			tInc *= -1;
		} else if (t.getLocalTranslation().y < -40) {
			t.getLocalTranslation().y = -40;
			tInc *= -1;
		}
		
		if(t.hasCollision(s, false)) {
			logger.info("hasCollision reports true");
		}
		
		BoundingCapsule cap1 = (BoundingCapsule)t.getWorldBound();
		BoundingCapsule cap2 = (BoundingCapsule)s.getWorldBound();
		c.reconstruct(cap1.getLineSegment().getOrigin(), cap2.getLineSegment().getOrigin(), 1);
        
		
	}

	/**
	 * builds the trimesh.
	 * 
	 * @see com.jme.app.SimpleGame#initGame()
	 */
	protected void simpleInitGame() {
		display.setTitle("jME - Bounding Capsule");

		s = new Teapot("Teapot");

		rootNode.attachChild(s);
		Quaternion q = new Quaternion();
		q.fromAngleAxis(2, new Vector3f(1, 23, 1));
		s.setLocalRotation(q);
		s.setLocalTranslation(new Vector3f(10, 2, 1));
		s.setModelBound(new BoundingCapsule());
		s.updateModelBound();

		t = new Box("box", new Vector3f(0, 0, 0), 10, 2, 2);

		t.getBatch(0).translatePoints(2.5f, 10, 1);
		t.setModelBound(new BoundingCapsule());
		t.setLocalTranslation(new Vector3f(15, 0, 10));
		t.setLocalScale(new Vector3f(1,2,1));
		t.updateModelBound();
		rootNode.attachChild(t);
		
		c = new Capsule("c", 20, 20, 20, 1,1);
		WireframeState ws = display.getRenderer().createWireframeState();
		ws.setEnabled(true);
		c.setRenderState(ws);
		c.clearRenderState(RenderState.RS_TEXTURE);
		c.setTextureCombineMode(TextureState.OFF);
		c.setLightCombineMode(LightState.OFF);
		c.setDefaultColor(new ColorRGBA(1,0,0,1));
		rootNode.attachChild(c);
		

		TextureState ts = display.getRenderer().createTextureState();
		ts.setEnabled(true);
		ts.setTexture(TextureManager.loadTexture(
				TestBoundingCapsule.class.getClassLoader().getResource(
						"jmetest/data/images/Monkey.jpg"),
				Texture.MM_LINEAR_LINEAR, Texture.FM_LINEAR));

		rootNode.setRenderState(ts);

		rootNode.updateGeometricState(0, true);
		logger.info("Worldbound: " + rootNode.getWorldBound());
	}
}
