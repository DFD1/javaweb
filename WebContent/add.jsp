<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--添加学生信息的jsp页面  -->
<html>
<head>
<meta charset="UTF-8">
<title>添加图书信息</title>
</head>
<body>
<form action="Insertstudent" method="post" onsubmit="return check(this);">
<table align="center" width="450" border="1"height="100" bordercolor="white" bgcolor="#b3d9ff" cellpadding="1" cellspacing="1">
<tr><td align="center" colspan="2">
<h2>添加学生信息</h2>
</td>
</tr>
<tr><td align="right">学号： </td>
<td><input type="text" name="id" /></td>
</tr>
<tr><td align="right">学生姓名： </td>
<td><input type="text" name="name" /></td>
</tr>
<tr><td align="right">课程名： </td>
<td><input type="text" name="course" /></td>
</tr>
<tr><td align="right">成绩： </td>
<td><input type="text" name="score" /></td>
</tr>
<tr><td align="center" colspan="2">
<input type="submit" value="添 加"></td>
</tr>
</table>
</form>
</body>
</html>