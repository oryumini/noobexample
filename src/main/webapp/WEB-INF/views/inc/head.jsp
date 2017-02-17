<%@ page session="true"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="_ctx" 
 value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" scope="application" />

<c:set var="user" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}" scope="application" />


<link type="text/css" rel="stylesheet" href="${_ctx}/res/css/mystyle.css" />


<!-- js -->
<script type="text/javascript" src="${_ctx}/res/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/jquery.form.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/messages_ko.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/dtree/dtree.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/mask/meiomask.js" charset="utf-8"></script>
<script type="text/javascript" src="http://www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>
