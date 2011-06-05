package SamsRTS;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UnitBuilder {

	private Sprite[]	builders;
	private	Unit[]		frogs;
	private Random		random;

	UnitBuilder(){
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

	public void tick(){
		for(int i = 0;i<frogs.length;i++){
			frogs[i].tick();
		}
	}

	boolean clicked(MouseEvent e,Point position, CommandCentre parentBase,Point relativeClick){

		if(e.getButton() == 3){
			moveUnits(frogs,relativeClick);
			
		}else if(e.getButton() == 1){

			boolean frogChecked = false;

			for(int n = 0;n < frogs.length;n++){
				if(frogs[n].isActive() && frogs[n].getSprite().collision(relativeClick,1)){
					if(!frogChecked){
						frogChecked = true;
						frogs[n].getSprite().check();
					}
				}else{
					frogs[n].getSprite().uncheck();
				}
			}

			boolean isClicked = false;
			for(int i = 0; i < builders.length; i++){
				if(builders[i].collision(e.getPoint(),1)){

					isClicked = true;

					Point spawnlocation = new Point(
							position.x +
							(random.nextInt() % parentBase.getBase().imageRadius()),
							position.y + parentBase.getBase().imageRadius()
							);

					switch(i){
						case 0:
							if(parentBase.spendResources(Frog.cost))
								spawnUnit(frogs,spawnlocation);

							break;
						case 1:
						break;
					}
				}
			}

			return isClicked;
		}
		return false;
	}

	public void drawUnits(Graphics g,Point camera){
		for(int i = 0; i < frogs.length; i++){
			if(frogs[i].isActive())
				frogs[i].draw(g,camera);
		}
	}

	public void spawnUnit(Unit[] units,Point inPoint){
		for(int n = 0;n < units.length; n++){
			if(!units[n].isActive()){
				units[n].spawn(inPoint);
				break;
			}
		}
	}

	public void moveUnits(Unit[] units,Point inPoint){
		for(int n = 0;n < units.length; n++){
			if(units[n].getSprite().isSelected()){
				units[n].moveTo(inPoint);
			}
		}
	}
}
