package SnowFlakes;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Data {

	public static BufferedImage im ;
	public static int hc=250;                 //����ʱ�䣬��ͼ��Ъʱ��
	public static int drop=10;                //�����ٶ�
	public static int screenwidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();//����ѩ����x���λ��,����Ļ���Ҷ�
	public static int screenheigh=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();//ѩ���������λ��y,����Ļ���¶�
	public static int dropspeedmax=10;        //ѩ������ƶ��ٶ�
	public static int rotatespeedmax=10;      //ѩ������ƶ��ٶ�
	
	public Data()
	{
		try {
			im = ImageIO.read(new File("image//snowflake.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
