package foosball.panels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class HomePanel extends JPanel implements ActionListener {

	AboutPanel about=new AboutPanel();
	HTPPanel htp=new HTPPanel();
	TossPanel toss=new TossPanel();
	TossResultPanel tossResult=new TossResultPanel();
	String[] choices = { "6-2-2","6-3-1", "5-2-3","5-3-2","5-4-1","4-2-4","4-3-3","4-4-2","4-5-1","3-3-4","3-4-3","3-5-2","3-6-1"};
	final JComboBox<String> cb = new JComboBox<String>(choices);
	TeamCompPanel teamComp=new TeamCompPanel(cb);
	DifficultyPanel level=new DifficultyPanel();
	
	String tossValue,difficultyLvl;
	String[] chosenPos=new String[3];
	int midF,def,attacker;
	
	
	
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
		toss.heads.addActionListener(this);
	 	toss.tails.addActionListener(this);
	 	tossResult.selectTeam.addActionListener(this);
	 	teamComp.OK.addActionListener(this);
	 	level.easyButton.addActionListener(this);
	 	level.mediumButton.addActionListener(this);
	 	level.hardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playButton) {
			buttonPanelContainer.remove(1);
			buttonPanelContainer.add(toss.tossPanel, 1);
			toss.tossPanel.setVisible(true);
			validate();
			this.repaint();
			/*	
			*/
		}
		if (e.getSource() == toss.heads || e.getSource() == toss.tails)
		{
			int rand=(int)(Math.random()*2);
			this.tossValue=tossResult.calcTossResult(rand);
			buttonPanelContainer.remove(1);
			buttonPanelContainer.add(tossResult.tossResultPanel, 1);
			JLabel tossLabel = new JLabel(tossValue);
	 	    tossResult.tossResultPanel.add(tossLabel,1);
			tossResult.tossResultPanel.setVisible(true);
			validate();
			this.repaint();
		
		}
		if(e.getSource() == tossResult.selectTeam)
		{
			
			buttonPanelContainer.remove(1);
			buttonPanelContainer.add(teamComp.teamCompPanel,1);
			teamComp.teamCompPanel.setVisible(true);
			validate();
			this.repaint();
			
		}
		if(e.getSource() == teamComp.OK) {
		
			String posSelection = (String)cb.getSelectedItem();
			chosenPos = posSelection.split("-");
			midF=Integer.parseInt(chosenPos[0]);
			def=Integer.parseInt(chosenPos[1]);
			attacker=Integer.parseInt(chosenPos[2]);
			buttonPanelContainer.remove(1);
			buttonPanelContainer.add(level.difficultyPanel,1);
			validate();
			this.repaint();
		}
		if (e.getSource()==level.easyButton)
		{
			difficultyLvl="Easy";
			frame.removeAll();
			frame.add(new GamePanel());
			frame.revalidate();
			frame.repaint();

		}
		if (e.getSource()==level.mediumButton)
		{
			difficultyLvl="Medium";
			frame.removeAll();
			frame.add(new GamePanel());
			frame.revalidate();
			frame.repaint();
		}
		if (e.getSource()==level.hardButton)
		{
			difficultyLvl="Hard";
			frame.removeAll();
			frame.add(new GamePanel());
			frame.revalidate();
			frame.repaint();
		}
		if(e.getSource() == HTPButton) {
			mainPanel.remove(1);
			mainPanel.add(htp.HtpPanel, 1);
			htp.HtpPanel.setVisible(true);
			validate();
			this.repaint();
		}
		if(e.getSource() == aboutButton) {

			mainPanel.remove(1);
			mainPanel.add(about.aboutPanel, 1);
			about.aboutPanel.setVisible(true);
			validate();
			this.repaint();
		}
	}
}
