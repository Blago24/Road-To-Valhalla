package com.roadtovalhalla.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import map.InteracterPlayerMap;
import map.SmallMap;
import map.WholeMap;
import models.Hero;
import sizes.SizesOfObjectsOnTheMap;
import textures.LoadTexturesForMap;

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
	public Hero hero;
	public LoadTexturesForMap loadTexturesForMap;
	public SizesOfObjectsOnTheMap sizesOfObjectsOnTheMap;

	public InteracterPlayerMap interacterPlayerMap;
	
	
	@Override
	public void create () {
				batch = new SpriteBatch();
		loadTexturesForMap = new LoadTexturesForMap();
		smallMap = new SmallMap();
		smallMap.initializingSmallMap();
		
		sizesOfObjectsOnTheMap = new SizesOfObjectsOnTheMap();
		wholeMap = new WholeMap();
		wholeMap.initializingBigMap();

		System.out.println("opa");
		wholeMap.createMap(smallMap);
		System.out.println("dpdaa");
		this.wholeMapArray = wholeMap.getMap();
		interacterPlayerMap = new InteracterPlayerMap(0, 0);
		//map = backgrArray.createNextSmallMapBeforeWholeIsLoaded(0, 0);
		hero = new Hero(smallMap.getMiddleYPosition(), smallMap.getMiddleXPosition(),
				smallMap.getMiddleRowIndex(), smallMap.getMiddleColIndex());
}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(this.batch);
	}
	private void update(SpriteBatch batch) {
		batch.begin();

		interacterPlayerMap.checkForCurrentMap(hero, hero.getxPositionForMovement(), hero.getyPositionForMovement());

		smallMap.showLowestLevel(
				wholeMap.getOneBoxMap(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, loadTexturesForMap, sizesOfObjectsOnTheMap);

		hero.update(Gdx.graphics.getDeltaTime(), batch);
		smallMap.showHighestLevel(
				wholeMap.getOneBoxMap(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, loadTexturesForMap, sizesOfObjectsOnTheMap);

		batch.end();
	}
	@Override
	public void dispose () {
		super.dispose();
	}
}
