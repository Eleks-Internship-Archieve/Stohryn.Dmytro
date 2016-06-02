package controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import logic.LogicForward;
import model.Registration;
import dao.RegistrationDAO;

public class ControllerStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllerStart() {
        super();
    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						doPost(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String submitLoginIn = request.getParameter("submitLoginIn");
			String submitRegistration = request.getParameter("submitRegistration");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter	printWriter = response.getWriter();
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			if(submitLoginIn != null){
				Registration registration = new RegistrationDAO().getLoginAndPassword(login, password);		
				if(registration != null){
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(15*60);;
					session.setAttribute("login", login);
					session.setAttribute("password", password);
					new LogicForward().forward(request, response,"/home");
				}else{
					request.setAttribute("eror","Введені дані неправильні");
					new LogicForward().forward(request, response,"/view/ErorPage.jsp");
				}
			}else{
				if(submitRegistration != null){
					request.setAttribute("login", login);
					request.setAttribute("password", password);
					new LogicForward().forward(request, response,"/view/RegistrationPage.jsp");
				}else{
					request.setAttribute("eror","сервлет був запущений без натискання клавіш LoginIn або Registration");
					new LogicForward().forward(request, response,"/view/ErorPage.jsp");
				}
			}
		}
}
