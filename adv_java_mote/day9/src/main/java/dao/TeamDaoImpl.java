package dao;

import pojos.Team;
import org.hibernate.*;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Added new Team with ID " + newTeam.getTeamId();
	}

	@Override
	public Team displayteamDetails(String abbr) {

		String jpql = "select e from Team e where e.abbreviation=:abbr";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Team t =null;
		try {
			 t = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return t;
	}

	@Override
	public List<Team> findTeamsMaxAge(int age) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select t from Team t where t.maxAge > :age";
		List<Team> t = null;
		
		try {
			t = session.createQuery(jpql, Team.class)
					.setParameter("age", age)
					.getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!= null)
				tx.rollback();
			throw e;
		}
		return t;
	}

	@Override
	public Team updateTeamWickets(int wickets, double batAvg, int teamId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Team t = null;
		try {
			t = session.get(Team.class, teamId);
			t.setMinWicketsTaken(wickets);
			t.setMinBattingAvg(batAvg);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return t;
	}

	

}
