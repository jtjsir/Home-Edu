<%@page import="com.jing.edu.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	//全路径
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();

	//上下文路径
	String contextPath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/html/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/html/common/common.css">
<style type="text/css">
	body{
			font-family: "华文新魏";
			background-image: url("/baseweb_homeEDU/images/pass/pattern.png");
		}
	.wordgood{
			text-align: center;
		}
</style>
<title>关于我们</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#loginHeader"
					aria-expanded="false">
					<!--sr-only指代让辅助设备该提示的意思-->
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a href="#" class=""><img
					src="<%=basePath%>/images/common/welcome-small.gif" alt="welcome"
					class="img-welcome"></a> <span class="content">HOME_EDU</span>
			</div>
			<div id="loginHeader" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=basePath%>/index">首页</a></li>
					<li><a href="#">|</a></li>
					<li><a href="<%=basePath%>/family/index/tea">老师部营</a></li>
					<li><a href="#">|</a></li>
					<li><a href="<%=basePath%>/family/index/stu">学生部营</a></li>
					<li><a href="#">|</a></li>
					<li><a href="<%=basePath%>/index/about">about us</a></li>
				</ul>
				<form class="nav navbar-right">
					<a href="<%=basePath%>/index/login" class="navbar-text">登录</a> <span
						class="navbar-text">|</span> <a
						href="<%=basePath%>/index/register" class="navbar-text">注册</a>
				</form>
			</div>
		</div>
	</div>
	<div style="margin:0 auto;height:600px;width:815px;">
		<div>
			<div><h2>网站简介</h2></div>
			<p>
				<span>
				在线家教系统已经越来越受国内外人民的欢迎，
				它能满足人们个性化的需求，时间自由灵活、一对一个性化服务而且资费不是很昂贵。
				随着软件工程思想的普及与现实生活的结合，开发出优质的在线家教系统还是会有一定的市场的。
				</span>
			</p>
			<p>就技术层面来说，开发基于web的在线家教网站平台系统，需在局域网中搭建自己的Web服务器，数据库服务器等等。</p>
			<p>本系统拟采用<i style="font-size:18px;">Java+JSP</i>为编程语言、
				<i style="font-size:18px;">Tomcat</i>为Web服务器，
				<i style="font-size:18px;">MySQL</i>为数据库服务器，
				<i style="font-size:18px;">WebSocket+GoEasy</i>作为消息推送框架，
			实现了四大模块，分别是<i style="font-size:18px;color:red;">老师部营模块，学生部营模块，个人中心模块，在线聊天模块</i>。</p>
		</div>
		<div>
			<img src="<%=basePath%>/images/common/welcome-small.gif" alt="welcome" >
			<img src="<%=basePath%>/images/common/welcome-small.gif" alt="welcome" >
			<img src="<%=basePath%>/images/common/welcome-small.gif" alt="welcome" >
			<img src="<%=basePath%>/images/common/welcome-small.gif" alt="welcome" >
		</div>
	</div>
	<div class="wordgood">
	<h3>Welcome To homeEDU! Be Happy!Be Useful!-------<span class="glyphicon glyphicon-send"></span>DogIfRich<span class="glyphicon glyphicon-send"></span></h3>
	</div>
	<div class="footer">
		<div class="bottom">Copyright &copy; 2015 by JingSir,All Right
				Reserved</div>
	</div>
		
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//共有的js代码
	$(function(){
		<%
			User user = (User)request.getSession().getAttribute("user") ;
			if(user!=null){
		%>
		//判断是否有用户已经登录
		var index_text1 = $('.navbar-right a[name="text1"]') ;
		var index_text2 = $('.navbar-right a[name="text2"]') ;
		index_text1.text('<%=user.getUsername()%>');
		index_text1.attr("href","<%=basePath%>/user/detail/tea/index") ;
		//退出返回到登录界面
		index_text2.text('退出');
		index_text2.attr("href","<%=basePath%>/login/out");
		<%
			}
		%>
});
</script>
</body>
</html>