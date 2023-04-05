<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studyinfo</title>
</head>
<body>
<c:forEach items="${gradeList}" var="item">
	学号：${item.sno}成绩：${item.grade}<br/>

</c:forEach>
<a href="studyinfo">返回</a>
</body>
</html>