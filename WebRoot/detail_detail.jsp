<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>题目详情</title>
</head>
<body>
<c:forEach items="${qdetail}" var="item">
	<div>题目${item.qno} 错误数${item.wrong} 正确数${item.correct}</div>
</c:forEach>
<a href="detail">返回</a>
</body>
</html>