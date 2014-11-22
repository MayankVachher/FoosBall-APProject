package foosball.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import foosball.environment.Ball;
import foosball.environment.Rods;
import foosball.math.Coordinates;
import foosball.math.GameConstants;
import foosball.math.Physics;
import foosball.math.Scoring;
import foosball.math.Vector;
import foosball.players.Player;
import foosball.strategy.CpuAI;
import foosball.strategy.Team;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Ball ball;
	public Team[] teams = new Team[2];
	Timer t1, t2;
	Image background;
	int frameCount = 0;
	private static final long serialVersionUID = 1L;
	GameEnd gameEnd;
	public GamePanel(String tossValue, int mid, int def, int att, String difficultyLvl) {
		
		Coordinates initialPosition = new Coordinates(30, (GameConstants.screenHeight / 2));
		Coordinates dummy = new Coordinates(28, (GameConstants.screenHeight / 2 + 1));
		
		//create Ball
		Vector ballDirection = new Vector(dummy, initialPosition);
		JLabel jlabel = new JLabel("0 - 0", SwingConstants.CENTER);
		Scoring sc = new Scoring(jlabel);
		ball = new Ball(initialPosition, ballDirection, sc);

	    jlabel.setFont(new Font("Verdana",1,20));
	    this.add(jlabel);
		//timer
		this.t1 = new Timer(10, this);
		t1.start();
		addKeyListener((KeyListener) this);
		this.setFocusable(true);
		
		if (tossValue.equals("You win!")) {
			this.ball.resetAndMove(true);
		} else {
			this.ball.resetAndMove(false);
		}

		//create teams
		try{
		teams[0] = new Team(att, mid, def, false);
		teams[1] = new Team(2, 4, 4, true);
		}
		catch(Exception e){
			System.exit(1);
		}
		CpuAI ca = new CpuAI(teams[1], ball);
		if (difficultyLvl.equals("Easy")) {
			this.t2 = new Timer(200, ca);
		} else if (difficultyLvl.equals("Medium")) {
			this.t2 = new Timer(100, ca);
		} else {
			this.t2 = new Timer(10, ca);
		}
		t2.start();

		ball.updateLastHit(teams[0]);
		this.setLayout(new GridLayout(1,1));
		
		try {
			background = ImageIO.read(new File("img/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void nextFrame() {
		//System.out.println("Pos: "+this.ball.position.x+", "+this.ball.position.y);
		//this.ball.direction.printDel();
		if(this.ball.gameFinish()!=0) {
			this.removeAll();
			gameEnd = new GameEnd(this.ball.gameFinish());
			this.add(gameEnd);
//			this.revalidate();
	//		this.repaint();
		}
		else {
			this.ball.step();
			Player collisionWith = Physics.checkPlayerCollisions(teams,ball);
			if(collisionWith != null)
				Physics.updateBallDirection(collisionWith,ball);
			this.repaint();
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 1000, 650, this);

		// Draw ball
		g.setColor(Color.YELLOW);
		//player_has_moved = false;
		g.fillOval(this.ball.position.x, this.ball.position.y, GameConstants.ballDiameter, GameConstants.ballDiameter);
		for (int k = 0; k < 2; k++)
		{
			//create rods and players
			for(int i = 0; i < 4; i++) {
				Rods temp_rod = teams[k].rods[i];
				for (int j=0;j<temp_rod.number_of_players;j++)
				{
					if (k == 0)
						g.setColor(new Color(49,49,49));
					else	
						g.setColor(new Color(181,43,56));
					int temp_x = temp_rod.team.players[temp_rod.start + j].position.x;
					int temp_y = temp_rod.team.players[temp_rod.start + j].position.y;
					g.drawRect(temp_x,temp_y,GameConstants.player_width, GameConstants.player_height);
					g.fillRect(temp_x,temp_y,GameConstants.player_width, GameConstants.player_height);
				}   
			}
			g.setColor(Color.PINK);
			int temp_x = teams[k].goal.position.x;
			int temp_y = teams[k].goal.position.y;
			g.drawRect(temp_x,temp_y,GameConstants.goal_width, GameConstants.goal_height);
			g.fillRect(temp_x,temp_y,GameConstants.goal_width, GameConstants.goal_height);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nextFrame();
		this.requestFocusInWindow(true);
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
					if(teams[0].players[0].position.y>=100){
						teams[0].players[i].position.y -= GameConstants.step_player;
						//teams[0].players[0].position.y--;
					}
					else if(i!=0)
						teams[0].players[i].position.y -= GameConstants.step_player;
				}
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < teams[0].players.length; i++) {
				if (teams[0].players[i].position.y >= GameConstants.screenHeight - 50 + GameConstants.step_player) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					if(teams[0].players[0].position.y<=525){
						teams[0].players[i].position.y += GameConstants.step_player;
						//teams[0].players[0].position.y--;
					}
					else if(i!=0)
						teams[0].players[i].position.y += GameConstants.step_player;
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < teams[0].players.length; i++) {
				if (teams[0].players[i].position.y <= GameConstants.step_player+10) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					if(teams[0].players[0].position.y>=100){
						teams[0].players[i].position.y -= GameConstants.step_player;
						//teams[0].players[0].position.y--;
					}
					else if(i!=0)
						teams[0].players[i].position.y -= GameConstants.step_player;
				}
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < teams[0].players.length; i++) {
				if (teams[0].players[i].position.y >= GameConstants.screenHeight - 50 + GameConstants.step_player) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					if(teams[0].players[0].position.y<=525){
						teams[0].players[i].position.y += GameConstants.step_player;
						//teams[0].players[0].position.y--;
					}
					else if(i!=0)
						teams[0].players[i].position.y += GameConstants.step_player;
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
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
				if (teams[0].players[i].position.y >= GameConstants.screenHeight - 50 + GameConstants.step_player) {
					al.add(teams[0].players[i].position.x);
				}
			} for (int i = 0; i < teams[0].players.length; i++) {
				if (!al.contains(teams[0].players[i].position.x)) {
					teams[0].players[i].position.y += GameConstants.step_player;
				}
			}
		}
	}
}

