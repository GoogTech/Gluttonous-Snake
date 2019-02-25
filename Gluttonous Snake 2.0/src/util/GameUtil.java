package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 
 * @Project Snack 2.0
 * @Package util
 * @Description Get the image and deal with it.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-10:53:22 AM
 * @version 2.0
 */
public class GameUtil
{
	/**
	 * @Title Get image.
	 * @Description Get the image by the path.
	 * @param image path
	 * @return Image
	 * @date Feb 11, 2019-10:54:40 AM
	 *
	 */
	public static Image getImage(String imagePath)
	{
		URL url = GameUtil.class.getClassLoader().getResource(imagePath);
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(url);
		} catch (Exception e)
		{
			System.err.println("ERROR : NOT FOUND THE SPECIFIED IMAGE !\n");
			e.printStackTrace();
		}

		return image;
	}

	/**
	 * @Title Deal with the image.
	 * @Description rotate the image.
	 * @param bufferedImage and degree.
	 * @return Image
	 * @date Feb 11, 2019-11:00:35 AM
	 *
	 */
	public static Image rotateImage(final BufferedImage bufferedImage, final int degree)
	{
		int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		int type = bufferedImage.getColorModel().getTransparency();// Get the image transparency.

		BufferedImage image;// Empty image.
		Graphics2D graphics2d; // Empty bush.

		/*
		 * Attention : what ? ? ?
		 */
		(graphics2d = (image = new BufferedImage(w, h, type)).createGraphics())
				.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);// Rotate the image.
		graphics2d.drawImage(bufferedImage, 0, 0, null);// Copy the picture to the 'image'.
		graphics2d.dispose();// Close

		return image;// Return the image after processing.(copy)

	}
}
