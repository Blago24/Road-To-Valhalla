package com.roadtovalhalla.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import map.SmallMap;
import map.WholeMap;

public class RoadToValhalla extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public final static int SCREEN_WIDTH = 690;
	public final static int SCREEN_HEIGHT = 690;
	public static final String GAME_NAME = "Road to Valhalla";
	public Object[][] wholeMapArray;

	public Object[][] map;
	public WholeMap wholeMap;
	public SmallMap smallMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		smallMap= new SmallMap();
		smallMap.initializingSmallMap();
		wholeMap = new WholeMap();
		wholeMap.initializingBigMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(this.batch);
	}
	private void update(SpriteBatch batch) {
		batch.begin();

		batch.end();
	}
	@Override
	public void dispose () {
		super.dispose();
	}
}
