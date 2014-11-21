package foosball.math;

public class Vector {
	Coordinates init;
	Coordinates fin;
	Coordinates delta;
	int steps;
	
	public Vector(Coordinates a1, Coordinates a2) {
		this.init = a1;
		this.fin = a2;
		delta = new Coordinates(fin.x - init.x, fin.y - init.y);
		if (delta.x < delta.y)
			this.steps = delta.x;
		else
			this.steps = delta.y;
	}

	public Vector(Coordinates a1, Coordinates a2, int steps) {
		this.init = a1;
		this.fin = a2;
		delta = new Coordinates(fin.x - init.x, fin.y - init.y);
		this.steps = steps;
	}	
	
	public void negateDeltaX() {
		delta.x = -delta.x;
	}
	
	public void negateDeltaY() {
		delta.y = -delta.y;
	}
	
	public void updateStartCoord(Coordinates a1) {
		this.init = a1;
		delta.x = fin.x - init.x;
		delta.y = fin.y - init.y;
		if (Math.abs(delta.x) < Math.abs(delta.y)) {
			this.steps = Math.abs(delta.x);
			if (delta.y / this.steps > 3) {
				delta.y = 3 * this.steps;
			}
		}
		else {
			this.steps = Math.abs(delta.y);
			if (delta.x / this.steps > 3) {
				delta.x = 3 * this.steps;
			}
		}
	}
	
	public void updateEndCoord(Coordinates a2) {
		this.fin = a2;
		delta.x = fin.x - init.x;
		delta.y = fin.y - init.y;
	}
	
	public Coordinates nextStep(Coordinates curr) {
		int temp_x = (int) (curr.x + (double)((delta.x) / (double)(steps)));
		int temp_y = (int) (curr.y + (double)((delta.y) / (double)(steps)));
		Coordinates step = new Coordinates(temp_x,temp_y);
		return step;
	}
	public void printDel() {
		System.out.println("Del: "+delta.x+", "+delta.y);
	}
}