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

package com.jme.system.lwjgl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.util.applet.LWJGLInstaller;

import com.jme.system.DisplaySystem;
import com.jme.system.JmeException;
import com.jme.system.SystemProvider;
import com.jme.util.Timer;
import com.jme.util.lwjgl.LWJGLTimer;

public class LWJGLSystemProvider implements SystemProvider {
    private static final Logger logger = Logger
            .getLogger(LWJGLSystemProvider.class.getName());

    public final static String LWJGL_SYSTEM_IDENTIFIER = "LWJGL";

    private DisplaySystem displaySystem;

    private Timer timer;

    public String getProviderIdentifier() {
        return LWJGL_SYSTEM_IDENTIFIER;
    }

    public DisplaySystem getDisplaySystem() {
        if (displaySystem == null) {
        	displaySystem = new LWJGLDisplaySystem();
        }
        return displaySystem;
    }

    public Timer getTimer() {
        if (timer == null) {
        	timer = new LWJGLTimer();
        }
        return timer;
    }

    public void installLibs() {
        try {
            LWJGLInstaller.tempInstall();
        } catch (Exception e) {
            logger.logp(Level.SEVERE, this.getClass().toString(), "installLibs()", "Exception",
                            e);
            throw new JmeException("Could not install lwjgl libs! "+e);
        }
    }

    public void disposeDisplaySystem() {
        displaySystem = null;
    }
}
