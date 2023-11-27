package tester;

import static utils.HibernateUtils.getFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class Test1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			TeamDao dao = new TeamDaoImpl();
			System.out.println("Enter new Team details :   name,  abbreviation,  owner, int maxAge, double minBattingAvg,\r\n"
					+ "			int minWicketsTaken");
			System.out.println(dao.addNewTeam(new Team( "chennai chi team", "csk" , "malya", 35, 90.5, 9)));

			
//			System.out.println("entr string firstName, String lastName, Date dob, double battingAvg, int wicketsTaken");
//			PlayerDao dao1 = new PlayerDaoImpl();
//			System.out.println(dao1.addNewPlayer(
//					new Player("shubham", "mote", Date.valueOf(LocalDate.parse("1996-07-22")), 98, 9), 1l));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
