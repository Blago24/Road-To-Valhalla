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

	Texture front;
	Texture frontLeftSmallStep;
	Texture frontLeftBigStep;
	Texture frontRightSmallStep;
	Texture frontRightBigStep;
	Texture left;
	Texture leftLeftStep;
	Texture leftRightStep;
	Texture right;
	Texture rightLeftStep;
	Texture rightRightStep;
	Texture back;
	Texture backLeftStep;
	Texture backRightStep;
	Texture lastTurn;

	public Hero() {
	}

	public void centralizedThePositionForCollision(float xPositionForMovement, float yPositionForMovement){
		setOldXPositionForCollision(xPositionForMovement);
		setOldYPositionForCollision(yPositionForMovement);
	
	}


	public Hero(float xPositionForMovement, float yPositionForMovement, int heroMapRowPositionForMovement,
			int heroMapColPositionForMovement) {

<<<<<<< HEAD
		this.xPositionForMovement = xPositionForMovement+23;
		this.yPositionForMovement = yPositionForMovement+23;
		centralizedThePositionForCollision(this.xPositionForMovement,this. yPositionForMovement);

=======

		this.xPositionForMovement = xPositionForMovement+23;
		this.yPositionForMovement = yPositionForMovement+23;
		centralizedThePositionForCollision(this.xPositionForMovement,this. yPositionForMovement);
>>>>>>> epa te
		this.heroMapRowPositionForMovement = heroMapRowPositionForMovement;
		this.heroMapColPositionForMovement = heroMapColPositionForMovement;

		this.front = new Texture("heroImages//Front.png");

		this.frontLeftSmallStep = new Texture("heroImages//frontLeftSmallStep.png");
		this.frontLeftBigStep = new Texture("heroImages//frontLeftBigStep.png");
		this.frontRightSmallStep = new Texture("heroImages//frontRightSmallStep.png");
		this.frontRightBigStep = new Texture("heroImages//frontRightBigStep.png");

		this.left = new Texture("heroImages//Left.png");
		this.leftLeftStep = new Texture("heroImages//Left-LeftStep.png");
		this.leftRightStep = new Texture("heroImages//Left-RightStep.png");
		this.right = new Texture("heroImages//Right.png");
		this.rightLeftStep = new Texture("heroImages//Right-LeftStep.png");
		this.rightRightStep = new Texture("heroImages//Right-RightStep.png");
		this.back = new Texture("heroImages//Back.png");
		this.backLeftStep = new Texture("heroImages//Back-LeftStep.png");
		this.backRightStep = new Texture("heroImages//Back-RightStep.png");
		this.lastTurn = this.front;
	}

	public void showHero(SpriteBatch batch) {

		batch.draw(getLastTurn(), getxPositionForMovement()-23, getyPositionForMovement()-23, 56, 70);

	}
	
	public void update(float delta, SpriteBatch batch) {
		// System.out.println("Y-" + yPositionForMovement);
		// System.out.println("X-" + xPositionForMovement);
		// System.out.println("OY-" + oldYPositionForMovement);
		// System.out.println("OX-" + oldXPositionForMovement);
		System.out.println("x="+getxPositionForMovement());
		System.out.println("y="+getyPositionForMovement());
		System.out.println("row=" + getHeroMapRowPositionForMovement());
		System.out.println("col=" + getHeroMapColPositionForMovement());

		if (!moveHero(batch)) {
			showHero(batch);

		}

	}

	public boolean moveHero(SpriteBatch batch) {
		updateMapBoxPositionForMovement(checkForDirection());
		if (checkForDirection() == 1) {
			if (getOldXPositionForMovement() - getxPositionForMovement() < 50) {
				batch.draw(getLeftLeftStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() > 50) {
				batch.draw(getLeftRightStep(), getxPositionForMovement()-23, getyPositionForMovement()-23,50,70);

			}
			if (getOldXPositionForMovement() - getxPositionForMovement() >= 100) {
				oldXPositionForMovement = xPositionForMovement;
			}
			moveLeft();
			return true;
		} else if (checkForDirection() == -1) {
			if (getxPositionForMovement() - getOldXPositionForMovement() > 50) {
				batch.draw(getRightLeftStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() < 50) {
				batch.draw(getRightRightStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			}
			if (getxPositionForMovement() - getOldXPositionForMovement() >= 100) {
				oldXPositionForMovement = xPositionForMovement;
			}
			moveRight();
			return true;
		} else if (checkForDirection() == 2) {
			if (getyPositionForMovement() - getOldYPositionForMovement() > 50) {
				batch.draw(getBackLeftStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() < 50) {
				batch.draw(getBackRightStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			}
			if (getyPositionForMovement() - getOldYPositionForMovement() >= 100) {
				oldYPositionForMovement = yPositionForMovement;
			}
			moveTop();
			return true;
		} else if (checkForDirection() == -2) {

<<<<<<< HEAD

			if (getOldYPositionForMovement() - getyPositionForMovement() < 30) {
				batch.draw(getFrontLeftSmallStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 30
					&& getOldYPositionForMovement() - getyPositionForMovement() < 60) {
				batch.draw(getFrontLeftBigStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 60
					&& getOldYPositionForMovement() - getyPositionForMovement() < 90) {
				batch.draw(getFrontLeftSmallStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 90
					&& getOldYPositionForMovement() - getyPositionForMovement() < 120) {
				batch.draw(getFrontRightSmallStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 120
					&& getOldYPositionForMovement() - getyPositionForMovement() < 150) {
				batch.draw(getFrontRightBigStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 150) {
				batch.draw(getFrontRightSmallStep(), getxPositionForMovement(), getyPositionForMovement(), 56, 70);

=======
			if (getOldYPositionForMovement() - getyPositionForMovement() < 50) {
				batch.draw(getFrontLeftStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() > 50) {
				batch.draw(getFrontRightStep(), getxPositionForMovement()-23, getyPositionForMovement()-23, 50,70);
>>>>>>> epa te

			}
			if (getOldYPositionForMovement() - getyPositionForMovement() >= 180) {
				oldYPositionForMovement = yPositionForMovement;
			}

			moveBot();
			return true;
		}
		return false;
	}

	private void updateMapBoxPositionForMovement(int checkForDirection) {
		switch (checkForDirection) {
<<<<<<< HEAD

		case 1:
			if (xPositionForMovement < oldXPositionForCollision-23 ) {

=======
		case 1:
			if (xPositionForMovement < oldXPositionForCollision-23 ) {
>>>>>>> epa te
				setHeroMapColPositionForMovement(getHeroMapColPositionForMovement() - 1);
				oldXPositionForCollision=oldXPositionForCollision-46;
				//centralizedThePositionForCollision
			}
			break;
		case -1:
			if (xPositionForMovement > oldXPositionForCollision+23 ) {
				setHeroMapColPositionForMovement(getHeroMapColPositionForMovement() + 1);
				oldXPositionForCollision=oldXPositionForCollision+46;
			}
			break;
		case 2:
			if (yPositionForMovement > oldYPositionForCollision + 23) {
				setHeroMapRowPositionForMovement(getHeroMapRowPositionForMovement() + 1);
				oldYPositionForCollision=oldYPositionForCollision+46;
			}
			break;
		case -2:
			if (yPositionForMovement < oldYPositionForCollision - 23) {
				setHeroMapRowPositionForMovement(getHeroMapRowPositionForMovement() - 1);
				oldYPositionForCollision=oldYPositionForCollision-46;
			}
			break;
		default:
			System.out.println("error");
			break;
		}

	}

	public Texture getFrontLeftSmallStep() {
		return frontLeftSmallStep;
	}

	public Texture getFrontLeftBigStep() {
		return frontLeftBigStep;
	}

	public Texture getFrontRightSmallStep() {
		return frontRightSmallStep;
	}

	public Texture getFrontRightBigStep() {
		return frontRightBigStep;
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

	private int checkForDirection() {
		if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)
				|| Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
			setLastTurn(right);
			return -1;
		}
		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)
				|| Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
			setLastTurn(left);
			return 1;
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

}
