package map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import models.Hero;

public class InteracterPlayerMap {
	protected int rowIndexForCurrentMap;
	protected int colIndexForCurrentMap;

	public InteracterPlayerMap(int rowIndexForCurrentMap, int colIndexForCurrentMap) {

		this.setRowIndexForCurrentMap(rowIndexForCurrentMap);
		this.setColIndexForCurrentMap(colIndexForCurrentMap);

	}
	

	public void checkForCollision(Hero hero, int[][] map) {

		int lastDir = hero.checkForDirection();
		System.out.println("LAST " + lastDir);
		// System.out.println("opaaaa "
		// +map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()-1]);
		// if(map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()]>3){
		// hero.setxPositionForMovement(100);
		// }
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 8) {
					System.out.println("ETO Go = " + i + " " + j);
				}
			}
		}
		System.out.println("da"+map[hero.getHeroMapColPositionForMovement()-1][hero.getHeroMapRowPositionForMovement()]);
		if(map[hero.getHeroMapColPositionForMovement()-1][hero.getHeroMapRowPositionForMovement()]==8){
			System.out.println("na kamuk si ");
		}
//		System.out.println("negoviq col" + hero.getHeroMapColPositionForMovement());
//		System.out.println("negoviq row=" + hero.getHeroMapRowPositionForMovement() + "-1");
//		switch (lastDir) {
//		// -1 left
//		// 1 right
//		// 2 top
//		// -2 down
//		case -1: {
//			if ((map[hero.getHeroMapColPositionForMovement()-1][hero.getHeroMapRowPositionForMovement()] < 3)
//					&& map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()] > 0) {
//				
//			}else{
//				hero.setxPositionForMovement(hero.getHeroMapColPositionForMovement() * 46);
//				hero.setxPositionForMovement(hero.getHeroMapRowPositionForMovement() * 46);
//			}
//		}
//		case 1: {
//			if ((map[hero.getHeroMapColPositionForMovement()+1][hero.getHeroMapRowPositionForMovement()] < 3)
//					&& map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()] > 0) {
//				
//			}else{
//				hero.setxPositionForMovement(hero.getHeroMapColPositionForMovement() * 46);
//				hero.setxPositionForMovement(hero.getHeroMapRowPositionForMovement() * 46);
//			}
//		}
//		case 2: {
//			if ((map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()+1] < 3)
//					&& map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()] > 0) {
//				
//			}else{
//				hero.setxPositionForMovement(hero.getHeroMapColPositionForMovement() * 46);
//				hero.setxPositionForMovement(hero.getHeroMapRowPositionForMovement() * 46);
//			}
//		}
//		case -2: {
//			if ((map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()-1] < 3)
//					&& map[hero.getHeroMapColPositionForMovement()][hero.getHeroMapRowPositionForMovement()] > 0) {
//				
//			}else{
//				hero.setxPositionForMovement(hero.getHeroMapColPositionForMovement() * 46);
//				hero.setxPositionForMovement(hero.getHeroMapRowPositionForMovement() * 46);
//				
//			}
//		}
//		}

	}

	public boolean checkForCurrentMap(Hero hero, float xPosition, float yPosition) {
		System.out.println("x----" + xPosition);
		System.out.println("y----" + yPosition);
		if (xPosition < 23 && colIndexForCurrentMap == 0) {
			hero.setxPositionForMovement(23);
			hero.setOldXPositionForMovement(23);
			hero.setOldXPositionForCollision(23);

			return false;
		} else {
			if (xPosition < 23 && colIndexForCurrentMap > 0) {
				setColIndexForCurrentMap(getColIndexForCurrentMap() - 1);
				hero.setxPositionForMovement(Gdx.graphics.getWidth() - 23);
				hero.setOldXPositionForMovement(Gdx.graphics.getWidth() - 23);
				hero.setHeroMapColPositionForMovement(14);
				hero.centralizedThePositionForCollision(Gdx.graphics.getWidth() - 23,
						hero.getHeroMapRowPositionForMovement() * 46);
				return true;
			}
		}
		if (xPosition > Gdx.graphics.getWidth() - 23 && colIndexForCurrentMap == 3) {
			hero.setxPositionForMovement(Gdx.graphics.getWidth() - 23);
			hero.setOldXPositionForMovement(Gdx.graphics.getWidth() - 23);
			return false;
		} else {
			if (xPosition > Gdx.graphics.getWidth() - 23 && colIndexForCurrentMap < 3) {
				setColIndexForCurrentMap(getColIndexForCurrentMap() + 1);
				hero.setxPositionForMovement(23);
				hero.setOldXPositionForMovement(23);
				hero.setOldXPositionForCollision(23);
				hero.setHeroMapColPositionForMovement(0);
				hero.centralizedThePositionForCollision(23, hero.getHeroMapRowPositionForMovement() * 46);
				return true;
			}
		}
		if (yPosition > Gdx.graphics.getHeight() - 23 && rowIndexForCurrentMap == 0) {
			hero.setyPositionForMovement(Gdx.graphics.getHeight() - 23);
			hero.setOldYPositionForMovement(Gdx.graphics.getHeight() - 23);
			return false;
		} else {
			if (yPosition > Gdx.graphics.getHeight() - 23 && rowIndexForCurrentMap > 0) {
				setRowIndexForCurrentMap(getRowIndexForCurrentMap() - 1);
				hero.setyPositionForMovement(23 + 138);
				hero.setOldYPositionForMovement(23 + 138);
				hero.setHeroMapRowPositionForMovement(12);
				hero.centralizedThePositionForCollision(hero.getHeroMapColPositionForMovement() * 46, 23 + 138);
				return true;
			}
		}

		if (yPosition < 138 && rowIndexForCurrentMap == 3) {
			hero.setyPositionForMovement(23);
			hero.setOldYPositionForMovement(23);
			return false;
		} else {
			if (yPosition < 138 && rowIndexForCurrentMap < 3) {
				setRowIndexForCurrentMap(getRowIndexForCurrentMap() + 1);
				hero.setyPositionForMovement(Gdx.graphics.getHeight() - 23);
				hero.setOldYPositionForMovement(Gdx.graphics.getHeight() - 23);
				hero.setHeroMapRowPositionForMovement(0);
				hero.centralizedThePositionForCollision(hero.getHeroMapColPositionForMovement() * 46,
						Gdx.graphics.getHeight() - 23);
				return true;
			}
		}
		return false;

	}

	public int getColIndexForCurrentMap() {
		return colIndexForCurrentMap;
	}

	public void setColIndexForCurrentMap(int colIndexForCurrentMap) {
		this.colIndexForCurrentMap = colIndexForCurrentMap;
	}

	public int getRowIndexForCurrentMap() {
		return rowIndexForCurrentMap;
	}

	public void setRowIndexForCurrentMap(int rowIndexForCurrentMap) {
		this.rowIndexForCurrentMap = rowIndexForCurrentMap;
	}
}
