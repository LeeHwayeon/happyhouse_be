<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아파트 실거래가 조회</title>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<link rel="stylesheet" href="${root}/css/houselist.css" >
	    <script type="text/javascript"
	        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40868a23b3a27c7fee40b3f1358636ca&libraries=services"></script>
</head>
<body>
<%@include file="Header.jsp"%>
<script type="text/javascript">
	$(function(){
		$(document).on("change", "#gugun", function(){
			console.log($(this).val());
			let list = [];
			<c:forEach var="gudong" items="${gudong}" varStatus="status">
				list.push({gugunName : "${gudong.gugunName}", dongName : "${gudong.dongName}"});
			</c:forEach>
			let dong = "";
			for(let i=0; i<list.length; i++){
				if($(this).val() == list[i].gugunName){
					dong += '<option value="'+ list[i].dongName +'">';
					dong += list[i].dongName;
					dong += '</option>';
				}
			}
			$("#dong").html(dong); 
		});
	})
</script>

	<!-- 중앙 시작 -->
	<div id="contents">
		<div class="container">
				<div class="search_header row justify-content-center m-4">
					<select id="gugun" class="filter-element" name="gu">
						<option value="">자치구</option>
						<c:forEach items="${requestScope.gugun}" var="gugun">
							<option value="${gugun.gugunName}">${gugun.gugunName}</option>
						</c:forEach>
					</select> 
					<select id="dong" class="filter-element" name="dong">
						<option value="">법정동명</option>
					</select> 
					<input type="text" name="aptName" id="aptName" placeholder="아파트 이름">
					<button id="search_btn" class=" btn btn-dark col-md-1">검색</button>
				</div>
				<div class="search_content row">
				<div id="map" class="col-md-7"></div>
				<div class="apt_list col-md-5">
					<table id="listTable" class="table table-striped">
						<tbody>
							<tr>
								<td>검색어를 입력하세요.</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<button id="route_btn" class=" btn btn-dark col-mt-1">경로검색</button>
				
			</div>
			<script type="text/javascript">
				$(document).ready(function () {
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
				    mapOption = { 
				        center: new kakao.maps.LatLng(37.5666805, 126.9784147), // 지도의 중심좌표
				        level: 5 // 지도의 확대 레벨
				    };

					var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
					
					// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
					var mapTypeControl = new kakao.maps.MapTypeControl();

					// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
					// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
					map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

					// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
					var zoomControl = new kakao.maps.ZoomControl();
					map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
				

					$("#search_btn").click(function() {
					
						let gu = $("#gugun option:selected").val();
						let dong = $("#dong option:selected").val();
						let aptName = $("#aptName").val();
						console.log("aptName :"+aptName);
						if((gu.length == 0 && dong.length == 0 ) && aptName.length == 0){
							alert("검색어를 입력하세요")
						}else{
							$.ajax({
								url : '${root}/housedeal/search',
								data : {
									'gu' : gu,
									'dong': dong ,
									'aptName' : aptName
								},
								method : 'post',
								success : function(data) {
									console.log(data);
									console.log(data.houseList);
									
									if(data.houseList.length == 0){
										$("#listTable>tbody>tr").remove();
										var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
									    mapOption = { 
									        center: new kakao.maps.LatLng(37.5666805, 126.9784147), // 지도의 중심좌표
									        level: 5 // 지도의 확대 레벨
									    };

										var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
										
										// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
										var mapTypeControl = new kakao.maps.MapTypeControl();

										// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
										// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
										map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

										// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
										var zoomControl = new kakao.maps.ZoomControl();
										map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
										
										let el = '<tr><td> 검색한 지역의 아파트 실거래가 자료가 존재하지 않습니다.</td></tr>';
										$('#listTable>tbody').html(el); 
									}else{
										$("#listTable>tbody>tr").remove();
										let positions = new Array();
										let el = '<tr><th>아파트 이름</th><th>동</th><th>거래가<br>(평균가 : '+ data.avg[0] +'(만원))</th><th>관심 매물</th></tr>';
										for (let i = 0; i < data.houseList.length; i++) {
											console.log(data.houseList[i].aptName);
											// 마커를 표시할 위치와 title 객체 배열입니다 
											positions[i] = [data.houseList[i].aptName, new kakao.maps.LatLng(data.houseList[i].lat, data.houseList[i].lng)];
											console.log(data.houseList[i].aptCode);
											
											el += '<tr class = "p">';
											el += '<td><a href="${root}/houseinfo/detail/'+data.houseList[i].no +'">' + data.houseList[i].aptName + '</a></td>';
											el += '<td>' + data.houseList[i].dongName + '</td>';
											el += '<td>' + data.houseList[i].dealAmount + '(만원)</td>';
											el += '<td><input type="checkbox" id="search" name="search" value = "'+ data.houseList[i].no+'"></td>';

											el += '</tr>';
										}
										$("#listTable>tbody>tr").remove();
										$('#listTable>tbody').append(el); 
										// 마커 이미지의 이미지 주소입니다
										var imageSrc = "${root}/img/apt3.png"; 
										
										var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
									    mapOption = { 
									        center: positions[0][1], // 지도의 중심좌표
									        level: 5 // 지도의 확대 레벨
									    };
	
										var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
										
										// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
										var mapTypeControl = new kakao.maps.MapTypeControl();

										// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
										// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
										map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

										// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
										var zoomControl = new kakao.maps.ZoomControl();
										map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
										
										console.log(positions[0][1]);
										console.log(positions[0][1].La);
										    
										for (var i = 0; i < positions.length; i ++) {
										    
										    // 마커 이미지의 이미지 크기 입니다
										    var imageSize = new kakao.maps.Size(24, 35); 
										    
										    // 마커 이미지를 생성합니다    
										    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
										    
										    // 마커를 생성합니다
										    var marker = new kakao.maps.Marker({
										        map: map, // 마커를 표시할 지도
										        position: positions[i][1], // 마커를 표시할 위치
										        title : positions[i][0], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
										        image : markerImage // 마커 이미지 
										    });
										    
										 	// 마커가 지도 위에 표시되도록 설정합니다
										    marker.setMap(map);

										    var iwContent = '<div style="padding:5px;">'+positions[i][0]+' <br><a href="https://map.kakao.com/link/map/'+positions[i][0]+','+positions[i][1].Ma+','+positions[i][1].La+'" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/'+positions[i][0]+','+positions[i][1].Ma+','+positions[i][1].La+'" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
										        iwPosition = positions[i][1]; //인포윈도우 표시 위치입니다

										    // 인포윈도우를 생성합니다
										    var infowindow = new kakao.maps.InfoWindow({
										        position : iwPosition, 
										        content : iwContent 
										    });
										      
								            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));

								            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

								            kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow));
										}
									}
								},
								error : function(e) {
									console.log(e);
									console.log("error");
								}
							});
							}
						});
						
/* 					$("#route_btn").click(function() {
						let route_no =new Array();
						route_no.push();
						$('input:checkbox[name="search"]').each(function() {
					 	    if(this.checked == true){ //값 비교
					 	    	route_no.push(this.value);
					   	    }
						 });	
						
						$.ajax({
							url : '${root}/housedeal/route',
							data : {
								'route_no' : route_no,
								'my_point' : my_point,
							},
							method : 'post',
							success : function(data) {
								
							}
							error   : function(){
								
							}
						
					}); */
					

						function makeClickListener(map, marker, infowindow) {
						    return function () {
						        let pos = marker.getPosition();
						        map.setLevel(5);
						        map.panTo(marker);
						    };
						}
	
						// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
						function makeOverListener(map, marker, infowindow) {
						    return function () {
						        infowindow.open(map, marker);
						    };
						}
	
						// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
						function makeOutListener(infowindow) {
						    return function () {
						        infowindow.close();
						    };
						}

					});
				</script>

		</div>
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>