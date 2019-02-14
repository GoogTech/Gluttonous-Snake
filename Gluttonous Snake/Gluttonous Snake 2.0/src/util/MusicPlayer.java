package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * 
 * @Project Snack 2.0
 * @Package util
 * @Description TODO
 * @Author HuangYuhui
 * @Date Feb 11, 2019-5:20:26 PM
 * @version 2.0
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
	 * @Title Music
	 * @Description Thread: play the music.
	 * @return void
	 * @date Feb 11, 2019-5:20:47 PM
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
	 * @date Feb 11, 2019-5:21:21 PM
	 *
	 */
	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
