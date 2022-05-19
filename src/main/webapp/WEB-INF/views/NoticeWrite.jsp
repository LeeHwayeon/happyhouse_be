<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 등록</title>
<style>
	h2{
		margin-bottom : 10%;
	}
	.container .form-group{
		text-align : left;
	}
</style>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="container">
		<h2 class="m-4">글 작성하기</h2>
		<form action="${root}/notice/write" method="post">
			<div class="form-group">
				<label for="ntitle" class="label">제목</label> 
				<input type="text"
					class="form-control" id="title" name="ntitle">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" rows="5" id="content" name="ncontext"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>