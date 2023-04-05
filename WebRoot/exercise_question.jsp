<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>试卷题目</title>
</head>
<body><form action="exercise?action=commit" method="post"><!---->
<c:forEach items="${questionList}" var="item" varStatus="i">
	题目${i.index+1}. ${item.stem}（ ${item.score}分）
		<input type="radio" name="answer${item.qno}" value="${item.option1}">${item.option1}
		<input type="radio" name="answer${item.qno}" value="${item.option2}">${item.option2}
		<input type="radio" name="answer${item.qno}" value="${item.option3}">${item.option3}
		<input type="radio" name="answer${item.qno}" value="${item.option4}">${item.option4}<br/>	
</c:forEach>
<input type="submit" name="submit" value="commit" >
<a href="exercise">返回</a>
</form>
</body>
</html>