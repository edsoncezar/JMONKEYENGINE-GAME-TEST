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

package com.jme.input.action;

import com.jme.math.Vector3f;
import com.jme.renderer.Camera;

/**
 * <code>KeyStrafeDownAction</code> defines an action that causes the camera
 * to move along the negative up vector. The speed at which it moves is set in
 * the form of units per second.
 * 
 * @author Mark Powell - suggestions by forum user Nodwick
 * @version $Id: KeyStrafeDownAction.java,v 1.3 2007/08/02 21:37:45 nca Exp $
 */
public class KeyStrafeDownAction extends KeyInputAction {
    // the camera to manipulate
    private Camera camera;
    // temporary vector to store translation
    private static final Vector3f tempVa = new Vector3f();
    // optional up vector if not set camera's up is used, if set this is used.
    private Vector3f upVector;
    

    /**
     * Constructor instantiates a new <code>KeyStrafeDownAction</code> object.
     * 
     * @param camera
     *            the camera to move along the negative up vector.
     * @param speed
     *            the speed at which to move the camera.
     */
    public KeyStrafeDownAction(Camera camera, float speed) {
        this.camera = camera;
        this.speed = speed;
    }

    /**
     * <code>performAction</code> moves the camera along the negative up
     * vector for a given distance of speed * time.
     * 
     * @see com.jme.input.action.KeyInputAction#performAction(InputActionEvent)
     */
    public void performAction(InputActionEvent evt) {
        Vector3f loc = camera.getLocation();
        if(upVector != null) {
            loc.subtractLocal(upVector.mult(speed * evt.getTime(), tempVa));
            camera.update();
        } else {
            loc.subtractLocal(camera.getUp().mult(speed * evt.getTime(), tempVa));
            camera.update();
        }
    }

    public Vector3f getUpVector() {
        return upVector;
    }

    public void setUpVector(Vector3f upVector) {
        this.upVector = upVector;
    }
}