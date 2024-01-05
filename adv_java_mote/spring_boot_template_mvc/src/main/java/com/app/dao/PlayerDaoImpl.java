package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Player;
import com.app.pojos.Team;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	@Autowired
	private EntityManager manager;

	@Override
	public String addPlayerToTeam(Player newPlayer, Team team) {
		manager.persist(newPlayer);
		System.out.println("player added");
		return "success";
	}

}
