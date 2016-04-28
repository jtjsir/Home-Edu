package com.jing.edu.common.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.jing.edu.model.EduType.LevelType;
import com.jing.edu.model.User;
import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.model.UserNotice;

/**
 * 简单排序工具类
 * @author jing
 *
 */
public class SortUtil {

	//age排序
	public static void sortByAge(List<User> users,int order){
		AgeSortComp ageSort = new AgeSortComp(order) ;
		Collections.sort(users, ageSort);
	}
	
	//price排序
	public static void sortByPrice(List<? extends UserDetail> users,int order,LevelType type){
		PriceSortComp priceSort = new PriceSortComp(order,type) ;
		Collections.sort(users, priceSort);
	}

	//notice排序
	public static void sortByNotice(List<UserNotice> users,int order){
		NoticeSortComp noticeSortComp = new NoticeSortComp(order) ;
		Collections.sort(users, noticeSortComp);
	}
	
	
	
	private static class AgeSortComp implements Comparator<User>{
		//0代表升序，1代表降序
		private int order = 0 ;
		
		public AgeSortComp(int order){
			this.order = order ;
		}
		
		@Override
		public int compare(User o1, User o2) {
			if(order==0){
				if(o1.getAge()>o2.getAge()){
					return 1 ;
				}else{
					return -1 ;
				}
			}else{
				if(o1.getAge()>o2.getAge()){
					return -1 ;
				}else{
					return 1 ;
				}
			}
		}
		
	}
	
	private static class PriceSortComp implements Comparator<UserDetail>{
		//0代表升序，1代表降序
		private int order = 0 ;
		
		//type
		private LevelType levelType ;
		
		public PriceSortComp(int order,LevelType type){
			this.order = order ;
			this.levelType = type ;
		}
		
		@Override
		public int compare(UserDetail o1, UserDetail o2) {
			if(o1.getClass().equals(UserDetailStu.class)){
				UserDetailStu stu1 = (UserDetailStu)o1 ;
				UserDetailStu stu2 = (UserDetailStu)o2 ;
				if(0==order){
					if(StringUtil.getPriceByType(stu1.getPrice(), levelType) > StringUtil.getPriceByType(stu2.getPrice(), levelType)){
						return 1 ;
					}else{
						return -1 ;
					}
				}else if(1==order){
					if(StringUtil.getPriceByType(stu1.getPrice(), levelType) > StringUtil.getPriceByType(stu2.getPrice(), levelType)){
						return -1 ;
					}else{
						return 1 ;
					}
				}
			}else if(o1.getClass().equals(UserDetailTea.class)){
				UserDetailTea tea1 = (UserDetailTea)o1 ;
				UserDetailTea tea2 = (UserDetailTea)o2 ;
				if(0==order){
					if(StringUtil.getPriceByType(tea1.getPrice(), levelType) > StringUtil.getPriceByType(tea2.getPrice(), levelType)){
						return 1 ;
					}else{
						return -1 ;
					}
				}else if(1==order){
					if(StringUtil.getPriceByType(tea1.getPrice(), levelType) > StringUtil.getPriceByType(tea2.getPrice(), levelType)){
						return -1 ;
					}else{
						return 1 ;
					}
				}
			}
			return 0;
		}
		
	}
	
	private static class NoticeSortComp implements Comparator<UserNotice>{

		//0-升序	1-降序
		private int order = 1 ;
		
		public NoticeSortComp(int order){
			this.order = order ;
		}
		@Override
		public int compare(UserNotice o1, UserNotice o2) {
			int comp = 0 ;
			if(0==order){
				if(o1.getNoticeNums() > o2.getNoticeNums()){
					comp = 1 ;
				}else {
					comp =  -1 ;
				}
			}else if(1==order){
				if(o1.getNoticeNums() > o2.getNoticeNums()){
					comp = -1 ;
				}else{
					comp = 1 ;
				}
			}
			
			return comp;
		}
		
	}
	
	public static void main(String[] args){
	}
}


