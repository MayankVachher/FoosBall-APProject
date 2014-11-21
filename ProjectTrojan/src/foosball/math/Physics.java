package foosball.math;

import foosball.environment.Ball;
import foosball.environment.Goal;
import foosball.players.Player;
import foosball.strategy.Team;

public class Physics {
	
	public static boolean checkEdgeCollision(Ball ball) {
		
		int pos_x = ball.position.x;
		int pos_y = ball.position.y;
		int edgeBottom = GameConstants.screenHeight - GameConstants.ballDiameter - 30;
		int edgeTop = 0;
		int edgeLeft = 0;
		int goalStart = (GameConstants.screenHeight - GameConstants.goal_height)/2;
		int edgeRight = GameConstants.screenWidth - GameConstants.ballDiameter;
		
		if (pos_y >= edgeBottom || pos_y < edgeTop) {
			ball.direction.negateDeltaY();
			return true;
		}
		if (pos_x <= edgeLeft || pos_x >= edgeRight) {
			if(pos_y >= goalStart && pos_y <= goalStart+GameConstants.goal_height) {
				System.out.println("Goal!!!!");
				if (pos_x <= edgeLeft) {
					Goal.goalScored(ball, true);
				} else {
					Goal.goalScored(ball, false);
				}
			}
			else {
			ball.direction.negateDeltaX();
			}
			return true;
		}
		return false;
	}
	
	public static Player checkPlayerCollisions(Team[] teams, Ball ball) {
		for(int k = 0; k < 2; k++) {
			for (int i = 0; i < 11; i++) {
				int ball_curr_x = ball.position.x;
				int ball_curr_y = ball.position.y;
				int r = GameConstants.ballDiameter/2;
				int w = GameConstants.player_width;
				int h = GameConstants.player_height;
				int p_curr_x = teams[k].players[i].position.x;
				int p_curr_y = teams[k].players[i].position.y;
				if (ball_curr_x + r >= p_curr_x     &&
					ball_curr_x + r <= p_curr_x + w &&
					ball_curr_y + r >= p_curr_y     &&
					ball_curr_y + r <= p_curr_y + h) {
					System.out.println("Collided with Team "+(k+1)+" Player: "+i+1);
					return teams[k].players[i];
				}
			}
		}
		return null;
	}

	public static void updateBallDirection(Player collisionWith, Ball ball) {
		int x = ball.position.x;
		int y = ball.position.y;
		int r = GameConstants.ballDiameter/2;
		int w = GameConstants.player_width;
		int h = GameConstants.player_height;
		int p_x = collisionWith.position.x;
		int p_y = collisionWith.position.y;
		
		boolean def = false;
		
		if (collisionWith.getTeam().pos != ball.getTeamPos()) {
			def = true;
			System.out.println("Defence mode!");
		}
		
		if(def) { //def
			if (collisionWith.getTeam().pos == false) {
				if((x - r) > p_x) {
					if(y < p_y+(h/3)) {
						collisionWith.reflect(ball, false);
					}
					else if(y < p_y+(2*h/3)) {
						collisionWith.reflect(ball, true);
					}
					else {
						collisionWith.reflect(ball, false);
					}
				}
				else {
					collisionWith.midHit(ball, false, false);
				}
			} else {
				if((x + r) < p_x + w) {
					collisionWith.midHit(ball, false, true);
				}
				else {
					if(y < p_y+(h/3)) {
						collisionWith.reflect(ball, false);
					}
					else if(y < p_y+(2*h/3)) {
						collisionWith.reflect(ball, true);
					}
					else {
						collisionWith.reflect(ball, false);
					}
				}
			}
		}
		else { //atk
			if (collisionWith.getTeam().pos == false) {
				if(x > p_x + w) {
					// from right side
					collisionWith.midHit(ball, true, false);
				}
				else {
						collisionWith.midHit(ball, false, false);
				}
			} else {
				if(x > p_x + w) {
					// from right side
					collisionWith.midHit(ball, false, true);
				}
				else {
						collisionWith.midHit(ball, true, true);
				}
			}
		}
		ball.updateLastHit(collisionWith.getTeam());
	}
}
