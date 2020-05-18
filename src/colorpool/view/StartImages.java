package colorpool.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class StartImages {
	private ArrayList<Image> images;
	
	public StartImages() {
		images = new ArrayList<>();
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start1.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start2.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start3.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start4.png"));
	}
	
	public Image getImage(int position) {
		return images.get(position);
	}
	
	
	public int getNumPics() {
		return images.size();
	}

}
