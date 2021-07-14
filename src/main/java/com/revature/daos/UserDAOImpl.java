package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.User;

import utils.JDBCConnection;

public class UserDAOImpl implements UserDAO{
	
	static Connection conn = JDBCConnection.makeConnection();
	private static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Override
	public User logInUser(String username, String pwd) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, "
					+ "username, pwd, role from bankuser where username = ? and pwd = ?");
			logger.debug("logging in");
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			logger.error("couldn't log in", e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public ArrayList<User> findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, username, pwd, role from bankuser where username = ?");
			logger.debug("finding user with username " + username);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("user record could not be found", e);
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void createNewUser(User user) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into bankuser(id, username, pwd, role) values (default, ?,?,?)");
			logger.debug("creating new user");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, "CUSTOMER");
			int k = pstmt.executeUpdate();
			System.out.println(k + " user added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("could not create new user", e);
			e.printStackTrace();
		}
	}

}
