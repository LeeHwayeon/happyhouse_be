let map;
$(document).ready(function () {

    //지도
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.56752279878814, 126.97808382237645), //지도의 중심좌표.
        level: 7 //지도의 레벨(확대, 축소 정도)
    };

    map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	$("#search_btn").click(function() {
		let gu = $("#gugun option:selected").val();
		let dong = $("#dong option:selected").val();
		let aptName = $("#aptName").val();
		if(dong == 'undefined' || !aptName){
			alert("검색어를 입력하세요.");
		}else{
			$.ajax({
				url : '${root}/houselist?act=search',
				data : {
					'gu' : gu,
					'dong': dong,
					'aptName' : aptName
				},
				method : 'post',
				dataType:'text',
				success : function(data) {
					let result = JSON.parse(data).result;
					console.log(result);
					console.log(result[0].aptName); 
					
					let el = '<tr><th>아파트 이름</th><th>동</th><th>거래가</th></tr>';
					for (let i = 0; i < result.length; i++) {
						el += '<tr>';
						el += '<td><a href="${root}/houseinfo?act=detail&no='+result[i].aptCode +'">' + result[i].aptName + '</a></td>';
						el += '<td>' + result[i].dongName + '</td>';
						el += '<td>' + result[i].dealAmount + '</td>';
						el += '</tr>';
					}
					$('#listTable').html(el); 
				},
				error : function(e) {
					console.log(e);
					console.log("error");
				}
			});
		}
	});

});

function makeMarker(item) {

    // for (item of result) {
    let address = item["시군구"] + " " + item["번지"];
    // console.log(address);

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(address, function (result, status) {

        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {

            let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 마커 이미지의 이미지 주소입니다
            var imageSrc = "./img/apt3.png";

            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(26, 30);

            // 마커 이미지를 생성합니다    
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: coords, // 마커를 표시할 위치
                title: item["단지명"], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image: markerImage // 마커 이미지 
            });

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: `<div>${item.단지명} <br><a href="https://map.kakao.com/link/map/${item.단지명},${coords.Ma},${coords.La}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${item.단지명},${coords.Ma},${coords.La}" style="color:blue;" target="_blank">길찾기</a></div>`,
                // content: "아파트명 : " + item["단지명"],
            });
            // infowindow.open(map, marker);

            // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
            // 이벤트 리스너로는 클로저를 만들어 등록합니다 
            // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));

            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

            kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow));

            // console.log(positions[0]);
            // var moveLocation = new kakao.maps.LatLng(positions[0].latlng.Ma, positions[0].latlng.La);
            // console.log(coords.La);
            var moveLocation = new kakao.maps.LatLng(coords.Ma, coords.La);
            map.setLevel(5);
            map.setCenter(moveLocation);

        }
    });
}

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
