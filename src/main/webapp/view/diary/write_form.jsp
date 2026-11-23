<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp" />

<link href="./res/css/member/signup_form.css" rel="stylesheet" type="text/css">

<%-- WRITE 버튼에서 호출하는 writeForm() JavaScript 함수를 포함합니다. --%>
<jsp:include page="../include/diary/diary.jsp" />

</head>
<body>

    <%-- 공통 헤더와 네비게이션을 화면에 포함합니다. --%>
    <jsp:include page="../include/header.jsp" />
    <jsp:include page="../include/nav.jsp" />

    <article>
        <div class="article_wrap">

            <%--
                action: form을 제출할 서버 주소입니다.
                name: JavaScript에서 form을 찾을 때 사용하는 이름입니다.
                method: POST 방식으로 입력 데이터를 전달합니다.
            --%>
            <form
                action="<%= request.getContextPath() %>/write_confirm.dir"
                name="write_form"
                method="POST">

                <%-- name="diaryWord"는 diary.jsp 및 DiaryService의 이름과 일치해야 합니다. --%>
                <input class="basic_input" type="text" name="diaryWord" placeholder="Input diary!!">
                <br>

                <%-- type="button"은 자동 제출하지 않고 writeForm()을 호출합니다. --%>
                <input class="basic_input_button" type="button" value="WRITE" onclick="writeForm();">
                <input class="basic_input_button" type="reset" value="RESET">
            </form>

        </div>
    </article>
    <jsp:include page="../include/footer.jsp" />
</body>
</html>
