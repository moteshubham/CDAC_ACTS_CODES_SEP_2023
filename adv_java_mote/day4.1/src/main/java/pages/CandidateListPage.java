package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	// doGet
	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in candidate list page ");
		// 1. set resp cont type
		rs.setContentType("text/html");
		// 2. get PW : to send resp from servlet ---> web clnt
		try (PrintWriter pw = rs.getWriter()) {
			// generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h5>Welcome Voter </h5>");
			// send validated user details retrieved from a cookie
			// 1. get cookies
			Cookie[] cookies = rq.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("user_info"))
						pw.print("<h4>Voter Details " + c.getValue() + "</h4>");
			} else // => no cookies
				pw.print("<h4> Session Tracking failed !!!!!!! No cookies.....</h4>");

		}
	}

}
