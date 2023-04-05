<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>课程班级</title>
</head>
<body>
<c:forEach items="${clstc}" var="item">
	<a href="exercise?action=paper&cno=${item.cno}">课程${item.cno}班级${item.clno}</a>
</c:forEach>
<a href="exercise">返回</a>
</body>
</html>