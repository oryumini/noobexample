<%@ page session="true"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="_ctx" 
 value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" 
 scope="application" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>회원 가입</title>
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		<script>
		
		$(document).ready(function(){
			
				var marginTop = ($(window).height() - $(".indexjoin").outerHeight() - $(".topimage2").outerHeight() ) / 2;
				$(".indexWrap").css("margin-top", marginTop);				
				
			 /* 캡챠 */
			 var siteKey = "6Lc-yRMUAAAAAIFwJ1srX65buwYowtrQdo7yOX7u";//Site key
			 var div = "recaptcha";
			 
			 Recaptcha.create(siteKey, div, {theme: "clean"});
			 

		 /* 	폼의 내용 점검. */
			$("#joinBlock").validate();
			
		 /*  reCaptcha + 폼의 내용 제출*/
			$("#joinClick").click(function(){
				var isCheckedId = $("#isCheckedId").val();
				
				if ( isCheckedId == "N") {
					alert("아이디 체크를 먼저 해주세요");
					
				} else {
					
					 var challenge = Recaptcha.get_challenge();
	     var response = Recaptcha.get_response();
	     var host = $(location).attr('host');
	      
	     $.ajax({
	         type: "POST",
	         url: "${_ctx}/validateRecaptcha",
	         async: false,
	         data: {
	             host: host,
	             challenge: challenge,
	             response: response
	         },
	         success: function(data) {
	             if(data == "Y") {
	                 document.getElementById("message").innerHTML = "Success!";
																		$("#joinBlock").submit();
																		n();
	                 
	             }else{
	                 document.getElementById("message").innerHTML = "캡챠 문자가 잘못되었습니다. 다시 입력해주세요.";
	                 Recaptcha.reload();
	             }
	         }
	     });
				}
				
			});
			
		 /* 폰 정보 마스크 */
			$("#phone").setMask();
		 
		 /* ajax를 이용한 중복 검사 1 */
		 $("#btnCheckId").click(function(){
		 	var lgnId = $("#lgnId").val();
		 	
		 	console.log(lgnId);
			 if( lgnId == "" || lgnId == " ") {
				
				 alert("로그인 아이디를 입력해주십시오.");
			 
			 } else {
				
				 $.post("${_ctx}/join/id/available", {lgnId : lgnId}, function(json){
					
					 if (json == "N") {
						
						 alert("아이디가 이미 존재합니다.");
					
					 } else if (json=="Y") {
						
						 alert("이 아이디는 사용가능합니다.");
							y();
						
					 }
				 
				 });
			 
			 }
			 
		 });

		 /* 아이디 중복검사 수정 1 */
		 $("#lgnId").focusin(function(){
				 n();
		 });
		    
		});
		
		function y() {
			$("#isCheckedId").val("Y");
		}
		
		function n() {
			$("#isCheckedId").val("N");
		}

	</script>

		

		
	</head>
	<body>
		
	<div class="indexWrap">
		<div class="topimage2" style="width:500px;height:50px;"></div>
		<div class="indexjoin">
		
			<form id="joinBlock" method="post" action="${_ctx}/join" target="_self" title="회원가입" class="join_area">
     <input type="hidden" id="isCheckedId" value="N" />
					<table class="createTable">
						<caption>회원가입</caption>
						<thead>
							<tr>
								<th colspan="2">
								필수 정보 <span style="color:red;font-size:10px">*반드시 입력해주세요.
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="6%">아이디</td>
								<td class="mTsubject"><input type="text" id="lgnId" name="lgnId" minlength="3" maxlength="10"  style="width:40%;" required />
       	<span id="btnCheckId" style="cursor:pointer; background-color:#e6ebee;border:1px solid #65696b; color:#333; width:70px; height:35px;">중복체크</span></td>
							</tr>
							<tr>
								<td width="6%">비밀번호</td>
								<td class="mTsubject"><input type="password" id ="logPw" name="lgnPw"  minlength="6" maxlength="10" required /><br></td>
							</tr>
							<tr>
								<td width="6%">비밀번호 확인</td>
								<td class="mTsubject"><input type="password" name="reLgnPw"  minlength="6" maxlength="10" equalTo="#logPw"  required/><br/></td>
							</tr>
							<tr>
								<td width="6%">이름</td>
								<td class="mTsubject"><input type="text" name="name" required/><br/></td>
							</tr>
							<tr>
								<td width="6%">핸드폰 번호</td>
								<td class="mTsubject"><input type="text" id="phone" alt="mobile" name="phone"  required/><br/></td>
							</tr>
							<tr>
								<td width="6%">이메일</td>
								<td class="mTsubject"><input type="email" name="email" required/><br/></td>
							</tr>
							<tr>
									<td colspan="2">
										<div id="recaptcha"></div>
										<div id="message" style="color:#ff0000; "></div>
									</td>
							</tr>
							
						</tbody>
							
					</table>
					
					<br />
					
					<a href="#" class="loginBtn" id="joinClick">회원가입</a>
     <a href="${_ctx}/login" class="loginBtn">취소</a><br/>
			
			</form>
				

		
		</div>
	</div>	
		
			<br/><br/>
						
		
	</body>
</html>