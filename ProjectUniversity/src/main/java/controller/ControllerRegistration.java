package controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import logic.LogicForward;
import model.Registration;
import dao.RegistrationDAO;

public class ControllerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllerRegistration() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						doPost(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			String accessLevel=null;
			if(password == confirmPassword){
				accessLevel = (String) request.getAttribute("accessLevel");
				if(accessLevel.equals("student")){
					new RegistrationDAO().setParameters(login, password);
				}else{
					if(accessLevel.equals("teacher")){
						new RegistrationDAO().setParameters(login, password);
					}else{
						if(accessLevel.equals("admin")){
							new RegistrationDAO().setParameters(login, password);
						}else{
							request.setAttribute("eror","жоден accessLevel не вибраний");
							new LogicForward().forward(request, response,"/view/ErorPage.jsp");
						}
					}
				}
			
			}
			HttpSession session =  request.getSession();
			session.setMaxInactiveInterval(15*60);
			session.setAttribute("login", login);
			session.setAttribute("password", password);
			new LogicForward().forward(request, response, "/home");
			
			
/*			//			String login = (String)request.getAttribute("login");
//			String password = (String)request.getAttribute("password");
//				request.setAttribute("description", "реєстрація");
//				new LogicForward().forward(request, response,"/view/RegistrationPage.jsp");
			PrintWriter printWriter = response.getWriter();
			printWriter.print("OK");*/
		}

}
