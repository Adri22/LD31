package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class GameObject {

    protected float x, y;
    protected ObjectID id;
    protected SpriteBatch batch;
    protected ShapeRenderer shapeRender;
    protected boolean selected;
    
    public GameObject(SpriteBatch b, ShapeRenderer sr, float x, float y, ObjectID id) {
	this.x = x;
	this.y = y;
	this.id = id;
	batch = b;
	shapeRender = sr;
	selected = false;
    }

    public abstract void update();

    public abstract void render();

    public float getX() {
	return x;
    };

    public float getY() {
	return y;
    };

    public void setX(float x) {
	this.x = x;
    };

    public void setY(float y) {
	this.y = y;
    };

    public ObjectID getID() {
	return id;
    };
    
    public void select(boolean s){
	selected = s;
    }
    
    public abstract void dispose();
}