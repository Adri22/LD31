package de._1nulleins0.ld31;

import java.util.LinkedList;
import com.badlogic.gdx.math.Circle;

public class Handler {
    public LinkedList<GameObject> circles;
    public LinkedList<GameObject> powerups;
    private GameObject tempObject;
    private boolean itemSelected;
    private int itemSelectedID;

    public Handler() {
	circles = new LinkedList<GameObject>();
	powerups = new LinkedList<GameObject>();
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

    public void updateCircles() {
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.update();
	    if (tempObject.shouldBeDeleted()) {
		removeCircle(tempObject);
		GameScreen.setLife(GameScreen.getLife() - 10);
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
	for (int i = 0; i < powerups.size(); i++) {
	    tempObject = powerups.get(i);
	    tempObject.update();
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
    }
}