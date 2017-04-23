package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
	float xPositionForMovement;
	float yPositionForMovement;
	float oldXPositionForMovement;
	float oldYPositionForMovement;

	float oldXPositionForCollision;
	float oldYPositionForCollision;
	int heroMapRowPositionForMovement;
	int heroMapColPositionForMovement;

	private Texture front;
	private Texture frontLeftStep;
	private Texture frontRightStep;
	private Texture left;
	private Texture leftLeftStep;
	private Texture leftRightStep;
	private Texture right;
	private Texture rightLeftStep;
	private Texture rightRightStep;
	private Texture back;
	private Texture backLeftStep;
	private Texture backRightStep;
	private Texture lastTurn;
	private Texture backRightBigStep;
	private Texture backLeftBigStep;
	private Texture rightRightBigStep;
	private Texture rightLeftBigStep;
	private Texture leftRightBigStep;
	private Texture leftLeftBigStep;
	private Texture frontRightBigStep;
	private Texture frontLeftBigStep;

	public Hero() {
	}

	public Hero(int heroMapRowPositionForMovement, int heroMapColPositionForMovement) {
		this.heroMapRowPositionForMovement = heroMapRowPositionForMovement-1;
		this.heroMapColPositionForMovement = heroMapColPositionForMovement-1;
		this.xPositionForMovement = this.heroMapColPositionForMovement*46 + 23;
		this.yPositionForMovement = Gdx.graphics.getHeight()-46-this.heroMapRowPositionForMovement*46 +23;
		this.oldXPositionForMovement = this.xPositionForMovement;
		this.oldYPositionForMovement = this.yPositionForMovement;
		centralizedThePositionForCollision(this.xPositionForMovement, this.yPositionForMovement);
		

		this.front = new Texture("heroImages//Front.png");
		this.frontLeftBigStep = new Texture("heroImages//FrontLeftBigStep.png");
		this.frontLeftStep = new Texture("heroImages//FrontLeftStep.png");
		this.frontRightBigStep = new Texture("heroImages//FrontRightBigStep.png");
		this.frontRightStep = new Texture("heroImages//FrontRightStep.png");

		this.left = new Texture("heroImages//Left.png");
		this.leftLeftBigStep = new Texture("heroImages//LeftBigLeftStep.png");
		this.leftLeftStep = new Texture("heroImages//LeftLeftStep.png");
		this.leftRightBigStep = new Texture("heroImages//LeftBigRightStep.png");
		this.leftRightStep = new Texture("heroImages//LeftRightStep.png");

		this.right = new Texture("heroImages//Right.png");
		this.rightLeftBigStep = new Texture("heroImages//RightBigLeftStep.png");
		this.rightLeftStep = new Texture("heroImages//RightLeftStep.png");
		this.rightRightBigStep = new Texture("heroImages//RightBigRightStep.png");
		this.rightRightStep = new Texture("heroImages//RightRightStep.png");

		this.back = new Texture("heroImages//Back.png");
		this.backLeftBigStep = new Texture("heroImages//BackLeftBigStep.png");
		this.backLeftStep = new Texture("heroImages//BackLeftStep.png");
		this.backRightBigStep = new Texture("heroImages//BackRightBigStep.png");
		this.backRightStep = new Texture("heroImages//BackRightStep.png");

		this.lastTurn = this.front;
	}

	public void showHero(SpriteBatch batch) {
		this.oldXPositionForMovement = this.getxPositionForMovement();
		this.oldYPositionForMovement = this.getyPositionForMovement();
		batch.draw(getLastTurn(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 56, 70);

	}

	public void update(float delta, SpriteBatch batch) {

		System.out.println("x=" + getxPositionForMovement());
		System.out.println("y=" + getyPositionForMovement());
		System.out.println("OX" + getOldXPositionForMovement());
		System.out.println("OY" + getOldYPositionForMovement());
		System.out.println("row=" + getHeroMapRowPositionForMovement());
		System.out.println("col=" + getHeroMapColPositionForMovement());
		
		if(!moveHero(batch)){
			showHero(batch);
		}
			
		updateMapBoxPositionForMovement(checkForDirection());
	}

	public boolean moveHero(SpriteBatch batch) {
		
		if (checkForDirection() == -1) {
			if (getOldXPositionForMovement() - getxPositionForMovement() < 30) {
				batch.draw(getLeftLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 30
					&& getOldXPositionForMovement() - getxPositionForMovement() < 60) {
				batch.draw(getLeftLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 60
					&& getOldXPositionForMovement() - getxPositionForMovement() < 90) {
				batch.draw(getLeftLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 90
					&& getOldXPositionForMovement() - getxPositionForMovement() < 120) {
				batch.draw(getLeftRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 120
					&& getOldXPositionForMovement() - getxPositionForMovement() < 150) {
				batch.draw(getLeftRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 150
					&& getOldXPositionForMovement() - getxPositionForMovement() < 180) {
				batch.draw(getLeftRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else {
				oldXPositionForMovement = xPositionForMovement;
			}
			moveLeft();
			return true;
		} else if (checkForDirection() == 1) {

			if (getxPositionForMovement() - getOldXPositionForMovement() < 30) {
				batch.draw(getRightLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 30
					&& getxPositionForMovement() - getOldXPositionForMovement() < 60) {
				batch.draw(getRightLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 60
					&& getxPositionForMovement() - getOldXPositionForMovement() < 90) {
				batch.draw(getRightLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 90
					&& getxPositionForMovement() - getOldXPositionForMovement() < 120) {
				batch.draw(getRightRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 120
					&& getxPositionForMovement() - getOldXPositionForMovement() < 150) {
				batch.draw(getRightRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 150
					&& getxPositionForMovement() - getOldXPositionForMovement() < 180) {
				batch.draw(getRightRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else {
				this.oldXPositionForMovement = this.xPositionForMovement;
			}
			moveRight();
			return true;
		} else if (checkForDirection() == 2) {
			if (getyPositionForMovement() - getOldYPositionForMovement() < 30) {
				batch.draw(getBackLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 30
					&& getyPositionForMovement() - getOldYPositionForMovement() < 60) {
				batch.draw(getBackLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 60
					&& getyPositionForMovement() - getOldYPositionForMovement() < 90) {
				batch.draw(getBackLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 90
					&& getyPositionForMovement() - getOldYPositionForMovement() < 120) {
				batch.draw(getBackRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 120
					&& getyPositionForMovement() - getOldYPositionForMovement() < 150) {
				batch.draw(getBackRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 150
					&& getyPositionForMovement() - getOldYPositionForMovement() < 180) {
				batch.draw(getBackRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else {
				this.oldYPositionForMovement = this.yPositionForMovement;
			}
			moveTop();
			return true;
		} else if (checkForDirection() == -2) {
			if (getOldYPositionForMovement() - getyPositionForMovement() < 30) {
				batch.draw(getFrontLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 30
					&& getOldYPositionForMovement() - getyPositionForMovement() < 60) {
				batch.draw(getFrontLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 60
					&& getOldYPositionForMovement() - getyPositionForMovement() < 90) {
				batch.draw(getFrontLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 90
					&& getOldYPositionForMovement() - getyPositionForMovement() < 120) {
				batch.draw(getFrontRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 120
					&& getOldYPositionForMovement() - getyPositionForMovement() < 150) {
				batch.draw(getFrontRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50,
						70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 150
					&& getOldYPositionForMovement() - getyPositionForMovement() < 180) {
				batch.draw(getFrontRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, 50, 70);

			} else {
				oldYPositionForMovement = yPositionForMovement;
			}
			moveBot();
			return true;

		}
		return false;
	}

	private void updateMapBoxPositionForMovement(int checkForDirection) {
		switch (checkForDirection) {
		case -1:
			if (xPositionForMovement < oldXPositionForCollision - 23) {
				setHeroMapColPositionForMovement(getHeroMapColPositionForMovement() - 1);
				oldXPositionForCollision = oldXPositionForCollision - 46;

			}
			break;
		case 1:
			if (xPositionForMovement > oldXPositionForCollision + 23) {
				setHeroMapColPositionForMovement(getHeroMapColPositionForMovement() + 1);
				oldXPositionForCollision = oldXPositionForCollision + 46;
			}
			break;
		case 2:
			if (yPositionForMovement > oldYPositionForCollision + 23) {
				setHeroMapRowPositionForMovement(getHeroMapRowPositionForMovement() - 1);
				oldYPositionForCollision = oldYPositionForCollision + 46;
			}
			break;
		case -2:
			if (yPositionForMovement < oldYPositionForCollision - 23) {
				setHeroMapRowPositionForMovement(getHeroMapRowPositionForMovement() + 1);
				oldYPositionForCollision = oldYPositionForCollision - 46;

			}
			break;
		default:
			System.out.println("error");
			break;
		}

	}

	public float getOldXPositionForMovement() {
		return oldXPositionForMovement;
	}

	public void setOldXPositionForMovement(float oldXPositionForMovement) {
		this.oldXPositionForMovement = oldXPositionForMovement;
	}

	public float getOldYPositionForMovement() {
		return oldYPositionForMovement;
	}

	public void setOldYPositionForMovement(float oldYPositionForMovement) {
		this.oldYPositionForMovement = oldYPositionForMovement;
	}

	public int checkForDirection() {
		if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)
				|| Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
			setLastTurn(right);
			return 1;
		}
		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)
				|| Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
			setLastTurn(left);
			return -1;
		}
		if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
			setLastTurn(back);
			return 2;
		}
		if (Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)
				|| Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
			setLastTurn(front);

			return -2;
		}

		return 0;

	}

	private void moveLeft() {
		this.xPositionForMovement -= 3;
	}

	private void moveRight() {
		this.xPositionForMovement += 3;
	}

	private void moveTop() {
		this.yPositionForMovement += 3;
	}

	private void moveBot() {
		this.yPositionForMovement -= 3;
	}

	public int getHeroMapRowPositionForMovement() {
		return heroMapRowPositionForMovement;
	}

	public void setHeroMapRowPositionForMovement(int heroMapRowPositionForMovement) {
		this.heroMapRowPositionForMovement = heroMapRowPositionForMovement;
	}

	public int getHeroMapColPositionForMovement() {
		return heroMapColPositionForMovement;
	}

	public void setHeroMapColPositionForMovement(int heroMapColPositionForMovement) {
		this.heroMapColPositionForMovement = heroMapColPositionForMovement;
	}

	public Texture getBack() {
		return back;
	}

	public void setBack(Texture back) {
		this.back = back;
	}

	public Texture getBackLeftStep() {
		return backLeftStep;
	}

	public void setBackLeftStep(Texture backLeftStep) {
		this.backLeftStep = backLeftStep;
	}

	public Texture getBackRightStep() {
		return backRightStep;
	}

	public void setBackRightStep(Texture backRightStep) {
		this.backRightStep = backRightStep;
	}

	public Texture getFront() {
		return front;
	}

	public void setFront(Texture front) {
		this.front = front;
	}

	public Texture getLeft() {
		return left;
	}

	public void setLeft(Texture left) {
		this.left = left;
	}

	public Texture getLeftLeftStep() {
		return leftLeftStep;
	}

	public void setLeftLeftStep(Texture leftLeftStep) {
		this.leftLeftStep = leftLeftStep;
	}

	public Texture getLeftRightStep() {
		return leftRightStep;
	}

	public void setLeftRightStep(Texture leftRightStep) {
		this.leftRightStep = leftRightStep;
	}

	public Texture getFrontRightStep() {
		return frontRightStep;
	}

	public void setFrontRightStep(Texture frontRightStep) {
		this.frontRightStep = frontRightStep;
	}

	public Texture getFrontLeftStep() {
		return frontLeftStep;
	}

	public void setFrontLeftStep(Texture frontLeftStep) {
		this.frontLeftStep = frontLeftStep;
	}

	public Texture getRight() {
		return right;
	}

	public void setRight(Texture right) {
		this.right = right;
	}

	public Texture getRightLeftStep() {
		return rightLeftStep;
	}

	public void setRightLeftStep(Texture rightLeftStep) {
		this.rightLeftStep = rightLeftStep;
	}

	public Texture getRightRightStep() {
		return rightRightStep;
	}

	public void setRightRightStep(Texture rightRightStep) {
		this.rightRightStep = rightRightStep;
	}

	public float getxPositionForMovement() {
		return xPositionForMovement;
	}

	public void setxPositionForMovement(float xPositionForMovement) {
		System.out.println("udri");
		this.xPositionForMovement = xPositionForMovement;
	}

	public float getyPositionForMovement() {
		return yPositionForMovement;
	}

	public void setyPositionForMovement(float yPositionForMovement) {
		this.yPositionForMovement = yPositionForMovement;
	}

	public Texture getLastTurn() {
		return lastTurn;
	}

	public void setLastTurn(Texture lastTurn) {
		this.lastTurn = lastTurn;
	}

	public Texture getBackRightBigStep() {
		return backRightBigStep;
	}

	public Texture getBackLeftBigStep() {
		return backLeftBigStep;
	}

	public Texture getRightRightBigStep() {
		return rightRightBigStep;
	}

	public Texture getRightLeftBigStep() {
		return rightLeftBigStep;
	}

	public Texture getLeftRightBigStep() {
		return leftRightBigStep;
	}

	public Texture getLeftLeftBigStep() {
		return leftLeftBigStep;
	}

	public Texture getFrontRightBigStep() {
		return frontRightBigStep;
	}

	public Texture getFrontLeftBigStep() {
		return frontLeftBigStep;
	}

	public void centralizedThePositionForCollision(float xPositionForMovement, float yPositionForMovement) {
		setOldXPositionForCollision(xPositionForMovement);
		setOldYPositionForCollision(yPositionForMovement);

	}

	public float getOldXPositionForCollision() {
		return oldXPositionForCollision;
	}

	public void setOldXPositionForCollision(float oldXPositionForCollision) {
		this.oldXPositionForCollision = oldXPositionForCollision;
	}

	public float getOldYPositionForCollision() {
		return oldYPositionForCollision;
	}

	public void setOldYPositionForCollision(float oldYPositionForCollision) {
		this.oldYPositionForCollision = oldYPositionForCollision;
	}

}
