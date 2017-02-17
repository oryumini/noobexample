<%@ page session="true"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>통합게시판 홈페이지</title>
		<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
		<script>
		
			$(document).ready(function(){
				
				var marginTop = ($(window).height() - $(".indexlogin").outerHeight() - $(".topimage2").outerHeight() ) / 2;
				$(".indexWrap").css("margin-top", marginTop);				
				
				/* 필수 체크 */
				$("#loginBlock").validate();
			
			/* 로그인 동작 */
				$("#login8").click(function(){
				
					$("#loginBlock").submit();
										
				});
			
				/* 패스워드 입력란에서 엔터를 눌렀을 때 로그인 */
				$("#lgnPw").keyup(function(e) {
					if(e.keyCode == 13) {
						$("#login8").click();
					}
				});
				
				
			});
		
		</script>
		<c:import url="/WEB-INF/views/inc/head.jsp" />

		
	</head>
	<body>
		
	<div class="indexWrap">
		<div class="topimage2" style="width:480px;height:50px;"></div>
		<div class="indexlogin">
		
			<form id="loginBlock" method="post" name="loginBlock" action="${_ctx}/security/login">
					
					<table>
						<caption>통합게시판 로그인</caption>
						<tbody>
							<tr>
								<td width="10%">ID </td>
								<td> <input name="lgnId" type="text" class="input" id="login_form_user_id" required /> </td>
							</tr>
							<tr>
								<td width="10%">PASSWORD </td>
								<td> <input name="lgnPw" id="lgnPw" type="password" class="input" required /> </td>
							</tr>
						</tbody>
					</table>
					
				<br>
			
			</form>
				
				 <a href="#" id="login8" class="loginBtn">로그인</a>
				
				<br><br>
				
				<table style="width:60%;font-size:0.8em;">
					<tbody>
						<tr> 
							<td width="50%">	<a href="${_ctx}/join">회원가입</a> </td>
							<td width="50%"> <a href="#none">ID/PW 찾기</a> </td>
						</tr>
					</tbody>
				</table>

		
		</div>
	</div>	
		
			<br/><br/>
						
   <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    	<center>
    	<font color="red">
    	 정상적으로 로그인이 되지 않았습니다. <br/><br/>
    	 <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
    	</font>
    	</center>
    	<c:remove var ="SPRING_SECURITY_LAST_EXCEPTION" scope ="session" />
   </c:if>			
		
		
	</body>
</html>