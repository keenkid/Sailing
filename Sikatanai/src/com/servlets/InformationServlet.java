package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.*;
import com.beans.*;

public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IEmployeeOperation operation = null;
	private int totalCount = 0;
	private int totalPages = 0;
	private int pageSize = 0;
	private int pageIndex = 0;
	
    public InformationServlet() {
        super();
        operation = new EmployeeOperation();
        try{
        	totalCount = operation.getTotalEmployeeCount("SELECT COUNT(*) TotalCount FROM v_Employee");
        }catch(Exception e){
        	totalCount = 0;
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseContent = "";
		
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			totalPages = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
			
			int start,end;
			start = (pageIndex - 1) * pageSize;
			end = pageIndex * pageSize;
						
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
		content.replace(content.length()-1, content.length(), "],");
		content.append("\"pages\":\"");
		content.append(totalPages);
//		content.append("\",\"index\":\"");
//		content.append(pageIndex+1);
		content.append("\"}");
		return content.toString();
	}

}
