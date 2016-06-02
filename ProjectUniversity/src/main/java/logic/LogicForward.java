package logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogicForward extends HttpServlet{

	public void forward(HttpServletRequest request, HttpServletResponse response, String send) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(send);
		dispatcher.forward(request, response);
	}
}
