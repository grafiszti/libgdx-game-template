package com.mygdx.screens.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by fisz on 09.08.15.
 */
public interface Level {
    void update(float deltaTime);
    void render(SpriteBatch batch);
}
