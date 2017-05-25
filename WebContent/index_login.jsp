<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
		//全路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() ;
	
		//上下文路径
		String contextPath = request.getContextPath() ;
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/html/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/html/common/common.css">
	<title>LoginPage</title>
	<style type="text/css">
		.login_wrap{
			/*position: absolute;*/
			background: url(/Home-Edu/images/login/bg_login.jpg) no-repeat center;
			/*background-size: 90%;*/
			width: 100%;
			height: 623px;
		}
		.login_in{
			position: relative;
			width: 918px;
			height: 623px;
			/*margin实现居中*/
			margin: 0 auto;
		}

		.login_in .login_title_change{
			position: absolute;
    		right: 0;
    		width: 374px;
    		height: 50px;
    		margin-top: 100px;
   			padding-left: 120px;
		}
		.login_in .login_title_change .font{
			font-size: 21px;
			width: 65px;
			/*display: block;*/
			background: #17BBE0;
    		color: #fff;
		}
		.login_in .login_box{
			position: absolute;
			right: 0 ;
			width: 374px;
			height: 357px;
			padding:14px 20px 0 ;
			margin-top: 164px;
		}
		.login_in h2{
			font-size:24px;
			line-height: 74px;
			color: #2ea9df;
			text-align: center;
		}

		.login_in .elseInfo{
			font-size: 14px;
			color: #999;
			line-height: 24px;

		}
		.login_in .elseInfo a{
			font-size: 14px;
			/*color: #999;*/
			line-height: 24px;
			padding-left: 20px;
		}

		.label-error{
			color: #FF0000;
			/*padding-left:20px;*/
		}
	</style>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#loginHeader" aria-expanded="false">
				<!--sr-only指代让辅助设备该提示的意思-->
				<span class="sr-only">切换导航</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class=""><img src="<%=basePath %>/images/common/welcome-small.gif" alt="welcome"
			 class="img-welcome"></a>
			 <span class="content">HOME_EDU</span>
		</div>
		<div id="loginHeader" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=basePath%>/index">首页</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath %>/family/index/tea">教师部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath %>/family/index/stu">学生部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath%>/index/about">about us</a></li>
			</ul>
			<form class="nav navbar-right">
				<a href="<%=basePath %>/index/login" class="navbar-text">登录</a>
				<span class="navbar-text">|</span>
				<a href="<%=basePath %>/index/register" class="navbar-text">注册</a>
			</form>
		</div>
	</div>

</div>
<div class="login_wrap">
	<div class="login_in">
		<div class="login_title_change">
			<div class="font">HOME</div>
		</div>
		<div class="login_box">
			<h2>HOME登录</h2>
			<form class="form-group" action="<%=basePath %>/login/on" method="post">
				<span class="glyphicon glyphicon-user"></span>
				<label class="label-error" id="label-username" hidden>&times;请输入正确的用户名</label>
				<input type="text" class="form-control" placeholder="请输入你的用户名" name="username" id="username">
				<span class="glyphicon glyphicon-lock"></span>
				<label class="label-error" id="label-pass" hidden>&times;请输入正确的密码</label>
				<input type="password" class="form-control" placeholder="请输入你的密码" name="password" id="password"><br>
				<label class="radio-inline">
					<input type="radio" name="userType" value="1" checked>教师
				</label>
				<label class="radio-inline">
					<input type="radio" name="userType" value="2">学生
				</label>
				<br><br>
				<input type="submit" class="form-control btn btn-success" value="立即登录" id="login">
			</form>
			<p class="elseInfo">
				还没有HomeEdu账号？
				<a href="<%=basePath%>/index/register">免费注册</a>
				<a href="<%=basePath%>/index/find">忘记密码</a>
			</p>
		</div>
	</div>
</div>
<!--当两个div之间没有其他的元素，子div的margin效果作用于父div-->
<div class="footer">
	<div class="bottom">Copyright &copy; 2015 by JingSir,All Right Reserved</div>
</div>

<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		<%
		String flag = request.getParameter("isError") ;
		if(flag!=null&&"true".equals(flag)){
		
		%>
		alert("请输入正确的用户信息!");
	<%
		}
	%>
	});
</script>
<script type="text/javascript">
	$(function(){
		var name;
		var password;
		$('#username').blur(function(event) {
			var username = $('#username').val() ;
			if(username===''){
				$('#label-username').show();
			}else{
				$('#label-username').hide() ;
			}
			name = username ;
		}); 
		$('#username').focus(function(event) {
				$('#label-username').hide();
			
		}); 
		
		$('#password').blur(function(event) {
			var pass = $('#password').val() ;
			if(pass===''){
				$('#label-pass').show();
			}else{
				$('#label-pass').hide();
			}
			password = pass ;
		}); 
		$('#password').focus(function(event) {
				$('#label-pass').hide();
			
		}); 

		//登录
		/**$('#login').click(function(event){
			var userType = $('.radio-inline input[name="userType"]').attr('value') ;
			$.post("http://localhost:8080/baseweb_homeEDU/login/on",{
				username:name,
				password:password,
				userType:userType
			});
		});**/
	});
</script>
</body>
</html>