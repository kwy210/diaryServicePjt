package com.office.diary;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// .dir로 끝나는 요청을 이 Controller가 받습니다
@WebServlet("*.dir")
public class DiaryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DiaryController() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        // 브라우저가 요청한 전체 URI를 가져옵니다.
        String requestURI = request.getRequestURI();
        // 프로젝트의 Context Path를 가져옵니다.
        String contextPath = request.getContextPath();
        // Context Path를 제외하여 실제 기능 요청 주소를 만듭니다.
        // 예: /diaryServicePjt/write_confirm.dir -> /write_confirm.dir
        String command = requestURI.substring(contextPath.length());
       

        DiaryService diaryService = null;
        String nextPage = null;

       
        switch (command) {

            // 작성 화면 요청이면 write_form.jsp 경로를 선택합니다.
            case "/diary_write_form.dir":
                nextPage = generateView("write_form");
                break;

            // 작성 내용 전송 요청이면 Service를 통해 DB 저장을 진행합니다.
            case "/write_confirm.dir":
                // DiaryDao 객체를 생성하고 DiaryService 생성자에 전달합니다.
                diaryService = new DiaryService(new DiaryDao());

                // Service가 반환한 DB 저장 결과를 받습니다.
                int resultForWrite = diaryService.writeNewDiary(request, response);

                // INSERT 결과가 0보다 크면 성공, 그렇지 않으면 실패 JSP를 선택합니다.
                if (resultForWrite > 0) {
                    nextPage = generateView("write_ok");
                } else {
                    nextPage = generateView("write_ng");
                }
                break;
                
            case "/diary_list.dir":

                diaryService = new DiaryService(new DiaryDao());

                List<DiaryDto> myDiaries =
                        diaryService.getMyDiaries(request, response);

                nextPage = generateView("list");

                break;
                
        }
        

        // 선택된 JSP로 요청과 응답을 전달하면서 이동합니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // POST로 전달된 한글 입력값이 깨지지 않도록 인코딩을 지정합니다.
        request.setCharacterEncoding("UTF-8");
        // doGet에 요청 처리를 위임하여 GET과 POST가 같은 분기 로직을 사용합니다.
        doGet(request, response);
    }
   
    // H 정답의 경로 표현을 유지합니다. 앞에 임의로 '/'를 추가하지 않습니다.
    private String generateView(String viewName) {
        return "view/diary/" + viewName + ".jsp";
    }
    
}
