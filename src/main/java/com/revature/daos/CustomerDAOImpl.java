package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customer;

import utils.JDBCConnection;

public class CustomerDAOImpl implements CustomerDAO {
	
	static Connection conn = JDBCConnection.makeConnection();
	private static Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

	@Override
	public Customer getCustomerById(int num) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select id, name, username, join_date from bankcustomer where id = ?");
			logger.debug("finding customer record for " + num);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setUsername(rs.getString(3));
				Date myDate = rs.getDate(4);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String transDate = myDate.toString();
				System.out.println(transDate);
				customer.setJoin_date(transDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("customer record could not be found", e);
			e.printStackTrace();
		}

		return customer;
	}

}
