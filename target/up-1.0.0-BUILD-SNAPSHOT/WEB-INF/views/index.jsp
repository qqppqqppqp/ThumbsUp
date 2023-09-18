<%--
  Created by IntelliJ IDEA.
  User: sungjaehyun
  Date: 2023/08/03
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>으뜸장터</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<div id="menu">
    <div id="logo">
        <a href="/" class="logo-image"></a>
    </div>
    <ul class="menu-container">
        <li><a href="<c:url value='/'/>">중고거래</a></li>
        <li><a href="<c:url value='/board/list'/>">커뮤니티</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/register/add'/>">회원가입</a></li>
    </ul>
</div>

<div id="wrap">
    <div id="cover-container">
        <div id="cover-content">
            <div id="cover-image"></div>
            <h1 id="cover-title">믿을만한 <br>이웃 간 중고거래</h1>
            <span id="cover-description">동네 주민들과 가깝고 따뜻한 거래를 <br>지금 경험해보세요.</span>
        </div>
    </div>

    <h1 id="main-title">중고거래 인기매물</h1>

    <div id="main-container">
        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_6191.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">제주 마음샌드</h2>
                    <div class="card-price">30,000원</div>
                    <div class="card-count">
                        <span>조회수 : 47</span>
                    </div>
                </div>
            </a>
        </article>

        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_7413.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">아내 몰래 내다 팔아요</h2>
                    <div class="card-price">27,000,000원</div>
                    <div class="card-count">
                        <span>조회수 : 30</span>
                    </div>
                </div>
            </a>
        </article>

        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_7152.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">오토바이 팝니다</h2>
                    <div class="card-price">2,200,000원</div>
                    <div class="card-count">
                        <span>조회수 : 256</span>
                    </div>
                </div>
            </a>
        </article>

        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_1918.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">제주도 우무 푸딩 팔아요~~</h2>
                    <div class="card-price">20,000원</div>
                    <div class="card-count">
                        <span>조회수 : 87</span>
                    </div>
                </div>
            </a>
        </article>

        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_7564.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">일본판 산토리 하이볼 팝니다</h2>
                    <div class="card-price">10,000원</div>
                    <div class="card-count">
                        <span>조회수 : 122</span>
                    </div>
                </div>
            </a>
        </article>

        <article class="card-top">
            <a class="card-link" href="">
                <div class="card-photo">
                    <img src="<c:url value="../img/IMG_6816.JPG"/>" alt="" width="223px" height="223px" style="border-radius: 12px">
                </div>

                <div class="card-desc">
                    <h2 class="card-title">방한 장갑 팝아봅니다</h2>
                    <div class="card-price">70,000원</div>
                    <div class="card-count">
                        <span>조회수 : 18</span>
                    </div>
                </div>
            </a>
        </article>
    </div>
    <br>
<%--    <div class="paging-container">--%>
<%--        <div class="paging">--%>
<%--            <c:if test="${totalCnt==null || totalCnt==0}">--%>
<%--                <div> 게시물이 없습니다. </div>--%>
<%--            </c:if>--%>
<%--            <c:if test="${totalCnt!=null && totalCnt!=0}">--%>
<%--                <c:if test="${ph.showPrev}">--%>
<%--                    <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>--%>
<%--                </c:if>--%>
<%--                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                    <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--                </c:forEach>--%>
<%--                <c:if test="${ph.showNext}">--%>
<%--                    <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>--%>
<%--                </c:if>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

<script>

</script>

</body>
</html>
