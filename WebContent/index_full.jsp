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
	<title>HOME_EDU INDEX</title>
	<style type="text/css">
		.carousel{
        	height:487px;
        	/*margin-bottom: 50px;**/
        }

        .carousel .item {
            height: 487px;
            background-color: #fff;
        }

        .carousel .item img {
        	height:100%;
            width: 100%;
        }
        
        .underline{
        	border: solid 1px #007;
        	margin:20px auto 2px auto;
        	width:90%;
        	
        }
        
        .sourcedoor{
        	text-align: center;
        	margin-bottom: 20px;
        }
        
        .infowrap{
        	text-align: center ;
        	padding-top:10px;
        	padding-left: 15px;
        	padding-bottom:10px;
        }
        
        .infoborder{
        	background-color:#ddd;
        	border:1px solid #5bc0de;
        }
        
        .infoborder:HOVER {
        	border:1px solid #000;
			background-color: #ccc;
		}
		
		.change-logo{
			float:right;
			margin-bottom: 2px;
			font-size: 15px;
		}
		
		.change-logo .logo-text{
			font-size: 15px;
		}
		
		.change-logo a:HOVER {
			text-decoration: none;
		}
		.stu_request_title{
			font-size: 15px;
		}
		.stu-more{
			float: right;
			font-size: 15px;
		}
		
		.stu-more a:HOVER {
			text-decoration: none;
		}
		
		.stuheader{
			margin-top: 17px;
		}
		
		.wordgood{
			text-align: center;
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

<div class="carousel slide" data-ride="carousel" id="ad-carousel">
	<ol class="carousel-indicators">
        <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
        <li data-target="#ad-carousel" data-slide-to="1"></li>
        <li data-target="#ad-carousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
    	<div class="item active">
    		<img src="<%=basePath%>/images/index/index_carousel_1.jpg" alt="1 slide">
    	</div>
    	<div class="item">
    		<img src="<%=basePath%>/images/index/index_carousel_2.jpg" alt="2 slide">
    	</div>
    	<div class="item">
    		<img src="<%=basePath%>/images/index/index_carousel_3.jpg" alt="3 slide">
    	</div>
    </div>
    <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
            class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
            class="glyphicon glyphicon-chevron-right"></span></a>
</div>

<p class="underline" />
<div class="container">
	<div class="row sourcedoor">
		<div class="col-md-6">
			<img alt="tea-logo" src="<%=basePath%>/images/index/tea_logo.jpg">
			<h2>教师入口点</h2>
			<p>单击下列按钮进入教师部营查看更多的教师资源</p>
			<a class="btn btn-lg btn-primary" href="<%=basePath %>/family/index/tea">Read More</a>
		</div>
		<div class="col-md-6">
			<img alt="stu-logo" src="<%=basePath%>/images/index/stu_logo.jpg">
			<h2>学生入口点</h2>
			<p>单击下列按钮进入学生部营查看更多的学生资源</p>
			<a class="btn btn-lg btn-primary" href="<%=basePath %>/family/index/stu">Read More</a>
		</div>
	</div>	
</div>
<p class="underline" />
<div class="container">
<!-- 老师风采展览 -->
	<!-- tab导航 -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-smallsch" data-toggle="tab">小学家教</a></li>
		<li><a href="#tab-mediumsch" data-toggle="tab">初中家教</a></li>
		<li><a href="#tab-seniorsch" data-toggle="tab">高中家教</a></li>
	</ul>
	<div class="tab-content teacontent">
		<div class="tab-pane active" id="tab-smallsch">
			<div class="row infowrap">
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/smallsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/smallsch/realname2_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname2</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/smallsch/realname3_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname3</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/smallsch/realname4_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname4</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
			</div>
			<span class="change-logo">
				<!-- 点击一次使图片资源再次请求一次 -->
				<a href="">
					<span class="glyphicon glyphicon-user"></span>
					<span class="logo-text">查看更多>></span>
				</a>
			</span>
		</div>
		<div class="tab-pane" id="tab-mediumsch">
			<div class="row infowrap">
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/mediumsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/mediumsch/realname2_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname2</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/mediumsch/realname3_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname3</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/mediumsch/realname4_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname4</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
			</div>
			<span class="change-logo">
				<!-- 点击一次使图片资源再次请求一次 -->
				<a href="">
					<span class="glyphicon glyphicon-user"></span>
					<span class="logo-text">查看更多>></span>
				</a>
			</span>
		</div>
		<div class="tab-pane" id="tab-seniorsch">
			<div class="row infowrap">
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/seniorsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/seniorsch/realname2_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname2</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/seniorsch/realname3_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname3</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/tea/seniorsch/realname4_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname4</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
			</div>
			<span class="change-logo">
				<!-- 点击一次使图片资源再次请求一次 -->
				<a href="">
					<span class="glyphicon glyphicon-user"></span>
					<span class="logo-text">查看更多>></span>
				</a>
			</span>
		</div>
	</div>
</div>
<p class="underline" />
<div class="container stucontent">
	<div class="stuheader">
		<span class="stu_request_title">学员请求</span><span class="stu-more"><a href=""><span class="glyphicon glyphicon-user"></span>查看更多>></a></span>
	</div>
	<div class="row infowrap">
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/stu/smallsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/stu/mediumsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/stu/seniorsch/realname1_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname1</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
				<div class="col-md-3 infoborder">
					<a href=""><img alt="" src="<%=basePath%>/upload_photos/stu/seniorsch/realname2_level_subjects.jpg" class="img-rounded"></a>
					<p>姓名:realname2</p>
					<p>学历:level</p>
					<p>授课内容:subjects </p>
				</div>
		</div>
</div>
<p class="underline" />
<div class="wordgood">
	<h3>Welcome To homeEDU! Be Happy!Be Useful!-------<span class="glyphicon glyphicon-send"></span>DogIfRich<span class="glyphicon glyphicon-send"></span></h3>
</div>
<div class="footer">
	<div class="bottom">Copyright &copy; 2015 by JingSir,All Right Reserved</div>
</div>

<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		//设置滚动图的速度
		$('#ad-carousel').carousel({
			interval:4000
		});
	});
</script>
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