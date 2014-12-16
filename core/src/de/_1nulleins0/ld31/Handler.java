package de._1nulleins0.ld31;

import java.util.LinkedList;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Handler {

    private SoundHandler sound;
    public LinkedList<GameObject> circles;
    public LinkedList<GameObject> powerups;
    public LinkedList<GameObject> explosions;
    private GameObject tempObject;
    private boolean itemSelected;
    private int itemSelectedID;

    public Handler(SoundHandler sound) {
	this.sound = sound;
	circles = new LinkedList<GameObject>();
	powerups = new LinkedList<GameObject>();
	explosions = new LinkedList<GameObject>();
	itemSelected = false;
	itemSelectedID = 0;
    }

    public void detectCircles(float x, float y) {
	Circle c;
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    c = tempObject.getBounds();
	    if ((x > (c.x - c.radius)) &&
		    (x < (c.x + c.radius)) &&
		    (y > (c.y - c.radius)) &&
		    (y < (c.y + c.radius))) {
		if (!itemSelected || itemSelectedID == tempObject.getID()) {
		    tempObject.select(true, x, y);
		    itemSelectedID = tempObject.getID();
		    itemSelected = true;
		}
	    } else {
		tempObject.select(false);
		itemSelected = false;
	    }
	}
    }

    public void detectPowerUps(float x, float y) {
	Rectangle r;
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    r = tempObject.getBounds();
	    if ((x > r.x) && (x < (r.x + r.width)) && (y > r.y) && (y < (r.y + r.height))) {
		tempObject.select(true);
		sound.explosion();
	    }
	}
    }

    public void resetSelection() {
	itemSelected = false;
	itemSelectedID = 0;
    }

    public void updateCircles() {
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.update();
	    if (tempObject.shouldBeDeleted()) {
		removeCircle(tempObject);
		GameScreen.setLife(GameScreen.getLife() - 10);
		sound.loseLife();
	    }
	}
    }

    public void updateSelectedCircle(float x, float y) {
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    if (itemSelectedID == tempObject.getID()) {
		tempObject.update(x, y);
	    }
	}
    }

    public void renderCircles() {
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.render();
	}
    }

    public void addCircle(GameObject object) {
	this.circles.add(object);
    }

    public void removeCircle(GameObject object) {
	this.circles.remove(object);
    }

    public void updatePowerUps() {
	if (powerups.size() > 2) {
	    removePowerUp(powerups.getFirst());
	}
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    tempObject.update();
	    if (tempObject.shouldBeDeleted()) {
		removePowerUp(tempObject);
	    }
	}
    }

    public void renderPowerUps() {
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    tempObject.render();
	}
    }

    public void addPowerUp(GameObject object) {
	this.powerups.add(object);
    }

    public void removePowerUp(GameObject object) {
	this.powerups.remove(object);
    }

    public void updateExplosions() {
	Circle exp;
	Circle dot;
	for (int i = 0; i < explosions.size(); i++) {
	    tempObject = explosions.get(i);
	    tempObject.update();
	    if (tempObject.shouldBeDeleted()) {
		removeExplosion(tempObject);
	    }
	    exp = tempObject.getBounds();
	    for (int j = 0; j < circles.size(); j++) {
		tempObject = circles.get(j);
		dot = tempObject.getBounds();
		if (exp.overlaps(dot)) {
		    removeCircle(tempObject);
		    sound.destroyDot();
		}
	    }
	}
    }

    public void renderExplosions() {
	for (int i = 0; i < explosions.size(); i++) {
	    tempObject = explosions.get(i);
	    tempObject.render();
	}
    }

    public void addExplosion(GameObject object) {
	this.explosions.add(object);
    }

    public void removeExplosion(GameObject object) {
	this.explosions.remove(object);
    }

    public void deleteEverything() {
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    tempObject.dispose();
	    removePowerUp(tempObject);
	}
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.dispose();
	    removeCircle(tempObject);
	}
	for (int i = 0; i < explosions.size(); i++) {
	    tempObject = explosions.get(i);
	    tempObject.dispose();
	    removeExplosion(tempObject);
	}
    }

    public void dispose() {
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    tempObject.dispose();
	}
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.dispose();
	}
	for (int i = 0; i < explosions.size(); i++) {
	    tempObject = explosions.get(i);
	    tempObject.dispose();
	}
    }
}