<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/common/common.css">
	
<title>密码重置页面</title>
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
				<li><a href="<%=basePath %>/family/index/tea">老师部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath %>/family/index/stu">学生部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="#">about us</a></li>
			</ul>
			<form class="nav navbar-right">
				<a href="<%=basePath %>/index/login" class="navbar-text" name="text1">登录</a>
				<span class="navbar-text">|</span>
				<a href="<%=basePath %>/index/register" class="navbar-text" name="text2">注册</a>
			</form>
		</div>
	</div>
</div>
<div style="height:600px;">
	<div class="g-hd" style="height:50px;background:rgba(72, 20, 20, 0.1);">
		<div class="g-in" style="width:990px;margin:0 auto;">
				<h1 style="float:left;width:70px;font-size: 20px;text-align:center;">
					<span class="glyphicon glyphicon-cog"></span>|
				</h1>
				<h2 style="float:left;font-size:20px;font-weight:normal;font-family: 'Microsoft YaHei'">密码重置</h2>
		</div>
	</div>
	<div style="height:550px;width:900px;margin:0 auto;padding-top:100px;background:url(/baseweb_homeEDU/images/common/password_bg.jpg)">
		<div style="height:300px;width:450px;margin:0 auto;">
			<p   id="newwordIt1"><span class="glyphicon glyphicon-eye-close" style="font-size:20px;margin-right:20px;"></span>
					  <input type="password" placeholder="输入新密码" style="width: 250px;    height: 48px;"/>
					  <label class="newwordTip1" hidden style="width:150px;font-size: 10px;"/>
			</p>
			<p   id="newwordIt2"><span class="glyphicon glyphicon-eye-close" style="font-size:20px;margin-right:20px;"></span>
					  <input type="password" placeholder="再次输入新密码" style="width: 250px;    height: 48px;"/>
					  <label class="newwordTip2" hidden style="width:150px;font-size: 10px;"/>
			</p>
			<p id="username"><input type="text" value="<%=request.getParameter("username") %>" hidden/></p>
			<p class="submitbtn"><input type="button"  value="下一步" style="width:290px;display: block;    height: 50px;  line-height: 50px; 
								   border: none;    overflow: hidden;   text-align: center;    border-radius: 2px;background: #69b3f2;    color: #FFF;" /></p>
		</div>
	</div>
</div>
<div class="footer">
	<div class="bottom">Copyright &copy; 2015 by JingSir,All Right Reserved</div>
</div>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.submitbtn').on('click','input',function(){
				var newwordlabel1 = $('.newwordTip1').html() ;
				var newwordlabel2 = $('.newwordTip2').html() ;
				if(newwordlabel1!=newwordlabel2){
					return;
				}else{
				var password = $('#newwordIt2 input').val() ;
				var account = $('#username input').attr('value') ;
				$.ajax({
					url:"/baseweb_homeEDU/password/reset/email",
					type:"get",
					data:{
						username:account,
						password:password
					},
					success:function(data){
					}
				});
				}
		});
		
		//新密码检测
		$('#newwordIt1 input').blur(function(event){
			var newword1 = $('#newwordIt1 input').val();
			if(newword1===''){
				$('.newwordTip1').html("Password is empty!<span style='color:red'>&times;</span>").show();
			}else{
				$('.newwordTip1').html("<span style='color:red'>&radic;</span>").show();
			}
		});
		$('#newwordIt1 input').focus(function(event){
			$('.newwordTip1').hide();
			var newword1 = $('#newwordIt1 input').val();
			if(newword1===''){
			}else{
				$('#newwordIt1 input').val('');
			}
		});
		//新密码确认检测
		$('#newwordIt2 input').blur(function(event){
			var newword1 = $('#newwordIt1 input').val();
			var newword2 = $('#newwordIt2 input').val();
			if(newword1===''){
				$('.newwordTip2').html("Password is empty!<span style='color:red'>&times;</span>").show();
			}else if(newword1!=newword2){
				$('.newwordTip2').html("Password is not similar!<span style='color:red'>&times;</span>").show();
			}else{
				$('.newwordTip2').html("<span style='color:red'>&radic;</span>").show();
			}
		});
		$('#newwordIt2 input').focus(function(event){
			$('.newwordTip2').hide();
			var newword2 = $('#newwordIt2 input').val();
			if(newword2===''){
			}else{
				$('#newwordIt2 input').val('');
			}
		});
	});
</script>
</body>
</html>