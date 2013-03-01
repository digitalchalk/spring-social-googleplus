<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${empty connections }">
<html>
<head>
</head>
<body>
<c:if test="${!empty param.error_description }">
<div style="color:red;">${param.error_description }</div>
</c:if>
<c:if test="${!empty social.provider.error }">
<div style="color:red;">ERROR: ${social.provider.error }</div>
</c:if>
<form name="go" method="POST" action="<c:url value='/connect/gplus'></c:url>">
<input type="hidden" name="scope" value="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"/>
<input type="submit" value="Connect to Google+"/>

</form>
</body>
</html>
</c:when>
<c:otherwise>
Here are your current connections to gplus:
TODO
</c:otherwise>
</c:choose>

