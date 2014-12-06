package de._1nulleins0.ld31.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import de._1nulleins0.ld31.LD31Main;

public class HtmlLauncher extends GwtApplication {

    int width = LD31Main.resolutionWidth;
    int height = LD31Main.resolutionHeight;

    @Override
    public GwtApplicationConfiguration getConfig() {
	return new GwtApplicationConfiguration(width, height);
    }

    @Override
    public ApplicationListener getApplicationListener() {
	return new LD31Main();
    }
}