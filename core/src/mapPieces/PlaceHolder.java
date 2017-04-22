package mapPieces;

import com.badlogic.gdx.graphics.Texture;

public class PlaceHolder extends BackgroundPiece{
	
	
	Texture texture = new Grass(0, 0).getTexture();
	
	
	public PlaceHolder(float xPosition, float yPosition) {
		super(xPosition, yPosition, false);
	}

}
