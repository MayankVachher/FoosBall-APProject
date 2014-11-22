package foosball.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HTPPanel extends JPanel{
	public JButton backButton;
	JPanel buttonPanel, buttonPanelContainer;
	
	public HTPPanel(){
	backButton = new JButton("Go Back");
	buttonPanelContainer = new JPanel(new GridLayout(3,1));
	buttonPanel = new JPanel(new GridLayout(1,10));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(new JLabel(""));
	buttonPanel.add(backButton);
	buttonPanel.add(new JLabel(""));
	buttonPanelContainer.add(new JLabel(""));
	buttonPanelContainer.add(buttonPanel);
	buttonPanelContainer.add(new JLabel(""));
	this.setLayout(new GridLayout(2,1));
	ImageIcon htpImage = new ImageIcon("img/howtoplay.jpg");
	JLabel htpLabel = new JLabel("", htpImage, JLabel.CENTER);
	this.add(htpLabel,BorderLayout.CENTER);
	this.add(buttonPanelContainer,BorderLayout.SOUTH);
	}
}
