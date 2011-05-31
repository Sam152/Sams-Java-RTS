package SamsRTS;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends Main{

	private CommandCentre		playerBase;
	private Point				cameraPosition;
	private Background			background;
	private int					cameraSpeed;

	public void init(){
		playerBase = new CommandCentre();
		cameraPosition = new Point(0,0);
		background = new Background();
		cameraSpeed = 5;
	}

	public void run(){

		if(controls.left)
			cameraPosition.x-= cameraSpeed;
		else if(controls.right)
			cameraPosition.x+= cameraSpeed;
		if(controls.up)
			cameraPosition.y-= cameraSpeed;
		else if(controls.down)
			cameraPosition.y+= cameraSpeed;

		playerBase.tick();
	}

	public void paint(Graphics g){
		background.draw(g,cameraPosition,screen);
		playerBase.draw(g,cameraPosition);
	}

	public void mouseClicked(MouseEvent e){
		playerBase.clicked(e,cameraPosition);
	}
	
	public void keyReleased(KeyEvent e){

	}

	public void keyPressed(KeyEvent e){

	}
}
