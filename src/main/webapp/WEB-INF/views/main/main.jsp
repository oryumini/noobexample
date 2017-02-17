<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="page" %>
<html>
	<head>
	 <c:import url="/WEB-INF/views/inc/head.jsp"/>
	
</head>

<body>
<div id="wrap">

			<!-- 상단 메뉴 -->
   <c:import url="/WEB-INF/views/inc/menu.jsp" />
   
   <!-- 좌측, 사용자 정보 -->
  	<c:import url="/WEB-INF/views/inc/left.jsp" />
  	
    <div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                <center><h1>메인 페이지.</h1></center>
            </div>
            
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
                
                

                
            </div>
           
            
        </div>
    
    </div>
    
</div>

</body>


<html>