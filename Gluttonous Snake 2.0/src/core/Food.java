package core;

import java.awt.Graphics;
import java.util.Random;

import constant.Constant;

/**
 *
 * @Project Snack 2.0
 * @Package score
 * @Description Draw the food.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-11:39:27 AM
 * @version 2.2
 */
public class Food extends SnackObject
{

	public Food()
	{
		this.live = true;
		// different food. Total food: twenty-two.
		this.image = util.ImageUtil.images.get(String.valueOf(new Random().nextInt(22)));

		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		// Dynamic position.
		this.x = (int) (Math.random() * (Constant.GAME_WIDTH - width + 10));
		this.y = (int) (Math.random() * (Constant.GAME_HEIGHT - height - 40));
	}

	/**
	 * @Title food.
	 * @Description Eat the food.
	 * @return void
	 * @date Feb 11, 2019-11:46:46 AM
	 *
	 */
	public void eaten(MySnack mySnack)
	{
		/*
		 * intersets : Determines whether or not this Rectangle and the specified
		 * Rectangle intersect.
		 */
		if (mySnack.getRectangle().intersects(this.getRectangle()) && live && mySnack.live)
		{
			this.live = false;
			mySnack.setLength(mySnack.getLength() + 1);
			// mySnack.score += 10 * mySnack.getLength();
			mySnack.score += 521;
		}
	}

	/*
	 * Draw the food.
	 * 
	 * @see score.SnackObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, null);
	}
}
