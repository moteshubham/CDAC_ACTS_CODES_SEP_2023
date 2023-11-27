package dao;

import java.util.List;

import pojos.Player;
import pojos.Team;

public interface TeamDao {
	String addNewTeam(Team team);
	//add a method to get abbr of all teams
	List<String> getAllTeamsAbbr();
	Team getDetailsByTeamAbbr(String abbr);
}
