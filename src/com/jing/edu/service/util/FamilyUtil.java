package com.jing.edu.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.jing.edu.model.User;
import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserNotice;

public class FamilyUtil {

	private static ConcurrentHashMap<String, List<? extends UserDetail>> familyCocurrMap = new ConcurrentHashMap<>() ;
	
	private FamilyUtil(){
		
	}
	public static FamilyUtil getInstance(){
		return SingletonFactory.util ;
	}
	
	private static class SingletonFactory{
		private static final FamilyUtil util = new FamilyUtil() ;
	}
	
	public static ConcurrentHashMap<String, List<? extends UserDetail>> getFamilyMap(){
		if(null == familyCocurrMap){
			familyCocurrMap = new ConcurrentHashMap<>() ;
		}
		
		return familyCocurrMap ;
	}
	
	public static List<? extends UserDetail> getUsers(String keyName){
		return getFamilyMap().get(keyName) ;
	}
	
	public static void putUsers(String keyName,List<? extends UserDetail> users){
		getFamilyMap().put(keyName, users) ;
	}
	
	/**
	 * 过滤搜索框的字符串
	 * @param content
	 * @return
	 */
	public static String filterGradeSubKeys(String content){
		StringBuffer gradeSubBuffer = new StringBuffer() ;
		if(content.contains("小学")){
			gradeSubBuffer.append("小学") ;
		}else if(content.contains("初中")){
			gradeSubBuffer.append("初中") ;
		}else if (content.contains("高中")) {
			gradeSubBuffer.append("高中") ;
		}else if(content.contains("数学")){
			gradeSubBuffer.append("数学");
		}else if(content.contains("语文")){
			gradeSubBuffer.append("语文") ;
		}else if(content.contains("英语")){
			gradeSubBuffer.append("英语") ;
		}else if(content.contains("科学")){
			gradeSubBuffer.append("科学") ;
		}else if(content.contains("物理")){
			gradeSubBuffer.append("物理") ;
		}else if(content.contains("化学")){
			gradeSubBuffer.append("化学") ;
		}else if(content.contains("生物")){
			gradeSubBuffer.append("生物") ;
		}else if(content.contains("历史")){
			gradeSubBuffer.append("历史") ;
		}else if(content.contains("政治")){
			gradeSubBuffer.append("政治") ;
		}else if(content.contains("地理")){
			gradeSubBuffer.append("地理") ;
		}else if(gradeSubBuffer.toString().equals("")){
			gradeSubBuffer.append("小学") ;
		}else{
			//默认为 小学
			gradeSubBuffer.append("小学") ;
		}
		return gradeSubBuffer.toString() ;
	}
	
	/**
	 * 重新组合userdetail中的list顺序
	 * @param sortList	排序好的userList
	 * @param willdetails 重排的userdetailList
	 * @return 
	 */
	public static List<UserDetail> reAddAgeList(List<User> sortList,List<? extends UserDetail> willdetails){
		int usersize = sortList.size() ;
		int detailsize = willdetails.size() ;
		List<UserDetail> details = new ArrayList<>(usersize) ;
		for(int i = 0 ; i < usersize ; i++){
			String username = sortList.get(i).getUsername() ;
			for(int j = 0 ; j < detailsize ; j++){
				if(username.equals(willdetails.get(j).getName())){
					UserDetail temp = willdetails.get(j) ;
					details.add(temp) ;
					break ;
				}
			}
		}
		
		return details ;
	}
	
	public static List<UserDetail> reAddNoticeList(List<UserNotice> sortList,List<? extends UserDetail> willdetails){
		int size = sortList.size() ;
		List<UserDetail> details = new ArrayList<>(size) ;
		for(int i = 0 ; i < size ; i++){
			String username = sortList.get(i).getUsername() ;
			for(int j = 0 ; j < size ; j++){
				if(username.equals(willdetails.get(j).getName())){
					UserDetail temp = willdetails.get(j) ;
					details.add(temp) ;
				}
			}
		}
		
		return details ;
	}
	
	//根据偏移量裁剪List
	public static List<? extends UserDetail> subList(List<? extends UserDetail> originList,int startOffset,int endOffset){
		return originList.subList(startOffset, endOffset) ;
	}
}
