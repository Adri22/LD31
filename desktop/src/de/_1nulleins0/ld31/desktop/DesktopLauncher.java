package de._1nulleins0.ld31.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de._1nulleins0.ld31.LD31Main;

public class DesktopLauncher {
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

	config.title = "LD31";
	config.width = LD31Main.resolution.width;
	config.height = LD31Main.resolution.height;
	config.resizable = false;

	new LwjglApplication(new LD31Main(), config);
    }
}
