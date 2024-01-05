package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test3",loadOnStartup = 1)
public class Servlet3 extends HttpServlet{

	@Override
	public void destroy() {
		System.out.println("in destroy of  "+getClass());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init of "+getClass());
	}

	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in do-get of "+getClass());
		//1. set resp cont type
		rs.setContentType("text/html");
		//2. get PW : to send resp from servlet ---> web clnt
		try(PrintWriter pw=rs.getWriter()) {
			//generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h5>Welcome to Servlets !"+LocalDateTime.now()+"</h5>");
		}
	}

}
