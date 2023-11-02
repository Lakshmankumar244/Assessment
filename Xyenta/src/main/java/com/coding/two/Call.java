package com.coding.two;

import java.util.Map;

public class Call {
	static int score(String s,Map<Character,Integer> m) {
		int sum=0;
		char[] ch=s.toCharArray();
		for(int x=0;x<ch.length;x++)
		{
			if(m.get(ch[x])!=null)
			sum=sum+m.get(ch[x]);
		}
		
		
		
			return sum;
	}

}
