package com.mygdx;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Assets;
import com.mygdx.screens.DirectedGame;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.assets.AssetManager;

public class MyGdxGame extends DirectedGame {

	@Override
	public void create () {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());

		// Start game at first screen
		//setScreen(new MenuScreen(this));
	}
}
