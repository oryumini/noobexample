<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<script>

	$(document).ready(function(){
		$("#header ul li a").click(function(){
			$("#header a").attr("class", "");
			$(this).attr("class", "on");
		});
	});
	</script>

	<div id="header">
    	<ul>
        	<li><a href="javascript:getList()">전체게시판</a></li>
            <li><a href="#">갤러리</a></li>
            <li><a href="${_ctx}/board/doc/listbyuserid" >내 글</a></li>
            <li><a href="${_ctx}/sessionview">내 정보</a></li>
            <li><a href="#">관리자</a></li>
        </ul>
    </div>