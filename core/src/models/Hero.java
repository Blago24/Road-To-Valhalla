package models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
	float height;
	float width;
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

	private Texture frontR;
	private Texture frontLeftStepR;
	private Texture frontRightStepR;
	private Texture leftR;
	private Texture leftLeftStepR;
	private Texture leftRightStepR;
	private Texture rightR;
	private Texture rightLeftStepR;
	private Texture rightRightStepR;
	private Texture backR;
	private Texture backLeftStepR;
	private Texture backRightStepR;
	private Texture lastTurnR;
	private Texture backRightBigStepR;
	private Texture backLeftBigStepR;
	private Texture rightRightBigStepR;
	private Texture rightLeftBigStepR;
	private Texture leftRightBigStepR;
	private Texture leftLeftBigStepR;
	private Texture frontRightBigStepR;
	private Texture frontLeftBigStepR;

	private Texture frontD;
	private Texture frontLeftStepD;
	private Texture frontRightStepD;
	private Texture leftD;
	private Texture leftLeftStepD;
	private Texture leftRightStepD;
	private Texture rightD;
	private Texture rightLeftStepD;
	private Texture rightRightStepD;
	private Texture backD;
	private Texture backLeftStepD;
	private Texture backRightStepD;
	private Texture lastTurnD;
	private Texture backRightBigStepD;
	private Texture backLeftBigStepD;
	private Texture rightRightBigStepD;
	private Texture rightLeftBigStepD;
	private Texture leftRightBigStepD;
	private Texture leftLeftBigStepD;
	private Texture frontRightBigStepD;
	private Texture frontLeftBigStepD;

	private Texture frontB;
	private Texture frontLeftStepB;
	private Texture frontRightStepB;
	private Texture leftB;
	private Texture leftLeftStepB;
	private Texture leftRightStepB;
	private Texture rightB;
	private Texture rightLeftStepB;
	private Texture rightRightStepB;
	private Texture backB;
	private Texture backLeftStepB;
	private Texture backRightStepB;
	private Texture lastTurnB;
	private Texture backRightBigStepB;
	private Texture backLeftBigStepB;
	private Texture rightRightBigStepB;
	private Texture rightLeftBigStepB;
	private Texture leftRightBigStepB;
	private Texture leftLeftBigStepB;
	private Texture frontRightBigStepB;
	private Texture frontLeftBigStepB;
	private Texture frontH;
	private Texture frontLeftBigStepH;
	private Texture frontLeftStepH;
	private Texture frontRightBigStepH;
	private Texture frontRightStepH;
	private Texture leftH;
	private Texture leftLeftBigStepH;
	private Texture leftLeftStepH;
	private Texture leftRightBigStepH;
	private Texture leftRightStepH;
	private Texture rightH;
	private Texture rightLeftStepH;
	private Texture rightLeftBigStepH;
	private Texture rightRightBigStepH;
	private Texture rightRightStepH;
	private Texture backH;
	private Texture backLeftBigStepH;
	private Texture backLeftStepH;
	private Texture backRightBigStepH;
	private Texture backRightStepH;
	private Texture lastTurnH;
	
	public Hero() {
	}

	public Hero(int heroMapRowPositionForMovement, int heroMapColPositionForMovement) {
		this.height=50;
		this.width=70;
		 
		this.heroMapRowPositionForMovement = heroMapRowPositionForMovement - 1;
		this.heroMapColPositionForMovement = heroMapColPositionForMovement - 1;
		this.xPositionForMovement = this.heroMapColPositionForMovement * 46 + 23;
		this.yPositionForMovement = Gdx.graphics.getHeight() - 46 - this.heroMapRowPositionForMovement * 46 + 23;
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
		this.lastTurn=this.front;
		this.frontH = this.front;
		this.frontLeftBigStepH = this.frontLeftBigStep;
		this.frontLeftStepH = this.frontLeftStep;
		this.frontRightBigStepH = this.frontRightBigStep;
		this.frontRightStepH = this.frontRightStep;

		this.leftH = this.left;
		this.leftLeftBigStepH =this.leftLeftBigStep;
		this.leftLeftStepH = this.leftLeftStep;
		this.leftRightBigStepH = this.leftRightBigStep;
		this.leftRightStepH = this.leftRightStep;

		this.rightH = this.right;
		this.rightLeftBigStepH = this.rightLeftBigStep;
		this.rightLeftStepH = this.rightLeftStep;
		this.rightRightBigStepH = this.rightRightBigStep;
		this.rightRightStepH =this.rightRightStep;

		this.backH = this.back;
		this.backLeftBigStepH = this.backLeftBigStep;
		this.backLeftStepH = this.backLeftStep;
		this.backRightBigStepH =this.backRightBigStep;
		this.backRightStepH =this.backRightStep;
		this.lastTurnH=this.frontH;
		
		this.frontR = new Texture("heroImages//Rabbit-front.png");
		this.frontLeftStepR = new Texture("heroImages//Rabbit-front-step1.png");
		this.frontRightStepR = new Texture("heroImages//Rabbit-front-step2.png");
		this.frontLeftBigStepR = new Texture("heroImages//Rabbit-front-step2.png");
		this.frontRightBigStepR = new Texture("heroImages//Rabbit-front-step3.png");

		this.leftR = new Texture("heroImages//Rabbit-left.png");
		this.leftLeftStepR = new Texture("heroImages//Rabbit-left-step1.png");
		this.leftRightStepR = new Texture("heroImages//Rabbit-left-step2.png");
		this.leftLeftBigStepR = new Texture("heroImages//Rabbit-left-step2.png");
		this.leftRightBigStepR = new Texture("heroImages//Rabbit-left-step3.png");

		this.rightR = new Texture("heroImages//Rabbit-right.png");
		this.rightLeftStepR = new Texture("heroImages//Rabbit-right-step1.png");
		this.rightRightStepR = new Texture("heroImages//Rabbit-right-step2.png");
		this.rightLeftBigStepR = new Texture("heroImages//Rabbit-right-step2.png");
		this.rightRightBigStepR = new Texture("heroImages//Rabbit-right-step3.png");

		this.backR = new Texture("heroImages//Rabbit-back.png");
		this.backLeftStepR = new Texture("heroImages//Rabbit-back-step1.png");
		this.backRightStepR = new Texture("heroImages//Rabbit-back-step2.png");
		this.backRightBigStepR = new Texture("heroImages//Rabbit-back-step2.png");
		this.backLeftBigStepR = new Texture("heroImages//Rabbit-back-step3.png");
		this.lastTurnR=this.frontR;

		this.frontD = new Texture("heroImages//Deer-front.png");
		this.frontLeftStepD = new Texture("heroImages//Deer-frontStep1.png");
		this.frontRightStepD = new Texture("heroImages//Deer-frontStep2.png");
		this.frontLeftBigStepD = new Texture("heroImages//Deer-frontStep2.png");
		this.frontRightBigStepD = new Texture("heroImages//Deer-frontStep3.png");

		this.leftD = new Texture("heroImages//Deer-left.png");
		this.leftLeftStepD = new Texture("heroImages//Deer-left-step1.png");
		this.leftRightStepD = new Texture("heroImages//Deer-left-step2.png");
		this.leftLeftBigStepD = new Texture("heroImages//Deer-left-step2.png");
		this.leftRightBigStepD = new Texture("heroImages//Deer-left-step3.png");

		this.rightD = new Texture("heroImages//Deer-right.png");
		this.rightLeftStepD = new Texture("heroImages//Deer-right-step1.png");
		this.rightRightStepD = new Texture("heroImages//Deer-right-step2.png");
		this.rightLeftBigStepD = new Texture("heroImages//Deer-right-step2.png");
		this.rightRightBigStepD = new Texture("heroImages//Deer-right-step3.png");

		this.backD = new Texture("heroImages//Deer-Back.png");
		this.backLeftStepD = new Texture("heroImages//Deer-BackStep1.png");
		this.backRightStepD = new Texture("heroImages//Deer-BackStep2.png");
		this.backLeftBigStepD = new Texture("heroImages//Deer-BackStep2.png");
		this.backRightBigStepD = new Texture("heroImages//Deer-BackStep3.png");
		this.lastTurnD=this.frontD;

		this.frontB = new Texture("heroImages//Bear-front.png");
		this.frontLeftStepB = new Texture("heroImages//Bear-frontStep1.png");
		this.frontRightStepB = new Texture("heroImages//Bear-frontStep2.png");
		this.frontLeftBigStepB = new Texture("heroImages//Bear-frontStep1.png");
		this.frontRightBigStepB = new Texture("heroImages//Bear-frontStep2.png");

		this.leftB = new Texture("heroImages//Bear-left.png");
		this.leftLeftStepB = new Texture("heroImages//Bear-leftStep1.png");
		this.leftRightStepB = new Texture("heroImages//Bear-leftStep2.png");
		this.leftLeftBigStepB = new Texture("heroImages//Bear-leftStep1.png");
		this.leftRightBigStepB = new Texture("heroImages//Bear-leftStep2.png");

		this.rightB = new Texture("heroImages//Bear-right.png");
		this.rightLeftStepB = new Texture("heroImages//Bear-rightStep1.png");
		this.rightRightStepB = new Texture("heroImages//Bear-rightStep2.png");
		this.rightLeftBigStepB = new Texture("heroImages//Bear-rightStep1.png");
		this.rightRightBigStepB = new Texture("heroImages//Bear-rightStep2.png");

		this.backB = new Texture("heroImages//Bear-Back.png");
		this.backLeftStepB = new Texture("heroImages//Bear-BackStep1.png");
		this.backRightStepB = new Texture("heroImages//Bear-BackStep2.png");
		this.backLeftBigStepB = new Texture("heroImages//Bear-BackStep1.png");
		this.backRightBigStepB = new Texture("heroImages//Bear-BackStep2.png");
		this.lastTurnB=this.frontB;
		this.lastTurn = this.front;
	}

	public void showHero(SpriteBatch batch) {
		this.oldXPositionForMovement = this.getxPositionForMovement();
		this.oldYPositionForMovement = this.getyPositionForMovement();
		batch.draw(getLastTurn(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);
	}

	public void update(float delta, SpriteBatch batch) {

		System.out.println("x=" + getxPositionForMovement());
		System.out.println("y=" + getyPositionForMovement());
		System.out.println("OX" + getOldXPositionForMovement());
		System.out.println("OY" + getOldYPositionForMovement());
		System.out.println("row=" + getHeroMapRowPositionForMovement());
		System.out.println("col=" + getHeroMapColPositionForMovement());

		if (!moveHero(batch)) {
			showHero(batch);
		}

		updateMapBoxPositionForMovement(checkForDirection());
	}

	public boolean moveHero(SpriteBatch batch) {

		if (checkForDirection() == -1) {
			if (getOldXPositionForMovement() - getxPositionForMovement() < 30) {
				batch.draw(getLeftLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, height, width);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 30
					&& getOldXPositionForMovement() - getxPositionForMovement() < 60) {
				batch.draw(getLeftLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 60
					&& getOldXPositionForMovement() - getxPositionForMovement() < 90) {
				batch.draw(getLeftLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 90
					&& getOldXPositionForMovement() - getxPositionForMovement() < 120) {
				batch.draw(getLeftRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 120
					&& getOldXPositionForMovement() - getxPositionForMovement() < 150) {
				batch.draw(getLeftRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldXPositionForMovement() - getxPositionForMovement() >= 150
					&& getOldXPositionForMovement() - getxPositionForMovement() < 180) {
				batch.draw(getLeftRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else {
				oldXPositionForMovement = xPositionForMovement;
			}
			moveLeft();
			return true;
		} else if (checkForDirection() == 1) {

			if (getxPositionForMovement() - getOldXPositionForMovement() < 30) {
				batch.draw(getRightLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, height, width);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 30
					&& getxPositionForMovement() - getOldXPositionForMovement() < 60) {
				batch.draw(getRightLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, height, width);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 60
					&& getxPositionForMovement() - getOldXPositionForMovement() < 90) {
				batch.draw(getRightLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 90
					&& getxPositionForMovement() - getOldXPositionForMovement() < 120) {
				batch.draw(getRightRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 120
					&& getxPositionForMovement() - getOldXPositionForMovement() < 150) {
				batch.draw(getRightRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getxPositionForMovement() - getOldXPositionForMovement() >= 150
					&& getxPositionForMovement() - getOldXPositionForMovement() < 180) {
				batch.draw(getRightRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else {
				this.oldXPositionForMovement = this.xPositionForMovement;
			}
			moveRight();
			return true;
		} else if (checkForDirection() == 2) {
			if (getyPositionForMovement() - getOldYPositionForMovement() < 30) {
				batch.draw(getBackLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 30
					&& getyPositionForMovement() - getOldYPositionForMovement() < 60) {
				batch.draw(getBackLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, height, width);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 60
					&& getyPositionForMovement() - getOldYPositionForMovement() < 90) {
				batch.draw(getBackLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 90
					&& getyPositionForMovement() - getOldYPositionForMovement() < 120) {
				batch.draw(getBackRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 120
					&& getyPositionForMovement() - getOldYPositionForMovement() < 150) {
				batch.draw(getBackRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getyPositionForMovement() - getOldYPositionForMovement() >= 150
					&& getyPositionForMovement() - getOldYPositionForMovement() < 180) {
				batch.draw(getBackRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else {
				this.oldYPositionForMovement = this.yPositionForMovement;
			}
			moveTop();
			return true;
		} else if (checkForDirection() == -2) {
			if (getOldYPositionForMovement() - getyPositionForMovement() < 30) {
				batch.draw(getFrontLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 30
					&& getOldYPositionForMovement() - getyPositionForMovement() < 60) {
				batch.draw(getFrontLeftBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);
			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 60
					&& getOldYPositionForMovement() - getyPositionForMovement() < 90) {
				batch.draw(getFrontLeftStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 90
					&& getOldYPositionForMovement() - getyPositionForMovement() < 120) {
				batch.draw(getFrontRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 120
					&& getOldYPositionForMovement() - getyPositionForMovement() < 150) {
				batch.draw(getFrontRightBigStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23, height, width);

			} else if (getOldYPositionForMovement() - getyPositionForMovement() >= 150
					&& getOldYPositionForMovement() - getyPositionForMovement() < 180) {
				batch.draw(getFrontRightStep(), getxPositionForMovement() - 23, getyPositionForMovement() - 23,  height, width);

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

	public void choose() {

		if (Gdx.input.isKeyJustPressed(Keys.H)) {
			 height=50;
			 width=70;
			 this.lastTurn=this.lastTurnH;
			this.front = this.frontH;
			this.frontLeftBigStep = this.frontLeftBigStepH;
			this.frontLeftStep= this.frontLeftStepH;
			this.frontRightBigStep = this.frontRightBigStepH;
			this.frontRightStep= this.frontRightStepH;

			this.left = this.leftH;
			this.leftLeftBigStep =this.leftLeftBigStepH;
			this.leftLeftStep = this.leftLeftStepH;
			this.leftRightBigStep = this.leftRightBigStepH;
			this.leftRightStep = this.leftRightStepH;

			this.right = this.rightH;
			this.rightLeftBigStep = this.rightLeftBigStepH;
			this.rightLeftStep = this.rightLeftStepH;
			this.rightRightBigStep = this.rightRightBigStepH;
			this.rightRightStep =this.rightRightStepH;

			this.back = this.backH;
			this.backLeftBigStep = this.backLeftBigStepH;
			this.backLeftStep = this.backLeftStepH;
			this.backRightBigStep =this.backRightBigStepH;
			this.backRightStep =this.backRightStepH;
			

		} else if (Gdx.input.isKeyJustPressed(Keys.J)) {
			height=138;
			 width=92;
			 this.lastTurn=this.lastTurnB;
			this.front =this.frontB;
			this.frontLeftBigStep =this.frontLeftBigStepB;
			this.frontLeftStep = this.frontLeftStepB;
			this.frontRightBigStep =this.frontRightBigStepB;
			this.frontRightStep = this.frontRightStepB;

			this.left =this.leftB;
			this.leftLeftBigStep = this.leftLeftBigStepB;
			this.leftLeftStep = this.leftLeftStepB;
			this.leftRightBigStep =this.leftRightBigStepB;
			this.leftRightStep = this.leftRightStepB;

			this.right = this.rightB;
			this.rightLeftBigStep = this.rightLeftBigStepB;
			this.rightLeftStep =this.rightLeftStepB;
			this.rightRightBigStep = this.rightRightBigStepB;
			this.rightRightStep = this.rightRightStepB;

			this.back =this.backB;
			this.backLeftBigStep = this.backLeftBigStepB;
			this.backLeftStep = this.backLeftBigStepB;
			this.backRightBigStep = this.backRightBigStepB;
			this.backRightStep = this.backRightStepB;


			

		} else if (Gdx.input.isKeyPressed(Keys.K)) {
			height=138;
			 width=92;
			 this.lastTurn=this.lastTurnD;
			this.front =this.frontD;
			this.frontLeftBigStep =this.frontLeftBigStepD;
			this.frontLeftStep = this.frontLeftStepD;
			this.frontRightBigStep =this.frontRightBigStepD;
			this.frontRightStep = this.frontRightStepD;

			this.left =this.leftD;
			this.leftLeftBigStep = this.leftLeftBigStepD;
			this.leftLeftStep = this.leftLeftStepD;
			this.leftRightBigStep =this.leftRightBigStepD;
			this.leftRightStep = this.leftRightStepD;

			this.right = this.rightD;
			this.rightLeftBigStep = this.rightLeftBigStepD;
			this.rightLeftStep =this.rightLeftStepD;
			this.rightRightBigStep = this.rightRightBigStepD;
			this.rightRightStep = this.rightRightStepD;

			this.back =this.backD;
			this.backLeftBigStep = this.backLeftBigStepD;
			this.backLeftStep = this.backLeftBigStepD;
			this.backRightBigStep = this.backRightBigStepD;
			this.backRightStep = this.backRightStepD;


			

		} else if (Gdx.input.isKeyPressed(Keys.L)) {
			height=46;
			 width=46;
			 this.lastTurn=this.lastTurnR;
			this.front =this.frontR;
			this.frontLeftBigStep =this.frontLeftBigStepR;
			this.frontLeftStep = this.frontLeftStepR;
			this.frontRightBigStep =this.frontRightBigStepR;
			this.frontRightStep = this.frontRightStepR;

			this.left =this.leftR;
			this.leftLeftBigStep = this.leftLeftBigStepR;
			this.leftLeftStep = this.leftLeftStepR;
			this.leftRightBigStep =this.leftRightBigStepR;
			this.leftRightStep = this.leftRightStepR;

			this.right = this.rightR;
			this.rightLeftBigStep = this.rightLeftBigStepR;
			this.rightLeftStep =this.rightLeftStepR;
			this.rightRightBigStep = this.rightRightBigStepR;
			this.rightRightStep = this.rightRightStepR;

			this.back =this.backR;
			this.backLeftBigStep = this.backLeftBigStepR;
			this.backLeftStep = this.backLeftBigStepR;
			this.backRightBigStep = this.backRightBigStepR;
			this.backRightStep = this.backRightStepR;


			

		}
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
