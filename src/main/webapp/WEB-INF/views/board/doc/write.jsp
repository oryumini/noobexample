<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="page" %>

<html>
	<head>
		<c:import url="/WEB-INF/views/inc/head.jsp"/>
		<title>통합게시판 글보기</title>
	
		<script src="${_ctx}/res/js/ckeditor/ckeditor.js"></script>
	<script>
	
	$(document).ready(function(){
			
		/* 폼의 내용 점검 */
		$("#writeForm").validate();
		
		/* 폼의 내용 제출*/		
		$("#writeSubmit").click(function(){
			
			/* 첨부파일 null 체크 */			
			$(".fileForm").find("input").each(function() {
				if ( $(this).val() == "" | $(this).val() == " ") {
					$(this).remove();
				}
			});
 	 
			/* ckeditor 내용 빈칸 검사 */
			var data = CKEDITOR.instances.editor1.getData();
			
			if (data == "" | data == " ") {
				alert("글 내용을 작성해주십시오.");	
			} else {
				$("#writeForm").submit();
			}
			
		});
		
	});
	
	function addFile(obj) {
		var fileHtml ="<input type='file' name='files' />";
		$(obj).parent().next().append(fileHtml);
	}
	
	</script>
	</head>
	<body>
	
		<div id="container">

			<header>
				<div id="topimage">
					<ul id="ulmenu">
						<li class="list"><a href="${_ctx}/main/index" target="_self">home</a> </li>
						<li class="list"><a href="#none" target="_self">about</a> </li>
						<li class="list"><a class="active" href="#none" target="_self">board</a> </li>
						<li class="list"><a href="#none" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
						
			<section>
			
				<div id="boardWrap">
				<div id="subWrap">
					<form id="writeForm" action="${_ctx}/board/doc/write" method="post" enctype="multipart/form-data">
					<!-- 맵 아이디 추출-->
    	<input type="hidden" name="mapId" value="${map.mapId}" />
                
					<table id="writeForm">
						<caption>${map.mapNm} - 글 쓰기</caption>
						<tbody>

							<tr>
								<td width="10%">글쓴이</td>
								<td class="writeForm1"> 	
										${user.name}
								</td>
							</tr>
							<tr>
								<td width="10%">제목</td>
								<td class="writeForm1">
									<input type="text" name="title" id="subject" size="60" required />
								</td>
							</tr>
							<tr>
								<td width="10%">내용</td>
								<td class="writeForm1">
									<textarea name="docContents" id="editor1" cols="90" rows="20" style="resize:none;font-family:Nanum Gothic;"></textarea>
									<script>
        			CKEDITOR.replace('editor1');
        	</script>
								</td>
							</tr>
							<tr>
								<td width="10%">파일 첨부
										<span class="smlButton" onclick="addFile(this);">파일추가</span>
								</td>
								<td class="writeForm1 fileForm">
							</td>
							</tr>

						</tbody>						
					</table>
	
					<br>
					
				</form>
				
					<button id="writeSubmit">글쓰기</button>
					<a href="javascript:getList(${map.mapId})"><button id="cancel">취소</button></a>
					<br><br><br>
					
				</div>
					
				<!-- 사이드바  -->
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