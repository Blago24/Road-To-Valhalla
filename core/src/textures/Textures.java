package textures;


import com.badlogic.gdx.graphics.Texture;

public class Textures {
	private Texture grass ;
	private Texture water;
	private Texture shop;
	private Texture bar;
	
	private Texture grassWithRocks;
	private Texture fatRock;
	private Texture thinRock;
	private Texture sapling;
	private Texture smallRock;
	private Texture fatTree;
	private Texture thenTree;
	public Textures() {
		
		this.grass = new Texture("mapImages//GrassLast.png");
	
		this.bar=new Texture("mapImages//Bar.png");
		this.grassWithRocks= new Texture("mapImages//GrassWithRocks.png");
		
		this.fatRock= new Texture("mapImages//Rock1.png");
		this.thinRock= new Texture("mapImages//rock2.png");
		this.sapling= new Texture("mapImages//Sapling.png");
		this.smallRock= new Texture("mapImages//SmallRock.png");
		this.fatTree= new Texture("mapImages//Tree1.png");
		this.thenTree= new Texture("mapImages//Tree2.png");
		
		
	}

	
	public Texture checkTheTypeForLowestLevel(int type){
		switch (type) {
		case 0:
			return this.grass;
		case 1:
			return this.grass;
			
		case 2:
			return this.grassWithRocks;
		case 3:
			return this.sapling;
		default:
			
			return this.grass;
			
		
		}
		
		
		
			
	}
	public Texture checkTheTypeForHighestLevel(int type){
		switch (type) {
		
		case 7:
			return fatRock;
		case 8:
			return thinRock;
		case 9:
			return fatTree;
		case 10:
			return thenTree;
		case 11:
			return smallRock;
		
		
		default:
			return grass;
		}
		
		
			
	}


	public Texture getBar() {
		return bar;
	}


}
