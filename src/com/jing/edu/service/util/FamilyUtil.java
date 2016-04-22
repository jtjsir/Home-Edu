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
	 * 重新组合userdetail中的list顺序
	 * @param sortList	排序好的userList
	 * @param willdetails 重排的userdetailList
	 * @return 
	 */
	public static List<UserDetail> reAddAgeList(List<User> sortList,List<? extends UserDetail> willdetails){
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
