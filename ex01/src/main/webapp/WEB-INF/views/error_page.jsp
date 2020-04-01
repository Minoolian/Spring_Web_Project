<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4><c:out value="${exception.getMessage()}"></c:out></h4>
<ul>
	<c:forEach items="${exception.getStackTrace() }" var="stack">
		<li><c:out value="${stack }"></c:out></li>
	</c:forEach>
</ul>

</body>
</html>

<!-- (200401) Chap6.6.1: /sample/ex04?name=aaa&age=bbb&page=9 와 같이 적합하지 않은 파라미터를 전달하거나 했을 때 오류페이지가 출력된다 -->