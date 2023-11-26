package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.Player;

public class PlayerDaoImp implements PlayerDao {
	private Connection connection;
	private PreparedStatement pst1;
	public PlayerDaoImp() throws SQLException{
		// get cn
		connection =getCn();
		pst1=connection.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("player dao created");
	}

	@Override
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		// set IN params
		//first_name,last_name, dob,batting_avg,wickets_taken,team_id
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3,newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, teamId);
		//exec update (DML)
		int rows=pst1.executeUpdate();
		if(rows == 1)
			return "New player added to the team....";		
		return "Adding new player failed !!!!!!!!!!!!!";
	}
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		System.out.println("player dao cleaned up....");
	}

}
