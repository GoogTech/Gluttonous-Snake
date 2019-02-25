package core;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.Constant;

/**
 * 
 * @Project Snack 2.0
 * @Package score
 * @Description Load the game and refresh it constantly.
 * @Author HuangYuhui
 * @Date Feb 11, 2019-10:20:42 AM
 * @version 2.1
 */
public class MyFrame extends JPanel implements KeyListener
{
	private static final long serialVersionUID = -3149926831770554380L;

	JFrame jFrame = new JFrame();

	/**
	 * @Description SetIconImage
	 * @Date Feb 11, 2019-6:22:15 PM
	 */
	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/image/snack-logo.png")));
	}

	/*
	 * Load the JFrame.
	 */
	public void loadFrame()
	{
		/*
		 * Attention :Prevent the picture from flashing.
		 */
		this.setDoubleBuffered(true);
		/*
		 * Attention :Add JPanel into the JFrame.
		 */
		jFrame.add(this);
		/*
		 * Attention :Listen the event.
		 */
		jFrame.addKeyListener(this);

		jFrame.setTitle("SNACK 2.1");
		jFrame.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		jFrame.setLocationRelativeTo(null);// Center
		jFrame.addWindowListener(new WindowAdapter()// Close
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		/*
		 * Thread-repaint constantly.
		 */
		new MyThread().start();
	}

	/*
	 * Prevent the picture from flashing.
	 */
//	Image backImg = null;
//	@Override
//	public void update(Graphics g)
//	{
//		super.update(g);
//		if (backImg == null)
//		{
//			backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
//		}
//		Graphics back_g = backImg.getGraphics();
//		Color color = back_g.getColor();
//
//		back_g.setColor(Color.BLACK);
//		back_g.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
//		back_g.setColor(color);
//
//		paint(back_g);
//		g.drawImage(backImg, 0, 0, null);
//	}

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
			while (true)
			{
				repaint();// Repaints this component.
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

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
