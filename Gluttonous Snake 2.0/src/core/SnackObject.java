package core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import Interface.Drawable;

/**
 * 
 * @Project Snack 2.0
 * @Package score
 * @Description Both the food and the snake need to be drawn, and both have life
 *              cycles, so extract a parent class.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-11:28:42 AM
 * @version 2.0
 */
public abstract class SnackObject implements Drawable
{
	// the position of the snack.
	int x;
	int y;

	// the image size of the snack.
	Image image;
	int width;
	int height;

	// the state of the snack.
	public boolean live;

	/*
	 * Draw the snack and food.
	 * 
	 * @see Interface.Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public abstract void draw(Graphics g);

	/**
	 * @Title image size.
	 * @Description Gets the rectangle of the image.
	 * @return Rectangle
	 * @date Feb 11, 2019-11:35:56 AM
	 *
	 */
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
}
