<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paper</title>
</head>
<body>
<c:forEach items="${paperList}" var="item">
	
		<a href="studyinfo?action=grade&pno=${item.pno}&times=${item.times}" >试卷${item.pno}</a>

</c:forEach>
<a href="studyinfo">返回</a>
</body>
</html>

