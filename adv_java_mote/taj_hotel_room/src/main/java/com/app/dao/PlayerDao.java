package com.app.dao;

import com.app.pojos.Player;
import com.app.pojos.Team;

public interface PlayerDao {
	public String addPlayerToTeam(Player newPlayer, Team team) ;
}
