<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>questions</title>
</head>
<body>
<form action="merge?action=choose" method="post">
<c:forEach items="${questionList}" var="item" varStatus="i">
	题目${i.index+1}.${item.stem}
		<input type="checkbox" name="qno" value="${item.qno}">${item.stem}<br/>	
</c:forEach>
<input type="submit" name="submit" value="commit" >
<a href="merge">返回</a>
</form>
</body>
</html>