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
	<title>TEA_DETAIL_INFO</title>
	<style type="text/css">
		body{
		}
		.info-content{
			padding-top:60px;
			padding-left:2px;
		}
		.info_text{
			width: 178px;
    		float: left;
    		margin-left: 100px;
		}
		.info_input{
			width:200px;
			float:left;
		}
		.info_submit{
			width: 200px;
    		margin-left: 278px;
    		margin-top: 20px;
		}
	</style>
</head>
<body>
	<% 
		User user = (User)request.getSession().getAttribute("user") ;
	%>
	<div class="container info-content">
		<form class="form-horizontal" action="" method="post" enctype="multipart/form-data">
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-user">Username(用户名)</span></div>
					<div class="info_input">
						<input type="text" class="form-control" name="username" value="${user.username }">
					</div>
			</div>
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-tag">Realname(真实姓名)</span></div>
					<div class="info_input">
						<input type="text" class="form-control" name="realname" value="test_realtime">
					</div>
			</div>
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-tree-conifer">Level(学历)</span></div>
					<div class="info_input">
						<input type="text" class="form-control" name="level" value="${user.level }">
					</div>
			</div>
			<div class="form-group">
				<div class="info_text"><span class="glyphicon glyphicon-send">Introduction(自我简介)</span></div>
				<div class="info_input">
					<textarea rows="5"  class="form-control" name="introduction" placeholder="请输入自己的相关简介" value="test_introduction">
					</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="info_text"><span class="glyphicon glyphicon-thumbs-up">Honor(荣誉)</span></div>
				<div class="info_input">
					<textarea rows="5"  class="form-control" name="honor" placeholder="请输入自己的相关荣誉" value="test_honor">
					</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="info_text"><span class="glyphicon glyphicon-book">Subjects(授课内容)</span></div>
				<div class="info_input">
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="小学数学" checked>小学数学
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="小学语文">小学语文
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="小学英语">小学英语
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="初中数学">初中数学
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="初中语文">初中语文
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="初中英语">初中英语
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="初中科学">初中科学
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中数学">高中数学
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中语文">高中语文
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中英语">高中英语
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中物理">高中物理
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中化学">高中化学
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中生物">高中生物
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中地理">高中地理
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中历史">高中历史
					</lable>
					<lable class="checkbox-inline">
						<input type="checkbox" name="subjects" value="高中政治">高中政治
					</lable>
				</div>
			</div>
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-euro">Price(价格)</span></div>
					<div class="info_input">
						小学: <input type="text" placeholder="单位:元/小时;默认为0" name="small-price" >
						初中: <input type="text" placeholder="单位:元/小时;默认为0" name="medium-price">
						高中： <input type="text" placeholder="单位:元/小时;默认为0" name="senior-price">
					</div>
			</div>
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-map-marker">Location(位置)</span></div>
					<div class="info_input">
						城市: <input class="form-control" name="city" type="text" value="杭州市" placeholder="默认:杭州市/浙江杭州市">
						学校: <input class="form-control" name="school" type="text" value="test_school">
					</div>
			</div>
			<div class="form-group">
					<div class="info_text"><span class="glyphicon glyphicon-picture">Image(个人头像)</span></div>
					<div class="info_input">
						<input class="form-control" name="imageFile" type="file">
					</div>
			</div>
			<div class="form-group">
				<div class="info_submit">
					<input type="submit" class="form-control btn btn-danger" value="提交个人详细信息">
				</div>
			</div>
			
		</form>
	</div>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		<%
			Object userDetail = request.getSession().getAttribute("userDetail") ;
			if(user!=null&&userDetail==null){
					User normalUser = (User)user ;				
					//表明还没有完善过详细资料
		%>
			$('.info_input input[name="username"]').attr({
				'value':'<%=normalUser.getUsername()%>',
				'disabled':'disabled'
			}) ;	
			$('.info_input input[name="level"]').attr({
				'value':'<%=normalUser.getLevel()%>',
				'disabled':'disabled'
			});
		<%}%>
		
		<%if(userDetail!=null&&user!=null){
			UserDetailTea teaDetail = (UserDetailTea)userDetail ;
		%>	
			$('.info_input input[name="username"]').attr({
				'value':'<%=teaDetail.getName()%>',
				'disabled':'disabled'
			});
			$('.info_input input[name="realname"]').attr({
				'value':'<%=teaDetail.getRealName()%>',
				'disabled':'disabled'
			});
			$('.info_input input[name="level"]').attr({
				'value':'<%=teaDetail.getLevel()%>',
				'disabled':'disabled'
			});
			$('.info_input input[name="introduction"]').attr({
				'value':'<%=teaDetail.getIntroduction()%>'
			});
			$('.info_input input[name="city"]').attr({
				'value':'<%=teaDetail.getCity()%>'
			});
			<%
				}
			%>
	});
</script>
<script type="text/javascript">
	$(function(){
		$('.info_sumbit').on('click','input',function(){
			//图片校验
			var image = $('.info_input[name="imageFile"]') ;
			if(image.value==""||image.value==null){
				$(".info_input name['imageFile']").focus();
				alert("请输入上传的头像图片!");
			}else{
				$('.form-horizontal').attr('action','<%=basePath %>/user/detail/add?userType=tea&id=<%=user.getId() %>').submit();
			}
		});
	});
</script>
</body>
</html>