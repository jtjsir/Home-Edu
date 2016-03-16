package com.jing.edu.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;


public interface IndexService {

	File getRandomPhoto(HttpServletRequest request) ;
	
	void sendParamters(File selectFile,HttpServletRequest request,String index) ;
}
