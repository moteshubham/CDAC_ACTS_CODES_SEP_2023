package tester;

import java.util.List;
import java.util.Scanner;

import dao.UserDaoImple;
import pojos.User;

public class UserTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImple usr = new UserDaoImple();
			System.out.println("Enter username and password");
			
			List<User> list = usr.authenticateUser(sc.next(), sc.next());
			list.forEach(System.out::println);
			
			usr.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
