package com.barrunner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.barrunner.Global;
import com.barrunner.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = Global.GAME_NAME;
		config.width = Global.CAMERA_WIDTH;
		config.height = Global.CAMERA_HEIGHT;
		config.vSyncEnabled = true;
		
		new LwjglApplication(new Main(), config);
	}
}
