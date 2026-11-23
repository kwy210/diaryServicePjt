<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="./res/css/include/nav.css" rel="stylesheet" type="text/css">
<nav>
    <div class="nav_wrap">
        <a href="${pageContext.request.contextPath}/">HOME</a>

        <c:choose>

            <%-- 로그인 세션이 없으면 회원가입 및 로그인 메뉴를 표시합니다. --%>
            <c:when test="${empty sessionScope.signinedMemberId}">
                <a href="${pageContext.request.contextPath}/signup_form.mem">SIGN-UP</a>
                <a href="${pageContext.request.contextPath}/signin_form.mem">SIGN-IN</a>
            </c:when>

            <%-- 로그인 세션이 있으면 로그아웃 및 일기 작성 메뉴를 표시합니다. --%>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/signout_confirm.mem">SIGN-OUT</a>
                <a href="${pageContext.request.contextPath}/diary_write_form.dir">DIARY_WRITE</a>
                <%-- DIARY_LIST는 요청에 따라 이번 학습 범위에서 제외했습니다. --%>
            </c:otherwise>

        </c:choose>
    </div>
</nav>
