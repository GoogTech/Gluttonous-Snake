package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @Project Snake
 * @Package game
 * @Description Control the game scene.
 * @Author HuangYuhui
 * @Date Feb 10, 2019-2:19:11 PM
 * @version 1.0
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener
{
	/*
	 * Initialize the game resource.
	 */
	ImageIcon up = new ImageIcon("resource/image/snack-head-up.png");
	ImageIcon down = new ImageIcon("resource/image/snack-head-down.png");
	ImageIcon left = new ImageIcon("resource/image/snack-head-left.png");
	ImageIcon right = new ImageIcon("resource/image/snack-head-right.png");
	// ImageIcon title = new ImageIcon("resource/image/title.jpg");
	ImageIcon body = new ImageIcon("resource/image/body.png");
	ImageIcon food_apple = new ImageIcon("resource/image/food-apple.png");
	ImageIcon food_cherry = new ImageIcon("resource/image/food-cherry.png");

	// Data structure design for the snack.
	int[] snakex = new int[750];
	int[] snakey = new int[750];
	int len = 3;

	// Score.
	int score;

	// Driection : Right Left Up and Down.
	String direction = "R";

	// Create the food for the snack.
	Random random = new Random();
//	int foodx = r.nextInt(34) * 25 + 25; // 34个格子，一个格子25排像素，还有25像素空白.
//	int foody = r.nextInt(24) * 25 + 75; // 24个格子，一个格子25排像素，还有75像素空白.
	int foodx = random.nextInt(25) * 25;
	int foody = random.nextInt(20) * 25;

	// Determine whether the game is start.
	boolean isStarted = false;

	// Determine whether the game is fail.
	boolean isFaild = false;

	/*
	 * Initialize the game.
	 */
	public void initSnake()
	{
		// Game status.
		isFaild = false;
		isStarted = false;

		len = 3;
		direction = "R";
		snakex[0] = 100;
		snakey[0] = 100;
		snakex[1] = 75;
		snakey[1] = 100;
		snakex[2] = 50;
		snakey[2] = 100;
	}

	/**
	 * @Description Initialize the game.
	 * @Date Feb 10, 2019-2:01:56 PM
	 */
	public SnakePanel()
	{
		/*
		 * focusable indicates whether this Component is focusable.
		 */
		this.setFocusable(true);
		// Initialize the static snack.
		initSnake();
		// Add keyboard listener interface.
		this.addKeyListener(this);

		timer.start();
	}

	/*
	 * Set the Moving speed of snack.
	 */
	Timer timer = new Timer(120, this);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g)
	{
		/*
		 * Set the background color.
		 */
		this.setBackground(Color.white);

		/*
		 * Draw the rect. According to : frame.setBounds(450, 200, 920, 600).
		 */
		g.fillRect(1, 1, 920, 600);

		/*
		 * 设置标题. According to : resource/image/title.jpg.
		 */
		// title.paintIcon(this, g, 25, 11);

		// Draw the hearder of the snack.
		if (direction.equals("R"))
		{
			right.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (direction.equals("L"))
		{
			left.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (direction.equals("U"))
		{
			up.paintIcon(this, g, snakex[0], snakey[0]);
		} else if (direction.equals("D"))
		{
			down.paintIcon(this, g, snakex[0], snakey[0]);
		}
		// Draw the body of the snack.
		for (int i = 1; i < len; i++)
		{
			body.paintIcon(this, g, snakex[i], snakey[i]);
		}

		/*
		 * Draw the score.
		 */
		Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 20);
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Score :  " + score, 15, 30);

		/*
		 * Draw the prompt statement.
		 */
		if (!isStarted)
		{
			g.setColor(Color.BLUE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Please press Space to Start or Pause", 205, 280);
		}

		/*
		 * Draw the prompt statement when game is over.
		 */
		if (isFaild)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Game Over ! Please press Space to Start", 205, 280);
		}

		// Draw the food.
		food_apple.paintIcon(this, g, foodx, foody);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}

	/*
	 * @Description : Listen event: keybord.
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		/*
		 * Pause the game or keep playing.
		 */
		if (keyCode == KeyEvent.VK_SPACE)
		{
			if (isFaild)
			{
				initSnake();
			} else
			{
				isStarted = !isStarted;
			}
			// repaint();
		}
		/*
		 * Turn a corner.
		 */
		else if (keyCode == KeyEvent.VK_UP && !direction.equals("D"))
		{
			direction = "U";
		} else if (keyCode == KeyEvent.VK_DOWN && !direction.equals("U"))
		{
			direction = "D";
		} else if (keyCode == KeyEvent.VK_LEFT && !direction.equals("R"))
		{
			direction = "L";
		} else if (keyCode == KeyEvent.VK_RIGHT && !direction.equals("L"))
		{
			direction = "R";
		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}

	/*
	 * 1.定个闹钟 2.蛇移动 3.重画一次蛇
	 * 
	 * @seejava.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//
		timer.start();

		if (isStarted && !isFaild)
		{
			// Move the body.
			for (int i = len; i > 0; i--)
			{
				snakex[i] = snakex[i - 1];
				snakey[i] = snakey[i - 1];
			}
			// Move the hearder.
			if (direction.equals("R"))
			{
				// X : +25
				snakex[0] = snakex[0] + 25;
				if (snakex[0] > 850)
				{
					snakex[0] = 25;
				}

			} else if (direction.equals("L"))
			{
				// X : -25
				snakex[0] = snakex[0] - 25;
				if (snakex[0] < 25)
				{
					snakex[0] = 850;
				}
			} else if (direction.equals("U"))
			{
				// Y : -25
				snakey[0] = snakey[0] - 25;
				if (snakey[0] < 75)
				{
					snakey[0] = 650;
				}
			} else if (direction.equals("D"))
			{
				// Y : +25
				snakey[0] = snakey[0] + 25;
				if (snakey[0] > 650)
				{
					snakey[0] = 75;
				}

			}

			// Eat the food.
			if (snakex[0] == foodx && snakey[0] == foody)
			{
				len++;
				foodx = random.nextInt(25) * 25;
				foody = random.nextInt(20) * 25;

				score++;
			}

			/*
			 * Determine whether the snack touch his body.
			 */
			for (int i = 1; i < len; i++)
			{
				if (snakex[0] == snakex[i] && snakey[0] == snakey[i])
				{
					isFaild = true;
				}
			}
		}
		repaint();// Repaints this component.
	}
}
