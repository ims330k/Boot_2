<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="template/boot.jsp"/>
</head>
<body>
<c:import url="template/nav.jsp"/>
<h1>index</h1>
<c:if test="${not empty sessionScope.member}">
	<h4 style="text-align: center;">${sessionScope.member.name}님 로그인 되었음</h4>
</c:if>
</body>
</html>