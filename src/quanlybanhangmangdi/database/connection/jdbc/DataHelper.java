package quanlybanhangmangdi.database.connection.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHelper {
	
	public static ResultSet execQuery(String query) {
		try {
			Connection conn = ConnectionUtils.getMyConnection();
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			return rs;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean execAction(String query) {
		try {
			Connection conn = ConnectionUtils.getMyConnection();
			Statement statement = conn.createStatement();
			statement.execute(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
 