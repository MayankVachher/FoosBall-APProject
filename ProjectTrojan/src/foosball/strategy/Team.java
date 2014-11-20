package foosball.strategy;

import foosball.players.Atk;
import foosball.players.Def;
import foosball.players.GK;
import foosball.players.Mid;
import foosball.players.Player;

public class Team {
	Player[] players;
	GK goalie;
	
	int n_attackers;
	int n_defenders;
	int n_midfielders;

	public Team(int n_attackers, int n_defenders, int n_midfielders) throws Exception {
		int i = 0;
		for (; i < n_attackers; i++) {
			players[i] = new Atk();
		}
		for (; i < n_midfielders; i++) {
			players[i] = new Mid();
		}
		for (; i < n_defenders; i++) {
			players[i] = new Def();
		}
		players[i] = new GK();
		if (i != 12) throw new Exception("Number of players less than 11.");
	}
	
	public Atk getAttacker(int index) {
		int i = 0;
		i += index;
		if (index < n_attackers) 
			return (Atk) players[i];
		return null;
	}

	public Def getDefender(int index) {
		int i = n_attackers + n_midfielders;
		i += index;
		if (index < n_defenders) 
			return (Def) players[i];
		return null;
	}

	public Mid getMidfielder(int index) {
		int i = n_attackers;
		i += index;
		if (index < n_midfielders) 
			return (Mid) players[i];
		return null;
	}

	public GK getGK() {
		return (GK) players[10];
	}
	
	public Player[] getPlayers() {
		return players;
	}
}