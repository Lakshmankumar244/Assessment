package com.coding.two;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/two")
public class Words extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("");
		PrintWriter out=resp.getWriter();
		
		String con=req.getParameter("conversation");
		String[] a=con.split("\n");
		for(String s:a)
		{
			out.println(s);
		}
		Map<Character,Integer> m=new HashMap<>();
		m.put('A', 1);
		m.put('B', 3);
		m.put('C', 3);
		m.put('D', 2);
		m.put('E', 1);
		m.put('F', 4);
		m.put('G', 2);
		m.put('H', 4);
		m.put('I', 1);
		m.put('J', 8);
		m.put('K', 5);
		m.put('L', 1);
		m.put('M', 3);
		m.put('N', 1);
		m.put('O', 1);
		m.put('P', 3);
		m.put('Q', 10);
		m.put('R', 1);
		m.put('S', 1);
		m.put('T', 1);
		m.put('U', 1);
		m.put('V', 4);
		m.put('W', 4);
		m.put('X', 8);
		m.put('Y', 4);
		m.put('Z', 10);
		
		int score1=0,score2=0;
		
	for(int i=0;i<a.length;i++)
		{
			if((a[i].substring(0, 2)).equals("p1"))
			{
				a[i]=a[i].substring(2).toUpperCase();
				 score1=score1+Call.score(a[i], m);
			}
			else if(((a[i].substring(0, 2)).equals("p2")))
			{
				a[i]=a[i].substring(2).toUpperCase();
				 score2=score2 + Call.score(a[i], m);
			}
		}
		out.println("player 1 score : "+score1);
		out.println("player 2 score : "+score2);
		if(score1==score2)
		{
			out.println("Tie!");
		}
		else if(score1>score2)
		{
			out.println("Player 1 wins!");
		}
		else
			out.println("Player 2 wins!");
	
		}	
}