package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;
import pojos.Player;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addNewPlayer(Player player, Long teamId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			session.save(player);
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
