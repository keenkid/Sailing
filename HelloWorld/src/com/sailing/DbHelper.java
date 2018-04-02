package com.sailing;

import java.sql.*;

//import com.microsoft.sqlserver.jdbc.*;

public class DbHelper {
	public DbHelper(){
		
	}
	
	private Connection sqlConnection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	private Connection CreateConnection() throws SQLException{
		String connectionString = "jdbc:sqlserver://AP-CHN-LP150074\\SQLEXPRESS:1433;databaseName=AdventureWorks;user=sa;password=maoyufeng";
		
		return DriverManager.getConnection(connectionString);
	}
	
	public ResultSet QueryData(String selectSql){
		try{			
			sqlConnection = CreateConnection();
			if(null != sqlConnection){
				statement = sqlConnection.createStatement();
				resultSet = statement.executeQuery(selectSql);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void ReleaseMemory(){
		if(null != resultSet) try { resultSet.close(); } catch (Exception e){}
		if(null != statement) try { statement.close(); } catch (Exception e){}
		if(null != sqlConnection) try { sqlConnection.close(); } catch (Exception e){}
	}
}