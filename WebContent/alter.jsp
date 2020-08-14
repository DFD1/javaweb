<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="message.Grade" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生信息</title>
</head>
<body>
<%Grade grade=(Grade)request.getAttribute("grade");
System.out.print(grade.getStudentid());
%>
<form action="Alterstudent" method="post" onsubmit="return check(this);">
<table align="center" width="450" border="1"height="100" bordercolor="white" bgcolor="#b3d9ff" cellpadding="1" cellspacing="1">
<tr><td align="center" colspan="2">
<h2>修改学生信息</h2>
</td>
</tr>
<tr><td align="right">学号： </td>
<td><input type="text" name="id" value=<%=grade.getStudentid() %> /></td>
</tr>
<tr><td align="right">学生姓名： </td>
<td><input type="text" name="name" value=<%=grade.getStudentname() %> > </td>
</tr>
<tr><td align="right">课程名： </td>
<td><input type="text" name="course" value=<%=grade.getCourse() %>></td>
</tr>
<tr><td align="right">成绩： </td>
<td><input type="text" name="score" value=<%=grade.getScore() %> /></td>
</tr>
<tr><td align="center" colspan="2">
<input type="submit" value="修改"></td>
</tr>
</table>
</form>
</body>
</html>