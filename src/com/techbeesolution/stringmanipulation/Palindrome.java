package com.techbeesolution.stringmanipulation;

public class Palindrome {
	public Palindrome()
	{}
	
	public void returnPalindrome(String sentence)
	{
		boolean revTrue = true;
		
		sentence.trim();
		int back = sentence.length() -1;
		int front = 0;
		
		while (front < back)
		{
			char frontChar = sentence.charAt(front++);
			char backChar = sentence.charAt(back--);
			
			if (frontChar != backChar)
			{
				revTrue = false;
			}
		}
		
		if (revTrue == true)
		{
			System.out.println("This is a Palindrome Word");
		}	
		else
		{
			System.out.println("This is not a Palindrome Word");
		}
	}

}
