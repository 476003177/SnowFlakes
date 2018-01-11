package SnowFlakes;

import java.awt.*;
import java.awt.image.*;
import java.util.Random;

public class Snow {

	public int x;                //横坐标
	public int y;                //纵坐标
	public int w;                //原图宽
	public int h;                //原图高
	public int xw;               //显示的宽
	public int xh;               //显示的高
	public int type;             //原图透明度
	public int degree;           //偏转角度
	public int dropspeed;        //下落速度
	public int rotatespeed;      //旋转速度
	public BufferedImage img1;   //原始图片
	public BufferedImage img;    //缓存图片
	
	
	public Snow(BufferedImage bufferedImage,int x,int y)//构造函数，指定图片流和出场xy坐标
	{
		this.img1=bufferedImage;
		this.x=x;
		this.y=y;
		Random random=new java.util.Random();// 定义随机类
		double mulriple=random.nextDouble();// 返回[0,1)，注意不包括1，作为雪花相比于原图大小的倍数
		this.dropspeed=random.nextInt(Data.dropspeedmax)+1;// 返回[1,Data.speedmax]的，作为雪花移动的速度
		this.rotatespeed=random.nextInt(Data.rotatespeedmax)+1;// 返回[1,Data.speedmax]的，作为雪花移动的速度
		this.w = this.img1.getWidth();
		this.h = this.img1.getHeight();
		this.xw=(int)(this.w/2*mulriple);
		this.xh=(int)(this.h/2*mulriple);
		this.degree=0;
		this.type = this.img1.getColorModel().getTransparency();
	}
	
	public void move()           //移动类，包括下落和旋转
	{
		this.rotateImage();
		this.y=this.y+this.dropspeed;
	}
	
	/** 
     * 旋转图片为指定角度 
     *  
     * @param bufferedimage 
     *            目标图像 
     * @param degree 
     *            旋转角度 
     * @return 
     */  
    public void rotateImage() {   
        this.degree=this.degree+this.rotatespeed;
        this.img=new BufferedImage(this.w, this.h, this.type);
        Graphics2D g=this.img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.rotate(Math.toRadians(this.degree), this.w / 2, this.h / 2);  //将数字角度转换为π角度再旋转
        g.drawImage(this.img1, 0, 0, null);  
        g.dispose();   
    }  
  
    /** 
     * 变更图像为指定大小，本工程未用到 
     *  
     * @param bufferedimage 
     *            目标图像 
     * @param w 
     *            宽 
     * @param h 
     *            高 
     * @return 
     */  
    public void resizeImage(int w, int h) {   
    	
    	this.img=new BufferedImage(this.w, this.h, this.type);
        Graphics2D g=this.img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(this.img1, 0, 0, w, h, 0, 0, this.w, this.h, null);  
        g.dispose();  
        
    }  
  
    /** 
     * 水平翻转图像，本工程未用到 
     *  
     * @param bufferedimage 目标图像 
     * @return 
     */  
    public void flipImage() {   
    	
    	this.img=new BufferedImage(this.w, this.h, this.type);
        Graphics2D g=this.img.createGraphics();
        g.drawImage(this.img1, 0, 0, this.w, this.h, this.w, 0, 0, this.h, null);  
        g.dispose();  
    }  
}
