package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.User;

public interface UserDao {
	public List<User> authenticateUser(String email, String password) throws SQLException;
}
