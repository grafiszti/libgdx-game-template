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

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {

    public static final String TAG = Level.class.getName();

    // all game objects

    public Level() {
    }

    public Level (String filename) {
        init(filename);
    }

    private void init (String filename) {
    }

    public void update (float deltaTime) {
        // all game objects update
        // called as object.update(deltaTime)
    }

    public void render (SpriteBatch batch) {
        // all game objects render
        // called as object.render(batch)
    }
}
