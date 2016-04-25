package com.jing.edu.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jing.edu.model.EduType.LevelType;

public class StringUtil {

	/**
	 * 前台传送过来的subjects数组转换为String
	 * 
	 * @param subjects
	 * @return
	 */
	public static String subjectsContact(String[] subjects) {
		int subSize = subjects.length;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < subSize; i++) {
			buffer.append(subjects[i]).append(",");
		}
		buffer.deleteCharAt(buffer.length() - 1);

		return buffer.toString();
	}

	/**
	 * price拼接成字符串
	 * 
	 * @param small
	 * @param medium
	 * @param senior
	 * @return
	 */
	public static String priceContact(String small, String medium, String senior) {
		StringBuffer buffer = new StringBuffer();
		if (null == small) {
			small = "0";
		}
		if (null == medium) {
			medium = "0";
		}
		if (null == senior) {
			senior = "0";
		}
		buffer.append("小学报价: ").append(small).append("元/小时;").append("初中报价: ").append(medium).append("元/小时;")
				.append("高中报价: ").append(senior).append("元/小时");

		return buffer.toString();
	}

	/**
	 * 
	 * @param priceStr
	 * @param type
	 *            学籍类别:小学/初中/高中
	 * @return
	 */
	public static int getPriceByType(String priceStr, LevelType type) {
		int price = 0;

		if (null == priceStr) {
			return 0;
		} else {
			int[] prices = getPrices(priceStr);
			switch (type) {
			case PRIMARY:
				price = prices[0];
				break;
			case MEDIUM:
				price = prices[1];
				break;
			case SENIOR:
				price = prices[2];
				break;
			default:
				price = 0;
				break;
			}
		}

		return price;
	}

	/**
	 * str转int[]
	 * 
	 * @param priceStr
	 * @return
	 */
	public static int[] getPrices(String priceStr) {
		int[] prices = new int[3];
		if (null != priceStr) {
			priceStr = priceStr + ";";
			int index1 = 0;
			int index2 = 0;
			for (int i = 0; i < 3; i++) {
				index1 = priceStr.indexOf(":");
				index2 = priceStr.indexOf(";");
				prices[i] = Integer.valueOf(priceStr.substring(index1 + 2, index2 - 4));
				priceStr = priceStr.substring(index2 + 1);
			}
		}

		return prices;
	}

	/**
	 * subject拼接成字符串
	 * 
	 * @param subject
	 * @return
	 */
	public static String[] seperateSubject(String subject) {
		String[] result = new String[3];
		if (subject == null) {
			return null;
		} else {
			int index = subject.indexOf(",");
			if (index == -1) {
				result[0] = subject;
				return result;
			}
			int count = 0;
			while (index != -1) {
				result[count] = subject.substring(0, index);
				subject = subject.substring(index + 1);
				index = subject.indexOf(",");
				count++;
			}
			result[count] = subject;
		}
		return result;
	}

	/**
	 * 格式化获取的实时时间
	 * 
	 * @return
	 */
	public static String getNowFormatTime() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	/**
	 * url加密参数
	 * 
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String encodeParam(String param, String charset) {
		String result = null;
		try {
			result = URLEncoder.encode(param, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * url解密参数
	 * 
	 * @param encodeParam
	 * @param charset
	 * @return
	 */
	public static String decodeParam(String encodeParam, String charset) {
		String resule = null;
		try {
			resule = URLDecoder.decode(encodeParam, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return resule;
	}
	
	//过滤html标签的正则表达式
	private static String htmlReg = "<([^>]*)>" ;
	
	public static String filterHTMLLabel(String str){
		Pattern pattern = Pattern.compile(htmlReg) ;
		Matcher matcher = pattern.matcher(str) ;
		StringBuffer sBuffer = new StringBuffer() ;
		boolean isFind = matcher.find() ;
		while(isFind){
			matcher.appendReplacement(sBuffer, "") ;
			isFind = matcher.find() ;
		}
		
		
		return sBuffer.toString() ;
	}
	
	public static void main(String[] args){
		System.err.println(StringUtil.filterHTMLLabel("<div><p>jingtj</p></div>"));
		System.err.println(StringUtil.encodeParam("tea", "GBK")) ;
	}
}
