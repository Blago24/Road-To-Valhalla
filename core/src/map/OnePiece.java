package map;


public class OnePiece {
	private int type;
	private float xPosition;
	private	float yPosition;
private boolean isItPosibleToPass;
private boolean isItPosibleToSwim;


public OnePiece(int type,float xPosition, float yPosition){
	this.type=type;
	this.xPosition=xPosition;
	this.yPosition=yPosition;
	
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
public void setPenetration(int type){
	switch (type) {
	//water 
	case 0:
		this.isItPosibleToPass=true;
		this.isItPosibleToSwim=true;
		break;
		//grass
	case 1:
		this.isItPosibleToPass=true;
		this.isItPosibleToSwim=false;
		break;
		//everything else
	default:
		this.isItPosibleToPass=false;
		this.isItPosibleToSwim=false;
		break;
	}
	
	
}


public int getType() {
	return type;
}




}