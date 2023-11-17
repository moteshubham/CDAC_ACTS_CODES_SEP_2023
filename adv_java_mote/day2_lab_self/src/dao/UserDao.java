package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.User;

public interface UserDao {
	 List<User> authenticateUser(String email, String password) throws SQLException;
//	 void VoterCountUpdate() throws SQLException;
}
