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

package com.jme.scene.state.lwjgl;

import org.lwjgl.opengl.GL11;

import com.jme.renderer.ColorRGBA;
import com.jme.renderer.RenderContext;
import com.jme.scene.state.MaterialState;
import com.jme.scene.state.lwjgl.records.MaterialStateRecord;
import com.jme.scene.state.lwjgl.records.StateRecord;
import com.jme.system.DisplaySystem;

/**
 * <code>LWJGLMaterialState</code> subclasses MaterialState using the LWJGL
 * API to access OpenGL to set the material for a given node and it's children.
 * 
 * @author Mark Powell
 * @author Joshua Slack - reworked for StateRecords.
 * @version $Id: LWJGLMaterialState.java,v 1.15 2007/04/11 18:27:36 nca Exp $
 */
public class LWJGLMaterialState extends MaterialState {
	private static final long serialVersionUID = 1L;

	/**
     * Constructor instantiates a new <code>LWJGLMaterialState</code> object.
     */
	public LWJGLMaterialState() {
		super();
	}

	/**
	 * <code>set</code> calls the OpenGL material function to set the proper
	 * material state.
	 * 
	 * @see com.jme.scene.state.RenderState#apply()
	 */
	public void apply() {
        // ask for the current state record
        RenderContext context = DisplaySystem.getDisplaySystem()
                .getCurrentContext();
        MaterialStateRecord record = (MaterialStateRecord) context
                .getStateRecord(RS_MATERIAL);
        context.currentStates[RS_MATERIAL] = this;

        int face = getGLMaterialFace(materialFace);

        // setup colormaterial, if changed.
        applyColorMaterial(getColorMaterial(), face, record);
        
        // apply colors, if needed and not what is currently set.
        applyColor(GL11.GL_AMBIENT, getAmbient(), face, record);
        applyColor(GL11.GL_DIFFUSE, getDiffuse(), face, record);
        applyColor(GL11.GL_EMISSION, getEmissive(), face, record);
        applyColor(GL11.GL_SPECULAR, getSpecular(), face, record);

        // set our shine
		if (!record.isValid() || face != record.face || record.shininess != shininess) {
			GL11.glMaterialf(face, GL11.GL_SHININESS, shininess);
            record.shininess = shininess;
		}
        
        record.face = face;
        
        if (!record.isValid())
            record.validate();
	}

    private static void applyColor(int glMatColor, ColorRGBA color, int face, MaterialStateRecord record) {
        if (!isVertexProvidedColor(glMatColor, record)
                && (!record.isValid() || face != record.face || !record
                        .isSetColor(face, glMatColor, color, record))) {
            
            record.tempColorBuff.clear();
            record.tempColorBuff.put(color.r).put(color.g).put(color.b).put(color.a);
            record.tempColorBuff.flip();
            GL11.glMaterial(face, glMatColor, record.tempColorBuff);
            
            record.setColor(face, glMatColor, color);
        }
    }

    private static boolean isVertexProvidedColor(int glMatColor, MaterialStateRecord record) {
        switch (glMatColor) {
            case GL11.GL_AMBIENT:
                return record.colorMaterial == GL11.GL_AMBIENT
                        || record.colorMaterial == GL11.GL_AMBIENT_AND_DIFFUSE;
            case GL11.GL_DIFFUSE:
                return record.colorMaterial == GL11.GL_DIFFUSE
                        || record.colorMaterial == GL11.GL_AMBIENT_AND_DIFFUSE;
            case GL11.GL_SPECULAR:
                return record.colorMaterial == GL11.GL_SPECULAR;
            case GL11.GL_EMISSION:
                return record.colorMaterial == GL11.GL_EMISSION;
        }
        return false;
    }

    private void applyColorMaterial(int colorMaterial, int face, MaterialStateRecord record) {
        int glMat = getGLColorMaterial(colorMaterial);
        if (!record.isValid() || face != record.face || glMat != record.colorMaterial) {
            if (glMat == -1) {
                GL11.glDisable(GL11.GL_COLOR_MATERIAL);
            } else {
                GL11.glColorMaterial(face, glMat);
                GL11.glEnable(GL11.GL_COLOR_MATERIAL);
                record.resetColorsForCM(face, glMat);
            }
            record.colorMaterial = glMat;
        }

    }

    /**
     * Converts the color material setting of this state to a GL constant.
     * 
     * @return the GL constant
     */
    private static int getGLColorMaterial(int colorMaterial) {
        switch (colorMaterial) {
            case CM_AMBIENT:
                return GL11.GL_AMBIENT;
            case CM_DIFFUSE:
                return GL11.GL_DIFFUSE;
            case CM_AMBIENT_AND_DIFFUSE:
                return GL11.GL_AMBIENT_AND_DIFFUSE;
            case CM_EMISSIVE:
                return GL11.GL_EMISSION;
            case CM_SPECULAR:
                return GL11.GL_SPECULAR;
        }
        return -1;
    }
    
    /**
     * Converts the material face setting of this state to a GL constant.
     * 
     * @return the GL constant
     */
    private static int getGLMaterialFace(int materialFace) {
        switch (materialFace) {
            case MF_FRONT:
                return GL11.GL_FRONT;
            case MF_BACK:
                return GL11.GL_BACK;
            case MF_FRONT_AND_BACK:
                return GL11.GL_FRONT_AND_BACK;
        }
        return -1;
    }

    @Override
    public StateRecord createStateRecord() {
        return new MaterialStateRecord();
    }
}