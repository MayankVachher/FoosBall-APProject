package foosball.homeScreen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.Constants;

import foosball.math.GameConstants;
import foosball.panels.*;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	
	public HomeScreen() {
		initUI();
	}

	private void initUI() {
		this.add(new HomePanel(),BorderLayout.CENTER);
		setTitle("Foosball");
		setSize(GameConstants.screenWidth, GameConstants.screenHeight);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new HomeScreen();
	}

}
