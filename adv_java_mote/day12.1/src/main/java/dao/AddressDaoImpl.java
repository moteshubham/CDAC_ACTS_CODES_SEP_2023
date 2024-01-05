package dao;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDaoImpl implements AddressDao {

	@Override
	public List<String> DisplayLastNamesOfEmpsByCity(String city) {
		String mesg = "Dsiplay lastnames  failed!!!!!";
//		2.5 Display last names of all emps from specified city.
		Session session = getFactory().getCurrentSession();
		List<String> lastNames = new ArrayList<>();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select a.emp.lastName from Address a where a.city = :city";
			lastNames = session.createQuery(jpql, String.class).setParameter("city", city).getResultList();

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return lastNames;

	}

}
