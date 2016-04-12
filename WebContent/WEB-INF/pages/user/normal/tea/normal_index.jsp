<%@page import="com.jing.edu.util.StringUtil"%>
<%@page import="com.jing.edu.model.UserDetailTea"%>
<%@page import="com.jing.edu.model.User"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/common/common.css">
	
<title>USER_normal</title>
<style type="text/css">
	.underline{
        	border: solid 1px #007;
        	margin:20px auto 2px auto;
        	width:100%;
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
				<li><a href="#">老师部营</a></li>
				<li><a href="#">|</a></li>
				<li><a href="#">学生部营</a></li>
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
<div class="container">
<div style="position:relative;">
	<div style="width:1000px;position:absolute;left:0;width:900px;border-right:solid 1px #eee;">
		<div style="height: 250px;margin-top: 10px;">
			<div style="width:24%;float: left;text-align: center;">
				<div style="height: 220px;">
				<% 
					String name = ((User)request.getAttribute("normalUser")).getUsername() ;
					String path = basePath + "/family/tea/photo?imgid=" +name ;
				%>
					<img alt="未上传图片" src="<%=path%>">
				</div>
				<div>
					<span>城市:<span id="city"></span></span>
					<span>性别:<span><%=((User)request.getAttribute("normalUser")).getSex() %></span></span>
				</div>
			</div>
			<div style="width:54%;float:left;margin-left: 120px;margin-top:10px;font-size: 16px;">
				<p>昵称:<span><%=((User)request.getAttribute("normalUser")).getUsername() %></span></p>
				<p>实际名字:<span id="realname"></span></p>
				<p>学历:<span><%=((User)request.getAttribute("normalUser")).getLevel() %></span></p>
				<p>学校:<span id="school"></span></p>
				<div style="height:92px;margin-top:50px;padding-top:32px;">
					<button class="btn btn-primary btn-danger subscribebtn" style="width: 44%;height: 65%;">立即预约</button>
					<%
							String chatbtnPath = basePath + "/user/chat/index" + "?from=" +	
																		StringUtil.encodeParam(((User)request.getSession().getAttribute("user")).getUsername(), "GBK") + "&to=" + 
																		StringUtil.encodeParam(((User)request.getAttribute("normalUser")).getUsername(), "GBK") + "&type=" + 
																		StringUtil.encodeParam("tea", "GBK");
					%>
					<a href="<%=chatbtnPath %>"><button class="btn btn-primary chatbtn" style="width: 44%;height: 65%;">发起聊天</button></a>
			</div>
			</div>
		</div>
		<p class="underline"></p>
		<div style="height: 200px;">
			<div style="width: 100px;height: 35px;">
				<div style="float: left;width:100px;padding-top: 10px;">
					<p class="glyphicon glyphicon-flag"></p>所获荣誉
				</div>
			</div>
			<div id="honor" style="padding-left: 80px;"></div>
		</div>
		<p class="underline"></p>
		<div style="height:200px;">
			<div style="width: 100px;height: 35px;">
				<div style="float: left;width:100px;padding-top: 10px;">
					<p class="glyphicon glyphicon-flag"></p>个人简介
				</div>
			</div>
			<div id="intro" style="padding-left: 80px;"></div>
		</div>
		<p class="underline"></p>
		<div style="height:150px;">
			<div style="height: 100px;padding:20px;">
				<div style="height:50px;">
					<span>辅导课程:<span id="sub"></span></span>
				</div>
				<div style="height:50px;">
					<span>课程报价:<span id="price"></span></span>
				</div>
			</div>
		</div>
		<p class="underline"></p>
	</div>
	<div style="width:200px;position:absolute;right:0;">
		<div style="position:absolute;top:40px;left:-35px;">
			<p style="font-weight:600">其他相似老师</p>
			<div class="similarTeas" style="margin-left:20px;"></div>
		</div>
		
	</div>
</div>
</div>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/bootstrap.min.js"></script>
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
		index_text1.val(<%=user.getUsername()%>);
		index_text1.attr("href","<%=basePath%>/user/detail/tea/index") ;
		//退出返回到登录界面
		index_text2.val('退出');
		index_text2.attr("href","<%=basePath%>/login/out");
		<%
			}
		%>
});
</script>
<script type="text/javascript">
	//右侧相似老师的推荐请求
	$.ajax({
		url:"/baseweb_homeEDU/family/stutea/infos",
		type:"GET",
		data:{
			userType:"tea",
			page:"1"
		},
		success:function(data){
			var teaOb = JSON.parse(data) ;
			//得到查询资源的条目数
			var teaLen = teaOb.size;
			if(teaLen==0){
				$('.similarTeas').html('尚无推荐') ;
			}else{
				var disableName = "<%=name%>" ;
				console.log(disableName) ;
				for(var j = 0; j <teaLen;j++){
					var oneTea = teaOb.familys[j] ;
					var name = oneTea.name ;
					if(name!=disableName){
					var level = oneTea.level ;
					var str = "<a href='<%=basePath%>/user/normal/tea/index?name="+ oneTea.name + "'><p>" + "<lable>" + name + "</label></a>" + "<lable style='margin-left:10px;'>" + level + "</label>"+ "</p>" ;
					$('.similarTeas').append(str) ;
						
					}
				}
			}
		}
	});
</script>
<script type="text/javascript">
	$(function(){
		<%
			int teacherid = ((User)request.getAttribute("normalUser")).getId() ;
			int stuid = ((User)request.getSession().getAttribute("user")).getId() ;
			int teaType = ((User)request.getAttribute("normalUser")).getType() ;
			int stuType = ((User)request.getSession().getAttribute("user")).getType() ;
		%>
		<%
			UserDetailTea detailUser = (UserDetailTea)request.getAttribute("detailUser") ;
			if(detailUser!=null){
				
		%>
		$('#city').html("<%=(detailUser.getCity())%>") ;
		$('#realname').html("<%=detailUser.getRealName()%>") ;
		$('#school').html("<%=detailUser.getSchool()%>") ;
		$('#honor').html("<%=detailUser.getHonor()%>") ;
		$('#intro').html("<%=detailUser.getIntroduction()%>") ;
		$('#sub').html("<strong style='font-size:40px;'><%=detailUser.getSubject()%></strong>") ;
		$('#price').html("<strong style='font-size:40px;'><%=detailUser.getPrice()%></strong>") ;
			<%
					int isOnline = detailUser.getIsonline() ;
			%>
		$('.chatbtn').attr('disabled',<%=isOnline%>==0?true:false) ;
		<%}%>
		<%
			if(detailUser==null){
		%>
		$('#city').html("未填写") ;
		$('#realname').html("未填写") ;
		$('#school').html("未填写") ;
		$('#honor').html("未填写") ;
		$('#intro').html("未填写") ;
		$('#sub').html("未填写") ;
		$('#price').html("未填写") ;
		$('.chatbtn').attr('disabled',true) ;
		<%}%>
		
		//立即预约按钮的点击事件
		$('.subscribebtn').on('click',function(){
			if(<%=stuType%>==2&&<%=teaType%>==1){
				$.ajax({
					url:"/baseweb_homeEDU/user/detail/record/addSubcribe",
					type:"GET",
					data:{
						stuid:<%=stuid%>,
						teacherid:<%=teacherid%>,
						guideby:0,
						isdelete:0
					}
				});
				//对该用户显示已经预约
				$('.subscribebtn').attr('disabled',true) ;
				$('.subscribebtn').attr('value','已经预约') ;
			}else{
				//相同类型的不可进行预约
				$('.subscribebtn').attr('disabled',true) ;
			}
		}) ;
	});
</script>
</body>
</html>