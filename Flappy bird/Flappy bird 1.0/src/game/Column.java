package game;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * 
 * @Project Flappy bird 1.0
 * @Package game
 * @Description TODO
 * @Author HuangYuhui
 * @Date Feb 6, 2019-7:23:45 PM
 * @version 1.0
 */
public class Column
{
	//The position of column.
	int x, y;
	//The size of column.
	int width, height;
	//Output the column.
	BufferedImage image;
	//The vertical distance between two pillar.
	int ver_distance;
	//Horizontal distance between two pillar.
	int hor_distance;

	/**
	 * @Description Initialize the column.
	 * @Date Feb 6, 2019-7:23:39 PM
	 * @param n : The count of column.
	 */
	public Column(int n)
	{
		try
		{
			image = ImageIO.read(getClass().getResource("column.png"));
			width = image.getWidth();
			height = image.getHeight();
			
			ver_distance = 144;
			hor_distance = 245;
			
			//Dynamic position of column.
			x = 550 + (n - 1) * hor_distance;
			y = (int) (Math.random() * 218) + 132;

		} catch (Exception e)
		{
			// no catch !?
		}
	}

	/**
	 * @Title Thread
	 * @Description Create new column constantly.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:24:14 PM
	 *
	 */
	public void run()
	{
		x--;
		if (x <= width / 2)
		{
			x = hor_distance * 2 - width / 2;
			y = (int) (Math.random() * 218) + 132;
		}
	}
}