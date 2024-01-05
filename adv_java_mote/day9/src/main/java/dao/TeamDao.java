package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to insert new team details
	String addTeamDetails(Team newTeam);
	Team displayteamDetails(String abbr);
	List<Team> findTeamsMaxAge(int age);
	Team updateTeamWickets(int wickets, double batAvg, int teamId);
}
