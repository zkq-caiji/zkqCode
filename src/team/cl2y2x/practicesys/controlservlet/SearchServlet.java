package team.cl2y2x.practicesys.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.cl2y2x.practicesys.factory.ServiceFactory;

public class SearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		if(action.equals("search")) {//หัฬโ
			
			request.getRequestDispatcher("/search_main.jsp").forward(request, response);
		} else if (action.equals("result")) {//
			try {
				ServiceFactory.getSearchServiceInstance().search(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/search_result.jsp").forward(request, response);
		} else {
			
		}
	}
	
}
