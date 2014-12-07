package de._1nulleins0.ld31;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class InputHandler implements InputProcessor {

    private OrthographicCamera camera;
    private Handler handler;
    private Vector3 clickPos;

    public InputHandler(OrthographicCamera camera, Handler handler) {
	this.camera = camera;
	this.handler = handler;
	clickPos = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode) {
	return false;
    }

    @Override
    public boolean keyUp(int keycode) {
	return false;
    }

    @Override
    public boolean keyTyped(char character) {
	return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
	clickPos.set(x, y, 0);
	camera.unproject(clickPos);
	handler.detectCircles(clickPos.x, clickPos.y);
	handler.detectPowerUps(clickPos.x, clickPos.y);
	return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	handler.resetSelection();
	return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
	clickPos.set(x, y, 0);
	camera.unproject(clickPos);
	handler.updateSelectedCircle(clickPos.x, clickPos.y);
	return false;
    }

    @Override
    public boolean mouseMoved(int x, int y) {
	return false;
    }

    @Override
    public boolean scrolled(int amount) {
	return false;
    }
}