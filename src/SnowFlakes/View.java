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
		this.addKeyListener(this);                      //监听器
		this.getContentPane().setBackground(Color.black);                //设置背景色
		this.setTitle("雪花");                           //设置窗体标题
		this.setSize(1000, 1000);                       //以像素为单位设置窗体长宽	
		this.setLocation(200,200);                          //设置初试横纵位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口即退出
//		this.setResizable(false);                       //禁止用户改变窗体大小
		this.setVisible(true);                          //显示
	}

	public void paint(Graphics g)                       //覆盖JPanel的paint方法，屏幕显示时候自动调用一次，Graphics是绘图的重要类，相当于一只画笔
	{
		//调用父类函数完成初始化   
		super.paint(g);                                 //不能少,作用：清空、初始化、重置
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
			for(int i=0;i<size;i++)                      //旋转
			{
				this.snows.get(i).move();
				if(this.snows.get(i).y>data.screenheigh)
				{
					this.snows.remove(i);
					size--;
				}
			}
			this.repaint();                              //重绘
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
			Random random=new java.util.Random();// 定义随机类
			int x=random.nextInt(data.screenwidth);// 返回[0,data.screenwidth)集合中的整数
			this.snow=new Snow(data.im, x, 0);
			this.snows.add(snow);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
