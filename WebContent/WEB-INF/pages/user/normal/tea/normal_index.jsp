<%@page import="com.jing.edu.common.util.StringUtil"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/html/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/html/common/common.css">
	
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
				<li><a href="<%=basePath %>/family/index/tea">老师部营</a></li>
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
					<span style="padding-left:20px;">性别:<span><%=((User)request.getAttribute("normalUser")).getSex() %></span></span>
				</div>
			</div>
			<div style="width:54%;float:left;margin-left: 120px;margin-top:10px;font-size: 16px;">
				<p>昵称:<span><%=((User)request.getAttribute("normalUser")).getUsername() %></span></p>
				<p>实际名字:<span id="realname"></span></p>
				<p>学历:<span><%=((User)request.getAttribute("normalUser")).getLevel() %></span></p>
				<p>学校:<span id="school"></span></p>
				<div><span>~~~~~~~</span><button  type="button" class="btn btn-default iconbtn" data-toggle="tooltip" data-placement="top" title="为其点赞,点赞之后也可取消" id="image_disable"><img alt="点赞图标" src="<%=basePath %>/images/common/icon_disable.png"></button><span>~~~~~~~</span>
					<span>已有点赞数:  <span style="font-size: 20px;font-style: oblique;" id="noticeNums"></span></span>
				</div>
				<div style="height:92px;margin-top:-7px;padding-top:32px;">
					<button class="btn btn-primary btn-danger subscribebtn" style="width: 44%;height: 65%;">立即预约</button>
					<%
							String chatbtnPath = basePath + "/user/chat/index" + "?from=" +	
																		StringUtil.encodeParam(((User)request.getSession().getAttribute("user")).getUsername(), "GBK") + "&to=" + 
																		StringUtil.encodeParam(((User)request.getAttribute("normalUser")).getUsername(), "GBK") + "&type=" + 
																		StringUtil.encodeParam("stu", "GBK");
					%>
					<a href="<%=chatbtnPath %>" target="_blank"><button class="btn btn-primary chatbtn" style="width: 44%;height: 65%;">发起聊天</button></a>
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
				<div style="height:50px;padding-top: 20px;">
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
<script type="text/javascript">
	//右侧相似老师的推荐请求
	$.ajax({
		url:"/baseweb_homeEDU/family/stutea/infos",
		type:"GET",
		data:{
			userType:"tea",
			city:'<%=request.getParameter("city")%>',
			grade:'<%=request.getParameter("grade")%>',
			subject:'<%=request.getParameter("subject")%>',
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
			String teaname = ((User)request.getAttribute("normalUser")).getUsername() ;
			String stuname = ((User)request.getSession().getAttribute("user")).getUsername() ;
			int teaType = ((User)request.getAttribute("normalUser")).getType() ;
			int stuType = ((User)request.getSession().getAttribute("user")).getType() ;
		%>
		<%
			UserDetailTea detailUser = (UserDetailTea)request.getAttribute("detailUser") ;
			if(detailUser!=null){
				
		%>
		$('#city').html("<%=(detailUser.getCity()==null?"未填写":detailUser.getCity())%>") ;
		$('#realname').html("<%=(detailUser.getRealName()==null?"未填写":detailUser.getRealName())%>") ;
		$('#school').html("<%=(detailUser.getSchool()==null?"未填写":detailUser.getSchool())%>") ;
		$('#honor').html("<%=(detailUser.getHonor()==null?"未填写":detailUser.getHonor())%>") ;
		$('#intro').html("<%=(detailUser.getIntroduction()==null?"未填写":detailUser.getIntroduction())%>") ;
		$('#sub').html("<strong style='font-size:40px;'><%=(detailUser.getSubject()==null?"未填写":detailUser.getSubject())%></strong>") ;
		$('#price').html("<strong style='font-size:20px;'><%=(detailUser.getPrice()==null?"未填写":detailUser.getPrice())%></strong>") ;
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
		<%}%>
		
		//判断是否已经预约过或者已被忽略
		$.ajax({
			url:"/baseweb_homeEDU/user/detail/record/subscribe/judge",
			data:{
				stuname:'<%=stuname%>',
				teaname:'<%=teaname%>',
				guideby:0
			},
			success:function(data){
				//已经订阅过
				if("YES"==data){
					//对该用户显示已经预约
					$('.subscribebtn').attr('disabled',true) ;
					$('.subscribebtn').attr('value','已经预约') ;
				}
			}
		});
		
		//立即预约按钮的点击事件
		$('.subscribebtn').on('click',function(){
			if(<%=stuType%>==2&&<%=teaType%>==1){
				$.ajax({
					url:"/baseweb_homeEDU/user/detail/record/subscribe/add",
					type:"GET",
					data:{
						stuname:'<%=stuname%>',
						teaname:'<%=teaname%>',
						guideby:0,
						isdelete:0
					}
				});
				//对该用户显示已经预约
				$('.subscribebtn').attr('disabled',true) ;
				$('.subscribebtn').attr('value','已经预约') ;
			}else{
				//类型相同不可进行预约与聊天
				$('.subscribebtn').attr('disabled',true) ;
				$('.chatbtn').attr('disabled',true);
			}
		}) ;
	});
</script>
<script type="text/javascript">
	$(function(){
		//点赞数请求
		$.ajax({
			url:"/baseweb_homeEDU/user/normal/notice/read",
			data:{
				username:'<%=((User)request.getAttribute("normalUser")).getUsername()%>',
				fromname:'<%=((User)request.getSession().getAttribute("user")).getUsername()%>'
			},
			success:function(data){
				var backData = JSON.parse(data) ;
				//数字显示
				$('#noticeNums').text(backData.count) ;
				//图片更改
				var imgpath = backData.isnoticed==true?"<%=basePath %>/images/common/icon_highlighted.png":"<%=basePath %>/images/common/icon_disable.png" ;
				var iconid = backData.isnoticed==true?"image_highlighted":"image_disable" ;
				$('.iconbtn img').attr('src',imgpath) ;
				$('.iconbtn').attr('id',iconid) ;
			},
			error:function(data){
				console.log(data) ;
			}
		});
		
		//处理点赞图片的点击事件	
		$('.iconbtn').click(function(){
			var iconid = $(this).attr('id') ;
			var isnotice = 0 ;
			if(iconid=='image_disable'){
				$('.iconbtn img').attr('src','<%=basePath %>/images/common/icon_highlighted.png') ;
				$(this).attr('id','image_highlighted');
				//修改显示数字
				var data = parseInt($('#noticeNums').text()) ;
				data++ ;
				$('#noticeNums').text(data) ;
				isnotice = 1 ;
			}else if(iconid=='image_highlighted'){
				$('.iconbtn img').attr('src','<%=basePath %>/images/common/icon_disable.png') ;
				$(this).attr('id','image_disable');
				
				var data = parseInt($('#noticeNums').text()) ;
				data-- ;
				$('#noticeNums').text(data) ;
				isnotice = 0 ;
			}
				//请求后台更改数据
				$.ajax({
					url:"/baseweb_homeEDU/user/normal/notice/update",
					data:{
						username:'<%=((User)request.getAttribute("normalUser")).getUsername()%>',
						fromname:'<%=((User)request.getSession().getAttribute("user")).getUsername()%>',
						type:<%=((User)request.getAttribute("normalUser")).getType()%>,
						isnotice:isnotice
					}
				});
		});
	});
</script>
</body>
</html>