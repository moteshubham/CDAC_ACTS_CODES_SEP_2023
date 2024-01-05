package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Player player, Integer teamId) {
		String mesg = "adding player to tea failsed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team t = session.get(Team.class, teamId);
			if(t != null) {
				//team : PERSISTENT
				t.addPlayer(player);
				mesg = "Added player to team";
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
