package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {

    private LD31Main game;
    private OrthographicCamera camera;
    private Texture menuLogo;

    public MainMenuScreen(LD31Main g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	menuLogo = new Texture("graphics/dotkeeper.png");
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0.2f, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	game.batch.draw(menuLogo, (game.resolutionWidth - menuLogo.getWidth()) / 2, game.resolutionHeight - menuLogo.getHeight());

	game.font.draw(game.batch, "Don't let your dots move out of the screen!", 300, 270);
	game.font.draw(game.batch, "Keep them inside by clicking on it and drag them back to the middle.", 300, 250);
	game.font.draw(game.batch, "Or click a bomb to destroy some dots.", 300, 230);
	game.font.draw(game.batch, "How long can you survive?", 300, 210);
	game.font.draw(game.batch, "Click anywhere to begin!", 420, 100);
	game.font.draw(game.batch, "v." + game.version, 5, 15);

	game.batch.end();

	if (Gdx.input.isTouched()) {
	    game.setScreen(new GameScreen(game));
	    dispose();
	}
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
	menuLogo.dispose();
    }
}