package mapPieces;

public class BackgroundPiece {
	private float xPosition;
	private	float yPosition;
	private boolean isItPosibleToPass;
	private boolean isItPosibleToSwim;
	
	
	public BackgroundPiece(float xPosition, float yPosition, boolean isItPossibleToPass){
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		isItPosibleToSwim = false;
		this.isItPosibleToPass = isItPossibleToPass;
	}
	public float getxPosition() {
		return xPosition;
	}
	public float getyPosition() {
		return yPosition;
	}
	public boolean isItPosibleToPass() {
		return isItPosibleToPass;
	}
	public boolean isItPosibleToSwim() {
		return isItPosibleToSwim;
	}
}
