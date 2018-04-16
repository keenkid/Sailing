package com.sailing;

import java.sql.*;

public class HelloWorld {

	public static void main(String[] args) {
		DbHelper helper = new DbHelper();
		
		testInsert(helper);
		
		testUpdate(helper);
		
		testQuery(helper);
		
		helper.ReleaseMemory();
	}
	
	private static void testQuery(DbHelper helper){
		String selectSql = "SELECT * FROM CountryCode";
		
		try {
			ResultSet resultSet = helper.QueryData(selectSql);
			while(resultSet.next()){
				System.out.println(String.format("%s : %s",resultSet.getString("Code"), resultSet.getString("CountryName")));
			}
			
			helper.ReleaseMemory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testInsert(DbHelper helper){
		String insertSql = "INSERT CountryCode(Code,CountryName) Values('US', 'United States')";
		
		try{
			int effectedRows = helper.UpdateData(insertSql);
			System.out.println(String.format("%d row(s) inserted.", effectedRows));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testUpdate(DbHelper helper){
		String insertSql = "UPDATE CountryCode SET CountryName = 'United States' WHERE Code = 'US'";
		
		try{
			int effectedRows = helper.UpdateData(insertSql);
			System.out.println(String.format("%d row(s) updated.", effectedRows));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
