package foosball.strategy;

import foosball.math.Coordinates;
import foosball.players.Atk;
import foosball.players.Def;
import foosball.players.GK;
import foosball.players.Mid;
import foosball.players.Player;

public class Team {
	public Player[] players;
	
	int n_atk;
	int n_def;
	int n_mid;

	public Team(int n_attackers, int n_midfielders, int n_defenders) {
		int i = 0;
		n_atk = n_attackers;
		n_def = n_defenders;
		n_mid = n_midfielders;
		
		players = new Player[11];

		for (; i < n_atk; i++) {
			Coordinates initial = new Coordinates();
			players[i] = new Atk(initial, this);
		}
		
		for (; i < (n_atk+n_mid); i++) {
			Coordinates initial = new Coordinates();
			players[i] = new Mid(initial, this); //create Mid-fielders
		}
		for (; i < (n_atk+n_mid+n_def); i++) {
			Coordinates initial = new Coordinates();
			players[i] = new Def(initial, this); //create Defenders
		}
		
		Coordinates initial = new Coordinates();
		players[i] = new GK(initial, this); //create Goal Keeper
		
		try {
			if (i != 12) throw new Exception("Number of players less than 11.");
		}
		catch(Exception e) {
			System.exit(0);
		}
	}
	
	public Atk getAttacker(int pos) {
		int i = 0;
		i += pos;
		if (pos < n_atk) 
			return (Atk) players[i];
		return null;
	}
	
	public Mid getMidfielder(int pos) {
		int i = n_atk;
		i += pos;
		if (pos < n_mid) 
			return (Mid) players[i];
		return null;
	}

	public Def getDefender(int pos) {
		int i = n_atk + n_mid;
		i += pos;
		if (pos < n_def) 
			return (Def) players[i];
		return null;
	}

	public GK getGK() {
		return (GK) players[10];
	}
	
	public Player[] getPlayers() {
		return players;
	}
}