package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WC's map's entry : key : /test1 , value : pages.Servlet1
@WebServlet("/test1")
public class Servlet1 extends HttpServlet{
	//doGet
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in do-get");
		//1. set resp cont type
		rs.setContentType("text/html");
		//2. get PW : to send resp from servlet ---> web clnt
		try(PrintWriter pw=rs.getWriter()) {
			//generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h5>Welcome to Servlets !"+LocalDateTime.now()+"</h5>");
		}//pw.close -->pw flush ---> send resp buf contents in resp pkt --->sent to client
	}

}
