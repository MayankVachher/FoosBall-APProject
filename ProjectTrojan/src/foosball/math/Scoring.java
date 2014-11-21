package foosball.math;

import javax.swing.JLabel;

public class Scoring {
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
}
