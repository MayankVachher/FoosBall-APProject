package foosball.strategy;

import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.players.Atk;
import foosball.players.Def;
import foosball.players.GK;
import foosball.players.Mid;
import foosball.players.Player;
import foosball.environment.Rods;

public class Team {
	public Player[] players = new Player[11];
	public Rods[] rods = new Rods[4]; 
	int n_atk;
	int n_def;
	int n_mid;
	public boolean pos; // 0 for keeper on left, 1 for keeper on right

	public Team(int n_attackers, int n_midfielders, int n_defenders, boolean pos) {
		int i = 0;
		this.n_atk = n_attackers;
		this.n_def = n_defenders;
		this.n_mid = n_midfielders;
		this.pos = pos;
		
		this.createRods(n_atk, n_mid, n_def, pos);
		Coordinates initial = new Coordinates((GameConstants.screenWidth/2),(GameConstants.screenHeight/2));

		for (; i < n_atk; i++)
			players[i] = new Atk(initial, this);
		for (; i < (n_atk+n_mid); i++)
			players[i] = new Mid(initial, this); //create Mid-fielders
		for (; i < (n_atk+n_mid+n_def); i++)
			players[i] = new Def(initial, this); //create Defenders
		players[i] = new GK(initial, this); //create Goal Keeper
		
		try {
			if (i != 10) throw new Exception("Number of players less than 11.");
		}
		catch(Exception e) {
			System.exit(0);
		}
		
		this.updatePlayerPositions(pos);
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
	
	private void createRods(int n_atk, int n_mid, int n_def, boolean pos) {
		if(pos) { // defending
			rods[0] = new Rods(350, this, 1, n_atk);
			rods[1] = new Rods(550, this, n_atk+1, n_mid);
			rods[2] = new Rods(750, this, n_atk+n_mid+1, n_def);
			rods[3] = new Rods(850, this, 0, 1);
		}
		else { // attacking
			rods[0] = new Rods(150, this, 0, 1);
			rods[1] = new Rods(250, this, n_atk+n_mid+1, n_def);
			rods[2] = new Rods(450, this, n_atk+1, n_mid);
			rods[3] = new Rods(650, this, 1, n_atk);
		}
	}
	
	private void updatePlayerPositions(boolean pos) {
		for (int i = 0; i < 4; i++)
		{
			int y_diff = (GameConstants.screenHeight/(this.rods[i].number_of_players+1));
			int y_crawl = y_diff;
			for (int j=0;j<this.rods[i].number_of_players;j++)
			{
				int temp_x = this.rods[i].pos_x - (GameConstants.player_width/2);
				int temp_y = y_crawl - (GameConstants.player_height/2);
				int start_index = this.rods[i].start;
				this.rods[i].team.players[start_index+j].updateCoordinate(temp_x, temp_y);
				y_crawl += y_diff;
			}
		}
	}
}