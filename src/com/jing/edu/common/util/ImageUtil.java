package com.jing.edu.common.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

//	private BufferedImage getImage(String pathName) {
//		BufferedImage image = null;
//		try {
//			FileInputStream fs = new FileInputStream(new File(pathName));
//			image = ImageIO.read(fs);
//		} catch (Exception e) {
//
//		}
//		return image;
//	}

	public static boolean isStrictImage(long imageSize) {
		boolean flag = true;

		double size = imageSize / 1024.0;
		// 上传的图片不可大于2M且不可小于7KB
		if (size > 2 * 1024.0 || size < 7.0) {
			flag = false;
		}

		return flag;
	}

	/**
	 * 
	 * @param preData 
	 *            图片原始字节流
	 * @param size
	 *            宽度高度设定的大小 200px
	 * @param format
	 *            转换的格式
	 *            
	 * @return 返回图像的字节流用来上传到数据库 保存尺寸为200px*200px 方便前台显示
	 */
	public static byte[] resizeImage(byte[] preData, int size, String format) {
		byte[] data = null;
		try {
			// 转换byte[]为输入流
			ByteArrayInputStream bis = new ByteArrayInputStream(preData);
			BufferedImage preImage = ImageIO.read(bis);
//			int width = preImage.getWidth();
//			int height = preImage.getHeight();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			int newWidth = size;
			int newHeight = size ;
			//重新塑造
			BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
			Graphics graphics = image.createGraphics();
			// 将图片修改成指定大小的image
			graphics.drawImage(preImage, 0, 0, newWidth, newHeight, null);
			// 写入到os中
			ImageIO.write(image, format, os);
			data = os.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void write(String path,byte[] data,int size,String format){
		byte[] newData = resizeImage(data, size, format) ;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(newData) ;
			FileOutputStream fos = new FileOutputStream(new File(path)) ;
			BufferedInputStream bStream = new BufferedInputStream(bis) ;
			BufferedOutputStream bOutputStream = new BufferedOutputStream(fos) ;
			byte[] images = new byte[1024] ;
			int len = 0 ;
			while((len = bStream.read(images))!=-1){
				bOutputStream.write(images, 0, len);
			}
			bOutputStream.close();
			bStream.close();
			fos.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	// public static void main(String[] args){
	// ImageUtil.isOkImage("src/byebye-small.gif");
	// }
}
