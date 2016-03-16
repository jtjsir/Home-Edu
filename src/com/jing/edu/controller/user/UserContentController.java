package com.jing.edu.controller.user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * user具体信息类的对应模块的HTML代码的呈现获取类
 * @author jing
 *
 */
@Controller
@RequestMapping(value = "/user/detail/content")
public class UserContentController {
	private String personinfoFile = "com/jing/resources/html/personHTML.txt" ;
	
	private String informMessageFile = "com/jing/resources/html/informMessageHTML.txt" ;
	
	private String resRecommendFile = "com/jing/resources/html/resRecommendHTML.txt" ;
	
	@RequestMapping( value = "/personinfoHTML")
	public void getPersonInfoHTML(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8") ;
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(personinfoFile) ;
		BufferedReader bufferedReader = null ;
		PrintWriter writer = null ;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is)) ;
			writer = response.getWriter() ;
			String str = null ;
			while((str = bufferedReader.readLine())!=null){
				writer.write(str);
			}
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer!=null){
				writer.close();
			}
		}
	}

	@RequestMapping( value = "/informMessageHTML")
	public void getInformMessageHTML(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8") ;
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(informMessageFile) ;
		BufferedReader bufferedReader = null ;
		PrintWriter writer = null ;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is)) ;
			writer = response.getWriter() ;
			String str = null ;
			while((str = bufferedReader.readLine())!=null){
				writer.write(str);
			}
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer!=null){
				writer.close();
			}
		}
	}
	
	@RequestMapping( value = "/resRecommendHTML")
	public void getResRecommendHTML(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8") ;
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(resRecommendFile) ;
		BufferedReader bufferedReader = null ;
		PrintWriter writer = null ;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is)) ;
			writer = response.getWriter() ;
			String str = null ;
			while((str = bufferedReader.readLine())!=null){
				writer.write(str);
			}
			writer.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer!=null){
				writer.close();
			}
		}
	}
}
