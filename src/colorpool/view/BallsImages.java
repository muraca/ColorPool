package colorpool.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class BallsImages {
	private ArrayList<Image> images;
	private static BallsImages instance;
	
	public BallsImages() {
		images = new ArrayList<>();
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/whiteball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/redball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/orangeball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/yellowball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/greenball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/cyanball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/blueball.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/balls/purpleball.png"));
	}
	
	public static BallsImages getInstance() {
		if(instance==null)
			instance = new BallsImages();
		return instance;
	}
	
	public Image getBall(Color c) {
		if(c==Color.WHITE) {
			return images.get(0);
		}
		if(c==Color.RED) {
			return images.get(1);
		}
		if(c==Color.ORANGE) {
			return images.get(2);
		}
		if(c==Color.YELLOW) {
			return images.get(3);
		}
		if(c==Color.GREEN) {
			return images.get(4);
		}
		if(c==Color.CYAN) {
			return images.get(5);
		}
		if(c==Color.BLUE) {
			return images.get(6);
		}
		if(c==Color.MAGENTA) {
			return images.get(7);
		}
		return null;
	}
}
