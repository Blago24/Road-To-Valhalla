package map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import textures.Textures;

public class RenderBar {
	
public void showBar(SpriteBatch batch, Textures texture) {
	batch.draw(texture.getBar(),0, 0,690,138);

}
}
