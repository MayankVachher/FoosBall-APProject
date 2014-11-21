package foosball.environment;

import foosball.math.Coordinates;
import foosball.math.Physics;
import foosball.math.Vector;
import foosball.strategy.Team;

public class Ball {
	Team lastHitBy;
	public Vector direction;
	public Coordinates position;
	
	public Ball(Coordinates startPosition, Vector initialDirection) {
		this.direction = initialDirection;
		this.position = startPosition;
	}

	public void step() {
		position = direction.nextStep(position);
		System.out.println(Physics.checkEdgeCollision(this));
	}
	
	public void updateDirection(Vector direction) {
		this.direction = direction;
	}
	
	public void updateLastHit(Team t) {
		this.lastHitBy = t;
	}
	
	public boolean getTeamPos() {
		return lastHitBy.pos;
	}
}