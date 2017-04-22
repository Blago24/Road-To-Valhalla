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
		System.out.println("x" + xPosition);
		System.out.println("y" + yPosition);
		if (xPosition < 0 && colIndexForCurrentMap == 0) {
			hero.setxPositionForMovement(0);
			hero.setOldXPositionForMovement(0);
			return false;
		} else {
			if (xPosition < 0 && colIndexForCurrentMap > 0) {
				setColIndexForCurrentMap(getColIndexForCurrentMap() - 1);
				hero.setxPositionForMovement(Gdx.graphics.getWidth() - 46);
				hero.setOldXPositionForMovement(Gdx.graphics.getWidth() - 46);
				return true;
			}
		}
		if (xPosition > Gdx.graphics.getWidth() - 46 && colIndexForCurrentMap == 3) {
			hero.setxPositionForMovement(Gdx.graphics.getWidth() - 46);
			hero.setOldXPositionForMovement(Gdx.graphics.getWidth() - 46);
			return false;
		} else {
			if (xPosition > Gdx.graphics.getWidth() - 46 && colIndexForCurrentMap < 3) {
				setColIndexForCurrentMap(getColIndexForCurrentMap() + 1);
				hero.setxPositionForMovement(0);
				hero.setOldXPositionForMovement(0);
				return true;
			}
		}
		if (yPosition > Gdx.graphics.getHeight() - 46 && rowIndexForCurrentMap == 0) {
			hero.setyPositionForMovement(Gdx.graphics.getHeight() - 46);
			hero.setOldYPositionForMovement(Gdx.graphics.getHeight() - 46);
			return false;
		} else {
			if (yPosition > Gdx.graphics.getHeight() - 46 && rowIndexForCurrentMap > 0) {
				setRowIndexForCurrentMap(getRowIndexForCurrentMap() - 1);
				hero.setyPositionForMovement(0);
				hero.setOldYPositionForMovement(0);
				return true;
			}
		}

		if (yPosition < 0 && rowIndexForCurrentMap == 3) {
			hero.setyPositionForMovement(0);
			hero.setOldYPositionForMovement(0);
			return false;
		} else {
			if (yPosition < 0 && rowIndexForCurrentMap < 3) {
				setRowIndexForCurrentMap(getRowIndexForCurrentMap() + 1);
				hero.setyPositionForMovement(Gdx.graphics.getHeight() - 46);
				hero.setOldYPositionForMovement(Gdx.graphics.getHeight() - 46);
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
