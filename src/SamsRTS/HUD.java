package SamsRTS;

import java.awt.*;

public class HUD {

	private Point position;
	private String hudString;

	HUD(){
		position = new Point(10,15);
		hudString = new String();
	}

	HUD(String inHudString){
		position = new Point(10,15);
		hudString = new String(inHudString);
	}

	public void add(String inString){
		hudString += inString;
	}

	public void add(int inInt){
		hudString += Integer.toString(inInt);
	}

	public void reset(){
		hudString = "";
	}

	public void draw(Graphics g,Point camera,Dimension screen){

		g.setColor(Color.WHITE);
		g.fillRect(0,0,screen.width,20);

		g.setColor(Color.BLACK);
		g.drawString(hudString,position.x,position.y);
	}

}
