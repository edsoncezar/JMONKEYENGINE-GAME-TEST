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
package com.jme.scene.state.lwjgl.records;

import org.lwjgl.opengl.GL11;

public class LineRecord extends StateRecord {
    public boolean smoothed = false;
    public boolean stippled = false;
    public int smoothHint = -1;
    public float width = -1;
    public int stippleFactor = -1;
    public short stipplePattern = -1;

    public void applyLineWidth(float lineWidth) {
        if (!isValid() || this.width != lineWidth) {
            GL11.glLineWidth(lineWidth);
            this.width = lineWidth;
        }
    }

    public void applyLineSmooth(boolean smoothed) {
        if (smoothed) {
            if (!isValid() || !this.smoothed) {
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
                this.smoothed = true;
            }
            if (!isValid() || smoothHint != GL11.GL_NICEST) {
                GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
                smoothHint = GL11.GL_NICEST;
            }
        } else if (!isValid() || this.smoothed) {
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            this.smoothed = false;
        }
    }

    public void applyLineStipple(int stippleFactor, short stipplePattern) {
        if (stipplePattern != (short)0xFFFF) {
            if (!isValid() || !this.stippled) {
                GL11.glEnable(GL11.GL_LINE_STIPPLE);
                this.stippled = true;
            }

            if (!isValid() || stippleFactor != this.stippleFactor || stipplePattern != this.stipplePattern) {
                GL11.glLineStipple(stippleFactor, stipplePattern);
                this.stippleFactor = stippleFactor;
                this.stipplePattern = stipplePattern;
            }
        } else if (!isValid() || this.stippled) {
            GL11.glDisable(GL11.GL_LINE_STIPPLE);
            this.stippled = false;
        }
        
    }
    
    @Override
    public void invalidate() {
    	super.invalidate();
        smoothed = false;
        stippled = false;
        smoothHint = -1;
        width = -1;
        stippleFactor = -1;
        stipplePattern = -1;
    }
}
