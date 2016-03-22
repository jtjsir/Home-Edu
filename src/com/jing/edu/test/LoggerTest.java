package com.jing.edu.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

	static Logger logger = LogManager.getLogger(LoggerTest.class.getName()) ;
	
	public static void main(String[] args){
		logger.info("this is a info message");
		logger.error("this is a warn message");
	}
}
