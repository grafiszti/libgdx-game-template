package com.mygdx.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.screens.game.Assets;

public abstract class AbstractGameScreen implements Screen {
    public Stage stage;
    public Skin skin;
    protected DirectedGame game;

    public AbstractGameScreen(DirectedGame game) {
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
