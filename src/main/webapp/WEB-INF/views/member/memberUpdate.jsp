<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<div class="container">
<h2>my page update</h2>
<form:form action="memberUpdate" method="post" modelAttribute="memberVO"  enctype="multipart/form-data">
<table class="table border-table">
<tr><td>id</td><td><form:input type="text" value="${sessionScope.member.id}" path="id" readonly="readonly"/></td></tr>
<tr><td>pw</td><td><form:input type="text" value="${sessionScope.member.pw}" path="pw"/></td></tr>
<tr><td>name</td><td><form:input type="text" value="${sessionScope.member.name}" path="name" /></td></tr>
<tr><td>email</td><td><form:input type="text" value="${sessionScope.member.email}" path="email"/></td></tr>
<tr>
<td>file</td>
<td><input type="file" class="form-control" id="files" name="file" placeholder="files"></td>
<%-- 	<td><img src="../upload/${files.oname}"></td> --%>
<%-- 	<td><br><br><br><br><br><br><br><a class="btn btn-primary" href="./memberFileDown?fnum=${files.fnum}">fileDown</a></td> --%>
</tr>
</table>
11
<button class="btn btn-warning" id="update">submit</button>
</form:form>
</div>


</body>
</html>