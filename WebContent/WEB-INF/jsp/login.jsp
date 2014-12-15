<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 화면</h1>
<form:form modelAttribute="user" action="login.html" method="post">
<!-- 에러 -->
<table border="1">
	<tr>
		<td>유저ID</td>
		<td><form:input path="userId" /><!-- 에러 --></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><form:input path="password" /><!-- 에러 --></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="로그인">
			<input type="reset" value="리셋">
		</td>
	</tr>
</table>
</form:form>
</body>
</html>