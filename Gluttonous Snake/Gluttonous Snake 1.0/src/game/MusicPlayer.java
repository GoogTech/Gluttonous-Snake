package game;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * 
 * @Project Snake
 * @Package game
 * @Description Play the music.
 * @Author HuangYuhui
 * @Date Feb 10, 2019-6:57:46 PM
 * @version 1.0
 */
public class MusicPlayer extends Thread
{
	private String filename;
	private Player player;

	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

	/**
	 * @Title music
	 * @Description Thread-play the music.
	 * @param Empty
	 * @return void
	 * @date Feb 10, 2019-6:58:09 PM
	 *
	 */
	public void play()
	{
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				try
				{
					BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
					player = new Player(buffer);
					player.play();
					// player.close();

				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}

	/**
	 * @Title Play
	 * @Description Initialize the class and play the game music.
	 * @param file name
	 * @return void
	 * @date Feb 10, 2019-6:58:37 PM
	 *
	 */
	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
