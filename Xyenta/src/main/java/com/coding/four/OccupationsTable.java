package com.coding.four;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/four")
public class OccupationsTable extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
			boolean condition=true;
			String copy="select concat(name,'(',upper(substring(occupation,1,1)),')') as Output from occupations union (select concat('There is a total of ',count(occupation),' ',occupation) from occupations group by occupation)";
			String query=request.getParameter("query");
			
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();

				while(rs.next())
				{
					condition=false;
					out.println(rs.getString(1)+"<br>");
				}

				if(condition)
				{
					out.println("Query Invalid");
					RequestDispatcher rd=request.getRequestDispatcher("Occupation.html");
					rd.forward(request, response);
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
