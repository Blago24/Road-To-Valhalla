package mapPieces;

import com.badlogic.gdx.graphics.Texture;

public class Grass extends BackgroundPiece{
	public Grass(float xPosition, float yPosition) {
		super(xPosition, yPosition, true);
	}

	private Texture texture = new Texture("images//grass.png");
	private boolean isItPosibleToPass = true;
	private boolean isItPosibleToSwim = false;
	

	public boolean isItPosibleToSwim() {
		return isItPosibleToSwim;
	}

	public Texture getTexture() {
		return this.texture;
	}

	public boolean isItPosibleToPass() {
		return isItPosibleToPass;
	}

}
