<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="page" %>
<html>
	<head>
	 <c:import url="/WEB-INF/views/inc/head.jsp"/>
	
		<script type="text/javascript">
				function goPageDoc(page) {
					$("#page").val(page);
					$("#frmSearch").submit();
				}
			 
	
	</script>
</head>

<body>
<div id="wrap">

			<!-- 상단 메뉴 -->
   <c:import url="/WEB-INF/views/inc/menu.jsp" />
   
   <!-- 좌측, 사용자 정보 -->
  	<c:import url="/WEB-INF/views/inc/left.jsp" />
  	
    <div id="rightWrap">
    
    	<div class="rightBlock">
    	
    								<!-- 게시판 상단 표지판 -->
            <div class="page_top">
         		   <center><h1>
            				<c:if test="${map.mapNm == null}">
            					${user.name}의 작성 게시물
            				</c:if>
                ${map.mapNm}
                </h1></center>
                
            </div>
            
            <!-- 검색 시작 -->
								    <form id="frmSearch" name="frmSearch" action="${_ctx}/board/doc/listbyuserid" class="search_area" method="post">
								     <input type="hidden" name="mapId" value="${map.mapId}" />
								     <input type="hidden" name="page" id="page" value="${search.page}" />
								     <dl>
								      <dd>
								       <select name="searchType" id="searchType" style="height: 30px;">
								        <option value="T">제목</option>
								        <option value="C">내용</option>
								        <option value="TC">제목+내용</option>
								        <option value="R">작성자</option>
								       </select>
								      </dd>
								      <dd>
								       <input type="text" name="searchText" id="searchText" value="${search.searchText}"
								        style="width:200px; height: 30px;" />
								      </dd>
								      <dd>
								       <button id="btnSearch" class="hand" style="width:50px; height:30px;" onclick="goSearch();">검색</button>
								      </dd>
								     </dl>
								    </form>
								    <!-- 검색 끝 -->
            
            <!-- 게시판 본체 레이아웃 -->
            <div class="boardWrap">
                
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th width="8%">번호</th>
                            <th>제목</th>
                            <th width="10%">글쓴이</th>
                            <th width="25%">작성일</th>
                            <th width="10%">조회수</th>
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
                            <td class="txtCut alignLeft">
                            	[${item.mapNm }] &nbsp;
                            	<a href="${_ctx}/board/doc/view2?docId=${item.docId}">${item.title}</a> &nbsp;&nbsp;&nbsp; (${item.memoNum})
                            	&nbsp;&nbsp;&nbsp;
                        			<c:forEach items="${item.fileList}" var="file">
                        				<!-- 갤러리에서 섬네일을 만들 때에는 begin="0" end="0" 을 추가하면 맨 앞의 이미지만 표시하게 될 것이다. -->
                        					<a href="${_ctx}/file/download?fileId=${file.fileId}"><img src="/from/res/img/dataicon.png"/></a> &nbsp;
                        			</c:forEach>
                            </td>
                            <td>${item.name} </td>
                            <td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
                            <td>${item.hit}</td>
                        </tr>
                                           			
                    			</c:forEach>
                    			
                    </tbody>
                </table>
                

                
                <!-- 페이징 -->
                <page:paging page="${search}" script="goPageDoc" />
                

                
            </div>
            
        </div>
    
    </div>
    
</div>

</body>


</html>