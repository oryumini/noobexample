<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="_ctx" 
 value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" 
 scope="application" />
 
<html>
	<head>
		<title>회원 정보 열람</title>
		<c:import url="/WEB-INF/views/inc/head.jsp"/>
		<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
		<script>
		
					
		
		</script>
	</head>
	<body>
	
		<div id="container">

			<header>
				<div id="topimage">
					<ul id="ulmenu">
						<li class="list"><a href="${_ctx}/main/index" target="_self">home</a> </li>
						<li class="list"><a href="#none" target="_self">about</a> </li>
						<li class="list"><a href="javascript:getList()" target="_self">board</a> </li>
						<li class="list"><a href="#none" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
			
			<section>
						
				<div id="boardWrap">
					<div id="subWrap">
				
					<table class="createTable">
						<caption>${user.name}님의 정보</caption>
						<thead>
							<tr>
								<th colspan="2">
								 회원정보
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="15%" class="alignLeft">아이디</td>
								<td class="mTsubject">${user.lgnId}</td>
							</tr>
							<tr>
								<td width="15%" class="alignLeft">이름</td>
								<td class="mTsubject">${user.name }</td>
							</tr>
							<tr>
								<td width="15%" class="alignLeft">핸드폰 번호</td>
								<td class="mTsubject">${user.phone }</td>
							</tr>
							<tr>
								<td width="15%" class="alignLeft">이메일</td>
								<td class="mTsubject">${user.email }</td>
							</tr>
							<tr>
								<td width="15%" class="alignLeft">가입일</td>
								<td class="mTsubject"> <fmt:formatDate value="${user.regDt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							
						</tbody>
							
					
					</table>
					
					<br>
					
     <a href="${_ctx }/edit" class="loginBtn">회원정보 수정</a> <br /> <br />
     <a href="${_ctx }/editpass" class="loginBtn">비밀번호 수정</a>
					
					<br/><br/><br />
				
				</div>
					
					<c:import url="/WEB-INF/views/inc/sidebar.jsp"/>
				
					<table id="lowLast">
						<tr>
							<td>
							
							<a href="#none">이용약관</a>
							   |   
							<a href="#none">개인정보 취급방침</a>
							   |   
							<a href="#none">이메일문의</a>
							   |   
							<a href="#none">사이트맵</a>
							
							</td>
						</tr>
					</table>
		
				</div>
				
			</section>
			
		</div>
	
	</body>
</html>