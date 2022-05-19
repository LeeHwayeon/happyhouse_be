<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<!-- Set Root Path -->
<c:set value="<%=request.getContextPath()%>" var="root"></c:set>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HappyHouse</title>
    <link rel="stylesheet" href="${root}/css/sign_in.css"/>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
        $(document).ready(function () {
        	$("#upass").keydown(function(key) {
                if (key.keyCode == 13) {
                    login();
                }
            });

            $("#btnLogin").click(function () {
                login();
            });
        });
        
        function login() {
        	if (!$("#uid").val()) {
                alert("아이디 입력!!!");
                return;
            } else if (!$("#upass").val()) {
                alert("비밀번호 입력!!!");
                return;
            } else {
            	console.log("123");
                $("#loginForm").attr("action", "${root}/user/login").submit();
            }
        }
    </script>



<body>
	<%@include file="Header.jsp" %>
    <!-- wrapper -->
    <div id="wrapper">
        <!-- content-->
        <div id="content">
	        	<h2>로그인</h2>
	        	<form id="loginForm" action="" method="post" class="text-left mb-3">
		        	<div class="form-group">
		        		<!-- ID -->
		                <span class="box int_id mb-3">
		                    <input type="text" id="uid" name="uid" class="int" maxlength="20" placeholder="아이디">
		                </span>
			            <!-- PW1 -->
		                <span class="box int_pass mb-3">
		                    <input type="password" id="upass" name="upass" class="int" maxlength="20" placeholder="비밀번호">
		                    <img src="${root}/img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
		                </span>
	                	<div class="text-danger mb-2">${msg}</div>
		                
		        		<div style="margin-top: 10px;" class="form-group form-check text-right">
	                	</div>
			            <!-- LOGIN BTN-->
			            <div class="loginBtn">
							<button type="button" id="btnLogin" class="btn btn-outline-success">
								로그인
							</button>
						</div>
						
<%-- 						<a href="${root}/user/signup">
						<button type="button" id="btnSignup" class="btn btn-outline-primary">
							회원가입
						</button>
						</a> --%>
					</div>
	        	</form>
        </div>
    </div>
    <%@include file="Footer.jsp" %>

</body>
</html>