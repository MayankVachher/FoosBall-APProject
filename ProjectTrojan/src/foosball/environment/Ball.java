package foosball.environment;

import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.math.Vector;
import foosball.strategy.Team;

public class Ball {
	Team lastHitBy;
	Vector direction;
	public Coordinates position;
	
	public Ball(Coordinates startPosition, Vector initialDirection) {
		this.direction = initialDirection;
		this.position = startPosition;
	}

	public void step() {
		position = direction.nextStep(position);
		if (position.y >= GameConstants.screenHeight - GameConstants.ballDiameter - 30) {
			direction.negateDeltaY();
			position = direction.nextStep(position);
		}
		if (position.y <= 0) {
			direction.negateDeltaY();
			position = direction.nextStep(position);
		}
		if (position.x <= 0) {
			direction.negateDeltaX();
			position = direction.nextStep(position);
		}
		if (position.x >= GameConstants.screenWidth - GameConstants.ballDiameter - 30) {
			direction.negateDeltaX();
			position = direction.nextStep(position);
		}
		
	}
	
	public void updateDirection(Vector direction) {
		this.direction = direction;
	}
	
	public void updateLastHit(Team t) {
		this.lastHitBy = t;
	}
}