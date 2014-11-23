package foosball.panels;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import foosball.homeScreen.HomeScreen;

public class GameEnd extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton playAgain, quit;
	JPanel frame, buttonPanel, buttonPanelContainer, headerPanel;
	//JFrame game;
	ImageIcon image;
	
	public GameEnd(int team) {
		
		frame = new JPanel(new GridLayout(2,1));
		buttonPanelContainer = new JPanel(new GridLayout(3,1));
		buttonPanel = new JPanel(new GridLayout(1,10));
		headerPanel = new JPanel(new GridLayout(1,1));
		
		playAgain = new JButton("Play Again");
		quit = new JButton("Quit");
		
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(playAgain);
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(quit);
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(new JLabel(""));
		
		buttonPanelContainer.add(new JLabel(""));
		buttonPanelContainer.add(buttonPanel);
		buttonPanelContainer.add(new JLabel(""));
		
		if(team == 1) {
			image = new ImageIcon("img/team1.jpg");
		}
		else {	
			image = new ImageIcon("img/team2.jpg");
		}
		JLabel bgLabel = new JLabel("", image, JLabel.CENTER);
 		headerPanel.add(bgLabel);
 		
 		frame.add(headerPanel);
 		frame.add(buttonPanelContainer);
 		this.setLayout(new GridLayout(1,1));
 		this.add(frame);
 		
 		quit.addActionListener(this);
 		playAgain.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quit) {
			System.exit(0);
		}
		if(e.getSource() == playAgain) {
			new HomeScreen();
		}
	}
}
