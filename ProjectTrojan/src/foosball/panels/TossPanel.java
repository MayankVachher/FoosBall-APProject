package foosball.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TossPanel extends JPanel {
	public JPanel tossPanel;
	public JButton heads, tails;
	
	public TossPanel()
	{
		tossPanel = new JPanel(new GridLayout(1,5));
		
		heads = new JButton("Heads");
		tails = new JButton("Tails");
		
		tossPanel.add(new JLabel(""));
 		tossPanel.add(heads);
 		tossPanel.add(new JLabel(""));
 		tossPanel.add(tails);
 		tossPanel.add(new JLabel(""));
	}
}
