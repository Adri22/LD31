package de._1nulleins0.ld31;

import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> circles = new LinkedList<GameObject>();
    public LinkedList<GameObject> powerups = new LinkedList<GameObject>();
    private GameObject tempObject;

    public void updateCircles() {
	for (int i = 0; i < circles.size(); i++) {
	    tempObject = circles.get(i);
	    tempObject.update();
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