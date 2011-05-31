package SamsRTS;

import java.awt.*;
import java.awt.event.*;

public class CommandCentre {

	private Sprite			base;
	private int				resources;
	private String			hud;
	private UnitBuilders	builders;
	private HUD				baseHud;
	private int				owner;

	CommandCentre(){
		resources =		0;
		hud =			new String();
		base =			new Sprite("castle.png",new Point(100,100));
		builders =		new UnitBuilders();
		baseHud =		new HUD();

	}

	CommandCentre(String sprite,Point startingPoint){
		resources =		0;
		hud =			new String();
		base =			new Sprite(sprite,startingPoint);
		builders =		new UnitBuilders();
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
	}

	public void clicked(MouseEvent e, Point camera){
		if(base.collision(new Point(camera.x + e.getX(),camera.y + e.getY()),1))
			base.check();
		//Run the builder click code and use the result to decide if we want to keep the base checked
		else if(!builders.clicked(e,new Point(base.getX(),base.getY())))
			base.uncheck();
	}

	public Sprite getBase(){
		return base;
	}
	
}
