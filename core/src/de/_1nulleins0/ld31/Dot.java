package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Dot extends CircleObject {

    public Dot(SpriteBatch b, ShapeRenderer sr, float x, float y, ObjectID id, int r) {
	super(b, sr, x, y, id, r);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
	shapeRender.begin(ShapeType.Filled);
	shapeRender.setColor(1, 0, 0, 0);
	shapeRender.circle(x, y, radius);
	shapeRender.end();

	/*
	 * batch.draw( playerAnimation.getAnimationFrame(), x, y );
	 */
    }
}