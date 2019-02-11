package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import client.SnakeClient;
import constant.Constant;
import util.ImageUtil;

/**
 * 
 * @Project Snack 2.0
 * @Package score
 * @Description Load the game and refresh it constantly.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-10:20:42 AM
 * @version 2.0
 */
public class MyFrame extends JFrame
{
	/**
	 * @Description SetIconImage
	 * @Date Feb 11, 2019-6:22:15 PM
	 */
	public MyFrame() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/image/snack-logo.png")));
	}
	
	/*
	 * Load the Frame.
	 */
	public void loadFrame()
	{
		this.setTitle("SNACK 2.0");
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//References the constant.
		this.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);//Center
		//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()//Close
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		this.setVisible(true);
		
		/*
		 * Thread-repaint constantly.
		 */
		new MyThread().start();
		
	}
		
	
	/*
	 * Prevent the picture from flashing.
	 */
	Image backImg = null;
	
	@Override
	public void update(Graphics g)
	{
		super.update(g);
		if(backImg == null)
		{
			backImg = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		Graphics back_g = backImg.getGraphics();
		Color color = back_g.getColor();
		
		back_g.setColor(Color.BLACK);
		back_g.fillRect(0,0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		back_g.setColor(color);
		
		paint(back_g);
		g.drawImage(backImg, 0, 0, null);
	}
	
	
	/**
	 * @Project Snack 2.0
	 * @Package score
	 * @Description repaint constantly.
	 * @Author HuangYuhui
	 * @Date Feb 11, 2019-10:43:18 AM
	 * @version 2.0
	 */
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while(true)
			{
				repaint();
				try
				{
					sleep(30);// 30ms/repaint once.
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
