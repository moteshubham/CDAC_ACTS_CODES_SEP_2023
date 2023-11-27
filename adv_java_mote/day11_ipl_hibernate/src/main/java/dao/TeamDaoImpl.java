package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<String> getAllTeamsAbbr() {

		List<String> abbreviations = null;
		String jpql = "select t.abbreviation from Team t";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			abbreviations =  session.createQuery(jpql, String.class).getResultList();
			tx.commit();
		
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("in getAllTeamsAbbr");
			throw e;
		}
		return abbreviations;
	}

	@Override
	public String addNewTeam(Team team) {
	
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(team);
			System.out.println("team obj cerated");
			System.out.println(team);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "added";
	}

	@Override
	public Team getDetailsByTeamAbbr(String abbr) {
		Team team = null;
		String jpql = "select t from Team t where t.abbreviation = :abbr";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
			session.persist(team);
			System.out.println("team obj cerated");
			System.out.println(team);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		return team;
	}

	

}
