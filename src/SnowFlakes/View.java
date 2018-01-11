package SnowFlakes;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class View extends JFrame implements KeyListener,Runnable{

	Data data=new Data();
	Vector<Snow> snows;
	Snow snow;
	Thread t;
	
	public View()
	{
		this.snows=new Vector<Snow>();
		this.snow=new Snow(data.im, 100, 0);
		this.snows.add(snow);
		this.t=new Thread(this);
		this.addKeyListener(this);                      //������
		this.getContentPane().setBackground(Color.black);                //���ñ���ɫ
		this.setTitle("ѩ��");                           //���ô������
		this.setSize(1000, 1000);                       //������Ϊ��λ���ô��峤��	
		this.setLocation(200,200);                          //���ó��Ժ���λ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ��ڼ��˳�
//		this.setResizable(false);                       //��ֹ�û��ı䴰���С
		this.setVisible(true);                          //��ʾ
	}

	public void paint(Graphics g)                       //����JPanel��paint��������Ļ��ʾʱ���Զ�����һ�Σ�Graphics�ǻ�ͼ����Ҫ�࣬�൱��һֻ����
	{
		//���ø��ຯ����ɳ�ʼ��   
		super.paint(g);                                 //������,���ã���ա���ʼ��������
		Snow snow1;
		int size=this.snows.size();
		for(int i=0;i<size;i++)
		{
			snow1=this.snows.get(i);
			g.drawImage(snow1.img,snow1.x,snow1.y,(int)snow1.xw,(int)snow1.xh,this);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view=new View();
		view.t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			int size=this.snows.size();
			for(int i=0;i<size;i++)                      //��ת
			{
				this.snows.get(i).move();
				if(this.snows.get(i).y>data.screenheigh)
				{
					this.snows.remove(i);
					size--;
				}
			}
			this.repaint();                              //�ػ�
			try {
				Thread.sleep(Data.hc);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			Random random=new java.util.Random();// ���������
			int x=random.nextInt(data.screenwidth);// ����[0,data.screenwidth)�����е�����
			this.snow=new Snow(data.im, x, 0);
			this.snows.add(snow);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
