package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import pojos.Player;
import pojos.Team;

import  static utils.DBUtils.*;
/**
 * Servlet implementation class IPLTeam
 */
@WebServlet("/authenticatePlayer")
public class ValidateAndAddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDao playerDao;
	private Team team;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			playerDao = new PlayerDaoImpl();
		} catch (SQLException e) {
			
			throw new ServletException("ky zla abho ", e);
		}
		System.out.println("new player created in servlet iplteam");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			String teamName  = request.getParameter("team");
			String firstName = request.getParameter("fname");
			String lastName  = request.getParameter("lname");
			LocalDate dob  = LocalDate.parse(request.getParameter("dob"));
			double batAvg  = Double.parseDouble(request.getParameter("batavg"));
			int wickets  = Integer.parseInt( request.getParameter("wkt"));
			int teamId  = Integer.parseInt( request.getParameter("teamid"));
					
			int age = Period.between(dob, LocalDate.now()).getYears();
			
			Player newPlayer = new Player(firstName, lastName, Date.valueOf(dob), batAvg, wickets, teamId);
			pw.print(newPlayer);
			String msg = playerDao.addPlayerToTeam(newPlayer, teamId);
					if(msg!=null) {
						pw.print("<h4>saved</h4>");
						pw.print(newPlayer);
					}
					else {
						pw.print("<h4>nullll</h4>");
					}
			}catch(Exception e) {
			throw new RuntimeException("error while post method execution");
		}
				
	}

}
