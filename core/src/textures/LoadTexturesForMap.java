package textures;


import com.badlogic.gdx.graphics.Texture;

public class LoadTexturesForMap {
	private Texture grass ;
	private Texture water;
	private Texture shop;
	public LoadTexturesForMap() {
		
		this.grass = new Texture("mapImages//GrassLast.png");
		
		this.water = new Texture("mapImages//Grass1.png");
		this.shop= new Texture("mapImages//shopTest.png");
		
	}

	
	public Texture checkTheTypeForLowestLevel(int type){
		switch (type) {
		case 0:
			
			return this.grass;
		case 1:
			return this.grass;
			
		case 2:
			return this.water;
		
		default:
			
			return this.grass;
			
		
		}
		
		
		
			
	}
	public Texture checkTheTypeForHighestLevel(int type){
		switch (type) {
		
		case 7:
			return shop;
		
		default:
			return grass;
		}
		
		
			
	}
}
