package mapAttr;

import com.badlogic.gdx.graphics.Texture;

public class TestAnotherObject {
	private Texture texture = new Texture("images//shopTest.png");
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
