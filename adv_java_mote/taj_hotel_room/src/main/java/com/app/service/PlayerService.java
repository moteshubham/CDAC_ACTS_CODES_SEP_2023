package com.app.service;

import com.app.pojos.Player;
import com.app.pojos.Team;

public interface PlayerService {
	String addPlayerToTeam(Player newPlayer, String abbr);
	//public Team getTeam(String abbr,Player newPlayer); 
}
