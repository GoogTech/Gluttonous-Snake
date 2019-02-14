package game;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 
 * @Project Flappy bird 1.0
 * @Package game
 * @Description Play the background music and game special effects sound.
 * @Author HuangYuhui
 * @Date Feb 7, 2019-5:52:57 PM
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
	 * @date Feb 8, 2019-11:27:42 AM
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
	 * @Title music
	 * @Description Initialize the class and play the game music.
	 * @param file name
	 * @return void
	 * @date Feb 8, 2019-11:27:32 AM
	 *
	 */
	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
