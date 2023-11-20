package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {
//add a method to get all candidate details
	List<Candidate> getAllCandidates() throws SQLException;
	//add a method to inc votes
	String incrementVotes(int candidateId) throws SQLException;
}
