package tester;
import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()) {
			System.out.println("hib up n running....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
