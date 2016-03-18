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
	<link rel="alternate icon" type="text/css" href="<%=basePath %>/css/amazeui/assets/i/favicon.png">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/amazeui/assets/css/amazeui.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/amazeui/assets/css/app.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/umeditor/themes/default/css/umeditor.css">
<title>chat test</title>
<style>
	.title {
  		text-align: center;
	}
	.chat-content-container {
  		height: 29rem;
  		overflow-y: scroll;
  		border: 1px solid silver;
	}
</style>
</head>
<body>
<!-- title start -->
  <div class="title">
    <div class="am-g am-g-fixed">
      <div class="am-u-sm-12">
        <h1 class="am-text-primary">在线聊天</h1>
      </div>
    </div>
  </div>
  <!-- title end -->
  <!-- chat content start -->
  <div class="chat-content">
    <div class="am-g am-g-fixed chat-content-container">
      <div class="am-u-sm-12">
        <ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
      </div>
    </div>
  </div>
  <!-- chat content start -->
 <!-- message input start -->
  <div class="message-input am-margin-top">
    <div class="am-g am-g-fixed">
      <div class="am-u-sm-12">
        <form class="am-form">
          <div class="am-form-group">
            <script type="text/plain" id="myEditor" style="width: 100%;height: 8rem;"></script>
          </div>
        </form>
      </div>
    </div>
    <div class="am-g am-g-fixed am-margin-top">
      <div class="am-u-sm-6">
        <div id="message-input-nickname" class="am-input-group am-input-group-primary">
          <span class="am-input-group-label"><i class="am-icon-user"></i></span>
          <input id="nickname" type="text" class="am-form-field" placeholder="Please enter nickname"/>
        </div>
      </div>
      <div class="am-u-sm-6">
        <button id="send" type="button" class="am-btn am-btn-primary">
          <i class="am-icon-send"></i> Send
        </button>
      </div>
    </div>
  </div>

<script type="text/javascript" src="<%=basePath %>/css/bootstrap/js/jquery-1.11.1.min.js"></script>
<!-- 加入umeditor相关js文件 -->
<script type="text/javascript" charset="utf-8" src="<%=basePath %>/css/umeditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath %>/css/umeditor/umeditor.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/css/umeditor/lang/zh-cn/zh-cn.js"></script>
</body>
</html>