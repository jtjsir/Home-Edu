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
<title>管理员登录页面</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>/html/common/index.css">
</head>
<body>
<div class="login">
    <h3>后台管理登录页</h3>
    <form class="login_block" method="post">
        <input type="text" placeholder="用户名" name="name">
        <input type="password" placeholder="密码" name="password">
        <form class="login_button" >
            <button class="button">登录</button>
        </form>
    </form>
</div>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(document).on('click','.login_block .button',function(){
			$('.login_block').attr('action','<%=basePath%>/admin/login/on').submit() ;
		});
	})
</script>
</body>
</html>