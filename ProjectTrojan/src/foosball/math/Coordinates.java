package foosball.math;

public class Coordinates {
	public int x;
	public int y;
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distanceBetween(Coordinates c2) {
		return Math.sqrt((c2.x - this.x) * (c2.x - this.x) + (c2.y - this.y) * (c2.y - this.y));
	}
}
