package com.utils;

import java.sql.*;

public class DbHelper {
	private DbHelper(){
		
	}
	
	private static DbHelper __instance = null;
	
	public static synchronized DbHelper getInstance(){
		if(null == __instance){
			synchronized(DbHelper.class){
				if(null == __instance){
					__instance = new DbHelper();
				}
			}			
		}
		
		return __instance;
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
	
	public int QueryDataRowCount(String selectCountSql) throws Exception{
		if(!selectCountSql.trim().toUpperCase().startsWith("SELECT COUNT")){
			throw new Exception("This method only for the usage of query dataset row count");
		}
		sqlConnection = CreateConnection();
		if(null != sqlConnection){
			statement = sqlConnection.createStatement();
			resultSet = statement.executeQuery(selectCountSql);
		}
		if(resultSet.next()){
			return resultSet.getInt(1);
		}
		return 0;
	}
	
	public String JSONData(String selectSql) throws SQLException {
		resultSet = QueryData(selectSql);
		String content = "";
		while(null != resultSet && resultSet.next()){
			content += String.valueOf(resultSet.getInt("EmployeeID")); 
			content += ":" + resultSet.getString("NationalIDNumber");
			content += ":" + resultSet.getString("Title");
			content += ":" + resultSet.getDate("BirthDate") + ";";
		}
		
		return content;
	}
	
	public void ReleaseMemory(){
		if(null != resultSet) try { resultSet.close(); } catch (Exception e){}
		if(null != statement) try { statement.close(); } catch (Exception e){}
		if(null != sqlConnection) try { sqlConnection.close(); } catch (Exception e){}
	}
	
//	public static void main(String[] args) {
//		DbHelper helper = new DbHelper();
//		try {
//			System.out.println(helper.JSONData("SELECT * FROM HumanResources.Employee"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		helper.ReleaseMemory();
//	}
}
