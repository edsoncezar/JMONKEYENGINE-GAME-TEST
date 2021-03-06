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

package com.jme.light;

import java.io.IOException;

import com.jme.scene.Node;
import com.jme.scene.Spatial;
import com.jme.scene.state.LightState;
import com.jme.util.export.InputCapsule;
import com.jme.util.export.JMEExporter;
import com.jme.util.export.JMEImporter;
import com.jme.util.export.OutputCapsule;

/**
 * <code>LightNode</code> defines a scene node that contains and maintains a
 * light object. A light node contains a single light, and positions the light
 * based on it's translation vector. If the contained light is a spot light, the
 * rotation of the node determines it's direction. If the contained light is a
 * Directional light rotation determines it's direction. It has no concept of
 * location.
 * 
 * @author Mark Powell
 * @version $Id: LightNode.java,v 1.10 2006/07/20 14:23:26 nca Exp $
 */
public class LightNode extends Node {

    private static final long serialVersionUID = 1L;

    private Light light;

    private LightState lightState;
    
    public LightNode() {}

    /**
     * Constructor creates a new <code>LightState</code> object. The light
     * state the node controls is required at construction time.
     * 
     * @param name
     *            the name of the scene element. This is required for
     *            identification and comparision purposes.
     * @param lightState
     *            the lightstate that this node will control.
     */
    public LightNode(String name, LightState lightState) {
        super(name);
        this.lightState = lightState;
    }

    /**
     * 
     * <code>setLight</code> sets the light of this node. If a light was
     * previously set to the node, it is replaced by this light.
     * 
     * @param light
     *            the light to use for the node.
     */
    public void setLight(Light light) {
        this.light = light;
        lightState.detachAll();
        lightState.attach(light);
    }

    /**
     * 
     * <code>getLight</code> returns the light object this node is
     * controlling.
     * 
     * @return the light object of the node.
     */
    public Light getLight() {
        return light;
    }

    /**
     * 
     * <code>setTarget</code> defines the node (and it's children) that is
     * affected by this light.
     * 
     * @param node
     *            the node that is the target of the light.
     */
    public void setTarget(Spatial node) {
        node.setRenderState(lightState);
    }

    /**
     * <code>updateWorldData</code> modifies the light data based on any
     * change the light node has made.
     * 
     * @param time
     *            the time between frames.
     */
    public void updateWorldData(float time) {
        super.updateWorldData(time);

        if(light == null) {
            return;
        }
        switch (light.getType()) {
        case Light.LT_DIRECTIONAL: {
            DirectionalLight dLight = (DirectionalLight) light;
            dLight.getDirection().set(worldTranslation).negateLocal();
            break;
        }

        case Light.LT_POINT: {
            PointLight pLight = (PointLight) light;
            pLight.getLocation().set(worldTranslation);
            break;
        }

        case Light.LT_SPOT: {
            SpotLight sLight = (SpotLight) light;
            sLight.getLocation().set(worldTranslation);
            worldRotation.getRotationColumn(2, sLight.getDirection());
            break;
        }

        default:
            break;
        }

    }
    
    @Override
    public String toString() {
        String lightType = null;
        if (getLight() != null)
            switch (getLight().getType()) {
                case Light.LT_DIRECTIONAL:
                    lightType = "Directional";
                    break;
                case Light.LT_POINT:
                    lightType = "Point";
                    break;
                case Light.LT_SPOT:
                    lightType = "Spot";
                    break;
                default:
                    lightType = "unknown";
            }
        return getName() +" ("+ lightType+")";
    }
    
    public void write(JMEExporter e) throws IOException {
        super.write(e);
        OutputCapsule capsule = e.getCapsule(this);
        capsule.write(light, "light", null);
        capsule.write(lightState, "lightState", null);
       
    }
    
    public void read(JMEImporter e) throws IOException {
        super.read(e);
        InputCapsule capsule = e.getCapsule(this);
        light = (Light)capsule.readSavable("light", null);
        lightState = (LightState)capsule.readSavable("lightState", null);
        
    }
}