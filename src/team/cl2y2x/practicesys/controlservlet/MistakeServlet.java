package team.cl2y2x.practicesys.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.cl2y2x.practicesys.factory.ServiceFactory;

public class MistakeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html");
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("/main_student.jsp").forward(request, response);
			return;
		}
		try {
			if(!ServiceFactory.getLoginServiceInstance().isValidate(request) && !action.equals("login")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(action.equals("mistake")) {//�鿴����
			try {
				ServiceFactory.getMistakeServiceInstance().getMistake(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/mistake_show.jsp").forward(request, response);
		} else {
			
		}
	}
}
