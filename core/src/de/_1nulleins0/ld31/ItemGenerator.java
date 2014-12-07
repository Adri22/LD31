package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class ItemGenerator {

    private Handler handler;
    private SpriteBatch batch;
    private ShapeRenderer shapeRender;
    final private int MAX_RADIUS = 50;
    private int id;
    private int powerupWidth;
    private int powerupHeight;
    private int rndRadius;
    private int circleSpawnTime;
    private int powerupSpawnTime;
    private float deltaCircleTimer;
    private float deltaPowerUpTimer;

    public ItemGenerator(Handler h, SpriteBatch b, ShapeRenderer sr) {
	handler = h;
	batch = b;
	shapeRender = sr;
	id = 1;
	powerupWidth = 50;
	powerupHeight = 50;
	circleSpawnTime = 5;
	powerupSpawnTime = 10;
	deltaCircleTimer = 5;
	deltaPowerUpTimer = 0;
    }

    public void generateCircles(float delta) {
	deltaCircleTimer += delta;
	if (deltaCircleTimer > circleSpawnTime) {
	    rndRadius = MathUtils.random(10, MAX_RADIUS);
	    handler.addCircle(new Dot(
		    batch,
		    shapeRender,
		    LD31Main.resolutionWidth / 2,
		    LD31Main.resolutionHeight / 2,
		    id,
		    rndRadius
		    ));
	    deltaCircleTimer = 0;
	    id++;
	}
    }

    public void generatePowerUps(float delta) {
	deltaPowerUpTimer += delta;
	int randomPosX = MathUtils.random(0, LD31Main.resolutionWidth - powerupWidth);
	int randomPosY = MathUtils.random(0, LD31Main.resolutionHeight - powerupHeight - 10);
	if (deltaPowerUpTimer > powerupSpawnTime && MathUtils.randomBoolean()) {
	    handler.addPowerUp(new PowerUp(batch, shapeRender, randomPosX, randomPosY, id, powerupWidth, powerupHeight, handler));
	    deltaPowerUpTimer = 0;
	    id++;
	}
    }

    public void decreaseCircleSpawnTime(float timer) {
	if (timer >= 5 && circleSpawnTime == 5) {
	    circleSpawnTime -= 1;
	} else if (timer >= 10 && circleSpawnTime == 4) {
	    circleSpawnTime -= 1;
	} else if (timer >= 20 && circleSpawnTime == 3) {
	    circleSpawnTime -= 1;
	} else if (timer >= 60 && circleSpawnTime == 2) {
	    circleSpawnTime -= 1;
	}
    }
}
