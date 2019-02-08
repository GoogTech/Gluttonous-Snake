package game;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * 
 * @Project Flappy bird 1.0
 * @Package cn.tedu.game
 * @Description TODO
 * @Author HuangYuhui
 * @Date Feb 6, 2019-7:25:09 PM
 * @version 1.0
 */
public class Ground
{
	// The position of ground.
	int x, y;
	// Ouput the the ground.
	BufferedImage image;
	// The size of ground.
	int width, height;

	/**
	 * @Description Initialize the ground.
	 * @Date Feb 6, 2019-7:25:19 PM
	 */
	public Ground()
	{
		try
		{
			image = ImageIO.read(getClass().getResource("ground.png"));
			x = 0;
			y = 500;
			width = image.getWidth();
			height = image.getHeight();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @Title Thread
	 * @Description Move the ground constantly.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:25:30 PM
	 *
	 */
	public void run()
	{
		// Moving
		x--;
		if (x < -109)
		{
			x = 0;
		}
	}
}
