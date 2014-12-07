package de._1nulleins0.ld31;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LD31Main extends Game {

    public static int resolutionWidth = 1024;
    public static int resolutionHeight = 768;
    public static float version = 1.0f;
    public SpriteBatch batch;
    public ShapeRenderer shapeRender;
    public BitmapFont font;

    @Override
    public void create() {
	batch = new SpriteBatch();
	shapeRender = new ShapeRenderer();
	font = new BitmapFont();
	this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
	super.render();
    }

    @Override
    public void dispose() {
	batch.dispose();
	shapeRender.dispose();
	font.dispose();
    }
}
