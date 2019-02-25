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
 * @version 2.2
 */
public class ImageUtil
{
	public static Map<String, Image> images = new HashMap<>();

	/*
	 * Initialize all images.
	 */
	static
	{
		// snack
		images.put("snack-head-right", GameUtil.getImage(Constant.IMG_PRE + "snack-head-right.png"));
		images.put("snack-body", GameUtil.getImage(Constant.IMG_PRE + "snack-body.png"));
		// difference food.
		images.put("0", GameUtil.getImage(Constant.IMG_PRE + "food-Birthday_Cake-00.png"));
		images.put("1", GameUtil.getImage(Constant.IMG_PRE + "food-Birthday_Cake-01.png"));
		images.put("2", GameUtil.getImage(Constant.IMG_PRE + "food-Birthday_Cake-02.png"));
		images.put("3", GameUtil.getImage(Constant.IMG_PRE + "food-Birthday_Cake-04.png"));
		images.put("4", GameUtil.getImage(Constant.IMG_PRE + "food-apple.png"));
		images.put("5", GameUtil.getImage(Constant.IMG_PRE + "food-banana.png"));
		images.put("6", GameUtil.getImage(Constant.IMG_PRE + "food-blueberry.png"));
		images.put("7", GameUtil.getImage(Constant.IMG_PRE + "food-cherry.png"));
		images.put("8", GameUtil.getImage(Constant.IMG_PRE + "food-durian.png"));
		images.put("9", GameUtil.getImage(Constant.IMG_PRE + "food-grape.png"));
		images.put("10", GameUtil.getImage(Constant.IMG_PRE + "food-grapefruit.png"));
		images.put("11", GameUtil.getImage(Constant.IMG_PRE + "food-kiwi.png"));
		images.put("12", GameUtil.getImage(Constant.IMG_PRE + "food-lemon.png"));
		images.put("13", GameUtil.getImage(Constant.IMG_PRE + "food-litchi.png"));
		images.put("14", GameUtil.getImage(Constant.IMG_PRE + "food-mango.png"));
		images.put("15", GameUtil.getImage(Constant.IMG_PRE + "food-orange.png"));
		images.put("16", GameUtil.getImage(Constant.IMG_PRE + "food-peach.png"));
		images.put("17", GameUtil.getImage(Constant.IMG_PRE + "food-pear.png"));
		images.put("18", GameUtil.getImage(Constant.IMG_PRE + "food-pineapple.png"));
		images.put("19", GameUtil.getImage(Constant.IMG_PRE + "food-pitaya.png"));
		images.put("20", GameUtil.getImage(Constant.IMG_PRE + "food-strawberry.png"));
		images.put("21", GameUtil.getImage(Constant.IMG_PRE + "food-watermelon.png"));
		// ui
		images.put("UI-background", GameUtil.getImage(Constant.IMG_PRE + "UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage(Constant.IMG_PRE + "game-scene-01.jpg"));
	}
}
