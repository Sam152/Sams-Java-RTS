package SamsRTS;

import java.awt.*;

public class Camera {

	Point cameraPosition;
	int cameraSpeed;

	Camera(){
		cameraSpeed = 5;
		cameraPosition = new Point(0,0);
	}

	Camera(int inSpeed){
		cameraPosition = new Point(0,0);
		cameraSpeed = inSpeed;
	}

	public void moveCamera(Controller controls){
		if(controls.left)
			cameraPosition.x-= cameraSpeed;
		else if(controls.right)
			cameraPosition.x+= cameraSpeed;
		
		if(controls.up)
			cameraPosition.y-= cameraSpeed;
		else if(controls.down)
			cameraPosition.y+= cameraSpeed;
	}

	public Point position(){
		return cameraPosition;
	}

}
