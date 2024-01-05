package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import static utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

	/**
	 * @see Servlet#init()
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("in init of " + getClass());
		try {
			// open cn : singleton
			openConnection();
			// create user dao n candidate dao instance
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();

		} catch (Exception e) {
			// centralized err handling
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass());
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			// inform WC about the err : OPTIONAL !
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get PW to send buffered text resp to the clnt
		try (PrintWriter pw = response.getWriter()) {
			// 3. Read req params
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// 4. invoke user dao's method for auth
			User user = userDao.authenticateUser(email, pwd);
			if (user == null) // => invalid login
				pw.print("<h4> Invalid Login Please <a href='login.html'>Retry</a></h4>");
			else // login successful
			{
				// 1.get HttpSession from WC
				HttpSession hs = request.getSession();
				System.out.println("session id from login page " + hs.getId());
				// 2. save user details under session scope
				hs.setAttribute("clnt_details", user);
				// 2.1 store user dao n candidate dao under session scope
				hs.setAttribute("user_dao", userDao);
				hs.setAttribute("candidate_dao", candidateDao);
				// role based authorization
				if (user.getRole().equals("admin"))
					response.sendRedirect("admin_page");
				else { // voter role
					if (user.isVotingStatus()) // alrdy voted voter
						response.sendRedirect("logout");
					else // not yet voted
						response.sendRedirect("candidate_list");
					/*
					 * WC : sends temp resp SC 302 | Header Location: candidate_list , Set-Cookie:
					 * JSESSIONID : dagd54654gfshf, body : EMPTY def age of cookie = -1 Next req :
					 * http://host:port/day5.1/candidate_list , method=GET , hdr : Cookie :
					 * JSESSIONID : fdhf6764gfhgd
					 */
				}
			}
		} catch (Exception e) {
			throw new ServletException("err in do-post" + getClass(), e);
		}
	}

}
