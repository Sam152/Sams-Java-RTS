package SamsRTS;

import java.awt.*;

public abstract class Unit {
	private int			cost;
	private int			speed;
	private int			fogRadius;
	private Sprite		image;
	private boolean		active;
	private Point		destination;

	Unit(){
		cost =			1;
		speed =			1;
		fogRadius =		1;
		image =			new Sprite();
		active =		false;
	}

	Unit(String inImage,Point inPoint){
		image = new Sprite(inImage,inPoint);
	}

	void setVars(int inCost,int inSpeed,int inFogRadius){
		cost =			inCost;
		speed =			inSpeed;
		fogRadius =		inFogRadius;
	}

	public abstract void move();

	public void draw(Graphics g, Point camera){
		image.draw(g,camera);
	}

	public boolean isActive(){
		return active;
	}

	public void activate(){
		active = true;
	}

	public void spawn(Point position){
		activate();
		image.setPoint(new Point(position));

	}
	
}