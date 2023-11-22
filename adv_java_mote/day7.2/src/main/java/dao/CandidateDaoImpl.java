package dao;

import static utils.DBUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public CandidateDaoImpl() throws SQLException {
		// open cn
		cn = getCn();
		// pst1 : to get all candidates
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst4 = cn.prepareStatement("select party,sum(votes) from candidates group by party");
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		// create empty List
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	@Override
	public String incrementVotes(int candidateId) throws SQLException {
		// set IN param
		pst2.setInt(1, candidateId);
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Votes incremented.....";
		return "Votes incr failed......";
	}

	@Override
	public List<Candidate> getTop2Candidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	@Override
	public LinkedHashMap<String, Integer> getPartywiseVotes() throws SQLException {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				map.put(rst.getString(1), rst.getInt(2));
		}
		return map;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();

		System.out.println("candidate dao cleaned up....");
	}

}
