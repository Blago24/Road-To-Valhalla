package textures;

import com.badlogic.gdx.graphics.Texture;

public class TextureInitializer {
	private static TextureInitializer instance;
	private Texture grass = null;
	private Texture shop = null;
	
	public Texture getGrass() {
		return grass;
	}
	
	public Texture getShop() {
		return shop;
	}
	private TextureInitializer() {
		grass = new Texture("mapImages//grass.png");
		shop = new Texture("mapImages//shopTest.png");
	}
	
	public static TextureInitializer getInstance()
	{
		if(instance==null)
		{
			instance = new TextureInitializer();
		}
		return instance;
	}
}
