package com.jing.edu.util;

import java.io.File;

public class FileUtil {

	/**
	 * 获取不带后缀的文件名
	 * @param fileName
	 * @return
	 */
	public static String getNoExtension(String fileName){
		String result = null ;
		if(fileName!=null&&!"".equals(fileName)){
			int index = fileName.indexOf(".") ;
			int len = fileName.length() ;
			if(index<len&&index!=0){
				result = fileName.substring(0, index) ;
			}
		}
		
		return result ;
	}
	
	/**
	 * 得到服务器图片的名字里面的三个重要信息
	 * @param fileName
	 * @return
	 */
	public static String[] getParamters(String fileName){
		String[] paramters = new String[3] ;
		int preffix = fileName.indexOf("_") ;
		int suffix = fileName.lastIndexOf("_") ;
		//realName
		paramters[0] = fileName.substring(0, preffix) ;
		//level
		paramters[1] = fileName.substring(preffix+1, suffix) ;
		//subjects
		paramters[2] = fileName.substring(suffix+1) ;
		
		return paramters ;
	}
	
	public static File addCount(File[] files,int index){
		File selectFile = null ;
		int fileLen = files.length ;
		selectFile = files[index];
		index++ ;
		if(index==fileLen){
			index = 0 ;
		}
		
		return selectFile ;
	}
	
}
