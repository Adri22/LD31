package de._1nulleins0.ld31;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private Texture playerTex;
    private Rectangle player;
    private Animator playerAnimation;
    private SpriteBatch batch;

    public Player(SpriteBatch b) {
	batch = b;
	playerTex = new Texture("graphics/TestAnimation.bmp");
	player = new Rectangle();
	playerAnimation = new Animator(1, 3, playerTex, 0.025f);
	player.x = 0;
	player.y = 0;
	player.width = 0; // playerTex.getWidth();
	player.height = 0; // playerTex.getHeight();
    }

    public float getXPos() {
	return player.x;
    }

    public float getYPos() {
	return player.y;
    }

    private void setPos(int x, int y) {
	player.x = x;
	player.y = y;
    }

    public void renderPlayer() {
	batch.draw(
		playerAnimation.getAnimationFrame(),
		player.x,
		player.y
		);
    }

    public void updatePlayer(int posX, int posY, int moep) {
	setPos(posX, posY);
	playerAnimation.setAnimationSpeed(1.225f);

	// playerAnimation.setFlipping(true, false);
	if (moep == 0) // testing
	    playerAnimation.setFlipping(true, false);
	else if (moep == 1)
	    playerAnimation.setFlipping(false, false);
    }

    public void dispose() {
	playerTex.dispose();
    }
}
