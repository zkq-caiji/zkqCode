<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
<c:forEach items="${paperList}" var="item">
	
		<div >试卷${item.pno}<a href="merge?action=remove&pno=${item.pno}">删除</a></div>

</c:forEach><br/><br/>
	
	<form action="merge?action=create" method="post">
		<input name="pno" type="text">
		<input name="submit" type="submit" value="新增">
	</form>
	<a href="merge">返回</a>
</body>
</html>