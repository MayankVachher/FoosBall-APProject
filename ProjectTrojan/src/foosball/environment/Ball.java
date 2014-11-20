package foosball.environment;

import foosball.math.Coordinates;
import foosball.math.Vector;
import foosball.strategy.Team;

public class Ball {
	Team lastHitBy;
	Vector direction;
	Coordinates position;
	
	public Ball(Coordinates startPosition, Vector initialDirection) {
		this.direction = initialDirection;
		this.position = startPosition;
	}

	public void step() {
		position = direction.nextStep(position);
	}
	
	public void updateDirection(Vector direction) {
		this.direction = direction;
	}
}