package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.pojos.Player;
import com.app.pojos.Team;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private PlayerDao playerDao;

	@Override
	public String addPlayerToTeam(Player newPlayer, String abbr) {
//		List<String> teamAbbreviations = teamDao.getTeamAbbreviations();
		Team team = teamDao.getTeam(abbr);
		team.addPlayer(newPlayer);
		return playerDao.addPlayerToTeam(newPlayer, team);
	}

//	public Team getTeam(String abbr, Player newPlayer) {
//		Team team = teamDao.getTeam(abbr);
//		team.addPlayer(newPlayer);
//		return team;
//	}
	
// plAYEY dao mei entity mang persist inject dpepedenye // 
}
