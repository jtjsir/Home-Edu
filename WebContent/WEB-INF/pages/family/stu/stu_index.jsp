<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<title>学生部营主页</title>
	<style type="text/css">
		.searchframe{
			width: 500px;
    		margin: 0 auto;
    		padding: 20px;
    		height: 57px;
		}
		.underline{
        	border: solid 1px #007;
        	margin:20px auto 2px auto;
        	width:90%;
        }
        .keyword_search{
        	height: 200px;
        	width:800px;
        }
        .keyword_search .theme{
        	height: 50px;
        }
        .keyword_search .theme .title{
        	float: left;
        	width:200px;
        	text-align: center;
        	padding-top: 20px;
   			padding-bottom: 9px;
   			color: mediumseagreen;
    		font-size: 15px;
        }
        .keyword_search .theme .content{
        	float: left;
        	width:600px;
        	padding-top: 20px;
        }
        .keyword_search .theme .content .city{
        	margin-right:15px;
        }
        .keyword_search .theme .content .grade{
        	margin-right:15px;
        }
        .keyword_search .theme .content .subject{
        	margin-right:15px;
        }
        .wrap_content{
        	height: 300px;
        }
         .wrap_content .infowrap{
        	text-align: center ;
        	padding-top:10px;
        	padding-left: 15px;
        	padding-bottom:10px;
        }
        .wrap_content .infoborder{
        	background-color:#ddd;
        	border:1px solid #5bc0de;
        }
        .wrap_content .infoborder:HOVER {
        	border:1px solid #000;
			background-color: #ccc;
		}
        .pagebtn{
        	height: 200px;
        	width:500px;
        	margin:0 auto;
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
<div class="container">
	<div class="underline"></div>
	<div class="searchframe">
		<div style="float:left;width: 390px;">
			<input type="text" placeholder="输入搜索的科目,比如:小学/小学语文" class="form-control">
		</div>
		<div style="float:left;padding-top: 2px;">
			<button class="btn btn-default btn-danger" id="searchBt"><span class="glyphicon glyphicon-search"></span></button>
		</div>
	</div>
	<div class="underline"></div>
	<div class="keyword_search">
		<div class="theme">
			<div class="title">
				<span>省份</span>
			</div>
			<div class="content">
				<span>浙江</span>
			</div>
		</div>
		<div class="theme">
			<div class="title">
				<span>市级</span>
			</div>
			<div class="content">
				<span class="city"><a class="active" id="hangzhou">杭州市</a></span>
				<span class="city"><a id="ningbo">宁波市</a></span>
				<span class="city"><a id="wenzhou">温州市</a></span>
				<span class="city"><a id="jiaxing">嘉兴市</a></span>
				<span class="city"><a id="huzhou">湖州市</a></span>
				<span class="city"><a id="shaoxing">绍兴市</a></span>
				<span class="city"><a id="jinhua">金华市</a></span>
				<span class="city"><a id="quzhou">衢州市</a></span>
				<span class="city"><a id="zhoushan">舟山市</a></span>
				<span class="city"><a id="taizhou">台州市</a></span>
				<span class="city"><a id="lishui">丽水市</a></span>
			</div>
		</div>
		<div class="theme">
			<div class="title">
				<span>年级</span>
			</div>
			<div class="content">
				<span class="grade"><a class="active" id="xiaoxue">小学</a></span>
				<span class="grade"><a id="chuzhong">初中</a></span>
				<span class="grade"><a id="gaozhong">高中</a></span>
			</div>
		</div>
		<div class="theme">
			<div class="title">
				<span>科目</span>
			</div>
			<div class="content">
				<div class="subjectcontent">
					<span class="subject"><a class="active" id="yuwen">语文</a></span>
					<span class="subject"><a id="shuxue">数学</a></span>
					<span class="subject"><a id="yingyu">英语</a></span>
				</div>
			</div>
		</div>
	</div>
	<div class="underline"></div>
	<div class="sort_wrap">
		<div class="sort_menu" style="height:20px;">
  			<span style="margin-left: 86px;" id="sort_price"><a href="javascript:void(0)" style="text-decoration:none;">价格<span class="caret"></span></a></span>
  			<span style="margin-left: 20px;">|</span>
  			<span style="margin-left: 30px; " id="sort_notice"><a href="javascript:void(0)" style="text-decoration:none;">关注<span class="caret"></span></a></span>
  			<span style="margin-left: 20px;">|</span>
  			<span style="margin-left: 30px;" id="sort_age"><a href="javascript:void(0)" style="text-decoration:none;">年龄<span class="caret"></span></a></span>
  			<span style="margin-left: 20px;">|</span>
		</div>
		<!-- underline -->
		<div style="border: solid 1px #795548; margin: 10px auto 2px auto;width: 90%;"></div>
	</div>
	<div class="wrap_content">
		<div class="row infowrap"></div>
	</div>
	<div class="underline"></div>
	<div class="pagebtn">
		<div>
			<ul class="pagination">
				<li><a href="#"><<</a></li>
				<li><a href="#">>></a></li>
			</ul>
		</div>
	</div>
	<div class="underline"></div>
</div>
<div class="footer">
	<div class="bottom">Copyright &copy; 2015 by JingSir,All Right Reserved</div>
</div>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//第一次访问首先请求后台图片数据
	$(function(){
		$.ajax({
			url:"<%=basePath %>/family/stutea/infos",
			type:"GET",
			data:{
				userType:"stu",
				page:"1"
			},
			success:function(data){
				var stuOb = JSON.parse(data) ;
				//得到查询资源的条目数
				var stuLen = stuOb.size;
				if(stuLen===0){
					$('.sort_wrap').attr('hidden',true);
					$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
					$('.pagebtn').html("<ul class='pagination'><li><a href='javascript:void(0)'><<</a></li><li><a href='javascript:void(0)'>>></a></li></ul>");
				}else{
					$('.sort_wrap').attr('hidden',false);
					$('.wrap_content .infowrap').html('');
					var pageLen = Math.ceil(stuOb.count/4);
					if(stuLen>=4){
						stuLen = 4 ;
					}
					for(var i = 0;i < stuLen;i++){
						var str = "<div class='col-md-3 infoborder'>";
						var onestu = stuOb.familys[i] ;
						str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
						+ "<p>姓名:"+ onestu.realname + "</p>"
						+ "<p>学历:"+ onestu.level + "</p>"
						+ "<p>授课内容:"+ onestu.subjects + "</p>"
						;
						str+="</div>" ;
						$('.wrap_content .infowrap').append(str) ;
					}
					//生成page标签页
					var pageStr = "<ul class='pagination normalpage'><li><a id='page_1'><<</a></li>" ;
					for(var j= 0 ; j < pageLen ; j++){
						pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
					}
					pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
					console.log(pageStr);
					$('.pagebtn').html('');
					$('.pagebtn').append(pageStr) ;
				}
			}
		});
	});
</script>
<script type="text/javascript">
	//共有的js代码
	$(function(){
		<%
			User user = (User)request.getSession().getAttribute("user") ;
			if(user!=null){
				String type = user.getType()==1?"tea":"stu" ;
				String href = basePath + "/user/detail/" +type + "/index" ;
		%>
		//判断是否有用户已经登录
		var index_text1 = $('.navbar-right a[name="text1"]') ;
		var index_text2 = $('.navbar-right a[name="text2"]') ;
		
		index_text1.text('<%=user.getUsername()%>');
		index_text1.attr("href","<%=href%>") ;
		//退出返回到登录界面
		index_text2.text('退出');
		index_text2.attr("href","<%=basePath%>/login/out");
		<%
			}
		%>
});
</script>
<script type="text/javascript">
	$(function(){
		var contentDiv = $('.wrap_content .infowrap');
		
		//城市
		$('.keyword_search .theme .content .city a').click(function(event){
			var city= $(this).text() ;
			$.ajax({
				url:"<%=basePath %>/family/stutea/infos",
				type:"GET",
				data:{
					city:city,
					userType:"stu",
					page:"1"
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						contentDiv.html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						contentDiv.html('');
						var pageLen = Math.ceil((stuOb.count-1) / 4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var oneStu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ oneStu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+oneStu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ oneStu.realname + "</p>"
							+ "<p>学历:"+ oneStu.level + "</p>"
							+ "<p>授课内容:"+ oneStu.subjects + "</p>"
							;
							str+="</div>" ;
							contentDiv.append(str) ;
						}
						//生成page标签页
						var pageStr = "<ul class='pagination normalpage'><li><a id='page_1'><<</a></li>" ;
						for(var j= 0 ; j < pageLen ; j++){
							pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
						}
						pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
						console.log(pageStr);
						$('.pagebtn').html('');
						$('.pagebtn').append(pageStr) ;
					}
				}
			});
		});
		
		//年级
		$('.keyword_search .theme .content .grade a').click(function(event){
			var grade= $(this).text()  ; 
			//通过ajax请求得到相应的数据内容
			$.ajax({
				url:"<%=basePath %>/family/content/getsubject",
				type:"GET",
				data:{
					grade:grade
				},
				success:function(data){
					$('.keyword_search .theme .content .subjectcontent').html(data);
				}
			});
			$.ajax({
				url:"<%=basePath %>/family/stutea/infos",
				type:"GET",
				data:{
					grade:grade,
					userType:"stu",
					page:"1"
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						contentDiv.html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						contentDiv.html('');
						var pageLen = Math.ceil((stuOb.count-1) / 4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var oneStu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ oneStu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+oneStu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ oneStu.realname + "</p>"
							+ "<p>学历:"+ oneStu.level + "</p>"
							+ "<p>授课内容:"+ oneStu.subjects + "</p>"
							;
							str+="</div>" ;
							contentDiv.append(str) ;
						}
						
						//生成page标签页
						var pageStr = "<ul class='pagination normalpage'><li><a id='page_1'><<</a></li>" ;
						for(var j= 0 ; j < pageLen ; j++){
							pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
						}
						pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
						console.log(pageStr);
						$('.pagebtn').html('');
						$('.pagebtn').append(pageStr) ;
					}
				}
			});
		});
		
		//科目
		$('.keyword_search .theme .content .subjectcontent').on('click','.subject a',function(event){
			var subject= $(this).text()  ;
			console.log(subject) ;
			$.ajax({
				url:"<%=basePath %>/family/stutea/infos",
				type:"GET",
				data:{
					subject:subject,
					userType:"stu",
					page:"1"
				},
				success:function(data){
						console.log(data) ;
						var stuOb = JSON.parse(data) ;
						//得到查询资源的条目数
						var stuLen = stuOb.size;
						if(stuLen===0){
							$('.sort_wrap').attr('hidden',true);
							contentDiv.html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
							$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
						}else{
							$('.sort_wrap').attr('hidden',false);
							contentDiv.html('');
							var pageLen = Math.ceil(stuOb.count/4);
							if(stuLen>=4){
								stuLen = 4 ;
							}
							for(var i = 0;i < stuLen;i++){
								var str = "<div class='col-md-3 infoborder'>";
								var onestu = stuOb.familys[i] ;
								str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
								+ "<p>姓名:"+ onestu.realname + "</p>"
								+ "<p>学历:"+ onestu.level + "</p>"
								+ "<p>授课内容:"+ onestu.subjects + "</p>"
								;
								str+="</div>" ;
								contentDiv.append(str) ;
							}
							//生成page标签页
							var pageStr = "<ul class='pagination normalpage'><li><a id='page_1'><<</a></li>" ;
							for(var j= 0 ; j < pageLen ; j++){
								pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
							}
							pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
							console.log(pageStr);
							$('.pagebtn').html('');
							$('.pagebtn').append(pageStr) ;
						}
					}
			});
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		//搜索框的点击事件
		$('.searchframe #searchBt').click(function(e){
			var content = $('.searchframe input').val();
			if(content===null||content===''){
				console.log('没有输入任何搜索信息') ;
			}else{
				$.ajax({
					url:"<%=basePath %>/family/all/stutea/infos",
					data:{
						content:content,
						userType:"stu",
						page:"1"
					},
					type:"GET",
					success:function(data){
						var stuOb = JSON.parse(data) ;
						//得到查询资源的条目数
						var stuLen = stuOb.size;
						if(stuLen===0){
							$('.sort_wrap').attr('hidden',true);
							$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
							$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
						}else{
							$('.sort_wrap').attr('hidden',false);
							$('.wrap_content .infowrap').html('');
							var pageLen = Math.ceil(stuOb.count/4);
							if(stuLen>=4){
								stuLen = 4 ;
							}
							for(var i = 0;i < stuLen;i++){
								var str = "<div class='col-md-3 infoborder'>";
								var onestu = stuOb.familys[i] ;
								str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
								+ "<p>姓名:"+ onestu.realname + "</p>"
								+ "<p>学历:"+ onestu.level + "</p>"
								+ "<p>授课内容:"+ onestu.subjects + "</p>"
								;
								str+="</div>" ;
								$('.wrap_content .infowrap').append(str) ;
							}
							
							//生成page标签页
							var pageStr = "<ul class='pagination normalpage'><li><a id='page_1'><<</a></li>" ;
							for(var j= 0 ; j < pageLen ; j++){
								pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
							}
							pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
							console.log(pageStr);
							$('.pagebtn').html('');
							$('.pagebtn').append(pageStr) ;
						}	
					}
				});
			}
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		//普通page标签按钮点击事件		
		$(document).on('click','.pagebtn .normalpage a',function(event){
			var id = $(this).attr('id') ;
			var page = id.substring(id.indexOf('_') + 1,id.length) ;
			$.ajax({
				url:"<%=basePath %>/family/stutea/infos",
				type:"GET",
				data:{
					userType:"stu",
					page:page
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='javascript:void(0)'><<</a></li><li><a href='javascript:void(0)'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						$('.wrap_content .infowrap').html('');
						var pageLen = Math.ceil(stuOb.count/4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var onestu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ onestu.realname + "</p>"
							+ "<p>学历:"+ onestu.level + "</p>"
							+ "<p>授课内容:"+ onestu.subjects + "</p>"
							;
							str+="</div>" ;
							$('.wrap_content .infowrap').append(str) ;
						}
					}
				}
			});
		});
		
		//sortpage标签按钮点击事件
		$(document).on('click','.pagebtn .sortpage a',function(event){
			//获取sort_type和order
			var sort_type_order = $('.pagebtn .sortpage').attr('id') ;
			var sort_type = sort_type_order.substring(0,sort_type_order.lastIndexOf('_'));
			var order = sort_type_order.substring(sort_type_order.lastIndexOf('_') + 1,sort_type_order.length);
			//获取page值
			var id = $(this).attr('id') ;
			var page = id.substring(id.indexOf('_') + 1,id.length) ;
			
			$.ajax({
				url:"<%=basePath %>/family/stutea/sort",
				type:"GET",
				data:{
					userType:"stu",
					page:page,
					sort_type:sort_type,
					order:order
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='javascript:void(0)'><<</a></li><li><a href='javascript:void(0)'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						$('.wrap_content .infowrap').html('');
						var pageLen = Math.ceil(stuOb.count/4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var onestu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ onestu.realname + "</p>"
							+ "<p>学历:"+ onestu.level + "</p>"
							+ "<p>授课内容:"+ onestu.subjects + "</p>"
							;
							str+="</div>" ;
							$('.wrap_content .infowrap').append(str) ;
						}
					}
				}
			});
		});
	});
</script>

<script type="text/javascript">
	//sort_type响应
	$(function(){
		//price排序
		$('.sort_menu #sort_price').on('click','a',function(){
			//升序
			var order = 0 ;
			var classAttr = $('.sort_menu #sort_price').attr('class') ;
			if(null==classAttr||""==classAttr||"undefined"==classAttr){
				order = 1 ;
				$('.sort_menu #sort_price').addClass('dropup');
			}else{
				$('.sort_menu #sort_price').removeClass('dropup');
			}
			$.ajax({
				url:"<%=basePath %>/family/stutea/sort",
				type:"GET",
				data:{
					userType:"stu",
					page:"1",
					sort_type:"sort_price",
					order:order
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						$('.wrap_content .infowrap').html('');
						var pageLen = Math.ceil(stuOb.count/4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var onestu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ onestu.realname + "</p>"
							+ "<p>学历:"+ onestu.level + "</p>"
							+ "<p>授课内容:"+ onestu.subjects + "</p>"
							;
							str+="</div>" ;
							$('.wrap_content .infowrap').append(str) ;
						}
						//生成page标签页
						var pageStr = "<ul class='pagination sortpage' id='sort_price_" + order + "'><li><a id='page_1'><<</a></li>" ;
						for(var j= 0 ; j < pageLen ; j++){
							pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
						}
						pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
						console.log(pageStr);
						$('.pagebtn').html('');
						$('.pagebtn').append(pageStr) ;
					}
				}
			});
		});
		//age排序
		$('.sort_menu #sort_age').on('click','a',function(){
			//升序
			var order = 0 ;
			var classAttr = $('.sort_menu #sort_age').attr('class') ;
			if(null==classAttr||""==classAttr||"undefined"==classAttr){
				order = 1 ;
				$('.sort_menu #sort_age').addClass('dropup');
			}else{
				$('.sort_menu #sort_age').removeClass('dropup');
			}
			$.ajax({
				url:"<%=basePath %>/family/stutea/sort",
				type:"GET",
				data:{
					userType:"stu",
					page:"1",
					sort_type:"sort_age",
					order:order
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_wrap').attr('hidden',true);
						$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						$('.wrap_content .infowrap').html('');
						var pageLen = Math.ceil(stuOb.count/4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var onestu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ onestu.realname + "</p>"
							+ "<p>学历:"+ onestu.level + "</p>"
							+ "<p>授课内容:"+ onestu.subjects + "</p>"
							;
							str+="</div>" ;
							$('.wrap_content .infowrap').append(str) ;
						}
						//生成page标签页
						var pageStr = "<ul class='pagination sortpage' id='sort_age_" + order + "'><li><a id='page_1'><<</a></li>" ;
						for(var j= 0 ; j < pageLen ; j++){
							pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
						}
						pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
						console.log(pageStr);
						$('.pagebtn').html('');
						$('.pagebtn').append(pageStr) ;
					}
				}
			});
		});
		//notice排序
		$('.sort_menu #sort_notice').on('click','a',function(){
			//升序
			var order = 0 ;
			var classAttr = $('.sort_menu #sort_notice').attr('class') ;
			if(null==classAttr||""==classAttr||"undefined"==classAttr){
				order = 1 ;
				$('.sort_menu #sort_notice').addClass('dropup');
			}else{
				$('.sort_menu #sort_notice').removeClass('dropup');
			}
			$.ajax({
				url:"<%=basePath %>/family/stutea/sort",
				type:"GET",
				data:{
					userType:"stu",
					page:"1",
					sort_type:"sort_notice",
					order:order
				},
				success:function(data){
					var stuOb = JSON.parse(data) ;
					//得到查询资源的条目数
					var stuLen = stuOb.size;
					if(stuLen===0){
						$('.sort_menu').attr('hidden',true);
						$('.wrap_content .infowrap').html("<p style='text-align: center;margin-top: 80px;font-size:24px;'>搜索的资源还未出现~~</p>");
						$('.pagebtn').html("<ul class='pagination'><li><a href='#'><<</a></li><li><a href='#'>>></a></li></ul>");
					}else{
						$('.sort_wrap').attr('hidden',false);
						$('.wrap_content .infowrap').html('');
						var pageLen = Math.ceil(stuOb.count/4);
						if(stuLen>=4){
							stuLen = 4 ;
						}
						for(var i = 0;i < stuLen;i++){
							var str = "<div class='col-md-3 infoborder'>";
							var onestu = stuOb.familys[i] ;
							str+="<a href='<%=basePath%>/user/normal/stu/index?name="+ onestu.name + "'>" + "<img alt='还未上传头像' class='img-rounded' src='"+onestu.imgpath+ "'>" + "</img>" + "</a>" 
							+ "<p>姓名:"+ onestu.realname + "</p>"
							+ "<p>学历:"+ onestu.level + "</p>"
							+ "<p>授课内容:"+ onestu.subjects + "</p>"
							;
							str+="</div>" ;
							$('.wrap_content .infowrap').append(str) ;
						}
						//生成page标签页
						var pageStr = "<ul class='pagination sortpage' id='sort_notice_" + order + "'><li><a id='page_1'><<</a></li>" ;
						for(var j= 0 ; j < pageLen ; j++){
							pageStr+="<li><a id='page_" + (j+1) + "'>" +(j+1) +  "</a></li>" ;
						}
						pageStr+="<li><a id='page_" +pageLen  + "'>>></a></li></ul>" ;
						console.log(pageStr);
						$('.pagebtn').html('');
						$('.pagebtn').append(pageStr) ;
					}
				}
			});
		});
	});
</script>

</body>
</html>