package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.User;

public class UserDaoImple implements UserDao {

	private Connection cn;
	private PreparedStatement pst;

	public UserDaoImple() throws SQLException {
		cn = openConnection();
//		pst = cn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
		pst = cn.prepareStatement("SELECT * FROM users where password = ? OR email=? order by email ");
	}
//-------------------------------------------------------------------------------------------------
	@Override
	public List<User> authenticateUser(String email, String password) throws SQLException {
		
		pst.setString(1,  email);
		pst.setString(2, password);
		
		List<User> userList = new ArrayList<User>();

		try (ResultSet rst = pst.executeQuery()) {
			while (rst.next()) {
//				| id | first_name | last_name | email             | password | dob        | status | role  |
				userList.add(new User(rst.getInt(1), rst.getString(2) ,rst.getString(3), rst.getString(4),rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
			}
		}
		return userList;
	}
//-------------------------------------------------------------------------------------------------
	public void cleanUp() throws SQLException {
		if(pst!=null)
			pst.close();
		cn.close();
	}
}
