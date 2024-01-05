package tester;
import java.sql.*;
import static utils.DBUtils.openConnection;

public class TestDBConnection {

	public static void main(String[] args) {
		try(Connection connection=openConnection()) {
			System.out.println("connected to DB "+connection);//com.mysql.cj.jdbc.ConnectionImpl@563567
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
