package com.jing.edu.util;

public class StringUtil {

	/**
	 *前台传送过来的subjects数组转换为String
	 * @param subjects
	 * @return
	 */
	public static String subjectsContact(String[] subjects){
		int subSize = subjects.length ;
		StringBuffer buffer = new StringBuffer() ;
		for(int i = 0 ; i < subSize ; i++){
			buffer.append(subjects[i]).append(",");
		}
		buffer.deleteCharAt(buffer.length()-1) ;
		
		return buffer.toString() ;
	}
	
	public static String priceContact(String small,String medium,String senior){
		StringBuffer buffer = new StringBuffer() ;
		buffer.append("小学报价: ").append(small).append("元/小时;")
		.append("初中报价: ").append(medium).append("元/小时;").append("高中报价: ")
		.append(senior).append("元/小时") ;
		
		return buffer.toString() ;
	}
	
	public static String[] seperateSubject(String subject){
		String[] result = new String[3] ;
		if(subject==null){
			return null ;
		}else{
			int index = subject.indexOf(",") ;
			if(index==-1){
				result[0] = subject ;
				return result ;
			}
			int count = 0 ;
			while(index!=-1){
				result[count] = subject.substring(0, index) ;
				subject = subject.substring(index+1) ;
				index = subject.indexOf(",") ;
				count++ ;
			}
			result[count] = subject ;
		}
		return result ;
	}
}
