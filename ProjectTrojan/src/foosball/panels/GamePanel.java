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
	Ball ball;
	public Team[] teams = new Team[2];
	Timer t;
	int frameCount = 0;
	private static final long serialVersionUID = 1L;
	public GamePanel() {
		
		Coordinates initialPosition = new Coordinates(30, (GameConstants.screenHeight / 2));
		Coordinates dummy = new Coordinates(31, (GameConstants.screenHeight / 2 + 1));
		
		//create Ball
		Vector ballDirection = new Vector(initialPosition, dummy);
		ball = new Ball(initialPosition, ballDirection);
		
		//timer
		this.t = new Timer(5, this);
		t.start();
		addKeyListener((KeyListener) this);
		setFocusable(true);
		
		//create teams
		teams[0] = new Team(2, 5, 3, false);
		teams[1] = new Team(2, 5, 3, true);

		initUI();
	}

	public void nextFrame() {
		this.ball.step();
		this.repaint();
	}

	public void paintComponent(Graphics g){
		frameCount = 1;
		super.paintComponent(g);
		//if (frameCount == 30) { this.t.setDelay((int)(Constants.speed)); frameCount = 0; }
		// g.drawImage(this.background, 0, 0, 1000, 600, this);
	    // g.fillRect(5, 84, 770, 450);
	    // g.setColor(Color.green);
	    // g.fillRect(5, 5, 900, 500);
	    
	   for (int k = 0; k < 2; k++)
	   {
		   for(int i = 0; i < 4; i++) {
			   Rods temp_rod = teams[k].rods[i];
			   for (int j=0;j<temp_rod.number_of_players;j++)
			   {
				   if (k == 0)
					   g.setColor(Color.red);
				   else	
					   g.setColor(Color.black);
				   int temp_x = temp_rod.team.players[temp_rod.start + j].position.x;
				   int temp_y = temp_rod.team.players[temp_rod.start + j].position.y;
				   g.drawRect(temp_x,temp_y,GameConstants.player_width, GameConstants.player_height);
				   g.fillRect(temp_x,temp_y,GameConstants.player_width, GameConstants.player_height);
			   }   
		   }
	   }
		// Draw ball
		g.setColor(Color.yellow);
		//player_has_moved = false;
		g.fillOval(this.ball.position.x, this.ball.position.y, GameConstants.ballDiameter, GameConstants.ballDiameter);
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

