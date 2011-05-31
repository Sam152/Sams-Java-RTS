package SamsRTS;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends Main{

	private CommandCentre		playerBase;
	private Camera				camera;
	private Background			background;

	public void init(){
		playerBase =		new CommandCentre();
		camera =			new Camera();
		background =		new Background();
	}

	public void run(){
		playerBase.tick();
		camera.moveCamera(controls);
	}

	public void paint(Graphics g){
		background.draw(g,camera.position(),screen);
		playerBase.draw(g,camera.position(),screen);
	}

	public void mouseClicked(MouseEvent e){
		playerBase.clicked(e,camera.position());
	}
	
	public void keyReleased(KeyEvent e){

	}

	public void keyPressed(KeyEvent e){

	}
}
