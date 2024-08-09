package com.boligame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private AssetManager assetManager;
    private Stage worldStage ;

    @Override
    public void create() {

        batch = new SpriteBatch();
        worldStage = new Stage();
        assetManager = new AssetManager();
        assetManager.load("atlas/Atlas.atlas", TextureAtlas.class);
        assetManager.load("fonts/20.fnt", BitmapFont.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get("atlas/Atlas.atlas", TextureAtlas.class);
        TextureRegion texture = atlas.findRegion("BAK/Player Sprites/Player");
        TextureRegion[][] splited = texture.split(32, 32);
        TextureRegion playerImage = splited[0][0];

        assetManager.finishLoading();

        Image image = new Image(playerImage);
        BitmapFont font = assetManager.get("fonts/20.fnt", BitmapFont.class);
        Label label = new Label("HOLA BOLICHERO", new Label.LabelStyle(font, Color.ORANGE));

        label.setPosition(100f, 100f);
        worldStage.addActor(image);
        worldStage.addActor(label);

    }

    @Override
    public void render() {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.end();

        worldStage.act();
        worldStage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        worldStage.dispose();
    }
}
