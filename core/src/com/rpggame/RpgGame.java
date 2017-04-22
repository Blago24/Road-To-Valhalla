package com.rpggame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import interaction.*;
import mapAttr.BackgroundArrayInitializer;
import mapAttr.CreateTheWholeMap;
import models.Hero;
import textures.TextureInitializer;

public class RpgGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public final static int SCREEN_WIDTH = 690;
	public final static int SCREEN_HEIGHT = 690;
	public static final String GAME_NAME = "Game";
	public int counter;
	public Object[][] wholeMap;

	public Object[][] map;

	public Hero hero;
	public BackgroundArrayInitializer backgrArray;
	public CreateTheWholeMap createTheWholeMap;
	public TextureInitializer textureIniter;
	public InteracterPlayerMap interacterPlayerMap;
	
	public void setWholeMap() {
		this.wholeMap = createTheWholeMap.getMap();
	}

	@Override
	public void create() {
		counter = 0;

		batch = new SpriteBatch();

		backgrArray = new BackgroundArrayInitializer();
		backgrArray.initializingSmallMap();
		textureIniter = TextureInitializer.getInstance();
		
		createTheWholeMap = new CreateTheWholeMap();
		createTheWholeMap.initializingBigMap();

		System.out.println("opa");
		createTheWholeMap.createMap(backgrArray);
		System.out.println("dpdaa");
		this.wholeMap = createTheWholeMap.getMap();
		interacterPlayerMap = new InteracterPlayerMap(0, 0);
		map = backgrArray.createNextSmallMapBeforeWholeIsLoaded(0, 0);
		hero = new Hero(backgrArray.getMiddleYPosition(), backgrArray.getMiddleXPosition(),
				backgrArray.getMiddleRowIndex(), backgrArray.getMiddleColIndex());

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(this.batch);

	}

	private void update(SpriteBatch batch) {
		batch.begin();

		interacterPlayerMap.checkForCurrentMap(hero, hero.getxPositionForMovement(), hero.getyPositionForMovement());

		backgrArray.showLowestLevel(
				createTheWholeMap.getOneBoxMap(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, textureIniter, sizesOfObjectsOnTheMap);

		hero.update(Gdx.graphics.getDeltaTime(), batch);
		backgrArray.showHighestLevel(
				createTheWholeMap.getOneBoxMap(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, loadTexturesForMap, sizesOfObjectsOnTheMap);

		batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
