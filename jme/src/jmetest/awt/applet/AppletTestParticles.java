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

package jmetest.awt.applet;

import com.jme.bounding.BoundingBox;
import com.jme.image.Texture;
import com.jme.math.FastMath;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.renderer.Renderer;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.AlphaState;
import com.jme.scene.state.TextureState;
import com.jme.scene.state.ZBufferState;
import com.jme.util.TextureManager;
import com.jme.util.Timer;
import com.jmex.awt.applet.SimpleJMEApplet;
import com.jmex.effects.particles.ParticleFactory;
import com.jmex.effects.particles.ParticleGeometry;
import com.jmex.effects.particles.SwarmInfluence;

public class AppletTestParticles extends SimpleJMEApplet {
    private static final long serialVersionUID = 1L;

    private ParticleGeometry particles;
    private Vector3f currentPos = new Vector3f(), newPos = new Vector3f();
    private float frameRate = 0;
    private SwarmInfluence swarm;
    private Sphere sphere;

    public void simpleAppletUpdate() {
        float tpf = getTimePerFrame();
        if (tpf > 1f)
            tpf = 1.0f; // do this to prevent a long pause at start

        if ((int) currentPos.x == (int) newPos.x
                && (int) currentPos.y == (int) newPos.y
                && (int) currentPos.z == (int) newPos.z) {
            newPos.x = (float) Math.random() * 50 - 25;
            newPos.y = (float) Math.random() * 50 - 25;
            newPos.z = (float) Math.random() * 50 - 150;
        }

        frameRate = Timer.getTimer().getFrameRate() / 2;
        currentPos.x -= (currentPos.x - newPos.x) / frameRate;
        currentPos.y -= (currentPos.y - newPos.y) / frameRate;
        currentPos.z -= (currentPos.z - newPos.z) / frameRate;

        particles.setOriginOffset(currentPos);
        sphere.getLocalTranslation().set(currentPos);
        swarm.getSwarmOffset().set(currentPos);        
    }
    
    public void simpleAppletSetup() {
        getLightState().setEnabled(false);
        
        sphere = new Sphere("sp", 12, 12, 3f);
        sphere.setModelBound(new BoundingBox());
        sphere.updateModelBound();
        sphere.setDefaultColor(ColorRGBA.blue.clone());
        sphere.setRenderQueueMode(Renderer.QUEUE_OPAQUE);
        
        particles = ParticleFactory.buildParticles("particles", 30);
        particles.setEmissionDirection(new Vector3f(0, 1, 0));
        particles.setStartSize(3f);
        particles.setEndSize(1.5f);
        particles.setOriginOffset(new Vector3f(0, 0, 0));
        particles.setInitialVelocity(.05f);
        particles.setMinimumLifeTime( 5000f);
        particles.setMaximumLifeTime(15000f);
        particles.setStartColor(new ColorRGBA(1, 0, 0, 1));
        particles.setEndColor(new ColorRGBA(0, 1, 0, 1));
        particles.setMaximumAngle(360f * FastMath.DEG_TO_RAD);
        particles.getParticleController().setControlFlow(false);
        particles.getParticleController().setSpeed(0.75f);
        swarm = new SwarmInfluence(new Vector3f(particles.getWorldTranslation()), .001f);
        swarm.setMaxSpeed(.2f);
        swarm.setSpeedBump(0.025f);
        swarm.setTurnSpeed(FastMath.DEG_TO_RAD * 360);
        particles.addInfluence(swarm);


        AlphaState as1 = getRenderer().createAlphaState();
        as1.setBlendEnabled(true);
        as1.setSrcFunction(AlphaState.SB_SRC_ALPHA);
        as1.setDstFunction(AlphaState.DB_ONE);
        as1.setTestEnabled(true);
        as1.setTestFunction(AlphaState.TF_GREATER);
        as1.setEnabled(true);
        particles.setRenderState(as1);

        TextureState ts = getRenderer().createTextureState();
        ts.setTexture(
            TextureManager.loadTexture(
            AppletTestParticles.class.getClassLoader().getResource(
            "jmetest/data/texture/flaresmall.jpg"),
            Texture.MM_LINEAR_LINEAR,
            Texture.FM_LINEAR));
        ts.setEnabled(true);
        particles.setRenderState(ts);

        ZBufferState zstate = getRenderer().createZBufferState();
        zstate.setEnabled(false);
        particles.setRenderState(zstate);

        particles.setModelBound(new BoundingBox());
        particles.updateModelBound();

        getRootNode().attachChild(particles);
        getRootNode().attachChild(sphere);

    }
}
