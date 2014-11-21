package foosball.panels;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JPanel{

	public JPanel aboutPanel;
	
	public AboutPanel()
	{
		
		aboutPanel= new JPanel(new GridLayout(1,1));
		
		ImageIcon aboutImage = new ImageIcon("img/about.jpg");
 		JLabel aboutLabel = new JLabel("", aboutImage, JLabel.CENTER);
 		aboutPanel.add(aboutLabel);
	}
}
