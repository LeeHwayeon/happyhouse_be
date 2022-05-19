<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<c:set value="<%=request.getContextPath()%>" var="root"></c:set>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HappyHouse</title>
    <link rel="stylesheet" href="${root}/css/sign_up.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
        	var isId = false;
        	// 아이디 중복검사
        	$("#uid").keyup(function () {
        		var ckid = $("#uid").val();
        		console.log(ckid.length);
        		if(ckid.length < 6 || ckid.length > 16) {
        			$("#idresult").text("아이디는 6자이상 16자이하입니다.").removeClass('text-primary').removeClass('text-danger').addClass('text-dark');
        			isId = false;
        		} else {
	                $.ajax({
	                	url: '${root}/user/idcheck',
	                	data: {'ckid': ckid},
	                  	type: 'GET',
	                  	dataType: 'json',
	                  	success: function (response) {
	                  		console.log(response);
	                    	var cnt = response.idcount;
	                    	if(cnt == 0) {
	                    		$("#idresult").text(ckid + "는 사용가능합니다.").removeClass('text-dark').removeClass('text-danger').addClass('text-primary');
	                    		isId = true;
	                    	} else {
	                    		$("#idresult").text(ckid + "는 사용할 수 없습니다.").removeClass('text-dark').removeClass('text-primary').addClass('text-danger');
	                    		isId = false;
	                    	}
	                  	}, 
	                  	error: function(request, status, error) {
	                  		console.log("status : " + request.status + "\tmsg : " + error);
	                  	}
					});
        		}
			}); 
        	
        	// 회원가입
            $("#registerBtn").click(function () {
                if (!$("#uname").val()) {
                    alert("이름을 입력하세요");
                    return;
                } else if (!isId) {
                    alert("아이디를 올바르게 입력하세요");
                    return;
                } else if (!$("#upass").val()) {
                    alert("비밀번호를 입력하세요");
                    return;
                } else if (!$("#ubirth").val()) {
                    alert("생년월일를 입력하세요");
                    return;
                    
                }else if (!$("#ugender").val()) {
                    alert("성별를 입력하세요");
                    return;
                }else if (!$("#uadd").val()) {
                    alert("주소를 입력하세요");
                    return;
                }
                
                else {
                    $("#signupForm").attr("action", "${root}/user/sign").submit();
                }
            });
        });
    </script>
</head>
<body>

	<%@include file="Header.jsp" %>
	<div id="wrapper">
        <div id="content">
            <h2>회원가입</h2>
            
            <form id="signupForm" class="text-left mb-3" method="post" action="">
            	<input type="hidden" name="act" id="act" value="signup">
            	<div class="form-group">
            	
	                <span class="box int_id mb-3">
	                    <input type="text" id="uid" name="uid" class="int" maxlength="20" placeholder="아이디">
	                </span>
	                <div id="idresult" class="mb-2"></div>
	                
	                <span class="box int_id mb-3">
	                    <input type="password" id="upass" name="upass" class="int" maxlength="20" placeholder="비밀번호">
	                    <img src="${root}/img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
	                </span>
 					<div id="idresult" class="mb-2"></div>
	                <span class="box int_id mb-3">
	                    <input type="text" id="uname" name="uname" class="int" maxlength="20" placeholder="이름">
	                </span>
	                 <div id="idresult" class="mb-2"></div>
	                <span class="box int_id mb-3">
	                    <input type="text" id="ubirth" name="ubirth" class="int" maxlength="20" placeholder="생년월일">
	                </span>
	                 <div id="idresult" class="mb-2"></div>
	                <span class="box int_id mb-3">
	                    <input type="text" id="ugender" name="ugender" class="int" maxlength="20" placeholder="성별">
	                </span>
	                <div id="idresult" class="mb-2"></div>
	                <span class="box int_id mb-3">
	                    <input type="text" id="uadd" name="uadd" class="int" maxlength="20" placeholder="주소">
	                </span>
	                <div id="idresult" class="mb-2"></div>
	        	</div>
                <div class="form-group text-center">
                    <button type="button" id="registerBtn" class="btn btn-outline-primary">회원가입</button>
                    <button type="reset" class="btn btn-outline-danger">초기화</button>
                </div>  
             </form>   
        </div>
      </div>
	<%@include file="Footer.jsp" %>
</body>
</html>