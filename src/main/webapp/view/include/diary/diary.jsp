<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    
    // write_form.jsp에서 WRITE 버튼을 클릭하면 이 함수가 호출됩니다.
    const writeForm = () => {

        console.log("writeForm()");

        // form의 name이 write_form이므로 document.write_form으로 form 객체를 가져옵니다.
        let form = document.write_form;

        // form 안에 있는 diaryWord 입력값이 비어 있는지 확인합니다.
        if (form.diaryWord.value === '') {

            // 입력값이 없으면 안내 메시지를 출력합니다.
            alert("Please input diary!!");

            // 입력창으로 커서를 이동시킵니다.
            form.diaryWord.focus();

        } else {

            // 입력값이 있으면 form의 action 주소로 POST 요청을 전송합니다.
            form.submit();

        }
    }
    
</script>
