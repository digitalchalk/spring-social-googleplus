<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
You are logged in as:
<br/>
<table>
<c:forEach items="${connections}" var="connection">
<tr>
	<td><img src="${connection.imageUrl}"/></td>
	<td>${connection.displayName }</td>
</tr>
</c:forEach>
</table>
</body>
</html>