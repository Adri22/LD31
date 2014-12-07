package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class GameObject {

    protected float x, y;
    protected int id;
    protected SpriteBatch batch;
    protected ShapeRenderer shapeRender;
    protected boolean selected;
    protected boolean delete;

    public GameObject(SpriteBatch b, ShapeRenderer sr, float x, float y, int id) {
	this.x = x;
	this.y = y;
	this.id = id;
	batch = b;
	shapeRender = sr;
	selected = false;
	delete = false;
    }

    public abstract void update();

    public abstract void update(float x, float y);

    public abstract void render();

    public void setX(float x) {
	this.x = x;
    }

    public void setY(float y) {
	this.y = y;
    }

    public int getID() {
	return id;
    }

    public void select(boolean s) {
	selected = s;
    }

    public void select(boolean s, float selectPosX, float selectPosY) {
	selected = s;
	x = selectPosX;
	y = selectPosY;
    }

    public boolean isSelected() {
	return selected;
    }

    public boolean shouldBeDeleted() {
	return delete;
    }

    public abstract <T> T getBounds();

    public abstract void dispose();
}