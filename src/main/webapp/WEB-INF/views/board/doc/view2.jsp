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
		<title>글 보기</title>
	 <script src="//cdn.ckeditor.com/4.6.2/basic/ckeditor.js"></script>

<script>
	
	
	$(document).ready(function(){
			
		//게시물 삭제 - 댓글 있을 때 삭제 불가
/* 		$("#docDelete").click(function(){

			if(confirm("게시물을 삭제하시겠습니까?") == true) {
			
					var commentCount = $("#memoNum").text();
					
					if (commentCount == 0 ) {
						
						location.replace("${_ctx}/board/doc/remove?docId=${doc.docId}");
						
					} else {
							
						alert("댓글이 있어 게시물을 삭제할 수 없습니다.");
						
					}
			
			} else {
				
					return;
				
			}
			
		}); */
		
		
		//게시물 삭제 - 댓글까지 전부 삭제
		$("#docDelete").click(function(){
			if(confirm("게시물과 댓글을 전부 삭제하시겠습니까?") == true) {
				location.replace("${_ctx}/board/doc/removememotoo?docId=${doc.docId}");
			} else {
				return;
			}
		});
		
		//댓글 목록 가져오기 
		getMemoList();
		
		//댓글 작성
		$("#memoSubmit").click(function(){
		 	 
			/* ckeditor 내용 빈칸 검사 */
			var data = CKEDITOR.instances.memoContents.getData();
			
			if (data == "" | data == " ") {
				alert("댓글 내용을 작성해주십시오.");	
			} else {
			
				$.post("${_ctx}/board/memo/write.json"
						, {memoContents:data, docId:${doc.docId}}
						, function(json){
					
					 	if (json == 0) {
								alert("오류가 발생했습니다.");
							} else {
								CKEDITOR.instances.memoContents.setData("");
								getMemoList();
							}
					 	
				});
				
			}
			
		});
	
	});
	
	function removeMemo(memoId2){
		var url = "${_ctx}/board/memo/remove.json";
		
		$.post(url, {memoId: memoId2}, function(json) {
					
					if (json == 0) {
						alert("오류가 발생했습니다.");
					} else {
						getMemoList();						
					}
					
		});
	}
		
	function removeDoc (docId2){
		var url = "${_ctx}/board/doc/removememotoo.json";
		
		$.post(url, {docId: docId2}, function(json) {
					
					if (json == 0) {
						alert("오류가 발생했습니다.");
					} else {
						getList("${map.mapId}");					
					}
					
		});
	
	}
	
	function getMemoList(){
		var url = "${_ctx}/board/memo/list";
		var url2 = "${_ctx}/board/doc/memoNum";
		
		$.post(url, {docId : "${doc.docId}"}, function(html){
			$("#replayListDiv").html(html);			
		});
		
		$.post(url2, {docId : "${doc.docId}"}, function(num){
			$("#memoNum").html(num);
		});
		
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
						<li class="list"><a class="active" href="HTMLBoard1.html" target="_self">board</a> </li>
						<li class="list"><a href="#none" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
						
			<section>
			
				<div id="boardWrap">
				<div id="subWrap">
					<table id="viewForm">
						<caption>${map.mapNm}</caption>
						<thead>

						</thead>
						<tbody>
							<tr style="font-size:14px;">
								<td width="5%">${doc.docId}</td>
								<td class="viewForm1" style="font-size:14px;"> 	
									${doc.title} &nbsp;&nbsp;
         (<span id="memoNum">${doc.memoNum}</span>)</td>
								<td style="font-size:14px;">${doc.name}</td>
								<td style="font-size:14px;"><fmt:formatDate value="${doc.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td style="font-size:14px;">${doc.hit}</td>
								</tr>
							<tr>
								<td width="10%">첨부 파일</td>
								<td colspan="5" class="viewForm1">
          <c:if test="${fn:length(doc.fileList) == 0}">
       				첨부파일이 없습니다.
       			</c:if>
       			<c:forEach items="${doc.fileList}" var="file">
       					<a href="${_ctx}/file/download?fileId=${file.fileId}">${file.orgFileNm}</a><br/>
       			</c:forEach>
								</td>
							</tr>
								
							<tr>
								<td colspan="6" id="viewFormMain">
								
											<c:forEach items="${doc.fileList}" var="image">
													<c:if test="${image.fileType == 'image' }">
															<img src="${_ctx}/file/download?fileId=${image.fileId}" style="max-width:500px;"></img> <br/>
													</c:if>
											</c:forEach>
											
								 	 ${doc.docContents}	

								</td>
							</tr>

						</tbody>						
					</table>
					
					<table id="viewFormMenu">
						<tr class="viewFormTop">
								<td class="alignLeft">
									<c:if test="${doc.mapId == 46 || doc.mapId == 47 }">
										<a href="javascript:getList2(${doc.mapId})"><button>목록</button></a>
									</c:if>
									<c:if test="${doc.mapId != 46 && doc.mapId != 47 }">
									<a href="javascript:getList(${doc.mapId})"><button>목록</button></a>
									</c:if>
								</td>
								<td colspan="5" class="alignRight">
									<!-- 세션 아이디와 작성자 아이디를 확인하여 수정, 삭제 버튼 -->
									<c:if test="${user.userId == doc.userId}">								
											<a href="${_ctx}/board/doc/edit?docId=${doc.docId}" onclick="goEdit();"><button>수정</button></a>
											<a href="javascript:removeDoc(${doc.docId})"><button>삭제</button></a>
									</c:if>								
								</td>
							</tr>
					</table>
		

     <div id="replayListDiv">

     </div>
					<br>
					<div id="commentForm">
						<textarea id="memoContents" name="memoContents" rows="3" cols="70" style="resize:none;font-family:Nanum Gothic;"></textarea>
						<script>
     	 CKEDITOR.replace('memoContents');
     	</script>
						<br/>                        	
						<a href="#" id="memoSubmit" class="disPB btnBase"><button>댓글등록</button></a>
					</div>
							
							
					
					<br/><br/>
					
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