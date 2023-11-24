package tester;

import org.hibernate.*;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTeamsMaxAge {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("hibernate booted successfully ! " + sf);
			TeamDao dao = new TeamDaoImpl();
			System.out.println("enter age ");
			List<Team> t = new ArrayList<Team>();
			t = dao.findTeamsMaxAge(sc.nextInt());
			t.forEach(e -> {
				System.out.println(e);
			});
		} // sf.close() --> DBCP cleaned up ...
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
