package ex02_request;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1. ��û�� UTF-8�� ���ڵ��Ѵ�.
		request.setCharacterEncoding("UTF-8");
		
		// 2. ��û �Ķ���͸� �޴´�. (��û �Ķ���ʹ� ��� String Ÿ���̴�.)
		  //1) ��û �Ķ���ʹ� ��� String Ÿ���̴�.
		  //2) ��û �Ķ���Ͱ� ������ null ������ ó���ȴ�.
		String name = request.getParameter("name");
    String strAge = request.getParameter("age");

    // 3. ��û �Ķ������ Ÿ���� �����Ѵ�.
    // Ÿ���� ������ �� Exception�� �߻����� �ʵ��� ��û �Ķ������ null ó���� �ʿ��ϴ�.
    
    // 1)���� null ó�� 
    /*
    int age = 0;
    if(strAge != null) {
      age = Integer.parseInt(strAge); 
    }
    */
    // 2) null ó���� ���� Optional Ŭ���� ó��
    Optional<String> opt = Optional.ofNullable(strAge);
    int age = Integer.parseInt(opt.orElse("0")); //opt�� ���� strAge�� null �̸� "0"�� ������
    System.out.println(name + "," + age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
