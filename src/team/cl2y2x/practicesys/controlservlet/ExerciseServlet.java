package team.cl2y2x.practicesys.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.cl2y2x.practicesys.factory.ServiceFactory;

public class ExerciseServlet extends HttpServlet{

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
		if(action.equals("question")) {//题目。
			try {
				ServiceFactory.getExerciseServiceInstance().getQuestion(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/exercise_question.jsp").forward(request, response);
		} else if (action.equals("commit")) {//提交，显示结果。
			try {
				ServiceFactory.getExerciseServiceInstance().score(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/exercise_grade.jsp").forward(request, response);
		} else if (action.equals("course")) {//选择课程
			try {
				ServiceFactory.getExerciseServiceInstance().getCourse(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/exercise_course.jsp").forward(request, response);
		} else if (action.equals("paper")) {//获取试卷
			try {
				ServiceFactory.getExerciseServiceInstance().getPaper(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/exercise_coursepaper.jsp").forward(request, response);
		} else {
			
		}
	}
}
