package foosball.math;

import foosball.environment.Ball;

public class Physics {
	
	public static boolean checkEdgeCollision(Ball ball) {
		
		int pos_x = ball.position.x;
		int pos_y = ball.position.y;
		int edgeBottom = GameConstants.screenHeight - GameConstants.ballDiameter - 30;
		int edgeTop = 0;
		int edgeLeft = 0;
		int edgeRight = GameConstants.screenWidth - GameConstants.ballDiameter;
		
		if (pos_y >= edgeBottom || pos_y <= edgeTop) {
			ball.direction.negateDeltaY();
			ball.position = ball.direction.nextStep(ball.position);
			return true;
		}
		
		if (pos_x <= edgeLeft || pos_x >= edgeRight) {
			ball.direction.negateDeltaX();
			ball.position = ball.direction.nextStep(ball.position);
			return true;
		}

		return false;
	}
}
