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
	<title>TEA_DETAIL_INDEX</title>
	<style type="text/css">
	body{
	}
    ul.nav-tabs{
        width: 150px;
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-tabs li{
        margin: 0;
        border-top: 1px solid #ddd;
    }
    ul.nav-tabs li:first-child{
        border-top: none;
    }
    ul.nav-tabs li a{
        color:#999;
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
    }
    ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
        color: #fff;
        background: #3c763d;
        border: 1px solid #3c763d;
    }
    ul.nav-tabs li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-tabs li:last-child a{
        border-radius: 0 0 4px 4px;
    }
    
    .left-border{
    	width:200px;
    	border-right:3px solid #999;
    	height:500px;
    	padding:38px;
    	float:left;
    	background-color: snow;
    }
    .right-wrap{
    	float:left;
    	width:1000px;
    }
    .personal_content{
    	width: 117%;
    	background-image: url('/baseweb_homeEDU/images/user/detail/index/bg.jpg');
    	background-size: 100%;
    }
    .wrap-content{
    	width:1200px;
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

<div class="wrap-content">
	<div class="left-border">
		<ul class="nav nav-tabs nav-stacked">
			<li ><a href="#personal-info"><span class="glyphicon glyphicon-user"></span>个人信息</a></li>
			<li ><a href="#personal-message"><span class="glyphicon glyphicon-envelope"></span>订阅消息</a></li>
			<li ><a href="#set-info"><span class="glyphicon glyphicon-cog"></span>设置</a></li>
			<li ><a href="#recommend-info"><span class="glyphicon glyphicon-fire"></span>资源推荐</a></li>
			<li ><a href="#chat-info"><span class="glyphicon glyphicon-bell"></span>有人@<span class="badge"></span></a></li>
		</ul>
	</div>
	<div class="right-wrap">
		<div class="right-content">
			<!-- <div style="text-align: center;margin-top: 80px;">
				<h2>还没完善自己的个人信息,点击设置进一步完善或者修改吧~</h2>
				<img alt="" src="<%=basePath %>/images/user/detail/index/cry.jpg" class="">
			</div> -->
		</div>
	</div>
</div>

<div id="result_modal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" >&times;</button>
				<h4 class="modal-title" id="myModalLabel">返回信息</h4>
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
		//是否显示哭泣图片
		<%
			String hasDetail = (String)request.getAttribute("hasDetail") ;
			if("0".equals(hasDetail)){
				
		%>
		$('.right-content').html("<div style='text-align: center;margin-top: 80px;'><h2>还没完善自己的个人信息,点击设置进一步完善或者修改吧~</h2><img alt='' src='<%=basePath %>/images/user/detail/index/cry.jpg' class=''></div>");
		<%}%>
		//个人信息设置修改点击事件
		$('.left-border a[href="#set-info"]').click(function(event){
			$.ajax({
				url:"/baseweb_homeEDU/user/detail/tea/index/right/info",
				type:"GET",
				success:function(data){
					$('.right-content').addClass("personal_content");
					$('.right-content').html(data) ;
				}
			});
		});	
		
		//个人信息点击事件
		$('.left-border a[href="#personal-info"]').click(function(event){
			$.ajax({
				url:"/baseweb_homeEDU/user/detail/content/personinfoHTML",
				type:"GET",
				success:function(data){
					$('.right-content').html(data) ;
				}
			});
		<%
			Object userindex = request.getSession().getAttribute("user") ;
			Object userDetail = request.getSession().getAttribute("userDetail") ;
			if(userindex!=null&&userDetail==null){
				User normalUser =(User) userindex ;
		%>
		$('#username').html('<%=normalUser.getUsername()%>');
		$('#realname').html('未填写');
		$('#type').html('<%=normalUser.getType()%>') ;
		$('#sex').html('<%=normalUser.getSex()%>') ;
		$('#city').html('未填写') ;
		$('#school').html('未填写') ;
		$('#level').html('<%=normalUser.getLevel()%>') ;
		$('#subjects').html('未填写') ;
		$('#intro').html('未填写') ;
		$('#honor').html('未填写') ;
		<%}%>
		<%
			if(userDetail!=null&&userindex!=null){
				User normalUser =(User) userindex ;
				UserDetailTea teaDetail = (UserDetailTea)userDetail ;
		%>
		$('#username').html('<%=normalUser.getUsername()%>');
		$('#realname').html('<%=teaDetail.getRealName()%>');
		$('#type').html('<%=normalUser.getType()%>') ;
		$('#sex').html('<%=normalUser.getSex()%>') ;
		$('#city').html('<%=teaDetail.getCity()%>') ;
		$('#school').html('<%=teaDetail.getSchool()%>') ;
		$('#level').html('<%=normalUser.getLevel()%>') ;
		$('#subjects').html('<%=teaDetail.getSubject()%>') ;
		$('#intro').html('<%=teaDetail.getIntroduction()%>') ;
		$('#honor').html('<%=teaDetail.getHonor()%>') ;
		<%
			String whichFolder = null ;
			if(teaDetail.getSubject().contains("小学")){
				whichFolder = "smallsch" ;
			}else if(teaDetail.getSubject().contains("初中")){
				whichFolder = "mediumsch" ;
			}else if(teaDetail.getSubject().contains("高中")){
				whichFolder = "seniorsch" ;
			}
			
			String photoname = teaDetail.getRealName() + "_" +teaDetail.getLevel() +"_" + teaDetail.getSubject() ;
		%>
		var photoFile = "/baseweb_homeEDU/uploads/tea/" + '<%=whichFolder%>' + "/" + '<%=photoname%>' + ".jpg";
		$('img[alt="empty_person"]').attr("src",photoFile);
		
		<%}%>
		});
		
		<%
			//图片是否上传成功信息展示
			String result = (String)request.getSession().getAttribute("result") ;
			if(result!=null){
		%>
		$('.modal-body').html('<%=result%>') ;
		$('#result_modal').modal('show');
		<%
			request.getSession().removeAttribute("result") ;
		}%>
		
		<%
			User teaUser = (User)request.getSession().getAttribute("user") ;
			if(null!=teaUser){
		%>
		//消息按钮响应事件
		$('.left-border a[href="#personal-message"]').click(function(event){
			$.ajax({
				url:"/baseweb_homeEDU/user/detail/content/informMessageHTML",
				type:"GET",
				success:function(data){
					$('.right-content').html(data) ;
				}
			});
			$.ajax({
				url:"/baseweb_homeEDU/user/detail/record/inform/getmessage",
				type:"GET",
				data:{
					"userid":"<%=teaUser.getId()%>",
					"usertype":"tea"
				},
				success:function(data){
					console.log(data);
					if(data===null){
						$('.right-content').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>尚无消息数据~~</p>");
					}else{
						var stuOb = JSON.parse(data) ;
						var len = stuOb.records.length;
						var contentBody = $('#contentBody') ;
						for(var i = 0;i < len;i++){
							var stuContent = "<tr>" ;
							var oneStu = stuOb.records[i] ;
							var ignorePath = "<%=basePath%>/user/detail/record/inform/setignore?stuid=" + oneStu.id +"&teacherid="+"<%=teaUser.getId()%>"
								+"&guideby=0";
							//console.log(stuOb.records[i].username + "----" + stuOb.records[i].level);
							stuContent+="<td>" + (i+1) +"</td>"+"<td>" + oneStu.username+"</td>" +"<td>" + oneStu.age+"</td>"
							+"<td>" +oneStu.sex + "</td>" + "<td>" + oneStu.level + "</td>" + "<td>"
							+"<span><a href=''>前往</a></span>|<span><a href='"+ ignorePath + "'>忽略</a></span>" + "</td>";
							contentBody.append(stuContent);
						}
					}
				},
				error:function(data){
					console.log(data);
				}
			});
		});	
		
	//推荐按钮响应事件
	$('.left-border a[href="#recommend-info"]').click(function(event){
		$.ajax({
			url:"/baseweb_homeEDU/user/detail/content/resRecommendHTML",
			type:"GET",
			success:function(data){
				$('.right-content').html(data) ;
			}
		});
		$.ajax({
			url:"/baseweb_homeEDU/user/detail/record/recommend/getmessage",
			type:"GET",
			data:{
				"userType":"tea"
			},
			success:function(data){
				console.log(data);
				if(data===null){
					$('.right-content').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>尚无推荐数据,请完善您的详细资料~~</p>");
				}else{
					var stuOb = JSON.parse(data) ;
					var len = stuOb.recommRecords.length;
					var contentBody = $('#contentBody') ;
					contentBody.html('');
					for(var i = 0;i < len;i++){
						var onestu = stuOb.recommRecords[i] ;
						var username = onestu.username ;
						var price = onestu.price ;
						var level = onestu.level ;
						var content = "<div style='height:100px;padding:50px 0 10px 30px'><span style='margin-right:10px;'>昵称:" +username+"</span><span style='margin-right:10px;'>报价: " + price + "</span><span style='margin-right:10px;'>学历: " + level + "</span><span style='margin-right:10px;'><a href='#'>Read More</a></span></div>" ;
						var underline = "<div style='border: solid 1px #007;margin:20px auto 2px auto;width:90%;'></div>" ;
						contentBody.append(content) ;
						contentBody.append(underline) ;
					}
					var changebt = "<div style='float:right;margin-bottom: 2px;font-size: 15px;height:100px' class='changebt'><a href='#'><span class='glyphicon glyphicon-repeat'></span>换一换</a></div>" ;
					contentBody.append(changebt) ;
				}
			},
			error:function(data){
				console.log(data);
			}
		});
	});
	<%}%>
});
</script>
<script type="text/javascript">
	$(function(){
		$('.changebt').on('click','a',function(event){
			$.ajax({
				url:"/baseweb_homeEDU/user/detail/record/recommend/getmessage",
				type:"GET",
				data:{
					"userType":"tea"
				},
				success:function(data){
					console.log(data);
					if(data===null){
						$('.right-content').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>尚无推荐数据,请完善您的详细资料~~</p>");
					}else{
						var stuOb = JSON.parse(data) ;
						var len = stuOb.recommRecords.length;
						var contentBody = $('#contentBody') ;
						contentBody.html('');
						for(var i = 0;i < len;i++){
							var onestu = stuOb.recommRecords[i] ;
							var username = onestu.username ;
							var price = onestu.price ;
							var level = onestu.level ;
							var content = "<div style='height:100px;padding:50px 0 10px 30px'><span style='margin-right:10px;'>昵称:" +username+"</span><span style='margin-right:10px;'>报价: " + price + "</span><span style='margin-right:10px;'>学历: " + level + "</span><span style='margin-right:10px;'><a href='#'>Read More</a></span></div>" ;
							var underline = "<div style='border: solid 1px #007;margin:20px auto 2px auto;width:90%;'></div>" ;
							contentBody.append(content) ;
							contentBody.append(underline) ;
						}
						var changebt = "<div style='float:right;margin-bottom: 2px;font-size: 15px;height:100px' class='changebt'><a href='#'><span class='glyphicon glyphicon-repeat'></span>换一换</a></div>" ;
						contentBody.append(changebt) ;
					}
				},
				error:function(data){
					console.log(data);
				}
			});
		});
	});
</script>
<script type="text/javascript" src="<%=basePath %>/html/goeasy/goeasy.js"></script>
<script type="text/javascript">
	//goeasy事件js
	var goEasy = new GoEasy({
		appkey:"04f5a023-63f6-477a-a933-a6dfa264fdda"
	});
	var messageAcceptNums = 0 ;
	var messageCon = new Array();
	
	goEasy.subscribe({
		channel:"channel_chat_jingtj" ,
		onMessage:function(result){
			//alert(result.content);
			messageCon[messageAcceptNums] = result.content;
			messageAcceptNums++ ;
			$('.badge').text(messageAcceptNums);
		}
	});
	
	//有人@按钮的点击事件
	$('.left-border a[href="#chat-info"]').click(function(event){
		//聊天消息数目置为0并删除相应的badges数目
		messageAcceptNums = 0 ;
		for(var i = 0 ; i < messageCon.length;i++){
			var rightContent = "" ;
			var text = JSON.parse(messageCon[i]);
			var words = text.content ;
			//来源者
			var from = text.username ;
			//接受者
			var to = text.toName ;
			rightContent+="<div>名为:<span class='font-size:20px;'> " + from 
											+ "</span>的拜访者给您发送了如下消息: <span style='font-style:oblique;font-size:18px;'>" 
											+words + "</span>"
											+"<span style='padding-left:10px;'><a href='javascript:void(0)' class='reply'>点击回复</a></span></div>";
			$('.right-content').append(rightContent) ;
			//
			$('.reply').attr('href','<%=basePath%>/user/chat/index?from=' + to + "&to=" + from + "&type=tea") ;
			$('.reply').removeClass('reply');
		}
		messageCon.length = 0 ;
		
	});	
</script>
</body>
</html>