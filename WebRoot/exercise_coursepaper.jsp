<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>paper</title>
</head>
<body>
<c:forEach items="${paperList}" var="item">
	<a href="exercise?action=question&pno=${item.pno}&times=${item.times}">试卷${item.pno}--${item.times}</a>
</c:forEach>
	<a href="exercise">返回</a>
</body>
</html>