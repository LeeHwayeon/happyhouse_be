<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

	<c:if test="${empty sessionScope.userinfo}">
		<h2 class="mt-5">로그인 후 이용해주세요.</h2>
	</c:if>
	
	<c:if test="${not empty sessionScope.userinfo}">
		
		<div id="content text-center justify-content-center">
			<div class="row-content">
				<div class="text-center col-sm-12 mb-5">
					<h1><strong>마이 페이지</strong></h1>
					<hr>
				</div>
				<div class="col-sm-12 text-center">
					<h2 class="col-sm-12">회원 정보</h2>
					<div class="rounded w-75 bg-light col-sm-12 col p-5" style="float: none; margin: 0 auto;">
						<form id="updateForm" class="text-left col-sm-12" method="post" action="">
							<input type="hidden" name="act" id="act" value="update">
							<div class="list_element mb-4 row">
								<div class="col-sm-6 text-center">아 이 디</div>
								<div class="col-sm-6">${userinfo.uid}</div>
								<input type="hidden" name="uid" id="uid" value="${userinfo.uid}">
							</div>
							<div class="list_element mb-4 row">
								<div class="col-sm-6 text-center">비 밀 번 호</div>
								<input class="col-sm-6" type="password" id="upass" name="upass" value="${userinfo.upass}">
							</div>
							<div class="list_element mb-4 row">
								<div class="col-sm-6 text-center">이 름</div>
								<input class="col-sm-6" type="text" id="uname" name="uname" value="${userinfo.uname}">
							</div> 
							<div class="list_element mb-4 row">
								<div class="col-sm-6 text-center">주 소</div> 
								<input class="col-sm-6" type="text" id="uadd" name="uadd" value="${userinfo.uadd}">
							</div>
							<button type="button" id="updateBtn" class="btn btn-block btn-warning mt-3">회원 정보 수정</button>
							<a href="${root}/user/delete">
							<button type="button" id="deleteBtn" class="btn btn-block btn-danger mt-3 mb-3">회원 탈퇴</button>
							</a>
						</form>
						
					</div>
					
				</div>
			</div>
		</div>
	</c:if>
	
	<script>
		$("#updateBtn").click(function(){
			if(!$("#uname").val()){
                alert("이름을 입력하세요");
                return;
			} else if(!$("#upass").val()){
                alert("비밀번호를 입력하세요");
                return;
			} else if(!$("#uadd").val()){
                alert("주소를 입력하세요");
                return;
			} else {
				$("#updateForm").attr("action", "${root}/user/update").submit();
			}
		});
	</script>

<%@include file="Footer.jsp" %>