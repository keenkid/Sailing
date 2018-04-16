package com.sailing;

import java.sql.*;

public class DbHelper {
	public DbHelper(){}
	
	private Connection sqlConnection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	private Connection CreateConnection() throws Exception{
		//String connectionString = "jdbc:sqlserver://AP-CHN-LP150074\\SQLEXPRESS:1433;databaseName=AdventureWorks;user=sa;password=maoyufeng";
		String connectionString = "jdbc:mysql://localhost:3306/keenkid?user=keenkid&password=maoyufeng&useSSL=false";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(connectionString);
	}
	
	public ResultSet QueryData(String selectSql) throws Exception{
		try{			
			sqlConnection = CreateConnection();
			if(null != sqlConnection){
				statement = sqlConnection.createStatement();
				resultSet = statement.executeQuery(selectSql);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public int UpdateData(String updateSql) throws Exception{
		int effectedRows = 0;
		
		try{
			sqlConnection = CreateConnection();
			if(null != sqlConnection){
				statement = sqlConnection.createStatement();
				effectedRows = statement.executeUpdate(updateSql);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sqlConnection.close();
		}
		
		return effectedRows;
	}
	
	public void ReleaseMemory(){
		if(null != resultSet) try { resultSet.close(); } catch (Exception e){}
		if(null != statement) try { statement.close(); } catch (Exception e){}
		if(null != sqlConnection) try { sqlConnection.close(); } catch (Exception e){}
	}
}