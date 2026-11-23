<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
const writeForm = () => {

    console.log("DIARY.JS VERSION 2");
    console.log("writeForm() 실행");

    // 1. write_form이라는 이름을 가진 form 검색
    let form = document.querySelector('form[name="write_form"]');

    console.log("form 객체:", form);

    // 2. form이 존재하지 않는 경우
    if (form === null) {
        console.log("write_form을 찾을 수 없습니다.");
        return;
    }

    // 3. form 내부에서 diaryword 입력창 검색
    let diaryword = form.querySelector('[name="diaryword"]');

    console.log("diaryword 객체:", diaryword);

    // 4. 입력창이 존재하지 않는 경우
    if (diaryword === null) {
        console.log("diaryword 입력창을 찾을 수 없습니다.");
        return;
    }

    // 5. 입력 내용 검사
    if (diaryword.value.trim() === '') {

        alert("일기 내용을 입력해 주세요.");
        diaryword.focus();

        return;

    }

    // 6. 입력 내용이 있으면 form 전송
    form.submit();

}
</script>