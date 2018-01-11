package SnowFlakes;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Data {

	public static BufferedImage im ;
	public static int hc=250;                 //缓冲时间，画图间歇时间
	public static int drop=10;                //下落速度
	public static int screenwidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();//产生雪花的x最大位置,即屏幕最右端
	public static int screenheigh=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();//雪花最大下落位置y,即屏幕最下端
	public static int dropspeedmax=10;        //雪花最大移动速度
	public static int rotatespeedmax=10;      //雪花最大移动速度
	
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
