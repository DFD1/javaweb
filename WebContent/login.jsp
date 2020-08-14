<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生成绩管理系统</title>
<style>
.t
{
	width: 100%; height: 45px;display: block;line-height: 45px;text-align: center;
}

</style>
</head>
<body>
<center class='t'><h1>欢迎登录学生成绩管理系统</h1></center>
<center>
    <form action="FindUser" method="post">
	<p>账号<input name="username" value=""><br></p>
	<p>密码<input type="password" name="password" value=""><br></p>
	学生<input type="radio" name="check" value="学生" >
	管理员<input type="radio" name="check" value="管理员" ><br>
	<input type="submit" value="登录" >
    </form>
    <p><a href="zhuce.jsp">没有账号？点击注册吧</a></p></center>
<%@include file="down.jsp" %>
</body>
</html>