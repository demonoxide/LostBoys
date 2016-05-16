package com.lostboy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lostboy.game.Lost_Boy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Lost_Boy.WIDTH;
		config.height = Lost_Boy.HEIGHT;
		config.title = Lost_Boy.TITLE;
		new LwjglApplication(new Lost_Boy(), config);
	}
}
