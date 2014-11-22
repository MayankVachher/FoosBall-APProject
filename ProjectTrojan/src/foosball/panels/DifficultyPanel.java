package foosball.panels;
 
import java.awt.GridLayout;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class DifficultyPanel extends JPanel{
 
	public JPanel difficultyPanel;
	public JButton easyButton,mediumButton,hardButton;
	public DifficultyPanel(){
	
	difficultyPanel = new JPanel(new GridLayout(1,7));
	
	easyButton = new JButton("Easy");
	mediumButton = new JButton("Medium");
	hardButton = new JButton("Hard");
	
	difficultyPanel.add(new JLabel(""));
	difficultyPanel.add(easyButton);
	difficultyPanel.add(new JLabel(""));
	difficultyPanel.add(mediumButton);
	difficultyPanel.add(new JLabel(""));
	difficultyPanel.add(hardButton);
	difficultyPanel.add(new JLabel(""));
 
	}
}