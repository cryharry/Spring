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
<h1>회원가입화면</h1>
<form:form method="post" action="userEntry.html" modelAttribute="user">
<!-- 에러 -->
	<table border="1">
		<tr>
			<td>유저ID</td>
			<td><form:input path="userId" /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><form:input path="postCode" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<form:select path="job">
					<form:option value="사회인" label="사회인" />
					<form:option value="주부" label="주부" />
					<form:option value="학생" label="학생" />
					<form:option value="그외" label="그외" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><form:input path="birthDay" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="리셋">
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>