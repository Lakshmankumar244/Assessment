package com.coding.three;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/three")
public class Calculator extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String expression=req.getParameter("expression");
		String[] values=expression.split(" ");
		Map<String,String> m=new HashMap<>();
		m.put("+", "-");
		m.put("-", "+");
		m.put("*","/");
		m.put("/", "*");
		m.put("%", "|");
		m.put("|", "%");
		LinkedList<String> list=new LinkedList<>();		

		for(int x=0;x<values.length;x++)
		{
				list.add(values[x]);
		}

	if(m.containsKey(list.get(0)))
	{
		list.addFirst("0");
	}
	if(m.containsKey(list.get(list.size()-1)))
	{
		list.addLast("0");
	}
	int count1=0,count2=0;
	for(int x=1;x<values.length;x+=2)
	{
		count1++;
		if(m.containsKey(list.get(x)))
			count2++;
	}
	
	if(count1==count2)
	{
	int sum=Integer.parseInt(list.get(0));
for(int i=0;i<list.size()-1;i++)
{
	if(i%2!=0)
	{
		String s=list.get(i);
		switch(s)
		{
		case "+": sum = sum - Integer.parseInt(list.get(i+1)) ;break;
		case "-": sum = sum + Integer.parseInt(list.get(i+1)) ;break;
		case "*": sum = sum / Integer.parseInt(list.get(i+1)) ;break;
		case "/": sum = sum * Integer.parseInt(list.get(i+1)) ;break;
		case "%": sum = sum | Integer.parseInt(list.get(i+1)) ;break;
		case "|": sum = sum % Integer.parseInt(list.get(i+1)) ;break;
		}
	}	
}out.println(list);
	out.println("Output is : "+ sum);
	}
	else
	{
		out.println("Invalid Expression");
		RequestDispatcher rs=req.getRequestDispatcher("Arithmetic.html");
	}
	}
	
}