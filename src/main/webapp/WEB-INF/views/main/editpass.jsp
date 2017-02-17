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
		<c:import url="/WEB-INF/views/inc/head.jsp"/>
		<title>비밀번호 변경</title>
		<script>
		
				$(document).ready(function(){
					
					
					 /* 	폼의 내용 점검. */
						$("#editBlock").validate();
						
					 /*  폼의 내용 제출*/
						$("#editClick").click(function(){
							
							
								$("#editBlock").submit();
								
								alert("비밀번호가 변경되었습니다?");
								
						});
						
					});
			
		
		</script>
	</head>
	<body>
	
		<div id="container">

			<header>
				<div id="topimage">
					<ul id="ulmenu">
						<li class="list"><a href="HTMLIndex.html" target="_self">home</a> </li>
						<li class="list"><a href="#none" target="_self">about</a> </li>
						<li class="list"><a href="HTMLBoard1.html" target="_self">board</a> </li>
						<li class="list"><a href="#none" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
			
			<section>
						
				<div id="boardWrap">
					<div id="subWrap">
					<form id="editBlock" method="post" action="${_ctx}/editpass" target="_self" >
					<table class="createTable">
						<caption>비밀번호 변경</caption>
						<thead>
							<tr>
								<th colspan="2">
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="20%"> 새 비밀번호 입력</td>
								<td class="mTsubject"><input type="password" id ="logPw" name="lgnPw" minlength="6" maxlength="10" required></td>
							</tr>
							<tr>
								<td width="20%">새 비밀번호 재입력</td>
								<td class="mTsubject"><input type="password" name="reLgnPw" minlength="6" maxlength="10" equalTo="#logPw"  required></td>
							</tr>
						
							
						</tbody>
							
					
					</table>
					
					<br>
					
	
			
					</form>
								<a href="#" class="loginBtn" id="editClick">수정완료</a>
								
								<br/>
								
								 <a href="${_ctx}/" class="joinBtn">취소</a>
							<br><br>
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