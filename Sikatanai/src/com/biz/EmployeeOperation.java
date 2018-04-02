package com.biz;

import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Employee;
import com.utils.*;

public class EmployeeOperation implements IEmployeeOperation {

	@Override
	public int getTotalEmployeeCount(String selectTotalCountSql) throws Exception {
		return DbHelper.getInstance().QueryDataRowCount(selectTotalCountSql);
	}

	@Override
	public List<Employee> getEmployees(String selectSql) throws Exception {
		ResultSet resultSet = DbHelper.getInstance().QueryData(selectSql);
		List<Employee> emps = new ArrayList<Employee>();
		Employee emp = null;
		
		while(resultSet.next()){
			emp = new Employee();
			emp.setEmployeeID(resultSet.getString("EmployeeID"));
			emp.setSalutation(resultSet.getString("Salutation"));
			emp.setNationalID(resultSet.getString("NationalIDNumber"));
			emp.setTitle(resultSet.getString("Title"));
			emp.setBirthday(resultSet.getDate("BirthDate"));
			
			emps.add(emp);
		}
		return emps;
	}

}
