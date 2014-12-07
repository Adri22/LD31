package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Dot extends CircleObject {

    private float colorR;
    private float colorG;
    private float colorB;
    private int destinationX;
    private int destinationY;
    private int speed;

    public Dot(SpriteBatch b, ShapeRenderer sr, float x, float y, int id, int r) {
	super(b, sr, x, y, id, r);
	colorR = MathUtils.random(0.01f, 1.0f);
	colorG = MathUtils.random(0.01f, 1.0f);
	colorB = MathUtils.random(0.01f, 1.0f);
	speed = 60;
	generateDestination();
    }

    @Override
    public void update() {
	if (!isSelected()) {
	    if (destinationX > x) {
		x = x + speed * Gdx.graphics.getDeltaTime();
	    } else if (destinationX < x) {
		x = x + (-1 * speed) * Gdx.graphics.getDeltaTime();
	    }
	    if (destinationY > y) {
		y = y + speed * Gdx.graphics.getDeltaTime();
	    } else if (destinationY < y) {
		y = y + (-1 * speed) * Gdx.graphics.getDeltaTime();
	    }
	} else {
	    generateDestination();
	}

	if ((destinationX > (x - radius)) &&
		(destinationX < (x + radius)) &&
		(destinationY > (y - radius)) &&
		(destinationY < (y + radius))) {
	    delete = true;
	}
    }

    @Override
    public void update(float x, float y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public void render() {
	if (selected) {
	    shapeRender.begin(ShapeType.Line);
	    shapeRender.setColor(1, 1, 1, 0);
	    shapeRender.circle(x, y, radius + 3);
	    shapeRender.end();
	}
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