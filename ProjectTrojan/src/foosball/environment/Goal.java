package foosball.environment;

import foosball.math.Coordinates;
import foosball.strategy.Team;

public class Goal {
	public Coordinates position;
	public Team team;
	
	public Goal(Coordinates pos, Team team) {
		this.position = pos;
		this.team = team;
	}

	public static void goalScored(Ball b, boolean left) {
		b.resetBallPosition(left);
	}
}