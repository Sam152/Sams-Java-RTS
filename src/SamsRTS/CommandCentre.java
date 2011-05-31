package SamsRTS;

import java.awt.*;
import java.awt.event.*;

public class CommandCentre extends SelectableObject {

	private Sprite		base;
	private int			resources;
	private String		hud;
	private Unit[]		units;
	private int			owner;

	CommandCentre(){
		resources = 0;
		hud = new String();
		base = new Sprite("castle.png",new Point(100,100));
	}

	CommandCentre(String sprite,Point startingPoint){
		resources = 0;
		hud = new String();
		base = new Sprite(sprite,startingPoint);
	}

	public void draw(Graphics g, Point cameraPosition){
		base.draw(g,selected,cameraPosition);
		g.setColor(Color.BLACK);
		g.drawString(hud,10,15);
	}

	public Sprite getBase(){
		return base;
	}

	public void tick(){
		hud = "";
		resources++;
		hud += "Resources: " + resources;
	}

	public void clicked(MouseEvent e, Point camera){
		//The mouse click has collided with the base
		if(base.collision(new Point(camera.x + e.getX(),camera.y + e.getY()),1))
			check();
		else
			uncheck();
	}
	
}
