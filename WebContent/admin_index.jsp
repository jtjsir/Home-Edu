<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	//全路径
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();

	//上下文路径
	String contextPath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>管理员页面</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>/html/common/index.css">
</head>
<body>
<div class="main">
    <div class="head">
        <span class="head-title">管理后台</span>
        <span class="head-info">
            <a class="user-name">${admin.username}</a>
            <a class="out" href="<%=basePath %>/admin/login/out">退出</a>
        </span>
    </div>
    <div id="menu">
        <ul class="menu">
            <li class='stuRq'><a>学生注册请求</a></li>
            <li class='teaRq'><a>老师注册请求</a></li>
        </ul>
    </div>
    <div class="content">
        <div class="search">
            <input type="text" class="text" placeholder="在这里输入要查找的用户">
            <input type="button" class="button" value="搜索">
        </div>
        <div class="border_bottom"></div>
       <div class="tab">
           <table id="on" class="user-list" border="1">
               <tr>
                   <th>id</th>
                   <th>用户名</th>
                   <th>性别</th>
                   <th>年龄</th>
                   <th>邮箱</th>
                   <th>手机号码</th>
                   <th>学历</th>
                   <th>操作</th>
               </tr>
           </table >
       </div>

    </div>
    <div class="foot">
        <p>JingSir-杭州电子科技大学-毕业设计</p>
    </div>
</div>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//解析字符串
		var decodeJson = function(appendNode,data){
			var json = JSON.parse(data) ;
			var len = json.length ;
			var fixedStr = "<tr><th>id</th><th>用户名</th><th>性别</th><th>年龄</th><th>邮箱</th><th>手机号码</th><th>学历</th>"
                +"<th>操作</th>"
           		+" </tr>" ;
           	appendNode.append(fixedStr) ;
			for(var i = 0; i < len ; i++){
				var appendStr = "<tr>" 
				+"<td>" + json[i].id + "</td>"
				+"<td class='username'>" + json[i].username + "</td>"
				+"<td>" + json[i].sex + "</td>"
				+"<td>" + json[i].age + "</td>"
				+"<td>" + json[i].email + "</td>"
				+"<td>" + json[i].phone + "</td>"
				+"<td>" + json[i].level + "</td>"
				+"<td>" +"<a class='agree'>同意" + "</a>/" + "<a class='ignore'>过滤</a>" + "</td>"
				+"</tr>"
				;
				appendNode.append(appendStr) ;
			}
		}
		//学生注册请求点击事件
		$(document).on('click','.stuRq',function(){
			$(this).attr('class','stuRq active') ;
			$('.teaRq').attr('class','teaRq') ;
			$.ajax({
				url:"<%=basePath %>/admin/user/index/query/all",
				data:{
					userType:"2"
				},
				success:function(data){
					var appendNode = $('.tab .user-list') ;
					appendNode.html('') ;
					if(data=="null"||data=="[]"){
						appendNode.html('没有相关的数据！') ;
					}else{
						decodeJson(appendNode,data) ;
					}
				}
			});
		});
		
		//老师注册请求点击事件
		$(document).on('click','.teaRq',function(){
			$(this).attr('class','teaRq active') ;
			$('.stuRq').attr('class','stuRq') ;
			$.ajax({
				url:"<%=basePath %>/admin/user/index/query/all",
				data:{
					userType:"1"
				},
				success:function(data){
					var appendNode = $('.tab .user-list') ;
					appendNode.html('') ;
					if(data=="null"||data=="[]"){
						appendNode.html('没有相关的数据！') ;
					}else{
						decodeJson(appendNode,data) ;
					}
				}
			});
		});
	})
</script>
<script type="text/javascript">
	$(function(){
		//解析字符串
		var decodeJson = function(appendNode,data){
			var json = JSON.parse(data) ;
			var len = json.length ;
			var fixedStr = "<tr><th>id</th><th>用户名</th><th>性别</th><th>年龄</th><th>邮箱</th><th>手机号码</th><th>学历</th>"
                +"<th>操作</th>"
           		+" </tr>" ;
           	appendNode.append(fixedStr) ;
			for(var i = 0; i < len ; i++){
				var appendStr = "<tr>" 
				+"<td>" + json[i].id + "</td>"
				+"<td class='username'>" + json[i].username + "</td>"
				+"<td>" + json[i].sex + "</td>"
				+"<td>" + json[i].age + "</td>"
				+"<td>" + json[i].email + "</td>"
				+"<td>" + json[i].phone + "</td>"
				+"<td>" + json[i].level + "</td>"
				+"<td>" +"<a class='agree'>同意" + "</a>/" + "<a class='ignore'>过滤</a>" + "</td>"
				+"</tr>"
				;
				appendNode.append(appendStr) ;
			}
		}
		//搜索事件
		$(document).on('click','.content .search .button',function(){
			var name = $(this).parent().children('.text').val() ;
			var userType = $('.teaRq').attr('class')=="teaRq active"?"1":"2" ;
			$.ajax({
				url:"<%=basePath %>/admin/user/index/query/some",
				data:{
					name:name,
					userType:userType
				},
				success:function(data){
					var appendNode = $('.tab .user-list') ;
					appendNode.html('') ;
					if(data=="null"||data=="[]"){
						appendNode.html('没有相关的数据！') ;
					}else{
						decodeJson(appendNode,data) ;
					}
				}
			});
		});
		
		//绑定接受事件
		$(document).on('click','.agree',function(){
			var name = $(this).parent().parent().children('.username').text() ;
			$(this).parent().parent().attr('hidden',true) ;
			
			$.ajax({
				url:"<%=basePath %>/admin/user/index/accept",
				data:{
					name:name 
				},
				success:function(){
					alert('已经向用户发送注册审核成功邮箱信息！') ;
				}
			});
		});
		
		//绑定过滤事件
		$(document).on('click','.ignore',function(){
			var name = $(this).parent().parent().children('.username').text() ;
			$(this).parent().parent().attr('hidden',true) ;
			
			$.ajax({
				url:"<%=basePath %>/admin/user/index/ignore",
				data:{
					name:name 
				},
				success:function(){
					alert('已经向用户发送注册审核失败邮箱信息！') ;
				}
			});
		});
	});
</script>
</body>
</html>