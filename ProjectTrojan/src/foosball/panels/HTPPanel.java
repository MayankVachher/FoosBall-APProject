package foosball.panels;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HTPPanel extends JPanel{
	public JPanel HtpPanel;
	public JButton HTPButton;
	
	public HTPPanel(){
		
	
	HtpPanel=new JPanel(new GridLayout(1,1));
	
	ImageIcon htpImage = new ImageIcon("img/howtoplay.jpg");
	JLabel htpLabel = new JLabel("", htpImage, JLabel.CENTER);
	HtpPanel.add(htpLabel);
	}
}
