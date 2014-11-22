package foosball.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TeamCompPanel extends JPanel{
	public JPanel teamCompPanel;
	public JButton OK;
	public TeamCompPanel(JComboBox cb)
	{
		teamCompPanel = new JPanel(new GridLayout(2,5));
		OK = new JButton("OK");
		
		  teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
	 	   JLabel label = new JLabel("Def-Mid-Att",SwingConstants.CENTER);
	 	   label.setVisible(true);
	 	   teamCompPanel.add(label);
	 	   teamCompPanel.add(new JLabel("")); 
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
		   cb.setVisible(true);
		   teamCompPanel.add(cb); 
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(OK);
	 	   teamCompPanel.add(new JLabel(""));
	 	   teamCompPanel.add(new JLabel(""));
	}
}
