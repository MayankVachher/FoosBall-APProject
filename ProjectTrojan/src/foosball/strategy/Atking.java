package foosball.strategy;

import foosball.environment.Ball;
import foosball.math.Coordinates;

public interface Atking {
	public void hitTowards(Ball b, Coordinates towards);
	public void reflect(Ball b, boolean mid);
	void midHit(Ball b, boolean negateX, boolean teamPos);
}
