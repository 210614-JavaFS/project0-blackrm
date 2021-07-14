package utils;
import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnection {
	
	private static Logger logger = LoggerFactory.getLogger(JDBCConnection.class);;

	static Connection conn;
	public static Connection makeConnection() {
		// TODO Auto-generated method stub
		//configure
		String url = "jdbc:postgresql://training.cfqhajquodzh.us-east-2.rds.amazonaws.com/postgres";
		String user = "postgres";
		String password = "postgres";
		
		//connect
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
		
		
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
