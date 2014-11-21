package foosball.panels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import foosball.math.GameConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class HomePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton playButton, HTPButton, aboutButton;
	private JPanel headerPanel, buttonPanelContainer, buttonPanel, mainPanel, frame;
	
	public HomePanel() {
		initUI();
		setVisible(true);
	}

	private void initUI() {
		
		playButton = new JButton("Play");
		HTPButton = new JButton("How To Play");
		aboutButton = new JButton("About");		


		headerPanel = new JPanel(new GridLayout(1,1));
		buttonPanel = new JPanel(new GridLayout(1,7));
 		buttonPanelContainer = new JPanel(new GridLayout(3,1));
 		mainPanel = new JPanel(new GridLayout(2,1));
 		frame = new JPanel(new GridLayout(1,1));
 
 		//headerPanel Work
 		ImageIcon image = new ImageIcon("img/header.jpg");
 		JLabel bgLabel = new JLabel("", image, JLabel.CENTER);
 		bgLabel.setBackground(Color.BLUE);
 		headerPanel.add(bgLabel);
 		
 		//buttonPanel Work - 3 buttons together (a.k.a middle row)
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(playButton);
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(HTPButton);
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(aboutButton);
 		buttonPanel.add(new JLabel(""));
 		
 		//buttonPanelContainer Work - container for 2 empty panels and buttonPanel
 		buttonPanelContainer.add(new JLabel(""));
 		buttonPanelContainer.add(buttonPanel);
 		buttonPanelContainer.add(new JLabel(""));
 		
 		//add header and buttonPanelContainer to mainPanel 	
 		mainPanel.add(headerPanel,BorderLayout.SOUTH);
 		mainPanel.add(buttonPanelContainer,BorderLayout.SOUTH);
 		frame.add(mainPanel,BorderLayout.CENTER);
 		this.setLayout(new GridLayout(1,1));
 		this.add(frame);
 		
 		
		//ActionListeners
		playButton.addActionListener(this);
		HTPButton.addActionListener(this);
		aboutButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playButton) {
				frame.removeAll();
				frame.add(new GamePanel());
				frame.revalidate();
				frame.repaint();
		}
		else if(e.getSource() == HTPButton) {
			System.exit(0);
		}
		else if(e.getSource() == aboutButton) {
			System.exit(0);
		}
	}
}
