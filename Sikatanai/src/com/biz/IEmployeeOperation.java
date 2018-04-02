package com.biz;

import java.util.*;

import com.beans.*;

public interface IEmployeeOperation {
	int getTotalEmployeeCount(String selectTotalCountSql) throws Exception;
	
	List<Employee> getEmployees(String selectSql) throws Exception;
}
