package com.techbeesolution.stringmanipulation;

public class Words {
	
	public Words()
	{}
	
	public int ReturnCount(String sentence )
	{
			int count = 0;
		String[] wordArray = sentence.trim().split(" ");
		
		count = wordArray.length;
		
		return count;	
		
	}

}
