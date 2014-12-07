package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class CircleGenerator {

    private Handler handler;
    private SpriteBatch batch;
    private ShapeRenderer shapeRender;
    final private int MAX_RADIUS = 50;
    private int id;
    private int rndRadius;
    private int spawnTime;
    private float deltaTimer;

    public CircleGenerator(Handler h, SpriteBatch b, ShapeRenderer sr) {
	handler = h;
	batch = b;
	shapeRender = sr;
	id = 1;
	spawnTime = 5;
	deltaTimer = 5;
    }

    public void generateCircles(float delta) {
	deltaTimer += delta;
	if (deltaTimer > spawnTime) {
	    rndRadius = MathUtils.random(10, MAX_RADIUS);
	    handler.addCircle(new Dot(
		    batch,
		    shapeRender,
		    LD31Main.resolutionWidth / 2,
		    LD31Main.resolutionHeight / 2,
		    ObjectID.Dot,
		    id,
		    rndRadius
		    ));
	    deltaTimer = 0;
	    id++;
	}
    }

    public void decreaseSpawnTime(float timer) {
	if (timer >= 5 && spawnTime == 5) {
	    spawnTime -= 1;
	} else if (timer >= 10 && spawnTime == 4) {
	    spawnTime -= 1;
	} else if (timer >= 20 && spawnTime == 3) {
	    spawnTime -= 1;
	} else if (timer >= 60 && spawnTime == 2) {
	    spawnTime -= 1;
	}
    }
}
