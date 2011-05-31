package SamsRTS;

public class Unit extends SelectableObject {
	private int cost;
	private int speed;
	private int fogRadius;
	private Sprite image;

	Unit(){
		cost = 1;
		speed = 1;
		fogRadius = 1;
	}

	Unit(int inCost,int inSpeed,int inFogRadius,Sprite inImage){
		cost = inCost;
		speed = inSpeed;
		fogRadius = inFogRadius;
		image = new Sprite(inImage);
	}

	void setVars(int inCost,int inSpeed,int inFogRadius){
		cost = inCost;
		speed = inSpeed;
		fogRadius = inFogRadius;
	}
}