package game;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * 
 * @Project Flappy bird 1.0
 * @Package game
 * @Description TODO
 * @Author HuangYuhui
 * @Date Feb 6, 2019-7:21:22 PM
 * @version 1.0
 */
public class Brid
{
	// The position of bird.
	int x, y;
	// The size of bird.
	int width, height;
	// Ouput the brid.
	BufferedImage image;
	// Acceleration of gravity
	double g;
	// The distance between the two positions.
	double distance;
	// Initial upthrow velocity.
	double v0;
	// Current upthrow speed.
	double speed;
	// The displacement after time 't'.
	double displacement;
	
	/*
	 * The size of bird.Determine whether it hit the column or ground.
	 */
	int size;

	/*
	 * Bird inclination(radian unit).
	 */
	double alpha;
	
	/*
	 * Bird animation frames.
	 */
	BufferedImage[] images;
	
	/*
	 * The subscript position of an animation frame element.
	 */
	int animation_index;
	

	/**
	 * @Description Initialize the bird.
	 * @Date Feb 6, 2019-7:21:00 PM
	 * @throws Exception
	 */
	public Brid() throws Exception
	{
		image = ImageIO.read(getClass().getResource("0.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 132;
		y = 280;
		size = 40;
		g = 4;
		v0 = 20;
		distance = 0.25;
		speed = v0;
		displacement = 0;
		alpha = 0;
		images = new BufferedImage[8];

		for (int i = 0; i < 8; i++)
		{
			// i = 0 1 2 3 4 5 6 7
			images[i] = ImageIO.read(getClass().getResource(i + ".png"));
		}
		animation_index = 0;
	}
	

	/**
	 * @Title Initialize
	 * @Description Initlize the position of bird's image.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:20:11 PM
	 *
	 */
	public void fly()
	{
		animation_index++;
		image = images[(animation_index / 12) % 8];
	}

	
	/**
	 * @Title Fly
	 * @Description Move the bird's position.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:20:03 PM
	 *
	 */
	public void run()
	{
		double v0 = speed;
		// Calculate the upcast displacement velocity.
		displacement = v0 * distance + g * distance * distance / 2;
		// Calculate the bird's coordinate position.
		y = y - (int) displacement;
		// Calculate the next velocity.
		double v = v0 - g * distance;
		speed = v;

		/*
		 * Call the inverse tangent function provided by the API to calculate the inclination.
		 */
		alpha = Math.atan(displacement / 8);
	}

	/**
	 * @Title Initlalize
	 * @Description Initialize the speed.
	 * @param Empty
	 * @return void
	 * @date Feb 6, 2019-7:35:48 PM
	 *
	 */
	public void flappy()
	{
		//Reset the initial speed and fly upward again.
		speed = v0;
	}

	/**
	 * @Title Judgement
	 * @Description Determine whether the bird will hit hit ground.
	 * @param Ground
	 * @return boolean
	 * @date Feb 6, 2019-7:17:28 PM
	 *
	 */
	public boolean hit(Ground ground)
	{
		boolean hit = y + size / 2 > ground.y;
		if (hit)
		{
			// Place the bird on the ground.
			y = ground.y - size / 2;
			// When the bird lands, it has the effect of falling down.(Bounce!!!)
			alpha = -3.14159265358979323 / 2;
		}
		return hit;
	}
	
	

	/**
	 * @Title Judgement
	 * @Description Determine whether the bird will hit the column.
	 * @param Column
	 * @return boolean
	 * @date Feb 6, 2019-7:17:43 PM
	 *
	 */
	public boolean hit(Column column)
	{
		if (x > column.x - column.width / 2 - size / 2 && x < column.x + column.width / 2 + size / 2)
		{
			/*
			 * Check whether it is in the gap between two pipes.
			 */
			if (y > column.y - column.ver_distance / 2 + size / 2 && y < column.y + column.ver_distance / 2 - size / 2)
			{
				return false;
			}
			return true;
		}
		return false;
	}
}
