<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teacher</title>
</head>
<body>
欢迎您，${teacher.tname}。
<a href="merge?action=paper">试卷管理</a>
<a href="detail?action=paper&cno=${clstc.cno}">试卷批阅</a>
<a href="studyinfo?action=paper&cno=${clstc.cno}">学习情况</a>
<a href="login?action=logout">登出</a>
</body>
</html>