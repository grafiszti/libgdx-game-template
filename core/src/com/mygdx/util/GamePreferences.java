package com.mygdx.util;

/**
 * ****************************************************************************
 * Copyright 2013 Andreas Oehlke
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ****************************************************************************
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.MathUtils;

public class GamePreferences {

    public static final String TAG = GamePreferences.class.getName();

    public static final GamePreferences instance = new GamePreferences();

    public boolean sound;
    public boolean music;
    public float volSound;
    public float volMusic;

    private Preferences prefs;

    // singleton: prevent instantiation from other classes
    private GamePreferences() {
        prefs = Gdx.app.getPreferences(Constants.PREFERENCES);
    }

    public void load() {
        sound = prefs.getBoolean("sound", true);
        music = prefs.getBoolean("music", true);
        volSound = MathUtils.clamp(prefs.getFloat("volSound", 0.5f), 0.0f, 1.0f);
        volMusic = MathUtils.clamp(prefs.getFloat("volMusic", 0.5f), 0.0f, 1.0f);
    }

    public void save() {
        prefs.putBoolean("sound", sound);
        prefs.putBoolean("music", music);
        prefs.putFloat("volSound", volSound);
        prefs.putFloat("volMusic", volMusic);
        prefs.flush();
    }
}
