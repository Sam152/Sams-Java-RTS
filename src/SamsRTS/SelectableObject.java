package SamsRTS;
import java.awt.*;

public class SelectableObject {
	
	boolean selected;

	SelectableObject(){
		selected = false;
	}

	void check(){
		selected = true;
	}

	void uncheck(){
		selected = false;
	}

	boolean status(){
		return selected;
	}
	
}
