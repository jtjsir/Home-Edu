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
	<title>RegisterPage</title>
	<style type="text/css">
		.register-wrap{
			background:url(/baseweb_homeEDU/images/register/bg_register.jpg) no-repeat left;
			width: 100%;
			height: 667px;
		}
		.register-wrap .register-in{
			float:right;
			width:350px;
			height: 662px;
			margin-top: 5px;
			background-color:#B5CEC8;
			border: solid 4px #000;
		}
		
		.register-box h2{
			font-size:24px;
			line-height: 74px;
			color: #31708f;
			text-align: center;
		}
		
		.register-in .elseInfo{
			font-size: 14px;
			color: #999;
			line-height: 24px;
			text-align: center;
		}
		.register_in .elseInfo a{
			font-size: 14px;
			color: #0B1F2F;
			line-height: 24px;
		}
		.label-error{
			color: #a94442;
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
				<li><a href="<%=basePath %>/family/index/tea">老师部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath %>/family/index/stu">学生部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="<%=basePath%>/index/about">about us</a></li>
			</ul>
			<form class="nav navbar-right">
				<a href="<%=basePath%>/index/login" class="navbar-text">登录</a>
				<span class="navbar-text">|</span>
				<a href="<%=basePath%>/index/register" class="navbar-text">注册</a>
			</form>
		</div>
	</div>

</div>

<div class="register-wrap">
	<div class="register-in">
		<div class="register-box">
			<h2>HOME注册</h2>
			<form class="form-group" action="" method="post">
				<p class="label-error" id="label-username" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Username</span>
					<input type="text" class="form-control" name="username">
				</div>
				<br>
				<p class="label-error" id="label-pass" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Password</span>
					<input type="password" class="form-control" name="password">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">Type</span>
					<label class="radio-inline">
						<input type="radio" name="type" value="1" checked>教师
					</label>
					<label class="radio-inline">
						<input type="radio" name="type" value="2">学生
					</label>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">Sex</span>
					<label class="radio-inline">
						<input type="radio" name="sex" value="男" checked>男
					</label>
					<label class="radio-inline">
						<input type="radio" name="sex" value="女">女
					</label>
				</div>
				<br>
				<p class="label-error" id="label-age" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Age</span>
					<input type="text" class="form-control" name="age">
				</div>
				<br>
				<p class="label-error" id="label-email" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Email</span>
					<input type="text" class="form-control" name="email" placeholder="input like abc@163.com">
				</div>
				<br>
				<p class="label-error" id="label-phone" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Phone</span>
					<input type="text" class="form-control" name="phone" placeholder="input 11 validate numbers">
				</div>
				<br>
				<p class="label-error" id="label-level" hidden></p>
				<div class="input-group">
					<span class="input-group-addon">Level</span>
					<input type="text" class="form-control" name="level" placeholder="input like 小一/初一/高一/大一">
				</div>
				<br><br>
				<input type="button" class="form-control btn btn-danger" value="一键注册" id="regbtn">
			</form>
			<p class="elseInfo">
				已有HomeEdu账号？
				<a href="<%=basePath%>/index/login">登录</a>
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
		//username校验
		$('.input-group input[name="username"]').blur(function(event){
			var username = $('.input-group input[name="username"]').val();
			if(username===''){
				$('#label-username').html("Username is empty!&times;").show();
			}else{
				$.ajax({
					url:"/baseweb_homeEDU/register/findName",
					type:"get",
					data:{username:username},
					success:function(info){
						$('#label-username').html(info).show();
					}
				});
			}
		});
		$('.input-group input[name="username"]').focus(function(event){
			$('#label-username').hide();
			var username = $('.input-group input[name="username"]').val();
			if(username===''){
			}else{
				$('.input-group input[name="username"]').val('');
			}
		});
		//password
		$('.input-group input[name="password"]').blur(function(event){
			var password = $('.input-group input[name="password"]').val();
			if(password===''){
				$('#label-pass').html("Password is empty!&times;").show();
			}
		});
		$('.input-group input[name="password"]').focus(function(event){
			$('#label-pass').hide();
			var password = $('.input-group input[name="password"]').val();
			if(password!==''){
				$('.input-group input[name="password"]').val('');
			}
			
		});
		//age
		$('.input-group input[name="age"]').blur(function(event){
			var age = $('.input-group input[name="age"]').val();
			console.log("age: " + age) ;
			if(!isNaN(age)){
				//是数字
			}else{
				$('#label-age').html("Age is not a number! &times;").show();
			}
			if(age==''||age==null){
				$('#label-age').html("Age is empty!&times;").show();
			}
		});
		$('.input-group input[name="age"]').focus(function(event){
			var age = $('.input-group input[name="age"]').val();
			$('#label-age').hide();
			if(age===''){
				//是数字
			}else{
				$('.input-group input[name="age"]').val('');
			}
		});
		
		//email
		$('.input-group input[name="email"]').blur(function(event){
			var email = $('.input-group input[name="email"]').val();
			var x = email.indexOf("@") ;
			var y = email.indexOf(".com") ;
			if(x>0&&y>x){
				
			}else{
				$('#label-email').html("email is not validate").show();
			}
		});
		$('.input-group input[name="email"]').focus(function(event){
			var email = $('.input-group input[name="email"]').val();
			$('#label-email').hide();
			if(email!==''){
				$('.input-group input[name="email"]').val('');
			}
		});
		
		//phone
		$('.input-group input[name="phone"]').blur(function(event){
			if($('.input-group input[name="phone"]').val().length!==11){
				$('#label-phone').html("phone's length is not 11").show();
			}
		});
		$('.input-group input[name="phone"]').focus(function(event){
			$('#label-phone').hide();
			if($('.input-group input[name="phone"]').val()!==''){
				$('.input-group input[name="phone"]').val('');
			}
		});
		
		//level
		$('.input-group input[name="level"]').blur(function(event){
			var level = $('.input-group input[name="level"]').val();
			console.log(level) ;
			if(level===''){
				$('#label-level').html("level is empty!&times;").show();
			}else if(level!=="小一"&&level!=='小二'&&level!=='小三'&&level!=='小四'&&level!=='小五'&&level!=='小六'
					&&level!=='初一'&&level!=='初二'&&level!=='初三'
					&&level!=='高一'&&level!=='高二'&&level!=='高三'
					&&level!=='大一'&&level!=='大二'&&level!=='大三'&&level!=='大四'){
				$('#label-level').html("<span>&times;Please input like 小一/初一/高一/大一</span>").show();
			}else{
				
			}
		});
		$('.input-group input[name="level"]').focus(function(event){
			$('#label-level').hide();
			if($('.input-group input[name="level"]').val()!==''){
				$('.input-group input[name="level"]').val('');
			}
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		$('.form-group').on('click','input[id="regbtn"]',function(){
			var hasName = $('.input-group input[name="username"]').val();
			var ispassHd = $('#label-pass').is(':hidden') ;
			var isageHd = $('#label-age').is(':hidden') ;
			var isemailHd = $('#label-email').is(':hidden') ;
			var isphoneHd = $('#label-phone').is(':hidden') ;
			var islevelHd = $('#label-level').is(':hidden') ;
			var isRedirect = false ;
			if(hasName!=null&&hasName!=''&&ispassHd==true&&isageHd==true&&isemailHd==true&&isphoneHd==true&&islevelHd==true){
				isRedirect = true ;
			}
			if(isRedirect){
				//可跳转则填入正确的url
				$('.form-group').attr('action',"<%=basePath%>/register").submit();
			}else{
				$('.input-group input[name="password"]').focus();
			}
		});
	});
</script>
</body>
</html>