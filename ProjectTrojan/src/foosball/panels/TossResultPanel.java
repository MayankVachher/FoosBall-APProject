package foosball.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TossResultPanel extends JPanel{
	public JPanel tossResultPanel;
	public JButton selectTeam;
	public TossResultPanel()
	{
		tossResultPanel = new JPanel(new GridLayout(1,7));
		
		selectTeam=new JButton("Select Team");
		
		 tossResultPanel.add(new JLabel(""));
	  	 tossResultPanel.add(selectTeam);
	  	 tossResultPanel.add(new JLabel(""));
	}
	public String calcTossResult(int rand)
	{
		if (rand==1)
			return "You win!";
		else
			return "You lose!";
		
	}
}
