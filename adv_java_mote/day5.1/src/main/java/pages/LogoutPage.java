package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	// doGet
	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in logout page ");
		// 1. set resp cont type
		rs.setContentType("text/html");
		// 2. get PW : to send resp from servlet ---> web clnt
		try (PrintWriter pw = rs.getWriter()) {
			// 3. get Session from WC
			HttpSession session = rq.getSession();
			System.out.println("session id from logout page "+session.getId());
			// get user details from the session scope
			User user = (User) session.getAttribute("clnt_details");

			if (user != null) {
				pw.print("<h5> Hello " + user.getFirstName() + "</h5>");
				// HttpSession : exists
				// chk if voter has alrdy voted
				if (user.isVotingStatus()) {
					pw.print("<h5>You have already voted !!!!!!!!!!!!!!!!</h5>");
				} else {
					// not yet voted
					// get daos from the session scope
					UserDaoImpl userDao = (UserDaoImpl) session.getAttribute("user_dao");
					CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
					// update voting status
					pw.print("<h5>" + userDao.updateVotingStatus(user.getUserId()) + "<h5>");
					// incr votes
					int candidateId = Integer.parseInt(rq.getParameter("candidate_id"));
					pw.print("<h5>" + candidateDao.incrementVotes(candidateId) + "<h5>");
				}
			} else
				pw.print("<h4> Session Tracking failed !!!!!!! No cookies.....</h4>");
	
			pw.print("<h5>You have logged out....</h5>");
			session.invalidate();//ends session life cycle!
		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}
