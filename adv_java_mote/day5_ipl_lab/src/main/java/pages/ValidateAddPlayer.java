package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImp;
import dao.TeamDaoImpl;
import pojos.Team;


@WebServlet("/ValidateAddPlayer")
public class ValidateAddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			PlayerDaoImp playerDao =(PlayerDaoImp)session.getAttribute("player_dao");
			TeamDaoImpl teamDao =(TeamDaoImpl)session.getAttribute("team_dao");
			
			if(teamDao != null) {
				String abbr = request.getParameter("abbrevation");
				Team team = teamDao.getTeamDetails(abbr);
				String fname = request.getParameter("nm");
				String lname = request.getParameter("lnm");
				LocalDate dob  = LocalDate.parse(request.getParameter("dob"));
				double batavg = Double.parseDouble(request.getParameter("avg"));
				int wickets = Integer.parseInt(request.getParameter("wickets"));
				int age= Period.between(dob, LocalDate.now()).getYears();
				if(age<team.getMaxAge() && batavg > team.getMinBattingAvg()) {
					
				}
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
