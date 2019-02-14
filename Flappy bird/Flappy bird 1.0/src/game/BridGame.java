package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @Project Flappy bird 1.0
 * @Package cn.tedu.game
 * @Description
 * @Author HuangYuhui
 * @Date Feb 6, 2019-7:21:44 PM
 * @version 1.0
 */
public class BridGame extends JPanel
{
	/*
	 * Create the Game scenes.
	 */
	Brid brid;
	Ground ground;
	Column column1;
	Column column2;
	BufferedImage background;

	/*
	 * The game state.
	 */
	int state;
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int GAME_OVER = 2;

	// Score
	int score;
	// The image of starting the game.
	BufferedImage startImage;
	// The screen at the end of the game.
	BufferedImage gameOverImage;

	
	/**
	 * @Description Initialize the game scenes.
	 * @Date Feb 6, 2019-7:21:51 PM
	 * @throws Exception
	 */
	public BridGame() throws Exception
	{
		state = START;

		startImage = ImageIO.read(getClass().getResource("start.png"));
		background = ImageIO.read(getClass().getResource("background.png"));
		gameOverImage = ImageIO.read(getClass().getResource("gameover.png"));

		brid = new Brid();
		ground = new Ground();
		column1 = new Column(1);
		column2 = new Column(2);
	}

	@Override
	public void paint(Graphics g)
	{
		/*
		 * Draw the column.
		 */
		super.paint(g);
		g.drawImage(background, 0, 0, null);		
		g.drawImage(column1.image, column1.x - column1.width / 2, column1.y - column1.height / 2, null);
		g.drawImage(column2.image, column2.x - column2.width / 2, column2.y - column2.height / 2, null);
		
		g.drawImage(ground.image, ground.x, ground.y, null);
		
		/*
		 * Rotate the drawing coordinate, that's the API method-(rotate).
		 */
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(-brid.alpha, brid.x, brid.y);
		g.drawImage(brid.image, brid.x - brid.width / 2, brid.y - brid.height / 2, null);
		g2.rotate(brid.alpha, brid.x, brid.y);

		/*
		 * Algorithm about drawing the score in game.
		 */
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		g.setFont(f);
		g.drawString("Score  " + score, 30, 60);
		g.setColor(Color.WHITE);
		//Shadow effects.
		g.drawString("Score  " + score, 40 - 3, 60 - 3);

		/*
		 * Add the Game end status code into the method of 'paint'.
		 */
		switch (state)
		{
		case GAME_OVER:
			g.drawImage(gameOverImage, 0, 0, null);
			break;
		case START:
			g.drawImage(startImage, 0, 0, null);
			break;
		}
	}
	

	/**
	 * @Title Play
	 * @Description Control of the game.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:22:22 PM
	 *
	 */
	public void action() throws Exception
	{
		MouseListener l = new MouseAdapter()
		{
			//Event-Mouse clicked
			public void mousePressed(MouseEvent e)
			{
				try
				{
					switch (state)
					{
					case GAME_OVER:
						column1 = new Column(1);
						column2 = new Column(2);
						brid = new Brid();
						score = 0;
						state = START;
						break;
						
					case START:
						state = RUNNING;
						
					case RUNNING:
						// The birds are flying upwards.
						brid.flappy();
						// Jump music.
						MusicPlayer.getMusicPlay("resource\\mp3\\Jump.mp3");
						
					}
				} catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		};
		
		/*
		 * 	将1挂接到当前的面板上.
		 */
		addMouseListener(l);

		while (true)
		{
			switch (state)
			{
			case START:
				brid.fly();
				ground.run();
				break;
				
			case RUNNING:
				/*
				 * Create the cloumn.
				 */
				column1.run();
				column2.run();
				/*
				 * Birds move up and down.
				 */
				brid.run();
				/*
				 * Wave the wings of a bird.
				 */
				brid.fly();
				/*
				 * Move the ground.
				 */
				ground.run();
				/*
				 * Get the score.
				 */
				if (brid.x == column1.x || brid.x == column2.x)
				{
					score++;
				}
				/*
				 * The game ends if the bird hits the ground.
				 */
				if (brid.hit(ground) || brid.hit(column1) || brid.hit(column2))
				{
					state = GAME_OVER;
				}
				break;
			}
			//Repaints this component. 
			repaint();
			//The speed of the game's progress.
			Thread.sleep(30);
		}
	}

	/**
	 * @Title Main
	 * @Description Test the project.
	 * @param ..
	 * @return void
	 * @date Feb 6, 2019-7:22:39 PM
	 *
	 */
	public static void main(String[] args) throws Exception
	{
		JFrame frame = new JFrame();
		BridGame game = new BridGame();
		
		/* 
		 * Thread-Background music.
		 */
		MusicPlayer.getMusicPlay("resource\\mp3\\background.mp3");
	
		frame.add(game);
		frame.setTitle("YUbuntu0109.github.io");
		frame.setSize(440, 670);
		frame.setLocationRelativeTo(null);// Center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close method.
		frame.setVisible(true);
		
		/*
		 * Listen the event of mouse clicked.
		 */
		game.action();
	}
}
