package de._1nulleins0.ld31.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de._1nulleins0.ld31.Game;

public class DesktopLauncher {
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

	config.title = "LD31";
	config.width = Game.resolution.width;
	config.height = Game.resolution.height;
	config.resizable = false;

	new LwjglApplication(new Game(), config);
    }
}
