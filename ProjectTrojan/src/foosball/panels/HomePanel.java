package foosball.panels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;

public class HomePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton playButton, HTPButton, aboutButton;
	private JPanel headerPanel, buttonPanelContainer, buttonPanel;
	
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

 		//headerPanel Work
 		ImageIcon image = new ImageIcon("img/header.jpg");
 		JLabel bgLabel = new JLabel("", image, JLabel.CENTER);
 		headerPanel.add(bgLabel);
 		
 		//buttonPanel Work - 3 buttons together (a.k.a middle row)
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(playButton);
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(HTPButton);
 		buttonPanel.add(new JLabel(""));
 		buttonPanel.add(aboutButton);
 		buttonPanel.add(new JLabel(""));
 		
 		//lowerPanel Work - container for 2 empty panels and buttonPanel
 		buttonPanelContainer.add(new JLabel(""));
 		buttonPanelContainer.add(buttonPanel);
 		buttonPanelContainer.add(new JLabel(""));
 		
 		//add header and buttonPanelContainer to main Panel 	
 		add(headerPanel);
 		add(buttonPanelContainer);
 		
		//ActionListeners
		playButton.addActionListener(this);
		HTPButton.addActionListener(this);
		aboutButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playButton) {
			buttonPanel.setVisible(true);
			buttonPanelContainer.remove(1);
		}
		else if(e.getSource() == HTPButton) {
			System.exit(0);
		}
		else if(e.getSource() == aboutButton) {
			System.exit(0);
		}
	}
}
