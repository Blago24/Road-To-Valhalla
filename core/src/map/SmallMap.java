
package map;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sizes.SizesOfObjectsOnTheMap;

import textures.Textures;

public class SmallMap {
	private Object[][] smallMap;
	public int startRowIndexForSmallMap;
	public int endRowIndexForSmallMap;
	public int middleRowIndex;
	public int middleColIndex;
	public float middleRowXPosition;
	public float middleColYPosition;

	public int getStartColIndexForSmallMap() {
		return startColIndexForSmallMap;
	}

	public void setStartColIndexForSmallMap(int startColIndexForSmallMap) {
		this.startColIndexForSmallMap = startColIndexForSmallMap;
	}

	public int getEndColIndexForSmallMap() {
		return endColIndexForSmallMap;
	}

	public void setEndColIndexForSmallMap(int endColIndexForSmallMap) {
		this.endColIndexForSmallMap = endColIndexForSmallMap;
	}

	public int startColIndexForSmallMap;
	public int endColIndexForSmallMap;

	public int getStartRowIndexForSmallMap() {
		return startRowIndexForSmallMap;
	}

	public void setStartRowIndexForSmallMap(int startRowIndexForSmallMap) {
		this.startRowIndexForSmallMap = startRowIndexForSmallMap;
	}

	public int getEndRowIndexForSmallMap() {
		return endRowIndexForSmallMap;
	}

	public void setEndRowIndexForSmallMap(int endRowIndexForSmallMap) {
		this.endRowIndexForSmallMap = endRowIndexForSmallMap;
	}

	public void initializingSmallMap() {
		this.smallMap = new Object[13][15];
		this.middleColIndex = 5;
		this.middleRowIndex = 5;
		
	}

	public int getMiddleRowIndex() {
		return this.middleRowIndex;
	}

	public int getMiddleColIndex() {
		return this.middleColIndex;
	}

	public float getMiddleXPosition() {

		return this.middleColIndex;
	}

	public float getMiddleYPosition() {
		return this.middleRowIndex;
	}

	public SmallMap() {

		this.startRowIndexForSmallMap = 0;
		this.endRowIndexForSmallMap = 1;
		this.startColIndexForSmallMap = 0;
		this.endColIndexForSmallMap = 1;

	}

	public void resetTheSmallMap() {
		this.smallMap = null;
		this.smallMap = new Object[13][15];
	}

	public Object[][] createNextSmallMap(int rowIndexBigMap, int colIndexBigMap) {
		resetTheSmallMap();
		float xPosition = 0;
		float yPosition = Gdx.graphics.getHeight();
		for (int row = 0; row < 13; row++) {
			for (int col = 0; col < 15; col++) {

				int type = getPiece(rowIndexBigMap, colIndexBigMap, row, col);

				OnePiece onePiece = new OnePiece(type, xPosition, yPosition);
				onePiece.setPenetration(type);
				this.smallMap[row][col] = onePiece;

				onePiece = null;
				xPosition += 46;
			}
			xPosition = 0;
			yPosition -= 46;
		}

		return this.smallMap;
	}

	public Object[][] getSmallMap() {
		return this.smallMap;
	}

	public void setSmallMap(int row, int col, OnePiece onePiece) {
		this.smallMap[row][col] = onePiece;
	}

	public void showLowestLevel(int[][] array, SpriteBatch batch, Textures loadTexturesForMap,
			SizesOfObjectsOnTheMap sizesOfObjectsOnTheMap) {
		System.out.println(Gdx.graphics.getHeight());
		int y = Gdx.graphics.getHeight() - 46;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 15; j++) {
				int type = array[i][j];
				
				batch.draw(loadTexturesForMap.checkTheTypeForLowestLevel(type), j * 46, y,
						sizesOfObjectsOnTheMap.checkTheTypeForWidth(1),
						sizesOfObjectsOnTheMap.checkTheTypeForHeight(1));

			}
			System.out.println();

			y -= 46;
		}

	}

	public void showHighestLevel(int[][] array, SpriteBatch batch, Textures loadTexturesForMap,
			SizesOfObjectsOnTheMap sizesOfObjectsOnTheMap) {
		int y=Gdx.graphics.getHeight()-46;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 15; j++) {
				int type = array[i][j];

				if (type >6) {
					batch.draw(loadTexturesForMap.checkTheTypeForHighestLevel(type) ,j*46,y,
							sizesOfObjectsOnTheMap.checkTheTypeForWidth(type),
							sizesOfObjectsOnTheMap.checkTheTypeForHeight(type));
				}

			}
			y-=46;
			

		}

	}

	public Object[][] newMap(int rowIndexBigMap, int colIndexBigMap) {
		return createNextSmallMap(rowIndexBigMap, colIndexBigMap);

	}

	public int getPiece(int rowIndexBigMap, int colIndexBigMap, int row, int col) {
		int[][] array = getTheSmallMap(rowIndexBigMap, colIndexBigMap);

		return array[row][col];

	}

	public int[][] getMapPiece(int rowIndexBigMap, int colIndexBigMap) {
		return getTheSmallMap(rowIndexBigMap, colIndexBigMap);

	}

	private int[][] getTheSmallMap(int rowIndexBigMap, int colIndexBigMap) {
		switch (rowIndexBigMap) {
		case 0:
			switch (colIndexBigMap) {
			case 0:
				return getSmallMapZeroZero();
			case 1:
				return getSmallMapZeroOne();
			case 2:
				return getSmallMapZeroTwo();
			case 3:
				return getSmallMapZeroThree();
			}

		case 1:
			switch (colIndexBigMap) {
			case 0:
				return getSmallMapOneZero();
			case 1:
				return getSmallMapOneOne();
			case 2:
				return getSmallMapOneTwo();
			case 3:
				return getSmallMapOneThree();
			}
			break;
		case 2:
			switch (colIndexBigMap) {
			case 0:
				return getSmallMapTwoZero();
			case 1:
				return getSmallMapTwoOne();
			case 2:
				return getSmallMapTwoTwo();
			case 3:
				return getSmallMapTwoThree();
			}
			break;
		case 3:
			switch (colIndexBigMap) {
			case 0:
				return getSmallMapThreeZero();
			case 1:
				return getSmallMapThreeOne();
			case 2:
				return getSmallMapThreeTwo();
			case 3:
				return getSmallMapThreeThree();
			}
			break;
		}
		return getSmallMapOneOne();

	}

	public int[][] getSmallMapZeroZero() {
		return smallMapZeroZero;
	}

	public int[][] getSmallMapZeroOne() {
		return smallMapZeroOne;
	}

	public int[][] getSmallMapZeroTwo() {
		return smallMapZeroTwo;
	}

	public int[][] getSmallMapZeroThree() {
		return smallMapZeroThree;
	}

	public int[][] getSmallMapOneZero() {
		return smallMapOneZero;
	}

	public int[][] getSmallMapOneOne() {
		return smallMapOneOne;
	}

	public int[][] getSmallMapOneTwo() {
		return smallMapOneTwo;
	}

	public int[][] getSmallMapOneThree() {
		return smallMapOneThree;
	}

	public int[][] getSmallMapTwoZero() {
		return smallMapTwoZero;
	}

	public int[][] getSmallMapTwoOne() {
		return smallMapTwoOne;
	}

	public int[][] getSmallMapTwoTwo() {
		return smallMapTwoTwo;
	}

	public int[][] getSmallMapTwoThree() {
		return smallMapTwoThree;
	}

	public int[][] getSmallMapThreeZero() {
		return smallMapThreeZero;
	}

	public int[][] getSmallMapThreeOne() {
		return smallMapThreeOne;
	}

	public int[][] getSmallMapThreeTwo() {
		return smallMapThreeTwo;
	}

	public int[][] getSmallMapThreeThree() {
		return smallMapThreeThree;
	}

	private int smallMapZeroZero[][] = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1 }, 
			{ 1, 7, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 14, 1, 1, 2, 2, 1, 1, 1, 1 }, 
			{ 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 4, 1, 4, 1, 4, 11, 14, 1, 1, 1 }, 
			{ 1, 1, 16, 1, 1, 1, 3, 3, 3, 1, 7, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 1, 4, 3, 2, 3, 4, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 1, 1, 2, 1, 1 },
			{ 1, 1, 14, 1, 1, 4, 1, 4, 1, 4, 1, 1, 1, 1, 1 }, 
			{ 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 10, 1, 2, 1, 1, 1, 1, 1, 16, 1, 2, 1 }, 
			{ 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };

	private int smallMapZeroOne[][] = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 8, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 10, 10, 1 }, 
			{ 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 1, 10, 10, 10, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 },
			{ 1, 1, 11, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 16, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16 ,1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapZeroTwo[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 8, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 10, 10, 1 }, 
			{ 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 1, 10, 10, 10, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 },
			{ 1, 1, 11, 1, 14, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 16, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16 ,1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapZeroThree[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 8, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 10, 10, 1 }, 
			{ 1, 1, 8, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 10, 1 },
			{ 1, 1, 1, 1, 1, 7, 1, 1, 1, 16, 1, 10, 10, 10, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 },
			{ 1, 1, 11, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 16, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 7, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 16 ,1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapOneZero[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 7, 1, 1, 1, 1, 11, 1, 1, 1, 7, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 7, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 11, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapOneOne[][] = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1 }, 
			{ 1, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 13, 1, 1, 15, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 17, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int smallMapOneTwo[][] = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 8, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 10, 10, 1 }, 
			{ 1, 1, 8, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 1, 10, 10, 10, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 },
			{ 1, 1, 11, 1, 1, 10, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 16, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 16 ,1, 1 }, 
			{ 1, 10, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapOneThree[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 },
			{ 1, 10, 1, 1, 11, 11, 11, 1, 1, 11, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 11, 11, 11, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 11, 1, 11, 11, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 11, 1, 1, 11, 11, 11, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 11, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapTwoZero[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 4, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapTwoOne[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int smallMapTwoTwo[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapTwoThree[][] = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 9, 1, 10, 1, 9, 1, 10, 1, 9, 1, 10, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 9, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 9, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 10, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapThreeZero[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	private int smallMapThreeOne[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapThreeTwo[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
	private int smallMapThreeThree[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  };
}
