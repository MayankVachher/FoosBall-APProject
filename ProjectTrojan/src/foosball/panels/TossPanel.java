package foosball.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TossPanel extends JPanel {
	public JPanel tossPanel;
	public JButton heads, tails;
	
	public TossPanel()
	{
		tossPanel = new JPanel(new GridLayout(2,5));
		
		heads = new JButton("Heads");
		tails = new JButton("Tails");
		
		tossPanel.add(new JLabel(""));
		tossPanel.add(new JLabel(""));
		JLabel tossLabel = new JLabel("Choose one to start the toss",SwingConstants.CENTER);
	 	tossLabel.setVisible(true);
	 	tossPanel.add(tossLabel);
	 	tossPanel.add(new JLabel(""));
	 	tossPanel.add(new JLabel(""));
	 	tossPanel.add(new JLabel(""));
 		tossPanel.add(heads);
 		tossPanel.add(new JLabel(""));
 		tossPanel.add(tails);
 		tossPanel.add(new JLabel(""));
	}
}
