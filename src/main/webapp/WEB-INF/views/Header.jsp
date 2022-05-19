<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<!-- Set Root Path -->
<c:set value="<%=request.getContextPath()%>" var="root"></c:set>
<% 
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
<head>
	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Expires" content="Mon, 06 Jan 1990 00:00:01 GMT">
    <meta http-equiv="Expires" content="-1"> 
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 

    <title>HappyHouse</title>
    <link rel="stylesheet" href="${root}/css/main.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${root}/js/main.js"></script>
</head>

<body class="container text-center mt-3">
    <header>
        <nav class="navbar navbar-expand-sm bg-light navbar-dark fixed-top shadow">
            <div class="container">
                <a class="navbar-brand" href="${root}/">
                	<img src="${root}/img/house.png" alt="Logo">
                	<span>Happy House</span>
                </a>
                <!-- Toggler/collapsibe Button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="header_nav_menu collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                    <div id="header_nav_confirm_off" class="navbar-nav">
                        
                        <c:if test="${empty userinfo}">
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/user/login">로그인</a>
                        </div>
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/user/signup">회원가입</a>
                        </div>                       
                        </c:if>

                        <c:if test="${not empty userinfo}">
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/notice/list">공지사항</a>
                        </div>
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/houseinfo/list">아파트 실거래가 조회</a>
                        </div>
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/interest?act=list">관심지역 조회</a>
                        </div>
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/user/logout">로그아웃</a>
                        </div>
                        <div class="header_nav_menuitem nav-item">
                            <a class="nav_link nav-link text-dark" href="${root}/user/mypage">마이페이지</a>
                        </div>
                        </c:if>
                    </div>
                </div>
        	</div>
        </nav>
    </header>

