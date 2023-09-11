package ex03_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
     // 1. 요청 인코딩
     request.setCharacterEncoding("UTF-8");
     
     // 2. 요청 파라미터
     String gender  = request.getParameter("gender");
     String domain  = request.getParameter("domain");
     String content = request.getParameter("content");
     String region  = request.getParameter("region");
     
     /* 
                      요청 (Request)
     클라이언트   ----------------------> 서버
     클라이언트   <---------------------- 서버
                      응답 (Response)
     */                 
                      
     /*
      * 응답 (Response)
      * 1. 서버가 클라이언트에게 데이터를 보내는 것을 의미한다.
      * 2. HttpServletResponse 클래스가 응답을 처리한다.
      * 3. 응답 데이터의 타입(MIME TYPE)을 결정하고 응답한다.
      *   1) text/html          : 태그를 만들어서 반환하는 경우
      *   2) application/xml    : XML을 반환하는 경우
      *   3) application/json   : JSON을 반환하는 경우
      */
     
     // 3. 응답 데이터의 타입과 인코딩 설정
     response.setContentType("text/html; charset=UTF-8");
     
     // 4. 응답 스트림 생성 (서버에서 내보내는 것이니, 출력스트림이다. 문자기반의 출력스트림인 Writer 생성)
     //    IOException 예외 처리가 필요하지만 doGet() 메소드는 IOException 처리를 이미 하고 있다. (throws로 예외처리를 다른 곳으로 던지고 있다.)
     PrintWriter out = response.getWriter();
     
     // 5. 응답하기 (온전한 웹 페이지)
     // PrintWriter를 쓰는 이유는 Println() : '출력 후 줄바꿈'을 쓰기 위해서이다.
     out.println("<!DOCTYPE html>");
     out.println("<html lang=\"ko\">");
     out.println("<head>");
     out.println("<meta charset=\"UTF-8\">");
     out.println("<title>페이지제목</title>");
     out.println("<style>");
     out.println(".wrap {");
     out.println(" background-color: #a0a0a0;");
     out.println("}");     
     out.println("</style>");
     out.println("</head>");
     out.println("<body>");
     out.println("<div class=\"wrap\">");
     out.println("<h1>요청 파라미터</h1>");
     out.println("<ul>");
     out.println("<li>성별: " + gender + "</li>");
     out.println("<li>도메인: " + domain + "</li>");
     out.println("<li><pre>" + content + "</pre></li>");
     out.println("<li>지역: " + region + "</li>");
     out.println("</ul>");
     out.println("</div>");
     out.println("</body>");
     out.println("</html>");
     out.flush();  // 출력스트림 안에 남아 있는 것이 있으면 다 밀어낸다.
     out.close();  // 출력스트림은 내보내고 반드시 닫아줘야 한다.
     
     
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}