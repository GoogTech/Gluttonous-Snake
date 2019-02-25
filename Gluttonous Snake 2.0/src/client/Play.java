package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import constant.Constant;
import core.Food;
import core.MyFrame;
import core.MySnack;
import util.ImageUtil;
import util.MusicPlayer;

/**
 * 
 * @Project Snack 2.0
 * @Package client
 * @Description Load the JFrame and Control the game flow.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-3:25:11 PM
 * @version 2.0
 */
public class Play extends MyFrame
{

	private static final long serialVersionUID = -3641221053272056036L;

	public MySnack mySnack = new MySnack(100, 100);// x , y
	public Food food = new Food();

	Image background = ImageUtil.images.get("UI-background");
	Image fail = ImageUtil.images.get("game-scene-01");

	/*
	 * Listen for the event.
	 * 
	 * @see core.MyFrame#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnack.keyPressed(e);
	}

	/*
	 * Draw the game.
	 * 
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(background, 0, 0, null);

		// Determine the state of the game.
		if (mySnack.live)
		{
			mySnack.draw(g);
			if (food.live)
			{
				food.draw(g);
				food.eaten(mySnack);
			} else
			{
				food = new Food();
			}
		} else
		{
			g.drawImage(fail, 0, 0, null);
		}
		drawScore(g);
	}

	/**
	 * @Title Draw
	 * @Description Draw the score.
	 * @param Graphics g
	 * @return void
	 * @date Feb 11, 2019-3:39:35 PM
	 *
	 */
	public void drawScore(Graphics g)
	{
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnack.score, 20, 40);
	}

	/**
	 * @Title Main
	 * @Description Test the project.
	 * @return void
	 * @date Feb 11, 2019-3:40:11 PM
	 *
	 */
	public static void main(String[] args)
	{
		// Play the game.
		new Play().loadFrame();

		// Play the background music.
		MusicPlayer.getMusicPlay(Constant.MUSIC_PRE + "Happy birthday.mp3");

	}
}
