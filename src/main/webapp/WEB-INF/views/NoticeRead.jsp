<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<%@include file="Header.jsp" %>
	
	<div class="container">
		<table class="table" id="noticeDetail">
		    
		</table>
		<a href="<%=request.getContextPath()%>/notice/list?p=${param.p}">[목록]</a>
		
	</div>
	
	<%@include file="Footer.jsp" %>
	
	<script type="text/javascript">
		let nno = '${param.nno}';
		let p = '${param.p}';
		let id = '${userinfo.uid}';
		console.log(id);
		function getNoticeDetails(){
			$.ajax({
				url : '<%=request.getContextPath()%>/notice/ajax/read?nno='+ nno +'&p='+ p,
				method : 'get',
				success: function(data){
					console.log(data);
					$('#updateBtn').remove();
					let result = '';
					result += '<tr><td>제목</td><td>'+ data.board.ntitle +'</td></tr>';
					result += '<tr><td>작성일시</td><td>'+ data.board.ndate +'</td></tr>';
					result += '<tr><td>작성자</td><td>'+ data.board.nwriter +'</td></tr>';
					result += '<tr><td>조회수</td><td>'+ data.board.ncount +'</td></tr>';
					result += '<tr><td>내용</td><td>'+ data.board.ncontext +'</td></tr>';
					$('#noticeDetail').html(result);
					
					let result2 = '';
					if(id == data.board.nwriter){
						result2 += '<button id="modifyBtn" class="read btn btn-primary">수정하기</button>';
						result2 += '<a class="read btn btn-danger" href="${root}/notice/delete/'+nno+'">삭제하기</a>';
					}
					$("#noticeDetail").after(result2);
					
				},
				error : function(){
					console.log("error");
				}
			})
		}

		$(document).on("click", "#modifyBtn", function(){
			console.log("dd")
			$.ajax({
				url : '<%=request.getContextPath()%>/notice/update/'+ nno,
				method : 'get',
				success: function(data){
					$('#noticeDetail>tr').remove();
					$('.read').remove();
					$('#noticeDetail').before('<h2 class="m-4">글 수정하기</h2>');
					console.log(data);
					let result = '';
					result += '<tr><td>제목</td><td><input type="text" id="ntitle" name="ntitle" value="'+ data.board.ntitle +'"></td></tr>';
					result += '<tr><td>작성일시</td><td><input type="text" id="ndate" name="ndate" readonly value="'+ data.board.ndate +'"></td></tr>';
					result += '<tr><td>작성자</td><td><input type="text" id="nwriter" name="nwriter" readonly value="'+ data.board.nwriter +'"></td></tr>';
					result += '<tr><td>조회수</td><td><input type="text" id="ncount" name="ncount" readonly value="'+ data.board.ncount +'"></td></tr>';
					result += '<tr><td>내용</td><td><input type="text" id="ncontext" name="ncontext" value="'+ data.board.ncontext +'"></td></tr>';
					$('#noticeDetail').html(result);
					
					let result2 = '';
					if(id == data.board.nwriter){
						result2 += '<button class="btn bnt-primary" id="updateBtn">수정하기</button>';
					}
					$("#noticeDetail").after(result2);
					
				},
				error : function(){
					console.log("error");
				}
			})
		});
		
		$(document).on("click", "#updateBtn", function(){
	        if(!$("#ntitle").val()){
	            alert("변경할 제목을 입력하세요");
	            return;
	        } else if(!$("#ncontext").val()){
	            alert("변경할 내용을 입력하세요");
	            return;
	        } else {
	        	let ntitle = $('#ntitle').val();
	        	let ndate = $('#ndate').val();
	        	let nwriter = $('#nwriter').val();
	        	let ncount = $('#ncount').val();
	        	let ncontext = $('#ncontext').val();
		        $.ajax({
	                url : '<%=request.getContextPath()%>/notice/ajax/update/'+nno,
					method: 'post',
					data : {'ntitle' : ntitle, 'ndate' : ndate, 'nwriter' : nwriter, 'ncount' : ncount, 'ncontext' : ncontext},
					success : function(msg){
						alert(msg); 
						getNoticeDetails();
					},
					error : function(){ // 에러
						console.log(JSON.stringify(error));
						alert("ajax error..!");
					}
	            })
	        } 
	    });		
		getNoticeDetails();
	</script>
</body>
</html>