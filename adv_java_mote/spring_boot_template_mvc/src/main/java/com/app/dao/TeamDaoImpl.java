package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Team;

@Repository
public class TeamDaoImpl implements TeamDao {
	//
	@Autowired
	private EntityManager em;

	@Override
	public List<String> getTeamAbbreviations() {

		String jpql = "select t.abbreviation from Team t";
		return em.createQuery(jpql, String.class).getResultList();
	}

	@Override
	public Team getTeam(String abbr) {

		String jpql = "select t.abbreviation from Team t where t.abbreviation = :abbr";
		Team team = em.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
		return team;
	}

}
