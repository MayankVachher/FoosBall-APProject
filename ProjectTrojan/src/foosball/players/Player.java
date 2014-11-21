package foosball.players;

import foosball.environment.Ball;
import foosball.math.Coordinates;
import foosball.math.GameConstants;
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
		b.direction.negateDeltaX();
		b.position = b.direction.nextStep(b.position);
	}
	
	public void updateCoordinate(int x, int y) {
		this.position = new Coordinates(x,y);
	}
	
	public Team getTeam() {
		return team;
	}
	@Override
	public void midHit(Ball b, boolean negateX, boolean teamPos) {
		if (teamPos == false) {
			b.position.x += 10;
			if(negateX)
				b.direction.negateDeltaX();
	
			if (!negateX) {
				Coordinates a2 = new Coordinates(GameConstants.screenWidth, GameConstants.screenHeight / 2);
				b.direction.updateEndCoord(a2);
				b.direction.updateStartCoord(b.position);
				b.direction.printDel();
			}
		} else {
			b.position.x -= 10;
			if(negateX)
				b.direction.negateDeltaX();
	
			if (!negateX) {
				Coordinates a2 = new Coordinates(0, GameConstants.screenHeight / 2);
				b.direction.updateEndCoord(a2);
				b.direction.updateStartCoord(b.position);
				b.direction.printDel();
			}
		}
	}
	@Override
	public void hitTowards(Ball b, Coordinates towards) {
		b.direction.updateStartCoord(b.position);
		b.direction.updateEndCoord(towards);
	}

}
