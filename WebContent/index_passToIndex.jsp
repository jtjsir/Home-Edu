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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Page to Pass</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/html/bootstrap/css/bootstrap.min.css">
	<style type="text/css">
		body{
			font-family: "华文新魏";
			background-image: url("/Home-Edu/images/pass/pattern.png");
		}
		.content{
			width: auto;
			font-size: 24px;
			text-align: center;
			overflow: hidden;
			height: auto;
			margin: 25% auto;
		}

		.content .text{
			padding: 0 4px;
			line-height: 1.8;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="content">
				<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
				<span class="text">退出成功，欢迎下次光临~3秒后将为你跳转到主页...</span><br>
				<p><img src="<%=basePath %>/images/pass/byebye-small.gif" alt="cutecat" class="img-circle"></p>	
			</div>
		</div>
		<%
			//跳转的路径
			String redirctPage = basePath + "/index_full.jsp" ;
			response.setHeader("Refresh", "3;URL=" + redirctPage) ;
		%>
	</div>

<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=basePath %>/html/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>