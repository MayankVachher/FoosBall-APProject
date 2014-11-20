package foosball.math;

public class Vector {
	Coordinates a1;
	Coordinates a2;
	
	Coordinates diff;
	int steps;
	
	public Vector(Coordinates a1, Coordinates a2) {
		diff = new Coordinates();
		diff.x = a1.x - a2.x;
		diff.y = a1.y - a2.y;
	
		this.steps = diff.x;
	}
	
	public Vector(Coordinates a1, Coordinates a2, int steps) {
		diff = new Coordinates();
		diff.x = a1.x - a2.x;
		diff.y = a1.y - a2.y;

		this.steps = steps;
	}	
	
	public void updateStartCoord(Coordinates a1) {
		this.a1 = a1;
		diff.x = a1.x - a2.x;
		diff.y = a1.y - a2.y;
	}
	
	public void updateEndCoord(Coordinates a2) {
		this.a2 = a2;
		diff.x = a1.x - a2.x;
		diff.y = a1.y - a2.y;
	}
	
	public Coordinates nextStep(Coordinates curr) {
		Coordinates step = new Coordinates();
		step.x = (int) (curr.x + (double)((diff.x) / (double)(steps)));
		step.y = (int) (curr.y + (double)((diff.y) / (double)(steps)));
		return step;
	}
}