package entity;

import movement.MovementRandomiser;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entityImages.TexturesOfBunny;
import models.Hero;

public class Entity{
	int xOn;
	int yOn;
	int pixelX;
	int pixelY;
	MovementRandomiser randomiser = MovementRandomiser.getInstance();
	TexturesOfBunny textures = new TexturesOfBunny();

	public Entity(int xOn, int yOn)
	{
		this.xOn = xOn;
		this.yOn = yOn;
		this.pixelX = xOn*46;
		this.pixelY = yOn*46;
	}

	public int getXOnMap() {
		return xOn;
	}

	public int getYOnMap() {
		return yOn;
	}

	public void update(Hero hero, int[][] map, SpriteBatch batch)
	{
		if(randomiser.decideIfWillMove(hero, this))
		{
			int randDir = randomiser.pickARandomNumber(3);
			switch(randDir)
			{
			case 0: if(canMove(0, map))
				{
					moveUp(batch);
				}break;
			case 1: if(canMove(1, map))
				{
					moveRight(batch);
				}break;
			case 2: if(canMove(2, map))
				{
					moveDown(batch);
				}break;
			case 3: if(canMove(3, map))
				{
					moveLeft(batch);
				}break;
			default: showStaticBunny(batch);
			}
			
		}
	}

	private void showStaticBunny(SpriteBatch batch) {
		batch.draw(textures.getStaticTexture(), pixelX, pixelY, 46,46);
		
	}

	private void moveUp(SpriteBatch batch) {
		int wholeMovement = 45;
		while(wholeMovement>0)
		{
			if(wholeMovement<=45 && wholeMovement>30)
			{
				batch.draw(textures.getBunnyBackStartJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=30 && wholeMovement>15)
			{
				batch.draw(textures.getBunnyBackLandingJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=15 && wholeMovement>0)
			{
				batch.draw(textures.getBunnyBackWinding(), pixelX, pixelY, 46,46 );
			}
			wholeMovement-=3;
			pixelY+=3;
			
		}
		pixelY+=1;
	}
	
	private void moveRight(SpriteBatch batch) {
		int wholeMovement = 45;
		while(wholeMovement>0)
		{
			if(wholeMovement<=45 && wholeMovement>30)
			{
				batch.draw(textures.getBunnyBackStartJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=30 && wholeMovement>15)
			{
				batch.draw(textures.getBunnyBackLandingJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=15 && wholeMovement>0)
			{
				batch.draw(textures.getBunnyBackWinding(), pixelX, pixelY, 46,46 );
			}
			wholeMovement-=3;
			pixelX+=3;
			
		}
		pixelX+=1;
	}

	private void moveLeft(SpriteBatch batch) {
		int wholeMovement = 45;
		while(wholeMovement>0)
		{
			if(wholeMovement<=45 && wholeMovement>30)
			{
				batch.draw(textures.getBunnyBackStartJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=30 && wholeMovement>15)
			{
				batch.draw(textures.getBunnyBackLandingJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=15 && wholeMovement>0)
			{
				batch.draw(textures.getBunnyBackWinding(), pixelX, pixelY, 46,46 );
			}
			wholeMovement-=3;
			pixelX-=3;
			
		}
		pixelX-=1;
	}
	
	private void moveDown(SpriteBatch batch) {
		int wholeMovement = 45;
		while(wholeMovement>0)
		{
			if(wholeMovement<=45 && wholeMovement>30)
			{
				batch.draw(textures.getBunnyBackStartJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=30 && wholeMovement>15)
			{
				batch.draw(textures.getBunnyBackLandingJump(), pixelX, pixelY, 46,46 );
			}else if(wholeMovement<=15 && wholeMovement>0)
			{
				batch.draw(textures.getBunnyBackWinding(), pixelX, pixelY, 46,46 );
			}
			wholeMovement-=3;
			pixelY-=3;
			
		}
		pixelY-=1;
		
	}
	
	private boolean canMove(int i, int[][] map) {
		switch(i)
		{
		case 0: 
		{
			if(map[xOn][yOn+1]==1)
			{
				return true;
			}
		}
		case 1:
		{
			if(map[xOn+1][yOn]==1)
			{
				return true;
			}
		}
		case 2:
		{
			if(map[xOn][yOn-1]==1)
			{
				return true;
			}
		}
		case 3:
		{
			if(map[xOn-1][yOn]==1)
			{
				return true;
			}
		}
		default: return false;
		}
		
	}
	
	public int getOnX() {
		return xOn;
	}

	public int getOnY() {
		return yOn;
	}
	

}
