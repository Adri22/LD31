package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {

    private LD31Main game;
    private OrthographicCamera camera;
    private Vector3 touchPos;
    private Player player;

    public GameScreen(LD31Main g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	touchPos = new Vector3();
	player = new Player(game.batch);
    }

    private void renderGame() {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	player.renderPlayer();

	game.font.draw(
		game.batch,
		"FPS:" + (1 / Gdx.graphics.getDeltaTime()),
		5,
		game.resolutionHeight - 5);
	game.batch.end();
    }

    private void updateGame() {
	/*
	 * if (Gdx.input.isTouched()) { touchPos.set(Gdx.input.getX(),
	 * Gdx.input.getY(), 0); camera.unproject(touchPos); //
	 * player.setPos(new Point((int) touchPos.x, (int) touchPos.y)); }
	 */
	
	
	/*
	if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
	    System.out.println("key - right - pressed");
	    player.updatePlayer(
		    (int) (player.getXPos() + 500 * Gdx.graphics.getDeltaTime()),
		    (int) player.getYPos(),
		    0
		    );
	    System.out.println(player.getXPos() + " ---- " + Gdx.graphics.getDeltaTime());
	} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
	    System.out.println("key - left - pressed");
	    player.updatePlayer(
		    (int) (player.getXPos() - 500 * Gdx.graphics.getDeltaTime()),
		    (int) player.getYPos(),
		    1
		    );
	    System.out.println(player.getXPos() + " ---- " + Gdx.graphics.getDeltaTime());
	}
	*/
	
    }

    @Override
    public void render(float delta) {
	updateGame();
	renderGame();
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
	player.dispose();
    }
}