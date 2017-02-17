<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="_ctx" 
 value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" scope="application" />

 <script type="text/javascript">

	//전역변수 dtree 객체  
	var d;
	
	$(document).ready(function(){
		
		getTreeList();
		
	});
	
	//트리 목록
	function getTreeList() {
		var _url = "${_ctx}/board/map/list.json";
		
		$.post(_url, function(data) {
			if($.isArray(data)) {									// 받아온 것을 data라는 이름으로. data가 array인가? 결과는 true, false로.
				
				//dTree d 객체 생성
				d = new dTree('d');
			
				$(data).each(function(){					// data가 array면 하나씩 받아와서 아래를 돌린다. foreach와 같다고 보면 될 듯?

					//console.log(this.mapNm);				// this. DTO의 getter에 있는 것. 하지만 여기로 들어오는 건 DTO 객체가 아니다.
					
					//root를 찾아서 pid ==> -1로 바꾼다.
					if(this.parMapId == null) {
						d.add(this.mapId, -1, this.mapNm,
								 "javascript:getList()");				// 첫번쨰. 유니크한 아이디. 두번째. Parant id. 루트는 -1이 되어야한다.(이건 전체게시판이며 parant가 존재하지 않는다.) 세번째는 맵 이름을 적는다.
					//폴더일 경우 url 파라미터는 없다.
					} else if ( this.parMapId == 0 ) {					// parMapId가 0이면 폴더를 의미하는 것이다. 자동화가 불가능하니 하드코딩으로..
						d.add(this.mapId, this.parMapId, this.mapNm);
					} else if ( this.parMapId == 2 ) {
						d.add(this.mapId, this.parMapId, this.mapNm,			//이미지 게시판 링크는 따로 건다.
								 "javascript:getList2("+ this.mapId +")");				// href 안으로 들어가게 된다. ajax를 쓰지 않아서 직접 적음.
					//일반 메뉴	
					} else {
						d.add(this.mapId, this.parMapId, this.mapNm,			//네번째는 이걸 눌렀을 때 가는 url을 적는다.
							 "javascript:getList("+ this.mapId +")");							// href 안으로 들어가게 된다. ajax를 쓰지 않아서 직접 적음.
				 // "${_ctx}/board/doc/list?mapId=" + this.mapId 
					}
					
				});
				
				$("#dtree").html(d.toString());
				
				d.openAll();
				
			
				
			} else {
				alert("잘못된 데이터입니다. 관리자에게 문의하시오.");
			}
			
		});
		
	}
	
	function getList(mapId) {
		$("#mapIdInTheLeft").val(mapId);
		$("#frmBoardMap").submit();
	}
	
	function getList2(mapId) {
		$("#mapIdInTheLeft2").val(mapId);
		$("#frmBoardMap2").submit();
	}
	
	

</script>

<form id="frmBoardMap" action="${_ctx}/board/doc/list" method="post">
	<input type="hidden" name="mapId" id="mapIdInTheLeft" />
</form>	
	
<form id="frmBoardMap2" action="${_ctx}/board/doc/listphoto" method="post">
	<input type="hidden" name="mapId" id="mapIdInTheLeft2" />
</form>	

<div class="sidebar">
			<h1>${user.name} </h1><br/>
			<p>${user.lgnId } 			<a href="${_ctx}/sessionview">회원정보</a></p>
			
			<a href="/from/logout"><button class="loginBtn logoutBtn">로그아웃</button></a>
					
</div>

<div class="sidebar">
			
			<div class="dtree" id="dtree">
			
			
			</div>
</div>