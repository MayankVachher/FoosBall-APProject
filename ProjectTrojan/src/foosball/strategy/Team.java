package foosball.strategy;

import foosball.players.Atk;
import foosball.players.Def;
import foosball.players.GK;
import foosball.players.Mid;
import foosball.players.Player;

public class Team {
	Player[] players;
	
	int n_atk;
	int n_def;
	int n_mid;

	public Team(int n_attackers, int n_midfielders, int n_defenders) throws Exception {
		int i = 0;
		n_atk = n_attackers;
		n_def = n_defenders;
		n_mid = n_midfielders;
		
		for (; i < n_atk; i++)
			players[i] = new Atk(); //create Attackers
		
		for (; i < (n_atk+n_mid); i++)
			players[i] = new Mid(); //create Mid-fielders
		
		for (; i < (n_atk+n_mid+n_def); i++)
			players[i] = new Def(); //create Defenders
		
		players[i] = new GK(); //create Goal Keeper
		
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