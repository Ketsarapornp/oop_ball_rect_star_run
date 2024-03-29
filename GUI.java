////⨷�����ҧ�١��� (2)Ẻ Constructor 
//�պ�� ��� ������������觪��ͺ
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	Ball balls[];
	Rect rects[];
	Star stars[];
	public GUI()
	{
		balls = new Ball[10];
		for(int i=0;i<balls.length;i++)
		{
			balls[i] = new Ball();
		}
		rects = new Rect[10];
		for(int i=0;i<rects.length;i++)
		{
			rects[i] = new Rect();
		}
		stars = new Star[10];
		for(int i=0;i<stars.length;i++)
		{
			stars[i] = new Star();
		}
		
		Thread t = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				while(true)
				{
					//Thread.sleep(40); // press on red cross front and choose Surround with try/catch
					try
					{
						Thread.sleep(40);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					
					for(int i=0;i<balls.length;i++)
					{
						balls[i].move();
					}
					for(int i=0;i<rects.length;i++)
					{
						rects[i].move();
					}
					for(int i=0;i<stars.length;i++)
					{
						stars[i].move();
					}
					
					repaint(); //to draw again
				}
				
			}
		});
		
		t.start();
		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);	
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i=0;i<balls.length;i++)
		{
			balls[i].draw(g);
		}
		for(int i=0;i<rects.length;i++)
		{
			rects[i].draw(g);
		}
		for(int i=0;i<stars.length;i++)
		{
			stars[i].draw(g);
		}
	}
	
	public static void main(String[] args)
	{
		new GUI();
	}

}
