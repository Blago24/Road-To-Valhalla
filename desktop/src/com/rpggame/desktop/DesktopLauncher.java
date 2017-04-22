package com.rpggame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rpggame.RpgGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		


		//config.addIcon("images\\iconata.png", Files.FileType.Internal);
		config.width = RpgGame.SCREEN_WIDTH;
		config.height = RpgGame.SCREEN_HEIGHT;
		config.title = RpgGame.GAME_NAME;
		new LwjglApplication(new RpgGame(), config);
	
	}
}
