<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错题</title>
</head>
<body>
<c:forEach items="${mistakeList}" var="item" varStatus="i">
	 题目${i.index+1}. ${item.stem}<br/>
</c:forEach>
<a href="mistake">返回</a>
</body>
</html>