package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {

    private LD31Main game;
    private OrthographicCamera camera;
    private Vector3 touchPos;
    private Handler handler;
    private CircleGenerator cg;
    private float timer;

    public GameScreen(LD31Main g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	touchPos = new Vector3();
	handler = new Handler();
	cg = new CircleGenerator(handler, game.batch, game.shapeRender);
	timer = 0;
    }

    private void renderGame() {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	handler.renderCircles();

	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	handler.renderPowerUps();

	// game.font.setColor(0, 0, 0, 0);
	game.font.draw(
		game.batch,
		"FPS:" + (1 / Gdx.graphics.getDeltaTime()),
		5,
		game.resolutionHeight - 5);
	game.font.draw(
		game.batch,
		"Time: " + (int) (timer / 60) + "min " + (int) (timer % 60) + "sec",
		200,
		game.resolutionHeight - 5);

	game.batch.end();
    }

    private void updateGame() {

	timer += Gdx.graphics.getDeltaTime();

	if (Gdx.input.isTouched()) {
	    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	    camera.unproject(touchPos);

	    // player.setPos(new Point((int) touchPos.x, (int) touchPos.y));
	}

	cg.decreaseSpawnTime(timer);
	cg.generateCircles(Gdx.graphics.getDeltaTime());

	// update stuff here
	handler.updateCircles();
	handler.updatePowerUps();
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
	handler.dispose();
    }
}
