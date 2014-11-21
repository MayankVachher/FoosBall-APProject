package foosball.players;

import foosball.environment.Ball;
import foosball.math.Coordinates;
import foosball.strategy.Atking;
import foosball.strategy.Defing;
import foosball.strategy.Team;

public class Player implements Atking, Defing {
	public Coordinates position;
	Team team;
	
	Player(Coordinates position, Team team) {
		this.position = position;
		this.team = team;
	}
	@Override
	public void reflect(Ball b, boolean mid) {
		if(mid) {
			b.direction.negateDeltaX();
			b.position = b.direction.nextStep(b.position);
		}
		else {
			b.direction.negateDeltaY();
			b.position = b.direction.nextStep(b.position);
		}
	}
	
	public void updateCoordinate(int x, int y) {
		this.position = new Coordinates(x,y);
	}
	
	public Team getTeam() {
		return team;
	}
	@Override
	public void midHit(Ball b, boolean negateX) {
		if(negateX)
			b.direction.negateDeltaX();
		b.direction.zeroDeltaY();
		b.position = b.direction.nextStep(b.position);
	}
	@Override
	public void hitTowards(Ball b, Coordinates towards) {
		b.direction.updateStartCoord(b.position);
		b.direction.updateEndCoord(towards);
	}

}
