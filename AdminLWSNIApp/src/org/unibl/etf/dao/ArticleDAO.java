package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.Article;


public class ArticleDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL_ARTICLES = "SELECT * FROM article WHERE active = 1 ";
	private static final String SQL_INSERT = "INSERT INTO article (name, price, active) VALUES (?,?,?)";	
	private static final String SQL_UPDATE_ARTICLE = "UPDATE article SET name = ?, price= ?, active = ? where id = ? ";	
	private static final String SQL_UPDATE_ARTICLE_TO_INACTIVE = "UPDATE article SET active = 0 where id = ? ";
	
	
	
	public static ArrayList<Article> getAllArticless() {
		ArrayList<Article> usersArrayList = new ArrayList<Article>();
		Connection connection = null;
		ResultSet rSet = null;
		Object values[] = {};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL_ARTICLES, false, values);
			rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				Article user = new Article(rSet.getInt("id"), rSet.getString("name"),rSet.getDouble("price"),rSet.getBoolean("active"));
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
	
	public static boolean add (Article article) {
		boolean result = false;
		Connection conn = null;
		ResultSet generatedKeys = null;
				
		Object values[] = {article.getName(), article.getPrice(), article.isActive() };
		try {
			conn = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(conn, SQL_INSERT, true, values);
			preparedStatement.executeUpdate();
			generatedKeys = preparedStatement.getGeneratedKeys();
			
			if(preparedStatement.getUpdateCount() > 0) {
				result = true;
			}
			if(generatedKeys.next()) {
				article.setId(generatedKeys.getInt(1));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(conn);
		}
		return result;
	}
	
	public static boolean updateArticle(Article article) {
		boolean result = false;
		Connection connection = null;
		Object[] values = {article.getName(), article.getPrice(), article.isActive(), article.getId()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_UPDATE_ARTICLE, true, values);
			int queryResult = preparedStatement.executeUpdate();
			if(queryResult != 0) {
				result = true;
			} else {
				result = false;
			}
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}
	
	public static boolean updateArticleToInactive(Article article) {
		boolean result = false;
		Connection connection = null;
		Object[] values = {article.getId()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_UPDATE_ARTICLE_TO_INACTIVE, true, values);
			int queryResult = preparedStatement.executeUpdate();
			if(queryResult != 0) {
				result = true;
			} else {
				result = false;
			}
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}

}
