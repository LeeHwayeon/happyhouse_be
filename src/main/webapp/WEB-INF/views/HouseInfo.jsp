<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아파트 상세 정보</title>
<style type="text/css">
	ul>li>img {
		width: 60%;
	}
</style>
</head>
<body>
<%@include file="Header.jsp" %>
<div class="container">
	<h2 class="m-4">거래 상세 정보</h2>
	<c:set value="${houseDetail}" var="h"></c:set>
	<ul class="list-group">
	  <li class="list-group-item"><img src="${root}/img/aptdetailimg.jpg" class="rounded" alt="Cinque Terre"></img></li>
	  <li class="list-group-item">아파트 이름 : ${h.aptName}</li>
	  <li class="list-group-item">건축 년도 : ${h.buildYear}</li>
	  <li class="list-group-item">거래 가격 : ${h.dealAmount}(만원)</li>
	  <li class="list-group-item">거래 일 : ${h.dealYear}년 ${h.dealMonth}월 ${h.dealDay}일</li>
	  <li class="list-group-item">면적 : ${h.area}㎡</li>
	  <li class="list-group-item">층 : ${h.floor}층</li>
	</ul>
	<div class="m-4"><a href="${root}/houseinfo/list">목록으로 돌아가기</a></div>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>