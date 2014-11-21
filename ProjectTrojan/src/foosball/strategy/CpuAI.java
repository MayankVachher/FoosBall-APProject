package foosball.strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import foosball.environment.Ball;
import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.players.Player;

public class CpuAI implements ActionListener {
	Team t;
	Ball b;
	Coordinates lastMovedAt;
	public CpuAI(Team t, Ball b) {
		this.t = t;
		this.b = b;
		this.lastMovedAt = new Coordinates(0, 0);
	}
	public void moveCPU() {
		Player min_player = t.players[0];
		
		ArrayList<Integer> touchingTop = new ArrayList<Integer>();
		ArrayList<Integer> touchingBot = new ArrayList<Integer>();
		
		for (int i = 0; i < t.players.length; i++) {
			if (t.players[i].position.y >= GameConstants.screenHeight + GameConstants.step_player) {
				touchingBot.add(t.players[i].position.x);
			} if (t.players[i].position.y <= GameConstants.step_player) {
				touchingTop.add(t.players[i].position.x);
			}
		}
		
		double min_distance = b.position.distanceBetween(min_player.position);
		for (int i = 1; i < 11; i++) {
			if (t.players[i].position.y > b.position.y) {
				if (touchingTop.contains(t.players[i].position.x)) continue;
				// can't move
			}
			if (t.players[i].position.y < b.position.y) {
				if (touchingBot.contains(t.players[i].position.x)) continue;
				// can't move
			}
			double curr_dist = b.position.distanceBetween(t.players[i].position);
			if (curr_dist < min_distance) {
				min_player = t.players[i];
				min_distance = curr_dist;
			}
		}
		
		// we know the min player
		
		if (min_player.position.y > b.position.y) {
			if (touchingTop.contains(min_player.position.x)) return;
			for (int i = 0; i < 11; i++) {
				if (!touchingTop.contains(t.players[i].position.x)) {
					t.players[i].position.y -= GameConstants.step_player;
				}
			}
		} else {
			if (touchingBot.contains(min_player.position.x)) return;
			
			for (int i = 0; i < 11; i++) {
				if (!touchingBot.contains(t.players[i].position.x)) {
					t.players[i].position.y += GameConstants.step_player;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.moveCPU();
	}
}