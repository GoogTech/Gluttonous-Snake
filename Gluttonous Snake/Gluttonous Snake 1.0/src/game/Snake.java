package game;

import javax.swing.JFrame;

/**
 * 
 * @Project Snake
 * @Package game
 * @Description Test the game.
 * @Author HuangYuhui
 * @Date Feb 10, 2019-2:32:14 PM
 * @version 1.0
 */
public class Snake
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		// frame.setSize(400,600);
		frame.setBounds(450, 200, 920, 600);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SnakePanel panel = new SnakePanel();
		frame.add(panel);

		frame.setVisible(true);

		/*
		 * Play the background music.
		 */
		MusicPlayer.getMusicPlay("resource\\music\\background.mp3");
	}
}