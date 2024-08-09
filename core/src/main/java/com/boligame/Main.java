package com.boligame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;
    private AssetManager assetManager;
    private Stage worldStage ;

    @Override
    public void create() {

        batch = new SpriteBatch();
        worldStage = new Stage();
        assetManager = new AssetManager();
        assetManager.load("atlas/Atlas.atlas", TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get("atlas/Atlas.atlas", TextureAtlas.class);
        TextureRegion texture = atlas.findRegion("BAK/Player Sprites/Player");
        TextureRegion[][] splited = texture.split(32, 32);
        TextureRegion playerImage = splited[0][0];

        Image image = new Image(playerImage);

        worldStage.addActor(image);

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
        image.dispose();
        worldStage.dispose();
    }
}
