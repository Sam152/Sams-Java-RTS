package SamsRTS;
import java.awt.*;

public class Background {

	private Sprite background;

	Background(){
		background = new Sprite("background.png",new Point(0,0));
	}

	public void draw(Graphics g,Point camera,Dimension screen){
		
		int width = background.getImage().getWidth();
		int height = background.getImage().getHeight();

		final int backgroundBleed = 2;

		int totalX = (int) Math.ceil(screen.width / width);
		int totalY = (int) Math.ceil(screen.height / height);
		
		int bgPosX = 0;
		int bgPosY = 0;

		for(int i = -backgroundBleed; i < totalX + backgroundBleed;i++){
			for(int n = -backgroundBleed; n < totalY + backgroundBleed; n++){

				bgPosX = (i * width) - (camera.x % width);
				bgPosY = (n * height) - (camera.y % height);
				
				g.drawImage(background.getImage(),bgPosX,bgPosY,null);

			}
		}

	}
}
