package com.roadtovalhalla.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.roadtovalhalla.game.RoadToValhalla;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	
	config.width = RoadToValhalla.SCREEN_WIDTH;
	config.height = RoadToValhalla.SCREEN_HEIGHT;
	config.title = RoadToValhalla.GAME_NAME;
	new LwjglApplication(new RoadToValhalla(), config);
}
}
