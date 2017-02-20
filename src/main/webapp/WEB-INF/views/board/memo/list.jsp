<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	.replyList p {
			display:inline;
	}
</style>
<table id ="commentView" class="replyList">
	<tbody>
				<c:if test="${fn:length(memolist) == 0 }">
					<tr>
						<th colspan="2"><center>댓글이 없습니다.</center></th>
					</tr>
				</c:if>
				
				<c:forEach items="${memolist}" var="item2">
 				<tr>
     	<th class="name" width="10%"> <b>${item2.name}</b></th>
      <td class="cont" width="70%">
         
      			${item2.memoContents}	                            			
     						
     		<!-- 세션의 아이디와 작성자의 아이디 일치 여부에 따라 수정, 삭제 아이콘 표시 -->
      	<c:if test="${user.userId == item2.userId}">
      			&nbsp;&nbsp;
      			<a href="javascript:removeMemo(${item2.memoId})" class="disPB btnS"><button class="smlButton">삭제</button></a>
       </c:if>			
         
      </td>
      <td class="date" style="text-align:right;"><fmt:formatDate value="${item2.regDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
     </tr>
    </c:forEach>

	</tbody>
</table>