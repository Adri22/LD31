package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Dot extends CircleObject {

    private int colorR;
    private int colorG;
    private int colorB;
    private int destinationX;
    private int destinationY;
    private int speed;

    public Dot(SpriteBatch b, ShapeRenderer sr, float x, float y, ObjectID id, int r) {
	super(b, sr, x, y, id, r);
	colorR = MathUtils.random(0, 1);
	colorG = MathUtils.random(0, 1);
	colorB = MathUtils.random(0, 1);
	speed = 100;
	generateDestination();
    }

    @Override
    public void update() {
	if (destinationX > x) {
	    x = x + speed * Gdx.graphics.getDeltaTime();
	} else if (destinationX < x) {
	    x = x + (-1 * speed) * Gdx.graphics.getDeltaTime();
	}
	// MathUtils.sin(radians)
	if (destinationY > y) {
	    y = y + speed * Gdx.graphics.getDeltaTime();
	} else if (destinationY < y) {
	    y = y + (-1 * speed) * Gdx.graphics.getDeltaTime();
	}
    }

    @Override
    public void render() {
	shapeRender.begin(ShapeType.Filled);
	shapeRender.setColor(colorR, colorG, colorB, 0);
	shapeRender.circle(x, y, radius);
	shapeRender.end();
    }

    private void generateDestination() {
	int[][] destinationOptions = {
		{ -100, MathUtils.random(0, LD31Main.resolutionHeight) },
		{ LD31Main.resolutionWidth + 100, MathUtils.random(0, LD31Main.resolutionHeight) },
		{ MathUtils.random(0, LD31Main.resolutionWidth), LD31Main.resolutionHeight + 100 },
		{ MathUtils.random(0, LD31Main.resolutionWidth), -100 },
	};
	int rndIndex = MathUtils.random(0, 3);
	destinationX = destinationOptions[rndIndex][0];
	destinationY = destinationOptions[rndIndex][1];
	System.out.println("X: " + destinationX + " Y: " + destinationY);
    }

    public int getSpeed() {
	return speed;
    }

    public void setSpeed(int s) {
	speed = s;
    }

    @Override
    public void dispose() {
    }
}