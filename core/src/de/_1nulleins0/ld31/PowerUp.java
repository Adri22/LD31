package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PowerUp extends RectObject {

    private Texture powerupTex;
    private Animator powerupAnimation;
    private Handler handler;

    public PowerUp(SpriteBatch b, ShapeRenderer sr, float x, float y, int id, int width, int height, Handler handler) {
	super(b, sr, x, y, id, width, height);
	this.handler = handler;
	powerupTex = new Texture("graphics/powerup_sheet.png");
	powerupAnimation = new Animator(1, 6, powerupTex, 0.08f);
    }

    @Override
    public void update() {
	if (selected) {
	    handler.addExplosion(new Explosion(
		    batch,
		    shapeRender,
		    x + width / 2,
		    y + height / 2,
		    -1,
		    1
		    ));
	    delete = true;
	}
    }

    @Override
    public void update(float x, float y) {
    }

    @Override
    public void render() {
	batch.draw(powerupAnimation.getAnimationFrame(), x, y);
    }

    @Override
    public void dispose() {
	powerupTex.dispose();
    }
}
