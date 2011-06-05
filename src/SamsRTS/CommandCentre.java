package SamsRTS;

import java.awt.*;
import java.awt.event.*;

public class CommandCentre {

	private Sprite			base;
	private int				resources;
	private String			hud;
	private UnitBuilder		builders;
	private HUD				baseHud;
	private int				owner;

	CommandCentre(){
		resources =		0;
		hud =			new String();
		base =			new Sprite("castle.png",new Point(100,100));
		builders =		new UnitBuilder();
		baseHud =		new HUD();

	}

	CommandCentre(String sprite,Point startingPoint){
		resources =		0;
		hud =			new String();
		base =			new Sprite(sprite,startingPoint);
		builders =		new UnitBuilder();
		baseHud =		new HUD();
	}

	public void draw(Graphics g, Point cameraPosition,Dimension screen){
		base.draw(g,cameraPosition);

		if(base.isSelected())
			builders.draw(g,cameraPosition,screen);

		builders.drawUnits(g,cameraPosition);

		baseHud.draw(g, cameraPosition, screen);
	}

	public void tick(){
		baseHud.reset();
		baseHud.add("Resources: " + resources);
		resources++;

		builders.tick();
	}

	public void clicked(MouseEvent e, Point camera){

		Point relativeClick = new Point(camera.x + e.getX(),camera.y + e.getY());

		if(base.collision(relativeClick,1))
			base.check();

		//Check all of the builders in this base
		else if(!builders.clicked(e,base.getCenterPosition(),this,relativeClick))
			base.uncheck();
	}

	public Sprite getBase(){
		return base;
	}

	public boolean spendResources(int total){

		if(total < resources){
			resources -= total;
			return true;
		}else{
			return false;
		}
	}
}
