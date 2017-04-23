package com.roadtovalhalla.game;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.security.auth.kerberos.KerberosKey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetLoaderParameters.LoadedCallback;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import map.InteracterPlayerMap;
import map.RenderBar;
import map.SmallMap;
import map.WholeMap;
import models.Hero;
import sizes.SizesOfObjectsOnTheMap;

import textures.Textures;

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
	public Textures loadTexturesForMap;
	public SizesOfObjectsOnTheMap sizesOfObjectsOnTheMap;
	public RenderBar bar;
private char playerType ;
public int playerChoice;
	public InteracterPlayerMap interacterPlayerMap;

	@Override
	public void create() {
		batch = new SpriteBatch();
		
		
		loadTexturesForMap = new Textures();
		smallMap = new SmallMap();
		smallMap.initializingSmallMap();

		sizesOfObjectsOnTheMap = new SizesOfObjectsOnTheMap();
		wholeMap = new WholeMap();
		wholeMap.initializingBigMap();

		System.out.println("opa");
		wholeMap.createMap(smallMap);
		System.out.println("dpdaa");
		this.wholeMapArray = wholeMap.getMap();
		hero = new Hero(8,8);

		interacterPlayerMap = new InteracterPlayerMap( 0, 0);
		// map = backgrArray.createNextSmallMapBeforeWholeIsLoaded(0, 0);
		bar = new RenderBar();
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

		smallMap.showLowestLevel(
				smallMap.getMapPiece(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, loadTexturesForMap, sizesOfObjectsOnTheMap);
		
//		interacterPlayerMap.checkForCollision(hero, smallMap.getMapPiece(interacterPlayerMap.getRowIndexForCurrentMap(),
//				interacterPlayerMap.getColIndexForCurrentMap()));
		
		hero.update(Gdx.graphics.getDeltaTime(), batch);
		smallMap.showHighestLevel(
				smallMap.getMapPiece(interacterPlayerMap.getRowIndexForCurrentMap(),
						interacterPlayerMap.getColIndexForCurrentMap()),
				batch, loadTexturesForMap, sizesOfObjectsOnTheMap);
		bar.showBar(batch, loadTexturesForMap);
		hero.choose();
		batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
