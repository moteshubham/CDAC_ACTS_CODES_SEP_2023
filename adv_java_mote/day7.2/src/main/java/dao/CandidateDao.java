package dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {
//add a method to get all candidate details
	List<Candidate> getAllCandidates() throws SQLException;

	// add a method to inc votes
	String incrementVotes(int candidateId) throws SQLException;

	// add a method to get top 2 candidates
	List<Candidate> getTop2Candidates() throws SQLException;

	// add a method to get party wise votes
	LinkedHashMap<String, Integer> getPartywiseVotes() throws SQLException;

}
