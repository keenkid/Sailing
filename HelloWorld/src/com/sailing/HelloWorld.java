package com.sailing;

import java.sql.*;

public class HelloWorld {

	public static void main(String[] args) {
		DbHelper helper = new DbHelper();
		String selectSql = "SELECT * FROM HumanResources.Employee";
		ResultSet resultSet = helper.QueryData(selectSql);
		try {
			while(resultSet.next()){
				System.out.println(resultSet.getString("NationalIDNumber") + ":" + resultSet.getString("Title"));
			}
		helper.ReleaseMemory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
