<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="<%=request.getContextPath()%>" var="root"></c:set>
    <footer>
        <div class="footer_content container">
            <div class="row mt-4">
                <div class="realty_site justify-content-start col-sm-7">
                    <div class="row">
                        <p class="col-sm-5 move">부동산 중개 사이트로 이동하기 >></p>
                        <div class="col-sm-7">
                            <div class="row">
                                <div class="logo_img col">
                                    <a href="https://www.dabangapp.com/" target="_blank">
                                        <img src="${root}/img/dabang.jpeg" alt="">
                                    </a>
                                </div>
                                <div class="logo_img col mt-2">
                                    <a href="https://www.zigbang.com/" target="_blank">
                                        <img src="${root}/img/zigbang.png" alt="">
                                    </a>
                                </div>
                                <div class="logo_img col mt-3">
                                    <a href="https://www.peterpanz.com/?filter=latitude:37.6182925~37.6337067%7C%7Clongitude:126.7030871~126.7273129&zoomLevel=16&center=%7B%22y%22:37.626,%22_lat%22:37.626,%22x%22:126.7152,%22_lng%22:126.7152%7D&dong=&gungu="
                                        target="_blank">
                                        <img src="${root}/img/perterpan.jpeg" alt="">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <p class="col-sm-5 text-right">
                    Copyright 2022. SSAFY All rights reserved.
                </p>
            </div>
        </div>
    </footer>

</body>
</html>