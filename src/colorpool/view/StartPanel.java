package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JTextField;

import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private Image foreground = null;
	private Image background = null;
	private Image loadingImg = null;
	private JTextField text;
	
	private boolean loading;
	private boolean toWrite;
	
	public StartPanel(ColorPoolFrame frame) {
		super();
		setLayout(null);
		
		loading = true;
		toWrite = true;
		
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
		else if(!loading&&toWrite)
			writePress();
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
		repaint();
	}
	
	private void writePress() { 
		toWrite = false;
		text = new JTextField();
		text.setBounds(300, 580, 800, 64);
		text.setForeground(Color.WHITE);
		text.setFont(BitBold.getFont().deriveFont(Font.BOLD, 40f));
		text.setOpaque(false);
    	text.setBorder(null);
    	text.setEditable(false);
		text.setText("PRESS ANY KEY TO START");
		text.setHorizontalAlignment(JTextField.CENTER);
		this.add(text);
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

}
