package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Woodstox;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// һ�㶼����doGet()�����е���doPost()������������doPost()�����е���doGet()����
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ����ʽ�����Է�ֹ�������
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// ��ȡ�û��ύ�������û��������룬��ͨ������input��name���Ի�ȡ��
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username + ":" + password);
		// ��ȡ��������û���ʾ��Ϣ��Ҳ������ת�������ض���
		PrintWriter pw = response.getWriter();
		if ("admin".equals(username) && "123".equals(password)) {
			pw.write("login success");
			request.getRequestDispatcher("/wood.jsp").forward(request, response);
			/*
			 * Ҫ�ȴ���success.jsp�ļ�
			 */
			// ת��
			// request.getRequestDispatcher("success.jsp").forward(request,
			// response);;
			// �ض���
			// response.sendRedirect("success.jsp");
		} else {
			pw.write("login fail");
			/*
			 * Ҫ�ȴ���fail.jsp�ļ�
			 */
			// ת��
			// request.getRequestDispatcher("fail.jsp").forward(request,
			// response);;
			// �ض���
			// response.sendRedirect("fail.jsp");
		}
	}
}
