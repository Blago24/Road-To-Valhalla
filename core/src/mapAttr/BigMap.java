package mapAttr;

public class BigMap {
	private SmallMap[][] smallMaps;
	
	public BigMap(SmallMap[][] smallMaps)
	{
		this.smallMaps = smallMaps;
	}
	
	public SmallMap getSmallMapAt(int bigX, int bigY)
	{
		return smallMaps[bigX][bigY];
	}
	
	public BigMap getWholeMap()
	{
		return new BigMap(this.smallMaps);
	}
	
	public void showSmallMapAt(int bigX, int bigY)
	{
		SmallMap currentMap = smallMaps[bigX][bigY];
		currentMap.showSmallMap();
	}
}
