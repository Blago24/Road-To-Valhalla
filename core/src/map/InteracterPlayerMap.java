package map;

import com.badlogic.gdx.Gdx;

import models.Hero;

public class InteracterPlayerMap {
	protected int rowIndexForCurrentMap;
	protected int colIndexForCurrentMap;

	public InteracterPlayerMap(int rowIndexForCurrentMap, int colIndexForCurrentMap) {

		this.setRowIndexForCurrentMap(rowIndexForCurrentMap);
		this.setColIndexForCurrentMap(colIndexForCurrentMap);
	}

	public boolean checkForCurrentMap(Hero hero, float xPosition, float yPosition) {
//		System.out.println("x" + xPosition);
//		System.out.println("y" + yPosition);
		if (xPosition < 23 && colIndexForCurrentMap == 0) {
			hero.setxPositionForMovement(23);
			hero.setOldXPositionForMovement(23);
			hero.setOldXPositionForCollision(23);
			return false;
		} else {
			if (xPosition < 23 && colIndexForCurrentMap > 0) {
				setColIndexForCurrentMap(getColIndexForCurrentMap() - 1);
				hero.setxPositionForMovement(Gdx.graphics.getWidth() - 46);
				hero.setOldXPositionForMovement(Gdx.graphics.getWidth() - 46);
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
				hero.setyPositionForMovement(23+138);
				hero.setOldYPositionForMovement(23+138);
				
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
