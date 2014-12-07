package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Explosion extends CircleObject{

    public Explosion(SpriteBatch b, ShapeRenderer sr, float x, float y, int id, int radius) {
	super(b, sr, x, y, id, radius);
    }

    @Override
    public void update() {
	if(radius != 200){
	    radius++;
	} else {
	    delete = true;
	}
    }

    @Override
    public void update(float x, float y) {
    }

    @Override
    public void render() {
	shapeRender.begin(ShapeType.Line);
	shapeRender.setColor(1, 0, 0, 0);
	shapeRender.circle(x, y, radius);
	shapeRender.end();
    }

    @Override
    public void dispose() {
    }
}
