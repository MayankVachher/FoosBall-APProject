package foosball.math;

public class ErrorMargin {
	int error_plus;
	int error_minus;
	
	public ErrorMargin(int error_plus, int error_minus) {
		this.error_plus = error_plus;
		this.error_minus = error_minus;
	}
	
	public Coordinates getErrorCoord(Coordinates coord) {
		Coordinates error = new Coordinates();
		error.x = (int) (Math.random() * (error_plus + error_minus)) + coord.x - error_minus;
		error.y = (int) (Math.random() * (error_plus + error_minus)) + coord.y - error_minus;
		return error;
	}
}
