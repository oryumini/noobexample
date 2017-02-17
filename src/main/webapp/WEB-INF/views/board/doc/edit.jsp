<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="page" %>

<c:set var="user" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}" scope="application" />

<html>
	<head>
		<c:import url="/WEB-INF/views/inc/head.jsp"/>
		
			<c:if test="${error.code == -1}">
			
			<script>
				
				alert("${error.msg}");
				document.location.href="${_ctx}/board/doc/view2?docId=${doc.docId}";
				
			</script>
			
		</c:if>
		
		<title>글 수정</title>
	
		<script src="${_ctx}/res/js/ckeditor/ckeditor.js"></script>
		<script>
		
		$(document).ready(function(){
				
			/* 폼의 내용 점검 */
			$("#editForm").validate();
			
			/* 폼의 내용 제출*/		
			$("#editSubmit").click(function(){
				
				/* 첨부파일 null인 입력은 제거한다. */			
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
		
		/* 첨부파일 삭제*/
		function removefile(fileId) {
			$("." + fileId).val(fileId);
			$("#" + fileId).html("");
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
					<form id="editForm" action="${_ctx}/board/doc/edit" method="post" enctype="multipart/form-data">
					<!-- 목록보기용 맵 아이디 -->
     <input type="hidden" name="mapId" value="${doc.mapId}" />
     <!-- 글 아이디 -->
     <input type="hidden" name="docId" value="${doc.docId}" />
                
					<table id="writeForm">
						<caption>글 수정</caption>
						<tbody>

							<tr>
								<td width="10%">글쓴이</td>
								<td class="writeForm1"> 	
										${doc.name}
								</td>
							</tr>
							<tr>
								<td width="10%">제목</td>
								<td class="writeForm1">
									<input type="text" name="title" id="subject" size="60" value="${doc.title}" required />
								</td>
							</tr>
							<tr>
								<td width="10%">내용</td>
								<td class="writeForm1">
									<textarea name="docContents" id="editor1" cols="90" rows="20" style="resize:none;font-family:Nanum Gothic;">${doc.docContents}</textarea>
									<script>
        			CKEDITOR.replace('editor1');
        	</script>
								</td>
							</tr>
							<tr>
								<td width="10%">첨부파일
										<span class="smlButton" onclick="addFile(this);">파일추가</span>
								</td>
								<td class="writeForm1 fileForm">
								
		       <c:forEach items="${doc.fileList}" var="file">
		    				<input type="hidden" class="${file.fileId}" name="delFileList"></input>
		    				<div id="${file.fileId}">
		    					${file.orgFileNm} &nbsp;&nbsp;<a href="javascript:removefile(${file.fileId})"><span class="smlButton">삭제</span></a><br/><br/>
		    				</div>
		    			</c:forEach>
     			
								</td>
							</tr>

						</tbody>						
					</table>
	
					<br>
				
					<a href="#"><button id="editSubmit">글쓰기</button></a>
					<a href="javascript:getList(${doc.mapId})"><button id="cancel">취소</button></a>
					<br><br><br>
					
				</form>
					
				</div>
					
				<!-- 사이드바  -->
				<c:import url="/WEB-INF/views/inc/sidebar.jsp"/>
					
				
				<!--최하단 -->	
				<c:import url="/WEB-INF/views/inc/lowlast.jsp" />
					
				</div>
				
			</section>
			
		</div>
			
	</body>
</html>