package SamsRTS;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class MainMenu extends Main{

	BufferedImage background,anyKey;
	boolean drawingPressAnyKey = false;

	public void init(){
		try{
			background  =  ImageIO.read(new File("img/swirl.jpg"));
			anyKey		= ImageIO.read(new File("img/anykey.png"));
		}catch(IOException e){ }
	}
	
	public void run(){
		drawingPressAnyKey = (ticker % 60 < 30);
	}
	
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);
		if(drawingPressAnyKey)
			g.drawImage(anyKey,(screen.width / 2) - (anyKey.getWidth() / 2),screen.height - 180, null);
	}

	public void draw(){

	}

	public void keyReleased(KeyEvent e){
		
	}

	public void keyPressed(KeyEvent e){
		currentState = STATE_GAMEPLAY;
	}

	public void keyTyped(KeyEvent e){

	}

	public void mouseClicked(MouseEvent e){
		
	}
}
