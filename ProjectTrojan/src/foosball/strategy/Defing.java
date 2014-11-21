package foosball.strategy;

import foosball.environment.Ball;

public interface Defing {
	public void reflect(Ball b, boolean mid);
	public void midHit(Ball b,  boolean negateX);
}
