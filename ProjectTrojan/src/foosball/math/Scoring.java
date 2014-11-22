package foosball.math;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class Scoring implements Observer{
	public int left_score = 0;
	public int right_score = 0;

	JLabel jlabel;
	
	public Scoring(JLabel jlabel) {
		this.jlabel = jlabel;
	}
	public void scoreLeft() {
		left_score += 1;
		jlabel.setText(left_score + " - " + right_score);
	}
	public void scoreRight() {
		right_score += 1;
		jlabel.setText(left_score + " - " + right_score);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("Observed value "+arg);
	}
}
