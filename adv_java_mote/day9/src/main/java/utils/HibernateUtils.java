package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//Create , immutable, inherently thrd safe ,time consuming SF
public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		factory = new Configuration().configure().buildSessionFactory();//configuration ka empty obj banaya, fir populate kkiya, 
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
