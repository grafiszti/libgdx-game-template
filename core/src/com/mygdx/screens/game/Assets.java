/*
 *
 *  Comments are example assets which could by add to game.
*/
package com.mygdx.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.util.Constants;


public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();

    private AssetManager assetManager;

    //public AssetFonts fonts;
    //public AssetBunny bunny;

    //public AssetSounds sounds;
    //public AssetMusic music;

    // singleton
    private Assets() { }

    /*public class AssetFonts {
        public final BitmapFont defaultNormal;

        public AssetFonts() {
            // create three fonts using Libgdx's built-in 15px bitmap font
            defaultNormal = new BitmapFont(
                    Gdx.files.internal("images/arial-15.fnt"), true);
            // set font sizes
            defaultNormal.setScale(1.0f);
            // enable linear texture filtering for smooth fonts
            defaultNormal.getRegion().getTexture()
                    .setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }
    }*/

    /*public class AssetBunny {
        public final AtlasRegion head;
        public final Animation animNormal;
        public final Animation animCopterTransform;
        public final Animation animCopterTransformBack;
        public final Animation animCopterRotate;

        public AssetBunny(TextureAtlas atlas) {
            head = atlas.findRegion("bunny_head");

            Array<AtlasRegion> regions = null;
            AtlasRegion region = null;

            // Animation: Bunny Normal
            regions = atlas.findRegions("anim_bunny_normal");
            animNormal = new Animation(1.0f / 10.0f, regions,
                    Animation.PlayMode.LOOP_PINGPONG);


            // Animation: Bunny Copter - knot ears
            regions = atlas.findRegions("anim_bunny_copter");
            animCopterTransform = new Animation(1.0f / 10.0f, regions);

            // Animation: Bunny Copter - unknot ears
            regions = atlas.findRegions("anim_bunny_copter");
            animCopterTransformBack = new Animation(1.0f / 10.0f, regions,
                    Animation.PlayMode.REVERSED);

            // Animation: Bunny Copter - rotate ears
            regions = new Array<AtlasRegion>();
            regions.add(atlas.findRegion("anim_bunny_copter", 4));
            regions.add(atlas.findRegion("anim_bunny_copter", 5));
            animCopterRotate = new Animation(1.0f / 15.0f, regions);
        }
    }*/

    /*public class AssetSounds {
        public final Sound jump;
        public final Sound jumpWithFeather;
        public final Sound pickupCoin;
        public final Sound pickupFeather;
        public final Sound liveLost;

        public AssetSounds(AssetManager am) {
            jump = am.get("sounds/jump.wav", Sound.class);
            jumpWithFeather = am.get("sounds/jump_with_feather.wav",
                    Sound.class);
            pickupCoin = am.get("sounds/pickup_coin.wav", Sound.class);
            pickupFeather = am.get("sounds/pickup_feather.wav", Sound.class);
            liveLost = am.get("sounds/live_lost.wav", Sound.class);
        }
    }

    public class AssetMusic {
        public final Music song01;

        public AssetMusic(AssetManager am) {
            song01 = am.get("music/keith303_-_brand_new_highscore.mp3",
                    Music.class);
        }
    }*/

    public void init(AssetManager assetManager) {
        initAssetManager(assetManager);

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

        enableTextureFiltering(atlas);

        createFonts();
        createGameObjects(atlas);
        createSounds(assetManager);
    }

    private void initAssetManager(AssetManager assetManager){
        this.assetManager = assetManager;
        // set asset manager error handler
        assetManager.setErrorListener(this);
        // load texture atlas
        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
        // load sounds
        assetManager.load("sounds/jump.wav", Sound.class);
        // load music
        assetManager.load("music/keith303_-_brand_new_highscore.mp3", Music.class);
        // start loading assets and wait until finished
        assetManager.finishLoading();
    }

    private void enableTextureFiltering(TextureAtlas atlas){
        for (Texture t : atlas.getTextures()) {
            t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }
    }

    private void createFonts(){
        //fonts = new AssetFonts();
    }

    private void createGameObjects(TextureAtlas atlas){
        //bunny = new AssetBunny(atlas);
    }

    private void createSounds(AssetManager assetManager){
        //sounds = new AssetSounds(assetManager);
        //music = new AssetMusic(assetManager);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
        //fonts.defaultNormal.dispose();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", throwable);
    }
}
