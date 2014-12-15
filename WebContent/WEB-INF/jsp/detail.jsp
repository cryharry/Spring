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
<h1>상품상세화면</h1>
<table border="1">
	<tr>
		<td><img src="img/${item.pictureUrl }"></td>
		<td>상품명:${item.itemName }<br>
		     가격:${item.price }원<br>
		     비고:${item.description }<br>
		<a href="index.html">목록으로 돌아가기</a></td>
	</tr>
</table>
</body>
</html>