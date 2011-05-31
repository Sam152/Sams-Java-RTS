package SamsRTS;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Sprite {

	private BufferedImage image;
	private Point position;
	private double selectionRadius;

	Sprite(){
		position = new Point();
		selectionRadius = 2;
	}

	Sprite(String filename, Point inPosition){
		try{
			image = ImageIO.read(new File("img/" + filename));
		} catch (IOException ex) {}

		position = (inPosition);
	}

	Sprite(Sprite inImage){
		image = inImage.getImage();
		position = new Point(inImage.getPosition());
	}

	BufferedImage getImage(){
		return image;
	}

	public Point getPosition(){
		return position;
	}

	public int getX(){
		return (position.x + (image.getWidth() / 2));
	}

	public int getY(){
		return (position.y + (image.getHeight() / 2));
	}

	public void draw(Graphics g, boolean selected,Point camera){
		//System.out.println(cameraPosition.toString());
		g.drawImage(image,position.x - camera.x,position.y - camera.y,null);

		if(selected){
			g.setColor(Color.GREEN);
			g.drawRoundRect(position.x - camera.x,position.y - camera.y,image.getWidth(),image.getHeight(),5,5);
		}
	}

	public int imageRadius(){
		return (image.getWidth() + image.getHeight()) / 4;
	}

	public void setPoint(Point inPoint){
		position = new Point(inPoint);
	}

	public boolean collision(Point inPoint,int inRadius){
		int collisionRadius = inRadius + imageRadius();
		System.out.println(collisionRadius);

		int distanceX = (int)Math.pow(inPoint.x - getX(),2);
		int distanceY = (int)Math.pow(inPoint.y - getY(),2);

		return	Math.sqrt(distanceX + distanceY) < collisionRadius;
	}
}
