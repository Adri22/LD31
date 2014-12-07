package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    private LD31Main game;
    private OrthographicCamera camera;
    private Handler handler;
    private InputHandler input;
    private SoundHandler sound;
    private ItemGenerator ig;
    private float timer;
    private static int life;
    private static boolean gameover;

    public GameScreen(LD31Main g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	sound = new SoundHandler();
	handler = new Handler(sound);
	input = new InputHandler(camera, handler);
	Gdx.input.setInputProcessor(input);
	ig = new ItemGenerator(handler, game.batch, game.shapeRender);
	timer = 0;
	life = 1000;
	gameover = false;
    }

    private void renderGame() {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	handler.renderPowerUps();

	game.font.draw(
		game.batch,
		"FPS:" + (1 / Gdx.graphics.getDeltaTime()),
		5,
		game.resolutionHeight - 5);

	if (!gameover) {
	    game.font.draw(
		    game.batch,
		    "Time: " + (int) (timer / 60) + "min " + (int) (timer % 60) + "sec",
		    200,
		    game.resolutionHeight - 5);
	    game.font.draw(
		    game.batch,
		    "Life: " + life,
		    400,
		    game.resolutionHeight - 5);
	} else {
	    game.font.draw(
		    game.batch,
		    "Your time: " + (int) (timer / 60) + "min " + (int) (timer % 60) + "sec",
		    430,
		    game.resolutionHeight - 300);
	    game.font.draw(
		    game.batch,
		    "Press Enter to start a new turn!",
		    390,
		    game.resolutionHeight - 350);
	}

	game.batch.end();

	handler.renderCircles();
	handler.renderExplosions();
    }

    private void updateGame() {
	if (!gameover) {
	    timer += Gdx.graphics.getDeltaTime();
	} else {
	    if (Gdx.input.isKeyPressed(Keys.ENTER)) {
		game.setScreen(new GameScreen(game));
		dispose();
	    }
	}

	ig.decreaseCircleSpawnTime(timer);
	ig.generateCircles(Gdx.graphics.getDeltaTime());
	ig.generatePowerUps(Gdx.graphics.getDeltaTime());

	handler.updateCircles();
	handler.updatePowerUps();
	handler.updateExplosions();

	if (life <= 0) {
	    handler.deleteEverything();
	    gameover = true;
	}
    }

    public static int getLife() {
	return life;
    }

    public static void setLife(int l) {
	life = l;
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
	sound.dispose();
    }
}
