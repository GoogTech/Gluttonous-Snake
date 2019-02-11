package core;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import Interface.Moveable;
import constant.Constant;
import util.GameUtil;
import util.ImageUtil;;

/**
 * 
 * @Project Snack 2.0
 * @Package score
 * @Description Design for the snack data sturct.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-12:33:08 PM
 * @version 2.0
 */
public class MySnack extends SnackObject implements Moveable
{
	// The game variable.
	private int speed_XY;
	private int length;
	private int num; // ?
	public int score = 0;

	/*
	 * revolve the head of snack.
	 */
	private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) util.ImageUtil.images.get("snack-head-right");

	/*
	 * The data struct of the snack.the body : Point
	 */
	public static List<Point> bodyPoints = new LinkedList<>();// Point : A point representing a location in (x,y).

	/*
	 * The image of the snack'head after revolving.
	 */
	private static BufferedImage newImgSnackHead;
	boolean up, down, left, right = true;// Initialize the direction of the snack'head.

	public MySnack(int x, int y)
	{
		this.live = true;
		this.x = x;
		this.y = y;
		this.image = ImageUtil.images.get("snack-body");
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);

		this.speed_XY = 5;
		this.length = 1;
		
		/*
		 * Attention : ?
		 */
		this.num = width / speed_XY;
		newImgSnackHead = IMG_SNAKE_HEAD;

	}

	/**
	 * @Title Snack
	 * @Description Get the length of the snack.
	 * @param
	 * @return int
	 * @date Feb 11, 2019-12:52:29 PM
	 *
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * @Title Snack
	 * @Description Set the length of the snack.
	 * @param length
	 * @return void
	 * @date Feb 11, 2019-12:52:34 PM
	 *
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	/**
	 * @Title Event
	 * @Description Mouse clicked.
	 * @param KeyEvent e
	 * @return void
	 * @date Feb 11, 2019-12:54:57 PM
	 *
	 */
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			if (!down)
			{
				up = true;
				down = false;
				left = false;
				right = false;

				// Initialize the direction of the snack'head.
				newImgSnackHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
			}
			break;
			
		case KeyEvent.VK_DOWN:
			if (!up)
			{
				up = false;
				down = true;
				left = false;
				right = false;

				newImgSnackHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
			}
			break;

		case KeyEvent.VK_LEFT:
			if (!right)
			{
				up = false;
				down = false;
				left = true;
				right = false;

				newImgSnackHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

			}
			break;

		case KeyEvent.VK_RIGHT:
			if (!left)
			{
				up = false;
				down = false;
				left = false;
				right = true;

				newImgSnackHead = IMG_SNAKE_HEAD;// default : right
			}

		default:
			break;
		}
	}

	/*
	 * The movement of the snake.
	 * 
	 * @see Interface.Moveable#move()
	 */
	@Override
	public void move()
	{
		if (up)
		{
			y -= speed_XY;
		} else if (down)
		{
			y += speed_XY;
		} else if (left)
		{
			x -= speed_XY;
		} else if (right)
		{
			x += speed_XY;
		}

	}

	/*
	 * Draw the snack.
	 * @see score.SnackObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g)
	{
		// Determine the state of the game.
		outofBounds();
		eatBody();

		// Store the current trajectory.
		bodyPoints.add(new Point(x, y));

		/*
		 * Attention : ?
		 */
		if (bodyPoints.size() == (this.length + 1) * num)
		{
			bodyPoints.remove(0);// Remove the frist node.
		}
		g.drawImage(newImgSnackHead, x, y, null);
		drawBody(g);

		move();
	}

	/**
	 * @Title Judgement
	 * @Description Determine whether the snack touch his body.
	 * @param
	 * @return void
	 * @date Feb 11, 2019-2:03:41 PM
	 *
	 */
	public void eatBody()
	{
		for (Point point : bodyPoints)
		{
			for (Point point2 : bodyPoints)
			{
				if (point.equals(point2) && point != point2)// Attention : point != point2
				{
					this.live = false;
				}
			}
		}
	}

	/**
	 * @Title Draw
	 * @Description Draw the body of the snack.
	 * @param
	 * @return void
	 * @date Feb 11, 2019-2:05:04 PM
	 *
	 */
	public void drawBody(Graphics g)
	{
		/*
		 * Attention : - 1 - num
		 */
		int length = bodyPoints.size() - 1 - num;

		for (int i = length; i >= num; i -= num)
		{
			Point point = bodyPoints.get(i);
			g.drawImage(image, point.x, point.y, null);
		}
	}

	/**
	 * @Title Judgement
	 * @Description Determine whether the snack touch the wall.
	 * @param
	 * @return void
	 * @date Feb 11, 2019-3:00:27 PM
	 *
	 */
	private void outofBounds()
	{
		boolean xOut = (x <= 0 || x >= (Constant.GAME_WIDTH - width));
		boolean yOut = (y <= 40 || y >= (Constant.GAME_HEIGHT - height));
		if (xOut || yOut)
		{
			live = false;
		}
	}
}
