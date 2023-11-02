package com.coding.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class patterns extends HttpServlet
	{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int height=Integer.parseInt(req.getParameter("height"));
		String alignment=req.getParameter("alignment").toLowerCase();
	
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int n=height;
//		out.println("<table border style='border-collapse:collapse;'>");
//		for(int x=0;x<n;x++)
//		{
//			if(alignment.equals("left"))
//			{
//				out.println("<tr><td>");
//				for(int y=0;y<=x;y++)
//					out.println("# "
//							    );
//				out.println("</td></tr>");
//			}
//		}
			if(alignment.equals("right"))
			{
				for(int y=0;y<n;y++)
				{
					for(int sp=n;sp>y;sp--)
					{
						System.out.print("  ");
					}
					for(int x1=0;x1<=y;x1++)
					{
						System.out.print("# ");
					}System.out.println();
				}
//					if(y<n-x-1)
//					{
//						System.out.print("  ");
//						out.println("  ");
//					}
//					else
//					{
//						System.out.print("# ");
//						out.println("# ");	
//					}
				}
				//out.println("</td></tr>");

			}
		
	}