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
	public void reflect(Ball b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pass_forward(Ball b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(Ball b) {
		// TODO Auto-generated method stub
		
	}

}
