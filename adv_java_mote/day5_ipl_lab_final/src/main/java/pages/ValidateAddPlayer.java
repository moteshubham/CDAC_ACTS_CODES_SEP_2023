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
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImp;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;


@WebServlet("/add_player")
public class ValidateAddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				// validate i/ps
				int age = Period.between(dob, LocalDate.now()).getYears();
				if (age < team.getMaxAge() && batavg > team.getMinBattingAvg()
						&& wickets > team.getMinWicketsTaken()) {
					// all valid i/ps , add the player in the team
					// firstName, String lastName, Date dob,
					// double battingAvg, int wicketsTaken
					Player player = new Player(fname, lname, Date.valueOf(dob), batavg, wickets, team.getTeamId());
					// simply call player dao's method , to insert a rec
					pw.print("<h3> Status " + playerDao.addPlayerToTeam(player, team.getTeamId()) + "</h3>");
				} else
					pw.print("<h3 style color='red;'> Can't add player details , Invalid I/ps</h3>");
			} else
				pw.print("<h5> No Cookies !!!!! Can't continue.....</h5>");
		//	session.invalidate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
