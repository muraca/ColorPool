package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private Image foreground = null;
	private Image background = null;
	
	public StartPanel(ColorPoolFrame frame) {
		super();
		StartListener listener = new StartListener(frame);
		addKeyListener(listener);
		addMouseListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background!=null)
			g.drawImage(background, 0, 0, null);
		if(foreground!=null)
			g.drawImage(foreground, 0, 0, null);
	}	
	
	public void setBackground(Image bg) {
		this.background = bg;
	}
	
	public void setForeground(Image bg) {
		this.background = bg;
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

}
