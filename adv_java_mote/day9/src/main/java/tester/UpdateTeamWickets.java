package tester;
import org.hibernate.*;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class UpdateTeamWickets {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			System.out.println("hibernate booted successfully ! "+sf);
			TeamDao dao = new TeamDaoImpl();
			
			System.out.println("enter wickets, bat avg and team id");
			Team t =  dao.updateTeamWickets(sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(t);
 			
			
		} //sf.close() --> DBCP cleaned up ...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
