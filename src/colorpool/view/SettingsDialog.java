package colorpool.view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;

import colorpool.config.BitBold;
import colorpool.config.Settings;
import colorpool.control.SettingsListener;

public class SettingsDialog extends JDialog {
	private Dimension dim;
	
	public SettingsDialog() {
		super(ColorPoolFrame.getFrame(), "Settings");
		dim = new Dimension(400, 320);
		this.setSize(dim);
		this.setFocusable(true);
		this.setLayout(null);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		
		JLabel sp = new JLabel("Single Player Color");
		sp.setFont(BitBold.getFont().deriveFont(21f));
		sp.setBounds(0, 0, 400, 100);
		sp.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		sp.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
		sp.setForeground(Settings.singleplayercolor);
		sp.addMouseListener(new SettingsListener(0));
		this.add(sp);
		
		JLabel p1 = new JLabel("Player 1 Color");
		p1.setFont(BitBold.getFont().deriveFont(21f));
		p1.setBounds(0, 100, 400, 100);
		p1.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		p1.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
		p1.setForeground(Settings.player1color);
		p1.addMouseListener(new SettingsListener(1));
		this.add(p1);
		
		JLabel p2 = new JLabel("Player 2 Color");
		p2.setFont(BitBold.getFont().deriveFont(21f));
		p2.setBounds(0, 200, 400, 100);
		p2.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		p2.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
		p2.setForeground(Settings.player2color);
		p2.addMouseListener(new SettingsListener(2));
		this.add(p2);
		
		this.setLocation(Settings.WIDTH / 2 - 50, (Settings.HEIGHT - 200) / 2);
		
		MyOptionPane.colorComponentsBG(this, Settings.BACKGROUNDCOLOR);
	}
	

	private static SettingsDialog instance = null;
	
	public static void showSettings() {
		if(instance == null)
			instance = new SettingsDialog();
		instance.setVisible(true);
	}
	
	public static void close() {
		if(instance != null)
			instance.dispose();
	}
	
	public static void renew() {
		instance = null;
		showSettings();
	}
	
	private static final long serialVersionUID = 5225644818436569036L;

}
