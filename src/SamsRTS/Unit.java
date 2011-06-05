package SamsRTS;

import java.awt.*;

public abstract class Unit {
	public static int	cost;
	private int			speed;
	private int			fogRadius;
	private Sprite		image;
	private boolean		active;
	private Point		destination;
	private boolean		moving;

	Unit(){
		cost =			1;
		speed =			10;
		fogRadius =		1;
		image =			new Sprite();
		active =		false;
		moving =		false;
	}

	Unit(String inImage,Point inPoint){
		image = new Sprite(inImage,inPoint);
		cost =			1;
		speed =			10;
		fogRadius =		1;
		active =		false;
		moving =		false;
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

	private void activate(){
		active = true;
	}

	public Sprite getSprite(){
		return image;
	}

	public void spawn(Point position){
		activate();
		image.setPoint(new Point(position));

	}

	public void moveTo(Point inPoint){
		destination = inPoint;
		moving = true;
	}

	public void tick(){
		if(isActive() && moving){

			Point currentPoint = image.getPosition();
			double moveToDistance = Math.sqrt(Math.pow(currentPoint.x - destination.x,2) + Math.pow(currentPoint.y - destination.y,2));
			double unitX = speed * (-currentPoint.x + destination.x) / moveToDistance;
			double unitY = speed * (-currentPoint.y + destination.y) / moveToDistance;
			Point moveTo = new Point((int)(currentPoint.x + unitX),(int)(currentPoint.y + unitY));
			image.setPoint(moveTo);

			if(moveToDistance < speed)
				moving = false;

		}
	}
	
}