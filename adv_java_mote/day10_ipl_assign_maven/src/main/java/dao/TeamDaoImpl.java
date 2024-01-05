package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;
public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Team team) {
		String mesg ="Adding team failed";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save( team);
			System.out.println("team obj cerated");
			System.out.println(team);
			tx.commit();
			mesg = "Team added successfully!";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
			throw e;
		}
		return mesg;
	}

}
