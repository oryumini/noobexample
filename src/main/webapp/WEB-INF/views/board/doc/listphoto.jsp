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
		<title>통합게시판 글보기</title>
		
		<script type="text/javascript">
				function goPageDoc(page) {
					$("#page").val(page);
					$("#frmSearch").submit();
				}
		
		</script>
		
		</head>
	<body>

	
		<div id="container">

			<header>
				<div id="topimage" style="background-image:url(${_ctx}/res/img/Forza33.jpg);">
					<ul id="ulmenu">
						<li class="list"><a id="home" href="${_ctx}/main/index" target="_self">home</a> </li>
						<li class="list"><a id="about" href="#none" target="_self">about</a> </li>
						<li class="list"><a id="board" href="javascript:getList()" target="_self">board</a> </li>
						<li class="list"><a id="photo" class="active" href="#none" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
						
			<section>
			
				<div id="boardWrap">
					
					<div id="imgBoard">
						
								${map.mapNm}
        	<c:if test="${map.mapNm == null }">
           사진 게시판	
         </c:if>							
						
					
						<ul id="imgUl">
						
						<c:if test="${fn:length(list) == 0}" >
     		
     			게시물이 존재하지 않습니다.
     			
     	</c:if>
						
						  <c:forEach items="${list}" var="item">
										<li>
											<ul class="imgList">
             
             			<!-- 전체게시물 보기로 들어왔을 경우 각 게시물 앞에 소속 게시판 이름을 표시한다. -->
             	<c:if test="${map.mapNm == null }">
               		[${item.mapNm }] &nbsp;	
              </c:if>
               	
              <li class="thumbnail">
               	<!-- 썸네일 표시 -->
               
               <c:if test="${fn:length(item.fileList) == 0 }">
                		<img src="${_ctx}/res/img/404.jpg"/>
               </c:if>
               	
             		<c:forEach items="${item.fileList}" var="image" begin="0" end="0">
             		
																		<c:if test="${image.fileType == 'image' }">
																				<img src="${_ctx}/res/img/thumb/${image.fpath}/${image.newFileNm}.${image.ext}" />
																		</c:if>
																		
																		<c:if test="${image.fileType != 'image' }">
																				<img src="${_ctx}/res/img/404.jpg"/>
																		</c:if>
																		
																</c:forEach> 
               	
               </li>
               
               <br />
               
               	<li>
              	<a href="${_ctx}/board/doc/view2?docId=${item.docId}">${item.title}</a> &nbsp;&nbsp;(${item.memoNum}) 
            			
               	
            				<!-- 첨부파일 표시-->
            			 <c:if test="${fn:length(item.fileList) != 0 }">
            					<img src="/from/res/img/dataicon.png" />
            				</c:if>
            			
            			</li>
															
															<br />
             <li>${item.name} / <fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd" /> 
              / ${item.hit}</li>
         		</ul>
         	</li>
                            			
     			</c:forEach>						
						
						</ul>
				
	
					<table id="secondrow">
						<tr>
							<td width="10%" style="text-align:left;">
								
							</td>
							<td>
								<div id="lowside1">
									<ul id="listnumber">
									
									<page:paging page="${search}" script="goPageDoc" />
									
										</ul>
								</div>
							</td>
							<td width="10%" style="text-align:right;">
								<a href="${_ctx}/board/doc/write?mapId=${map.mapId}"><button>글쓰기</button></a>
							</td>
						<tr>
					</table>
									
					<table id="lowside">
						<tr>
							<td>				
								 <form id="frmSearch" name="frmSearch" action="${_ctx}/board/doc/listphoto" class="search_area" method="post">
								   <input type="hidden" name="mapId" value="${map.mapId}" />
								   <input type="hidden" name="page" id="page" value="${search.page}" />
								
									<select  name="searchType" id="searchType" style="height:20px;">
										<option value="R">글쓴이</option>
										<option value="T">제목</option>
										<option value="C">내용</option>
										<option value="TC">제목+내용</option>
									</select>
								
									<input type="text" name="searchText" id="searchText" value="${search.searchText}" />
									
									<button id="btnSearch" class="hand" onclick="goSearch();">검색</button>
									
								</form>
								
							</td>
						</tr>
					</table>
				</div>
				
				<!-- 사이드바  -->
				<c:import url="/WEB-INF/views/inc/sidebar.jsp"/>
				
				<!--최하단 -->	
				<c:import url="/WEB-INF/views/inc/lowlast.jsp" />
		
				</div>
				
			</section>
			
		</div>
	
	<!-- </div> -->	
	</body>
</html>