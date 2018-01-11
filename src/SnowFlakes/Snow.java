package SnowFlakes;

import java.awt.*;
import java.awt.image.*;
import java.util.Random;

public class Snow {

	public int x;                //������
	public int y;                //������
	public int w;                //ԭͼ��
	public int h;                //ԭͼ��
	public int xw;               //��ʾ�Ŀ�
	public int xh;               //��ʾ�ĸ�
	public int type;             //ԭͼ͸����
	public int degree;           //ƫת�Ƕ�
	public int dropspeed;        //�����ٶ�
	public int rotatespeed;      //��ת�ٶ�
	public BufferedImage img1;   //ԭʼͼƬ
	public BufferedImage img;    //����ͼƬ
	
	
	public Snow(BufferedImage bufferedImage,int x,int y)//���캯����ָ��ͼƬ���ͳ���xy����
	{
		this.img1=bufferedImage;
		this.x=x;
		this.y=y;
		Random random=new java.util.Random();// ���������
		double mulriple=random.nextDouble();// ����[0,1)��ע�ⲻ����1����Ϊѩ�������ԭͼ��С�ı���
		this.dropspeed=random.nextInt(Data.dropspeedmax)+1;// ����[1,Data.speedmax]�ģ���Ϊѩ���ƶ����ٶ�
		this.rotatespeed=random.nextInt(Data.rotatespeedmax)+1;// ����[1,Data.speedmax]�ģ���Ϊѩ���ƶ����ٶ�
		this.w = this.img1.getWidth();
		this.h = this.img1.getHeight();
		this.xw=(int)(this.w/2*mulriple);
		this.xh=(int)(this.h/2*mulriple);
		this.degree=0;
		this.type = this.img1.getColorModel().getTransparency();
	}
	
	public void move()           //�ƶ��࣬�����������ת
	{
		this.rotateImage();
		this.y=this.y+this.dropspeed;
	}
	
	/** 
     * ��תͼƬΪָ���Ƕ� 
     *  
     * @param bufferedimage 
     *            Ŀ��ͼ�� 
     * @param degree 
     *            ��ת�Ƕ� 
     * @return 
     */  
    public void rotateImage() {   
        this.degree=this.degree+this.rotatespeed;
        this.img=new BufferedImage(this.w, this.h, this.type);
        Graphics2D g=this.img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.rotate(Math.toRadians(this.degree), this.w / 2, this.h / 2);  //�����ֽǶ�ת��Ϊ�нǶ�����ת
        g.drawImage(this.img1, 0, 0, null);  
        g.dispose();   
    }  
  
    /** 
     * ���ͼ��Ϊָ����С��������δ�õ� 
     *  
     * @param bufferedimage 
     *            Ŀ��ͼ�� 
     * @param w 
     *            �� 
     * @param h 
     *            �� 
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
     * ˮƽ��תͼ�񣬱�����δ�õ� 
     *  
     * @param bufferedimage Ŀ��ͼ�� 
     * @return 
     */  
    public void flipImage() {   
    	
    	this.img=new BufferedImage(this.w, this.h, this.type);
        Graphics2D g=this.img.createGraphics();
        g.drawImage(this.img1, 0, 0, this.w, this.h, this.w, 0, 0, this.h, null);  
        g.dispose();  
    }  
}
