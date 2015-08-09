package com.mygdx.screens.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.screens.DirectedGame;

public abstract class GameScreen implements Screen {
    protected DirectedGame game;

    public GameScreen(DirectedGame game) {
        this.game = game;
    }

    public abstract void render(float deltaTime);

    public abstract void resize(int width, int height);

    public abstract void show();

    public abstract void hide();

    public abstract void pause();

    public abstract InputProcessor getInputProcessor();

    public void resume() {
        Assets.instance.init(new AssetManager());
    }
    public void dispose() {
        Assets.instance.dispose();
    }
}
