<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>
<c:forEach items="${questions}" var="item" varStatus="i">
	<div>${i.index+1}.&nbsp;&nbsp;${item.stem}</div>
</c:forEach>
<a href="search">返回</a>
</body>
</html>