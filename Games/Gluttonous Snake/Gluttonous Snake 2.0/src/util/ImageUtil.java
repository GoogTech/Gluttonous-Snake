package util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import constant.Constant;

/**
 * 
 * @Project Snack 2.0
 * @Package util
 * @Description Store the image.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-10:49:01 AM
 * @version 2.0
 */
public class ImageUtil
{
	public static Map<String,Image> images = new HashMap<>();
	
	static
	{
		images.put("snack-head-right", GameUtil.getImage(Constant.IMG_PRE+"snack-head-right.png"));
		images.put("snack-body", GameUtil.getImage(Constant.IMG_PRE+"snack-body.png"));
		images.put("food-Birthday_Cake-04", GameUtil.getImage(Constant.IMG_PRE+"food-Birthday_Cake-04.png"));
		images.put("UI-background", GameUtil.getImage(Constant.IMG_PRE+"UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage(Constant.IMG_PRE+"game-scene-01.jpg"));
		
		
	}
}
