package SamsRTS;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	//Set up our state variables
	public final static int STATE_MENU = 0;
	public final static int STATE_GAMEPLAY = 1;
	public static int currentState = STATE_MENU;
	public static final Dimension screen = new Dimension(800,600);
	public static int ticker = 0;
	public static Controller controls;

	public Main[] States = new Main[2];

	public void init()
	{
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);

		controls = new Controller();

		//Define all of our states here
		States[STATE_MENU] = new MainMenu();
		States[STATE_GAMEPLAY] = new Gameplay();

		//Initialise all our states
		for(int i = 0;i < States.length;i++)
			States[i].init();

	}

	//Running Variables
	long lastFrame = 0;
	long currentTime = 0;
	int framesPerSecond = 30;
	
	public void run(){
		while(true){
			ticker++;
			States[currentState].run();
			repaint();

			currentTime = System.currentTimeMillis();
			if(lastFrame + framesPerSecond - currentTime > 0){
				try {
					Thread.sleep(lastFrame + framesPerSecond - currentTime);
				} catch (InterruptedException ex) {}
			}
			lastFrame = System.currentTimeMillis();
		}
	}

	public void keyReleased(KeyEvent e){
		controls.keyUp(e);
		States[currentState].keyReleased(e);
	}

	public void keyPressed(KeyEvent e){
		controls.keyDown(e);
		States[currentState].keyPressed(e);
	}

	public void keyTyped(KeyEvent e){
		
	}

	public void mouseMoved(MouseEvent e){

	}

	public void mouseDragged(MouseEvent e){
		
	}

	public void mouseExited(MouseEvent e){

	}

	public void mouseEntered(MouseEvent e){
		
	}

	public void mouseReleased(MouseEvent e){
		
	}

	public void mousePressed(MouseEvent e){
		
	}

	public void mouseClicked(MouseEvent e){
		States[currentState].mouseClicked(e);
	}
	
	public void paint (Graphics g)
	{
		States[currentState].paint(g);
	}

	//Double buffering variables
	private Image dbImage;
	private Graphics dbg;
	public void update (Graphics g)
	{
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor (getForeground());
		paint (dbg);
		g.drawImage (dbImage, 0, 0, this);
	}

	public void start ()
	{
		setSize(screen);
		setFocusable(true);
		Thread th = new Thread (this);
		th.start ();
	}
}
