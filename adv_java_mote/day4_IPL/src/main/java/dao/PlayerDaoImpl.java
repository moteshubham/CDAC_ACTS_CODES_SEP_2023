package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.*;
import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {

	private Connection cn;
	private PreparedStatement pst1;

	public PlayerDaoImpl() throws SQLException {
		cn = openConnection();
//		  first_name | last_name | dob | batting_avg | wickets_taken | team_id |
		pst1 = cn.prepareStatement("insert into players values ( 104,?, ?, ? ,? , ?, ?)");
		System.out.println("Player dao created");
	}

	@Override
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		System.out.println(newPlayer.getFirstName());
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, newPlayer.getTeamId());
		if(pst1.executeUpdate() == 1) {
			System.out.println("\"Player added successfully\"");
		}
		else {
			System.out.println("cant add player error");
		}
		System.out.println(newPlayer.getFirstName()+"  qury executed");
//		try(pst1.executeQuery()) {
//			if(rst.next()) {				
//				return "Player added successfully";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}
	public void cleanUp() throws SQLException {
		if(pst1 != null) {
			pst1.close();
		}
		closeConnection();
	}

}
