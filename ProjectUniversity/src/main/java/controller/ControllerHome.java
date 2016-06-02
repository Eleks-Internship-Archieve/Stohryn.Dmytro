package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.LogicForward;
import model.Registration;
import dao.RegistrationDAO;

public class ControllerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllerHome() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						doPost(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String login = (String)request.getSession().getAttribute("login");
			String password = (String)request.getSession().getAttribute("password");
			Registration registration = new RegistrationDAO().getLoginAndPassword(login, password);		
			if(registration != null){
				request.setAttribute("description", "домашня сторінка");
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				new LogicForward().forward(request, response,"/view/HomePage.jsp");
				
			}
			
		}
}
