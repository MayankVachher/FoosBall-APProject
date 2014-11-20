package foosball.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import foosball.environment.Ball;
import foosball.environment.Rods;
import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.math.Vector;
import foosball.players.Player;
import foosball.strategy.Team;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Ball b;
	Rods[] rods = new Rods[8];
	public Team[] teams = new Team[2];
	Timer t;
	int frameCount = 0;
	private static final long serialVersionUID = 1L;
	public GamePanel() {
		Coordinates initialPosition = new Coordinates();
		initialPosition.x = 30;
		initialPosition.y = GameConstants.screenHeight / 2;
		
		Coordinates dummy = new Coordinates();
		dummy.x = 31;
		dummy.y = GameConstants.screenHeight / 2 + 1;
		
		Vector ballDirection = new Vector(initialPosition, dummy);
		b = new Ball(initialPosition, ballDirection);
		this.t = new Timer(5, this);
		t.start();
		addKeyListener((KeyListener) this);
		setFocusable(true);
		teams[0] = new Team(2, 5, 3);
		teams[1] = new Team(2, 5, 3);

		rods[0] = new Rods(100, teams[0], 0, 1);
		rods[1] = new Rods(200, teams[0], 1, 2);
		rods[2] = new Rods(300, teams[1], 8, 3);
		rods[3] = new Rods(400, teams[0], 3, 5);
		rods[4] = new Rods(500, teams[1], 3, 5);
		rods[5] = new Rods(600, teams[0], 8, 3);
		rods[6] = new Rods(700, teams[1], 1, 2);
		rods[7] = new Rods(800, teams[1], 0, 1);
		initUI();
		initializePlayerPositions();
	}
	public void initializePlayerPositions() {
		int dist;
		for (int i = 0; i < 8; i++)
		{
			   dist = (500/(rods[i].number_of_players+1));
			   int Ycoordinate=dist;
			   for (int j=0;j<rods[i].number_of_players;j++)
			   {
				   rods[i].team.players[rods[i].start + j].position.x = rods[i].x - 5;
				   rods[i].team.players[rods[i].start + j].position.y = Ycoordinate - 10;
				   Ycoordinate=Ycoordinate+dist;
			   }
		  
		}
	}
	public void nextFrame() {
		this.b.step();
		this.repaint();
	}
	public static void main(String[] args) {
		GamePanel gp = new GamePanel();
	}
	public void paintComponent(Graphics g){
		frameCount = 1;
		super.paintComponent(g);
		//if (frameCount == 30) { this.t.setDelay((int)(Constants.speed)); frameCount = 0; }
		// g.drawImage(this.background, 0, 0, 1000, 600, this);
	    // g.fillRect(5, 84, 770, 450);
	    // g.setColor(Color.green);
	    // g.fillRect(5, 5, 900, 500);
	    
	   int i,j,dist;
	   for (i = 0; i < 8; i++)
	   {
		   dist = (500/(rods[i].number_of_players+1));
		   int Ycoordinate=dist;
		   for (j=0;j<rods[i].number_of_players;j++)
		   {
			   if (i == 0 || i == 1 || i == 3 || i == 5)
				   g.setColor(Color.red);
			   else	
				   g.setColor(Color.black);
			   
			   g.drawRect((rods[i].x - 5), (rods[i].team.players[rods[i].start + j].position.y), GameConstants.player_width, GameConstants.player_height);
			   g.fillRect((rods[i].x - 5), (rods[i].team.players[rods[i].start + j].position.y), GameConstants.player_width, GameConstants.player_height);
		   }
	  
	   }
		// Draw ball
		g.setColor(Color.yellow);
		//player_has_moved = false;
		g.fillOval(this.b.position.x, this.b.position.y, GameConstants.ballDiameter, GameConstants.ballDiameter);
	}
	private void initUI() {
		setSize(1000,650);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nextFrame();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < teams[0].players.length; i++) {
				if (teams[0].players[i].position.y <= GameConstants.step_player+10) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					teams[0].players[i].position.y -= GameConstants.step_player;
				}
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < teams[0].players.length; i++) {
				if (teams[0].players[i].position.y >= GameConstants.screenHeight + GameConstants.step_player) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					teams[0].players[i].position.y += GameConstants.step_player;
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

