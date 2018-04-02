package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.biz.*;
import com.beans.*;

public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IEmployeeOperation operation = null;
	
    public InformationServlet() {
        super();
        operation = new EmployeeOperation();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseContent = "";
		
		try {
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int totalPages = Integer.parseInt(request.getParameter("totalPages"));
			
			int start,end,totalCount;
			start = (pageIndex - 1) * pageSize;
			end = pageIndex * pageSize;
			
			totalCount = operation.getTotalEmployeeCount("SELECT COUNT(*) TotalCount FROM v_Employee");
			responseContent = getEmployeeContent(start,end);
		} catch (Exception e) {
			responseContent = e.getMessage();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(responseContent);
	}
	
	private String getEmployeeContent(int start, int end) throws Exception{		
		StringBuilder selectSql = new StringBuilder();
		selectSql.append("SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY Salutation) AS RowNum,* FROM v_Employee) AS RowConstraintResult WHERE RowNum>");
		selectSql.append(start);
		selectSql.append(" AND RowNum<=");
		selectSql.append(end);
		
		List<Employee> emps = operation.getEmployees(selectSql.toString());
		StringBuilder content = new StringBuilder();
		content.append("{\"employee\":[");
		for(Employee e : emps){
			content.append("{\"EmployeeID\":\"");
			content.append(e.getEmployeeID());
			content.append("\",\"Salutation\":\"");
			content.append(e.getSalutation());
			content.append("\",\"NationalID\":\"");
			content.append(e.getNationalID());
			content.append("\",\"Title\":\"");
			content.append(e.getTitle());
			content.append("\",\"BirthDate\":\"");
			content.append(e.getBirthday());
			content.append("\"},");
		}
		content.replace(content.length()-1, content.length(), "]}");
		return content.toString();
	}

}
