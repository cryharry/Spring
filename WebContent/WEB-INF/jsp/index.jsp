<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 목록 화면</h1>
<table border="1">
	<tr>
		<td>상품ID</td>
		<td>상품명</td>
		<td>가격</td>
	</tr>
	<c:forEach items="${itemList}" var="item">
		<tr>
			<td>${item.itemId }</td>
			<td>${item.itemName }</td>
			<td>${item.price }원</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>