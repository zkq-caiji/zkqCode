package team.cl2y2x.practicesys.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.cl2y2x.practicesys.factory.ServiceFactory;


public class LoginServlet extends HttpServlet {
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
		String status = request.getParameter("status");
		if(action == null || status == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);	
		}
		try {
			if(!ServiceFactory.getLoginServiceInstance().isValidate(request) && !action.equals("login") && !action.equals("register")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(action.equals("login")){
			try {
				if(ServiceFactory.getLoginServiceInstance().validate(request)) {//验证
					if(status.equals("admin")) {
						request.getRequestDispatcher("/main_admin.jsp").forward(request, response);
					} else if(status.equals("student")) {
						request.getRequestDispatcher("/main_student.jsp").forward(request, response);
					} else if(status.equals("teacher")) {
						request.getRequestDispatcher("/main_teacher.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					}				
				} else {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(action.equals("register")){
			try {
				ServiceFactory.getLoginServiceInstance().register(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(action.equals("logout")){
			request.getSession().setAttribute("user", null);
		}
	}

}	
