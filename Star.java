////⨷�����ҧ�١��� (2)Ẻ Constructor 
//�պ�� ��� ������������觪��ͺ
import java.awt.Color;
import java.awt.Graphics;

public class Star
{
	public int R,G,B,Size;
	public Vector pos,vel,acc;
	public Star()
	{
		pos = new Vector();
		vel = new Vector();
		acc = new Vector();
		pos.x = (int)(Math.random()*500);
		pos.y = (int)(Math.random()*500);
		vel.x = (int)(Math.random()*10-5);
		vel.y = (int)(Math.random()*10-5);
		acc.x = 0;
		acc.y = 0.1;
		R = (int)(Math.random()*250);
		G = (int)(Math.random()*250);
		B = (int)(Math.random()*250);
		Size = (int)(Math.random()*250);
	}
	public void move()
	{
		pos = pos.add(vel);
		if(pos.x + Size>500)
		{
			pos.x = 500 - Size;
			vel.x = vel.x*(-1);
		}
		if(pos.x<0)
		{
			pos.x = 0;
			vel.x = vel.x*(-1);
		}	
		if(pos.y + Size >500)
		{
			pos.y = 500 - Size;
			vel.y = vel.y*(-1);
		}	
		if(pos.y<0)
		{
			pos.y = 0;
			vel.y = vel.y*(-1);
		}
	}
	public void draw(Graphics g)
	{
		g.setColor(new Color(R, G, B,190));
		int n =5;
		int []xx = new int[n*2];
		int []yy = new int[n*2];
		for(int i=0;i<n*2;i++)
		{
			xx[i] = (int)(pos.x + Size*Math.cos(i*Math.PI/n));
			yy[i] = (int)(pos.y + Size*Math.sin(i*Math.PI/n));
			i++;
			xx[i] = (int)(pos.x + Size/2*Math.cos(i*Math.PI/n));
			yy[i] = (int)(pos.y + Size/2*Math.sin(i*Math.PI/n));
		}
		g.fillPolygon(xx, yy, n*2);
	}
}

