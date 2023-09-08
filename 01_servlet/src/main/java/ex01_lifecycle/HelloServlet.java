package ex01_lifecycle;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 
 *�����̶�?
 *1. �� �������� ���ؼ� ����Ǵ� Java Ŭ�����̴�.
 *2. Ŭ���̾�Ʈ�� ��û�� ���� �� �ִ� Java Ŭ�����̴�.
 *3. javax.servlet.http.HttpServlet Ŭ������ ��� �޴´�.
 *4. jsp/servlet container(��Ĺ)�� ����Ǳ� ������ ������ �̸��� servlet�� 2�� �̻� ���� �� ����.
 *5. ������ ���� Ŭ���̾�Ʈ���� ������ �� �ִ�
 */


/*
 *URL
 * 
 * 1. ����
 *  protocol://host:port/contextPath/URLMapping
 * 2. contxtPath
 *  1) ������Ʈ�� ����� �� ������ �⺻ ��θ� �ǹ��Ѵ�.(Context root)
 *  2) ���� ���
 *    ������Ʈ �Ӽ�(properties) - web Project Settings
 *  3) URLMapping
 *    ������ ���� ��θ� �ǹ��Ѵ� (URL Pattern) 
 *    ������� : @WebServlet �ֳ����̼�
 *               ������Ʈ src/main/webapp/WEB-INF/web.xml
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 1. ������
     *  1) ���� ������ �� ȣ��ȴ�. (���� ���� ȣ��ȴ�)
     *  2) ���� ���� �� �ڵ����� init() �޼ҵ尡 ȣ��ȴ�
     * 
     * @see HttpServlet#HttpServlet()
     * 
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	  System.out.println("2.init() �޼ҵ� ȣ��");
	}

	/**
	 * 3. service() �޼ҵ� 
	 *   1) Ŭ���̾�Ʈ(HTML)�� ��û�� �� �ڵ����� ȣ��Ǵ� �޼ҵ��̴�.
	 *   2) Ŭ���̾�Ʈ�κ��� ��û�� ���� �� �ְ� , �߰��� Ŭ���̾�Ʈ���� ������ �� �ִ�.
	 *   3) ��û�� ó���ϴ� Ŭ����: javax.servlet.http.HttpServletRequest
	 *   4) ������ ó���ϴ� Ŭ����: javax.servlet.http.HttpServletResponse
	 *   5) service() �޼ҵ尡 ������ doGet() �Ǵ� doPost()�� ���� �޼ҵ尡 ��û �޼ҵ忡 ���� �ڵ����� ȣ��ȴ�.
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("3.service() �޼ҵ� ȣ��");
	  // ��û �޼ҵ忡 ���� doGet() �Ǵ� doPost() �޼ҵ� ȣ���ϱ�
	  switch(request.getMethod()) {
	  case "GET": doGet(request, response); break;
	  case "POST": doPost(request, response); break;
	  }
	}

	/**
	 * 4. doGet()
	 *   1) GET ����� ��û�� ó���ϴ� �޼ҵ��̴�.
	 *   2) �⺻������ POST ����� ��û�� ó���ϵ��� �����Ǿ� �ִ�.
	 *   3) GET ������� ��û�ϴ� ���
	 *     (1) <a href="/servlet/HelloServlet">
	 *     (2) <form method= "get" action="/servlet/HelloServlet">
	 *     (3) location.href ='/servlet/HelloServlet'
	 *     (4) window.open('/servlet/HelloServlet', '','')
	 *     (5) $.ajax({
	 *            type: 'get',
	 *            url: '/servlet/HelloServlet',
	 *            ...
	 *         })
	 *     (6) 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("4. doPost() �޼ҵ� ȣ��");
	}

	/**
	 * 5. doPost()
	 *   1) POST ����� ��û�� ó���ϴ� �޼ҵ��̴�.
	 *   2) �⺻������ POST ����� ��û�� ������ doGet()���� ó���� �̰��Ѵ�.
	 *   3) POST ������� ��û�ϴ� ���
	 *     (1) <form method= "post" action="/servlet/HelloServlet">
   *     (2) $.ajax({
   *            type: 'post',
   *            url: '/servlet/HelloServlet',
   *            ...
   *         })
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("4. doPost() �޼ҵ� ȣ��");
		doGet(request, response);
	}

}
