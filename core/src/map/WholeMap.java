package map;


public class WholeMap {
	private Object[][] map;
	
	public WholeMap() {}
	
	public void initializingBigMap() {
		this.map = new Object[4][4];
	}

	public void createMap(SmallMap smallMap){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.println("da");
				this.map[i][j] = smallMap.createNextSmallMap(i, j);
				
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