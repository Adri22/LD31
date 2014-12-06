package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class RectObject extends GameObject {

    protected int width;
    protected int height;

    public RectObject(SpriteBatch b, ShapeRenderer sr, float x, float y, ObjectID id, int width, int height) {
	super(b, sr, x, y, id);
	this.width = width;
	this.height = height;
    }

    public Rectangle getBounds() {
	return new Rectangle(x, y, width, height);
    }

}
