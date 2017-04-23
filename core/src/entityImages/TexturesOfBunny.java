package entityImages;

import com.badlogic.gdx.graphics.Texture;

public class TexturesOfBunny {
	private Texture staticTexture = new Texture("heroImages//Rabbit-front.png");
	private Texture bunnyBackStartJump = new Texture("heroImages//Rabbit-front-step1.png");
	private Texture bunnyBackLanding = new Texture("heroImages//Rabbit-front-step2.png");
	private Texture bunnyBackWinding = new Texture("heroImages//Rabbit-front-step3.png");
	
	
	
	public Texture getStaticTexture() {
		return staticTexture;
	}
	public Texture getBunnyBackStartJump() {
		return bunnyBackStartJump;
	}
	public Texture getBunnyBackLandingJump() {
		return bunnyBackLanding;
	}
	public Texture getBunnyBackWinding() {
		return bunnyBackWinding;
	}
}
