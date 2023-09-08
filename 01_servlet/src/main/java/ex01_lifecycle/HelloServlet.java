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
 * �����̶�?
 * 1. �� �������� ���ؼ� ����Ǵ� Java Ŭ�����̴�.
 * 2. Ŭ���̾�Ʈ�� ��û�� ���� �� �ִ� Java Ŭ�����̴�.
 * 3. javax.servlet.http.HttpServlet Ŭ������ ��� �޴´�.
 * 4. jsp/servlet container(��Ĺ)�� ����Ǳ� ������ ������ �̸��� ������ 2�� �̻� ���� �� ����.
 * 5. ������ ���� Ŭ���̾�Ʈ���� ������ �� �ִ�.
 */

/*
 * URL
 * 
 * 1. ����
 *  protocol://host:port/ContextPath/URLMapping
 * 2. ContextPath
 *  1) ������Ʈ�� ����� �� ������ �⺻ ��θ� �ǹ��Ѵ�. (Context Root)
 *  2) ���� ���
 *    ������Ʈ �Ӽ�(properties) - Web Project Settings
 *  3) URLMapping
 *    1) ������ ���� ��θ� �ǹ��Ѵ�. (URL Pattern)
 *    2) ���� ���
 *      (1) @WebServlet �ֳ����̼�
 *      (2) ������Ʈ src/main/webapp/WEB-INF/web.xml
 */

@WebServlet("/HelloServlet")

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  /**
   * 1. ������
   *  1) ���� ������ �� ȣ��ȴ�. (���� ���� ȣ��ȴ�.)
   *  2) ���� ���� �� �ڵ����� init() �޼ҵ尡 ȣ��ȴ�.
   *  
   * @see HttpServlet#HttpServlet()
   */
  public HelloServlet() {
      super();
      // TODO Auto-generated constructor stub
      System.out.println("1. HelloServlet() ������ ȣ��");
  }

	/**
	 * 2. init()
	 *   1) ���� ȯ�� ������ ����ϴ� �޼ҵ��̴�.
	 *   2) init() �޼ҵ� ȣ�� �� �ڵ����� service() �޼ҵ尡 ȣ��ȴ�.
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	  System.out.println("2. init() �޼ҵ� ȣ��");
	}

	/**
	 * 3. service()
	 *   1) Ŭ���̾�Ʈ�� ��û�� �� �ڵ����� ȣ��Ǵ� �޼ҵ��̴�.
	 *   2) Ŭ���̾�Ʈ�κ��� ��û�� ���� �� �ְ�, Ŭ���̾�Ʈ���� ������ �� �ִ�.
	 *   3) ��û�� ó���ϴ� Ŭ���� : javax.servlet.http.HttpServletRequest
	 *   4) ������ ó���ϴ� Ŭ���� : javax.servlet.http.HttpServletResponse
	 *   5) service() �޼ҵ尡 ������ doGet() �Ǵ� doPost()�� ���� �޼ҵ尡 ��û �޼ҵ忡 ���� �ڵ����� ȣ��ȴ�.
	 *   
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("3. service() �޼ҵ� ȣ��");
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
	 *     (2) <form method="get" action="/servlet/HelloServlet">
	 *     (3) location.href = '/servlet/HelloServlet'
	 *     (4) window.open('/servlet/HelloServlet', '', '')
	 *     (5) $.ajax({
	 *           type: 'get',
	 *           url: '/servlet/HelloServlet',
	 *           ...
	 *         })
	 *   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("4. doGet() �޼ҵ� ȣ��");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 5. doPost()
	 *   1) POST ����� ��û�� ó���ϴ� �޼ҵ��̴�.
	 *   2) �⺻������ POST ����� ��û�� ������ doGet()���� ó���� �̰��Ѵ�.
	 *   3) POST ������� ��û�ϴ� ���
   *     (1) <form method="post" action="/servlet/HelloServlet">
   *     (2) $.ajax({
   *           type: 'post',
   *           url: '/servlet/HelloServlet',
   *           ...
   *         })
	 *   
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("4. doPost() �޼ҵ� ȣ��");
		doGet(request, response);
	}
  
}