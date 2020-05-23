package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private Image foreground = null;
	private Image background = null;
	private Image loadingImg = null;
	
	private boolean loading;
	
	public StartPanel(ColorPoolFrame frame) {
		super();
		loading = true;
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
		if(loadingImg!=null)
			g.drawImage(loadingImg, 0, 0, null);
		else if(!loading)
			writePress(g);
	}	
	
	public void setBackground(Image bg) {
		this.background = bg;
	}
	
	public void setForeground(Image fg) {
		this.foreground = fg;
	}
	
	public void setLoadingImg(Image l) {
		this.loadingImg = l;
	}
	
	public void completed() {
		loadingImg = null;
		loading = false;
	}
	
	private void writePress(Graphics g) { 
		//TODO 
		
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

}
