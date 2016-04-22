package com.jing.edu.service.impl;

import java.io.File;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.FileUtil;
import com.jing.edu.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService ,BaseLogger{

	private static final Logger logger = LogManager.getLogger(IndexServiceImpl.class) ;
	
	public static int selectNum1 = 0 ;
	public static int selectNum2 = 0 ;
	public static int selectNum3 = 0 ;
	public static int selectNum4 = 0 ;
	public static int selectNum5 = 0 ;
	public static int selectNum6 = 0 ;
	
	@Override
	public File getRandomPhoto(HttpServletRequest request) {
		String type = request.getParameter("userType");
		String directory = null;
		File selectFile = null;
		if (type != null) {
			directory = request.getServletContext().getRealPath("/upload_photos/" + type);
			File directoryFile = new File(directory);
			if (directoryFile.isDirectory()) {
				Random random = new Random();
				if ("tea".equals(type)) {
					String level = request.getParameter("level");
					directory = directory + "/" + level;
				} else if ("stu".equals(type)) {
					String[] levels = { "smallsch", "mediumsch", "seniorsch" };
					int levelLen = levels.length;
					int selectNumber = random.nextInt(levelLen);
					directory = directory + "/" + levels[selectNumber];
				}
				File directoryFile2 = new File(directory) ;
				if (directoryFile2.isDirectory()) {
					File[] files = directoryFile2.listFiles();
					int fileLen = files.length ;
					if(directory.contains("stu/smallsch")){
						selectFile = files[selectNum1] ;
						selectNum1++ ;
						if(selectNum1==fileLen){
							selectNum1 = 0 ;
						}
						
					}else if (directory.contains("stu/mediumsch")) {
						selectFile = files[selectNum2] ;
						selectNum2++ ;
						if(selectNum2==fileLen){
							selectNum2 = 0 ;
						}
					}
					else if (directory.contains("stu/seniorsch")) {
						selectFile = files[selectNum3] ;
						selectNum3++ ;
						if(selectNum3==fileLen){
							selectNum3 = 0 ;
						}
					}
					else if (directory.contains("tea/smallsch")) {
						selectFile = files[selectNum4] ;
						selectNum4++ ;
						if(selectNum4==fileLen){
							selectNum4 = 0 ;
						}
					}
					else if (directory.contains("tea/mediumsch")) {
						selectFile = files[selectNum5] ;
						selectNum5++ ;
						if(selectNum5==fileLen){
							selectNum5 = 0 ;
						}
					}
					else if (directory.contains("tea/seniorsch")) {
						selectFile = files[selectNum6] ;
						selectNum6++ ;
						if(selectNum6==fileLen){
							selectNum6 = 0 ;
						}
					}
				}
			}

		}
		return selectFile;
	}

	@Override
	public void sendParamters(File selectFile,HttpServletRequest request,String index) {
		String fileName = selectFile.getName() ;
		fileName = FileUtil.getNoExtension(fileName) ;
		String[] parameters = null ;
		try {
			parameters = FileUtil.getParamters(fileName) ;
		} catch (Exception e) {
			this.getLogger().debug(fileName + " 文件命名不正确!----> " + "应该为  realname_level_subjects命名方式");
		}
		
		request.getSession().setAttribute("realname" + index, parameters[0]);
		request.getSession().setAttribute("level" + index, parameters[1]);
		request.getSession().setAttribute("subjects" + index, parameters[2]);
		
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

}
