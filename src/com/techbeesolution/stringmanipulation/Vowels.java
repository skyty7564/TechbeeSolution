package com.techbeesolution.stringmanipulation;

public class Vowels {
	public Vowels()
	{
		
	}
	
	public int ReturnCount(String sentence )
	{
		int count = 0;
		
		String manSentence = sentence.toLowerCase().trim();
		char[] vowelArray = new char[] {'a','e','i','o','u'};
		
		for(int i = 0; i < manSentence.length(); i++)
		{
			for (int j = 0 ; j < vowelArray.length; j++)
			{
				if (manSentence.charAt(i) == vowelArray[j])
				{
					count++;
				}
			}
			
		}
		
		return count;	
		
	}
	
}
