package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public abstract class CircleObject extends GameObject{

    protected int radius;
    
    public CircleObject(SpriteBatch b, ShapeRenderer sr, float x, float y, ObjectID id, int radius) {
	super(b, sr, x, y, id);
	this.radius = radius;
    }
    
    public Circle getBounds() {
	return new Circle(x, y, radius);
    }

}
