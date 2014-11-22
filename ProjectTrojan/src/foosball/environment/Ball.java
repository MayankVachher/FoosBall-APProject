package foosball.environment;

import java.util.Observable;

import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.math.Physics;
import foosball.math.Scoring;
import foosball.math.Vector;
import foosball.strategy.Team;

public class Ball extends Observable{
	Team lastHitBy;
	public Vector direction;
	public Coordinates position;
	private Scoring sc;
	
	public Ball(Coordinates startPosition, Vector initialDirection, Scoring sc) {
		this.direction = initialDirection;
		this.position = startPosition;
		this.sc = sc;
	}

	public void step() {
		position = direction.nextStep(position);
		Physics.checkEdgeCollision(this);
	}
	
	public void updateDirection(Vector direction) {
		this.direction = direction;
		setChanged();
		notifyObservers();
	}
	
	public void updateLastHit(Team t) {
		this.lastHitBy = t;
		setChanged();
		notifyObservers(direction.speed_x+" "+direction.speed_y);
	}
	
	public boolean getTeamPos() {
		return lastHitBy.pos;
	}

	public void resetAndMove(boolean left) {
		this.position.y = GameConstants.screenHeight / 2;
		this.position.x = GameConstants.screenWidth / 2;

		if (left) {
			this.direction.speed_x = -1;
			this.direction.speed_y = 0;
		} else {
			this.direction.speed_x = 1;
			this.direction.speed_y = 0;
		}
	}
	public void resetBallPosition(boolean left) {
		this.position.y = GameConstants.screenHeight / 2;
		this.position.x = GameConstants.screenWidth / 2;

		if (left) {
			this.direction.speed_x = -1;
			this.direction.speed_y = 0;
			this.sc.scoreRight();
		} else {
			this.direction.speed_x = 1;
			this.direction.speed_y = 0;
			this.sc.scoreLeft();
		}
	}
	public int gameFinish() {
		if(sc.left_score >= 5)
			return 1;
		if(sc.right_score >= 5)
			return 2;
		return 0;
	}
}