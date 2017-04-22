package mapAttr;

public class CreateTheWholeMap {
	private Object[][] map;
	public int startRowIndexForWholeMap;
	public int endRowIndexForWholeMap;
	public int startColIndexForWholeMap;
	public int endColIndexForWholeMap;

	public CreateTheWholeMap() {}
	
	public void initializingBigMap() {
		this.map = new Object[4][4];
	}

	public void createMap(BackgroundArrayInitializer backgrArray){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.println("da");
				this.map[i][j] = backgrArray.createNextSmallMapBeforeWholeIsLoaded(i, j);
				
			}
		}
	}
	

	public Object[][] getMap() {

		return this.map;
	}

	public Object[][] getOneBoxMap(int i, int j) {

		return (Object[][]) this.map[i][j];
	}

	public void setMap(Object[][] map) {
		this.map = map;
	}

}