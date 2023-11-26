package dao;

import java.sql.SQLException;
import java.util.List;
import pojos.Team;

public interface TeamDao {
	// add a method to get abbreviations of all teams
	List<String> getTeamsAbbreviations() throws SQLException;

//add a method to get specific team's details
	Team getTeamDetails(String abbreviation) throws SQLException;
}
