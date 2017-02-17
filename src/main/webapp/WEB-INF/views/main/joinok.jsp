<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="_ctx" 
 value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" 
 scope="application" />
<html>
	<head>
		<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
		<title>title</title>
		<style>
			a {
				text-decoration: none;
				color: black;
			}
		
		</style>
	</head>
	<body>
	
	<center>
	<img src="/from/res/img/404.jpg">
	
	<br><br><br>
	
	<button><a href="${_ctx}/login">${username}으로 로그인</a></button>
	
	
	</center>
	</body>
<html>