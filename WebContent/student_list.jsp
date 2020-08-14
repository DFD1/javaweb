<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="message.Grade" %>
    <!-- 管理员看到的页面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有学生信息</title>
<style type="text/css">
td{
	font-size:12px;
}
h2{
	margin:0px;
}
</style>
</head>
<body>
<table align="center" width="800" border="1"height="200" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
<tr bgcolor="white">
<td align="center" colspan="7">
<h2>学生信息</h2>
</td>
</tr>
<tr align="center" bgcolor= "#b3d9ff">
<td><b>ID</b></td>
<td><b>学生姓名</b></td>
<td><b>课程名</b></td>
<td><b>成绩</b></td>
<td colspan="2"><b>权限</b></td>

</tr>
<%
List<Grade>list=(List<Grade>)request.getAttribute("list");
if(list==null||list.size()<1)
{
	out.print("没有数据!");
}
else
{
	for(Grade grade:list)
	{
		%>
		<tr align="center" bgcolor=" #b3d9ff">
		<td><%=grade.getStudentid() %></td>
		<td><%=grade.getStudentname() %></td>
		<td><%=grade.getCourse() %></td>
		<td><%=grade.getScore() %></td>
		<td><a href="Alterstudent1?id=<%= grade.getStudentid()%>">修改</a></td>
		<td><a href="Deletestudent?id=<%=grade.getStudentid()%>">删除</a></td>
		</tr>
<% 	}
}
%>
</table>
<p align="center"><a href="shouye.jsp">返回</a></p>
<p align="center"><a href="add.jsp">添加</a></p>
</form>
</body>
</html>