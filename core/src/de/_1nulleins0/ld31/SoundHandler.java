package de._1nulleins0.ld31;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundHandler {

    private Sound explosionSound;
    private Sound loseLifeSound;
    private Sound destroyDotSound;

    public SoundHandler() {
	explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
	loseLifeSound = Gdx.audio.newSound(Gdx.files.internal("sounds/loseLife.wav"));
	destroyDotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/destroyDot.wav"));
    }

    public void explosion() {
	explosionSound.play();
    }

    public void loseLife() {
	loseLifeSound.play();
    }

    public void destroyDot() {
	destroyDotSound.play();
    }

    public void dispose() {
	explosionSound.dispose();
	loseLifeSound.dispose();
	destroyDotSound.dispose();
    }
}
