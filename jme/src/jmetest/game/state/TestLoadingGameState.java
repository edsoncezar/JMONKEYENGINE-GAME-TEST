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
package jmetest.game.state;

import com.jmex.game.StandardGame;
import com.jmex.game.state.DebugGameState;
import com.jmex.game.state.GameStateManager;
import com.jmex.game.state.load.LoadingGameState;

/**
 * @author Matthew D. Hicks
 */
public class TestLoadingGameState {
	public static void main(String[] args) throws Exception {
		StandardGame game = new StandardGame("Test LoadingGameState");
		game.getSettings().clear();
		game.start();
		
		// Create LoadingGameState and enable
		LoadingGameState loading = new LoadingGameState();
		GameStateManager.getInstance().attachChild(loading);
		loading.setActive(true);
		
		// Enable DebugGameState
		DebugGameState debug = new DebugGameState();
		GameStateManager.getInstance().attachChild(debug);
		debug.setActive(true);
		
		// Start our slow loading test
		String status = "Started Loading";
		for (int i = 0; i <= 100; i++) {
			if (i == 100) {
				status = "I'm Finished!";
			} else if (i > 80) {
				status = "Almost There!";
			} else if (i > 70) {
				status = "Loading Something Extremely Useful";
			} else if (i > 50) {
				status = "More Than Half-Way There!";
			} else if (i > 20) {
				status = "Loading Something That You Probably Won't Care About";
			}
			Thread.sleep(100);
			loading.setProgress(i / 100.0f, status);
		}
	}
}
