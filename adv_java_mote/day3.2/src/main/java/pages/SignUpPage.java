package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class SignUpPage
 */
@SuppressWarnings("serial")
@WebServlet("/signup")
public class SignUpPage extends HttpServlet {
	private UserDaoImpl user;
	private String registerNewVoter;
	
	@Override
	public void init() throws ServletException {
		try {
			 user = new UserDaoImpl();
			
		} catch (SQLException e) {
			throw new ServletException("asdad", e);
		}
	}
	
	@Override
	public void destroy() {
		try {
			user.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("asd",e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		resp.setContentType("text/html");
			
		try(PrintWriter pw = resp.getWriter()){
			String firstName = req.getParameter("fname");
			String lastName = req.getParameter("lname");
			String email =  req.getParameter("em");
			String password = req.getParameter("pass");
			LocalDate dateB = LocalDate.parse(req.getParameter("dob"));
			int age = Period.between(dateB, LocalDate.now()).getYears();
			if (age<21) {
				throw new ServletException("not matured enough");
			}
			else {
				User userNew = new User(firstName, lastName, email, password, Date.valueOf(dateB));
				try {
					registerNewVoter = user.registerNewVoter(userNew);
					 pw.write(registerNewVoter);
				} catch (SQLException e) {
					
					throw new ServletException("erroe creating", e);
				}
			}
			
		}
		
	}

}
