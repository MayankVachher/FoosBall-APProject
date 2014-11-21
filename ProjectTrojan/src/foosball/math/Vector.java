package foosball.math;

public class Vector {
	Coordinates init;
	Coordinates fin;
	Coordinates delta;
	public int speed_x;
	public int speed_y;
	int steps;
	
	public Vector(Coordinates a1, Coordinates a2) {
		this.init = a1;
		this.fin = a2;
		delta = new Coordinates(fin.x - init.x, fin.y - init.y);
		calculateDelta();
		calculateSpeed();
	}

	private void calculateSpeed() {
		speed_x = delta.x / steps;		
		speed_y = delta.y / steps;
		if (speed_x > 5) { speed_x = 5; }
		if (speed_y > 5) { speed_y = 5; }
		if (speed_x < -5) { speed_x = -5; }
		if (speed_y < -5) { speed_y = -5; }
		
		System.out.println("SpeedX: " + speed_x + " SpeedY: " + speed_y);

	}
	
	private void calculateDelta() {
		delta.x = fin.x - init.x;
		delta.y = fin.y - init.y;
		if (delta.x == 0) delta.x = 1;
		if (delta.y == 0) delta.y = 1;
		if (Math.abs(delta.x) < Math.abs(delta.y)) {
			this.steps = Math.abs(delta.x);
		}
		else {
			this.steps = Math.abs(delta.y);
		}
		System.out.println("DeltaX: " + delta.x + " DeltaY: " + delta.y);
	}
	public void negateDeltaX() {
		speed_x = -speed_x;
	}
	
	public void negateDeltaY() {
		speed_y = -speed_y;
	}
	
	public void updateStartCoord(Coordinates a1) {
		this.init = a1;
		calculateDelta();
		calculateSpeed();
	}
	
	public void updateEndCoord(Coordinates a2) {
		this.fin = a2;
		calculateDelta();
		calculateSpeed();
	}
	
	public Coordinates nextStep(Coordinates curr) {
		int temp_x = curr.x + speed_x;
		int temp_y = curr.y + speed_y;
		Coordinates step = new Coordinates(temp_x,temp_y);
		return step;
	}
	public void printDel() {
		System.out.println("Del: "+delta.x+", "+delta.y);
	}
}