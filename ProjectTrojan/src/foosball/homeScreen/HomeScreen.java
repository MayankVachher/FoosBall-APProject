package foosball.homeScreen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import foosball.panels.*;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	
	public HomeScreen() {
		initUI();
	}

	private void initUI() {
		this.add(new HomePanel(),BorderLayout.CENTER);
		this.setTitle("Foosball");
		this.setVisible(true);
		this.setSize(1000,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new HomeScreen();
	}

}
