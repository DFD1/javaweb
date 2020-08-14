<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var time = 4;
 
	function returnUrlByTime() {
 
		window.setTimeout('returnUrlByTime()', 1000);
 
		time = time - 1;
 
		document.getElementById("layer").innerHTML = time;
	}
</script>
</head>
<body>
<%String username=request.getParameter("username"); %>
欢迎您登录，<font color="red"><%out.println(username); %></font>
<b><span id="layer">3</span>秒后,进入首页。</b>
<%response.setHeader("Refresh", "3;URL=shouye.jsp"); %>
</body>
</html>