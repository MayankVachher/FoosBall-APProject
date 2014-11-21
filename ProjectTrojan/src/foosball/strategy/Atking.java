package foosball.strategy;

import foosball.environment.Ball;
import foosball.math.Coordinates;

public interface Atking {
	public void midHit(Ball b, boolean negateX);
	public void hitTowards(Ball b, Coordinates towards);
	public void reflect(Ball b, boolean mid);
}
