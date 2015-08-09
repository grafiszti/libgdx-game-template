/*******************************************************************************
 * Copyright 2013 Andreas Oehlke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.mygdx.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.screens.DirectedGame;
import com.mygdx.util.GamePreferences;

public class GameScreenImpl extends GameScreen {

    private static final String TAG = GameScreenImpl.class.getName();

    private GameController gameController;
    private GameRenderer gameRenderer;

    private boolean paused;

    public GameScreenImpl(DirectedGame game) {
        super(game);
    }

    @Override
    public void render (float deltaTime) {
        if (!paused) {
            gameController.update(deltaTime);
        }
        // Sets the clear screen color to: Cornflower Blue
        Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
        // Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameRenderer.render();
    }

    @Override
    public void resize (int width, int height) {
        gameRenderer.resize(width, height);
    }

    @Override
    public void show () {
        GamePreferences.instance.load();
        gameController = new GameController(game);
        gameRenderer = new GameRenderer(gameController);
    }

    @Override
    public void hide () {
        gameController.dispose();
        gameRenderer.dispose();
    }

    @Override
    public void pause () {
        paused = true;
    }

    @Override
    public void resume () {
        super.resume();
        // Only called on Android!
        paused = false;
    }

    @Override
    public InputProcessor getInputProcessor () {
        return gameController;
    }
}
