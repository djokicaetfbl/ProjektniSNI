package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.User;

public class UserDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user WHERE active = 1 ";
	
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> usersArrayList = new ArrayList<User>();
		Connection connection = null;
		ResultSet rSet = null;
		Object values[] = {};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_USERS, false, values);
			rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				User user = new User(rSet.getInt("id"), rSet.getString("username"),rSet.getString("password"), rSet.getString("roles"),rSet.getBoolean("active"));
				usersArrayList.add(user);
			}
			preparedStatement.close();
			return usersArrayList;
		} catch (SQLException e) {
			
		} finally {
			connectionPool.checkIn(connection);
		}
		return null;
	}

}
