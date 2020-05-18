package colorpool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.config.Settings;
import colorpool.control.GameListener;
import colorpool.testbutton.TestButton;
import colorpool.testbutton.TestButtonListener;
import colorpool.view.GamePanel;

public class ColorPool {

	public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(Settings.WIDTH, Settings.HEIGHT+20);
        
        GamePanel panel = new GamePanel();
        
        TestButton testb = new TestButton();
        testb.addActionListener(new TestButtonListener());
        testb.setBounds(Settings.WIDTH-250, 0, 100, 30);
        
        panel.setLayout(null);
        panel.add(testb);
        
        GameListener gl=new GameListener(panel);
        panel.addMouseListener(gl);
        panel.addMouseMotionListener(gl);
        panel.setFocusable(true);//attivo il focus
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
            
        f.add(panel);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameLoop gameLoop = new GameLoop(panel);
		Thread t = new Thread(gameLoop);
		t.start();
	}
	
}
