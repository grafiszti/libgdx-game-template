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

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.screens.DirectedGame;
import com.mygdx.util.CameraHelper;

public class GameController extends InputAdapter implements Disposable {

    private static final String TAG = GameController.class.getName();

    private DirectedGame game;
    public Level level;
    public CameraHelper cameraHelper;
    public World b2world;

    public GameController (DirectedGame game) {
        this.game = game;
        init();
    }

    private void init () {
        cameraHelper = new CameraHelper();
        initLevel();
    }

    private void initLevel () {
        level = new Level();
        //cameraHelper.setTarget(/*object*/);
        initPhysics();
    }

    private void initPhysics () {
        if (b2world != null) b2world.dispose();
        b2world = new World(new Vector2(0, -9.81f), true);
    }

    public void update (float deltaTime) {
        handleInputGame(deltaTime);
        level.update(deltaTime);
        //b2world.step(deltaTime, 8, 3);
        cameraHelper.update(deltaTime);
    }

    private void handleInputGame (float deltaTime) {
    }

    private void moveCamera (float x, float y) {
        x += cameraHelper.getPosition().x;
        y += cameraHelper.getPosition().y;
        cameraHelper.setPosition(x, y);
    }

    @Override
    public void dispose () {
        if (b2world != null) b2world.dispose();
    }
}
