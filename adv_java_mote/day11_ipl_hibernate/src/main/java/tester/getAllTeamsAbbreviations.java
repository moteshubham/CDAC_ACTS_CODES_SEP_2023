package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class getAllTeamsAbbreviations {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			TeamDao dao = new TeamDaoImpl();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
