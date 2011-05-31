package SamsRTS;
import java.awt.event.*;

public class Controller {
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	Controller(){
		up = false;
		down = false;
		left = false;
		right = false;
	}

	public void keyDown(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_W:
				up = true;
				break;
			case KeyEvent.VK_D:
				right = true;
				break;
			case KeyEvent.VK_S:
				down = true;
				break;
			case KeyEvent.VK_A:
				left = true;
				break;
		}
	}

	public void keyUp(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_W:
				up = false;
				break;
			case KeyEvent.VK_D:
				right = false;
				break;
			case KeyEvent.VK_S:
				down = false;
				break;
			case KeyEvent.VK_A:
				left = false;
				break;
		}
	}

	
}
