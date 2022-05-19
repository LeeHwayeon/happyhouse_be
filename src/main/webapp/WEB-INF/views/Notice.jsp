<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>공지사항</h2>
		<a href="${root}/notice/write">
		<button type="button-right" class="btn btn-success float-right magin mb-4">글쓰기</button>
		</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
				</tr>
			</thead>
			
	
			<tr>
				<td>*</td>
				<td>게시글이 존재하지 않습니다. 게시글을 작성해 주세요</td>
			</tr>	

		</table>
		
	</div>
	
<%@include file="Footer.jsp"%>

<script type="text/javascript">
let currPage = '${param.p}';
console.log(currPage);
function getBoardLists(){
    $.ajax({
        url : '<%=request.getContextPath()%>/notice/ajax/list?p='+currPage,
        method : 'get',
        success : function(data){
            console.log(data);
            if(data.noticeList.length == 0){
                return;
            }
            let result = '';
            for(let i=0; i<data.noticeList.length; i++){
                let board = data.noticeList[i];
                result += '<tr>';
                result += '<td>'+ board.nno +'</td>';
                result += '<td><a href="<%=request.getContextPath()%>/notice/read?nno='+ board.nno +'&p='+ currPage +'">'+ board.ntitle +'</a></td>';
                result += '</tr>';
            }
            $('table tr:gt(0)').remove();
            $('table tr').after(result);
            
            $('.page-num').remove();
            let pages = '';
            if(data.startPage>1){
                pages += '<a href="#" class="page-num" p="'+ (data.startPage-1)+'">[이전]</a>';
            }
            
            for(let i=data.startPage; i<=data.endPage; i++){
                pages += '<a href="#" class="page-num" p="'+ i +'">['+ i +']</a>';
            }
            
            if(data.endPage<data.totalPage){
                pages += '<a href="#" class="page-num" p="'+ (data.endPage+1)+'">[다음]</a>';
            }
            $('table').after(pages);
        },
        error : function(){
            console.log("error");
        }
    })
}
getBoardLists();

$(function(){
    $(document).on('click', '.page-num', function(){
        currPage = $(this).attr('p');
        getBoardLists();
    })
})


</script>
	
</body>
</html>