package quanlybanhangmangdi.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHelper {
	public static Connection connection = null;
	public static ResultSet execQuery(String query) {
		try {
			if(connection == null) {
			connection = ConnectionUtils.getMyConnection();
			}
			Statement statement = connection.createStatement();
			
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
			if(connection == null) {
				connection = ConnectionUtils.getMyConnection();
			}
			Statement statement = connection.createStatement();
			statement.execute(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
 