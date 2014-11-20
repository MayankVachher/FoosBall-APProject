package foosball.homeScreen;

import javax.swing.*;

import foosball.panels.*;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	
	public HomeScreen() {
		initUI();
	}

	private void initUI() {
		setTitle("Foosball");
		setSize(1000,650);
		add(new HomePanel());
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new HomeScreen();
		f.setVisible(true);
	}

}
