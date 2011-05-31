package SamsRTS;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UnitBuilders {

	private Sprite[]	builders;
	private	Unit[]		frogs;
	private Random		random;

	UnitBuilders(){
		random = new Random();
		builders = new Sprite[1];
		builders[0] = new Sprite("frogpicker.jpg",new Point(0,0),true);

		frogs = new Unit[150];
		
		for(int i = 0; i < frogs.length; i++)
			frogs[i] = new Frog();

	}

	public void draw(Graphics g,Point camera,Dimension screen){
		
		for(int i = 0; i < builders.length; i++){
			int unitBuilderWidth = builders[i].getImage().getWidth();
			int unitBuilderHeight = builders[i].getImage().getHeight();
			builders[i].setPoint(new Point(i * unitBuilderWidth,screen.height - unitBuilderHeight));
			builders[i].draw(g,camera);
		}
	}

	boolean clicked(MouseEvent e,Point position){
		
		boolean isClicked = false;

		for(int i = 0; i < builders.length; i++){
			if(builders[i].collision(e.getPoint(),1)){
				
				isClicked = true;

				switch(i){
					case 0:
						for(int n = 0;n < frogs.length; n++){
							if(!frogs[n].isActive()){
								frogs[n].spawn(new Point(position.x + (random.nextInt() % 50),position.y + (random.nextInt() % 50)));
								break;
							}
						}
						break;
				}
			}
		}

		return isClicked;
	}

	public void drawUnits(Graphics g,Point camera){
		for(int i = 0; i < frogs.length; i++){
			if(frogs[i].isActive())
				frogs[i].draw(g,camera);
		}
	}
}
