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
						<li class="list"><a href="${_ctx}/main/index" target="_self">home</a> </li>
						<li class="list"><a href="#none" target="_self">about</a> </li>
						<li class="list"><a class="active" href="#none" target="_self">board</a> </li>
						<li class="list"><a href="javascript:getList2()" target="_self">photo</a> </li>
					</ul>
				</div>
			</header>
						
			<section>
			
				<div id="boardWrap">
					
					<div id="subWrap">
					<table id="mainTable">
						<caption>
								${map.mapNm}
     			<!-- 전체게시물 보기로 들어왔을 경우 각 게시물 앞에 소속 게시판 이름을 표시한다. -->
       	<c:if test="${map.mapNm == null }">
       		전체 게시판
       	</c:if>
      </caption>
						<thead>
							<tr>
								<th width="8%">번호</th>
								<th>제목</th>
								<th width="10%">글쓴이</th>
								<th width="15%">날짜</th>
								<th width="8%">조회수</th>
							</tr>
						</thead>
						<tbody>

 							<!-- 게시물이 존재하지 않을 때의 처리 -->	
       	<c:if test="${fn:length(list) == 0}" >
       		<tr>
       			<td colspan="5">
       			게시물이 존재하지 않습니다.
       			</td>
       		</tr>
       	</c:if>
       	
       		<!-- 게시물 리스트 표시 -->
       			<c:forEach items="${list}" var="item">
       			
        		   <tr>
               <td>${item.docId}</td>
               <td class="mTsubject">
               
               			<!-- 전체게시물 보기로 들어왔을 경우 각 게시물 앞에 소속 게시판 이름을 표시한다. -->
                 	<c:if test="${map.mapNm == null }">
                 		[${item.mapNm }] &nbsp;	
                 	</c:if>
                 	
                 	<a href="${_ctx}/board/doc/view2?docId=${item.docId}">${item.title}</a> &nbsp;&nbsp;&nbsp; (${item.memoNum})
                 	&nbsp;&nbsp;&nbsp;
                 	
              				<!-- 첨부파일 표시 및 링크-->
              			<c:forEach items="${item.fileList}" var="file">
              					<a href="${_ctx}/file/download?fileId=${file.fileId}"><img src="/from/res/img/dataicon.png" title="${file.orgFileNm}" /></a> &nbsp;
              			</c:forEach>
              			
               </td>
               <td>${item.name} </td>
               <td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm" /> </td>
               <td>${item.hit}</td>
          		 </tr>
                              			
       			</c:forEach>						

						</tbody>						
					</table>
	
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
								 <form id="frmSearch" name="frmSearch" action="${_ctx}/board/doc/list" class="search_area" method="post">
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