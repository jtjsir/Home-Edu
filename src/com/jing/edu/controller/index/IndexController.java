package com.jing.edu.controller.index;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.service.IndexService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	public static ReentrantLock lock = new ReentrantLock() ;

	@Resource
	public IndexService indexService ;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public void redirectToIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index.jsp页面
			request.getRequestDispatcher("/index_full.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login")
	public void redirectToLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_login.jsp页面
			request.getRequestDispatcher("/index_login.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/register")
	public void redirectToRegister(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_resister.jsp页面
			request.getRequestDispatcher("/index_register.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/passToLogin")
	public void redirectPassToLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_passToLogin.jsp页面
			request.getRequestDispatcher("/index_passToLogin.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/passToIndex")
	public void redirectPassToIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_passToLogin.jsp页面
			request.getRequestDispatcher("/index_passToIndex.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/find")
	public void redirectToForgetIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_find.jsp页面
			request.getRequestDispatcher("/index_find.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/reset")
	public void redirectToResetIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_reset.jsp页面
			request.getRequestDispatcher("/index_reset.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/about")
	public void redirectToAboutIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 跳转到index_reset.jsp页面
			request.getRequestDispatcher("/index_about.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Deprecated
	//后台获取图片  设计上有问题不使用
	@RequestMapping(value = "/searchImage")
	public void getImage(HttpServletRequest request, HttpServletResponse response) {
		lock.lock();
		//获取随机图片
		File selectFile = indexService.getRandomPhoto(request) ;
		try {
			String index = request.getParameter("a") ;
			////返回给前台的参数 realName_level_subjects
			indexService.sendParamters(selectFile,request,index);
			//图片字节流用response.getOutputstream
			response.setContentType("image/jpeg");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(selectFile));
			OutputStream writer = response.getOutputStream();
			byte[] data = new byte[1024];
			int dataLen = 0;
			while ((dataLen = bis.read(data)) != -1) {
				writer.write(data, 0, dataLen);
			}
			writer.flush();
			writer.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		lock.unlock();
	}
}
