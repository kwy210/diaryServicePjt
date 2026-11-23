<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp" />

<link href="./res/css/member/signup_form.css" rel="stylesheet" type="text/css">

<%-- H 정답의 include 구조를 유지합니다. --%>
<jsp:include page="../include/diary/diary.jsp" />

</head>
<body>

    <jsp:include page="../include/header.jsp" />
    <jsp:include page="../include/nav.jsp" />

    <article>
        <div class="article_wrap">

            <%-- DiaryController가 저장 결과가 0보다 클 때 이 화면을 선택합니다. --%>
            <h3>
                DIARY WRITE SUCCESS!!
            </h3>

        </div>
    </article>

    <jsp:include page="../include/footer.jsp" />

</body>
</html>
