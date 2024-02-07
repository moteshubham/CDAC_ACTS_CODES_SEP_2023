package com.app.dao;

import java.util.List;

import com.app.pojos.Team;

public interface TeamDao {
	List<String> getTeamAbbreviations();
	Team getTeam(String abbr);
}
