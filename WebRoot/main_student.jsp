<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生主页</title>
</head>
<body>
欢迎您，${student.sname}。
	<a href="exercise?action=course">做题</a>
	<a href="mistake?action=mistake">查看错题</a>
	<a href="search?action=search">搜题</a>
	<a href="login?action=logout">登出</a>
</body>
</html>