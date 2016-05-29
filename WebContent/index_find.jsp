<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jing.edu.model.User"%>
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
	
<title>密码寻找页面</title>
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
					<span class="glyphicon glyphicon-search"></span>|
				</h1>
				<h2 style="float:left;font-size:20px;font-weight:normal;font-family: 'Microsoft YaHei'">找回密码</h2>
		</div>
	</div>
	<div style="height:550px;width:900px;margin:0 auto;padding-top:100px;background:url(/baseweb_homeEDU/images/common/password_bg.jpg)">
		<div style="height:300px;width:450px;margin:0 auto;">
			<p   id="accountIt"><span class="glyphicon glyphicon-user" style="font-size:20px;margin-right:20px;"></span>
					  <input type="text" placeholder="注册帐号" style="width: 250px;    height: 48px;"/>
					  <label class="accountTip" hidden style="width:150px;font-size: 10px;"/>
			</p>
			<p   id="emailIt"><span class="glyphicon glyphicon-envelope" style="font-size:20px;margin-right:20px;"></span>
					  <input type="text" placeholder="注册邮箱" style="width: 250px;    height: 48px;"/>
					  <label class="emailTip" hidden style="width:150px;font-size: 10px;"/>
			</p>
			<p class="submitbtn"><input type="button"  value="下一步" style="width:290px;display: block;    height: 50px;  line-height: 50px; 
								   border: none;    overflow: hidden;   text-align: center;    border-radius: 2px;background: #69b3f2;    color: #FFF;" /></p>
		</div>
	</div>
</div>
<div class="footer">
	<div class="bottom">Copyright &copy; 2015 by JingSir,All Right Reserved</div>
</div>
<div id="result_modal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" >&times;</button>
				<h4 class="modal-title" id="myModalLabel">Notice</h4>
			</div>
			<div class="modal-body">
			</div>
			<div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            </div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.submitbtn').on('click','input',function(){
				var account = $('#accountIt input').val() ;
				var email = $('#emailIt input').val() ;
				var emailTips = $('.emailTip').html();
				var accountTips = $('.accountTip').html();
				if(emailTips==accountTips){
					$.ajax({
						url:"/baseweb_homeEDU/password/find/emailval",
						type:"post",
						data:{
							username:account,
							email:email
						},
						success:function(data){
							if(data==null||data==''){
								alert('重置链接已经发送到您的邮箱，请注意查收。点击 确定  按钮之后将跳转到登录页面');
								window.location.href = "<%=basePath%>/index/login" ;
							}else{
								console.log(data);
								$('.emailTip').html(data).show() ;
								$('#emailIt input').focus();
							}
						}
					});
				}else{
					return;
				}
		});
		
		//帐号检测
		$('#accountIt input').blur(function(event){
			var username = $('#accountIt input').val();
			if(username===''){
				$('.accountTip').html("Username is empty!<span style='color:red;'>&times;</span>").show();
			}else{
				$.ajax({
					url:"/baseweb_homeEDU/password/findName",
					type:"get",
					data:{username:username},
					success:function(info){
						$('.accountTip').html(info).show();
					}
				});
			}
		});
		$('#accountIt input').focus(function(event){
			$('.accountTip').hide();
			var username = $('#accountIt input').val();
			if(username===''){
			}else{
				$('#accountIt input').val('');
			}
		});
		//Email检测
		$('#emailIt input').focus(function(event){
			$('.emailTip').hide();
		});
		
		$('#emailIt input').blur(function(event){
			var email = $('#emailIt input').val();
			if(email===''){
				$('.emailTip').html("Email is empty!<span style='color:red'>&times;</span>").show();
			}else{
				$('.emailTip').html("<span style='color:red'>&radic;</span>").show();
			}
		});
	});
</script>
</body>
</html>