
package smallMap;

public class smallMap {
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
		this.smallMap = new Object[15][15];
		this.middleColIndex=this.smallMap[0].length/2;
		this.middleRowIndex=this.smallMap.length/2;
		
		
	}
	public int getMiddleRowIndex(){
		return this.middleRowIndex;
	}
	public int getMiddleColIndex(){
		return this.middleColIndex;
	}
	public smallMap() {

		this.startRowIndexForSmallMap = 0;
		this.endRowIndexForSmallMap = 1;
		this.startColIndexForSmallMap = 0;
		this.endColIndexForSmallMap = 1;
		
	}

	public void resetTheSmallMap() {
		this.smallMap = null;
		this.smallMap = new Object[15][15];
	}

}
