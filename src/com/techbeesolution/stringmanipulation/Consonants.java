package com.techbeesolution.stringmanipulation;

public class Consonants {
	
	public Consonants()
	{
		
		
	}
	
	public int ReturnCount(String sentence )
	{
		int count = 0;
		
		String manSentence = sentence.toLowerCase();
		char[] vowelArray = new char[] {'a','e','i','o','u'};
		
		for(int i = 0; i < manSentence.length(); i++)
		{
			for (int j = 0 ; j < vowelArray.length; j++)
			{
				if (manSentence.charAt(i) != vowelArray[j] && manSentence.charAt(i) != ' ')
				{
					count++;
					break;
				}
			}
			
		}
		
		return count;	
		
	}
	
	public String ReturnString(String sentence )
	{
		String newWord = " ";
		
		String manSentence = sentence.toLowerCase().trim();
	
		char[] vowelArray = new char[] {'a','e','i','o','u'};
		
		for(int i = 0; i < manSentence.length(); i++)
		{
			char letter = manSentence.charAt(i);
			boolean check = false;
			for (int j = 0 ; j < vowelArray.length; j++)
			{
				if( letter == vowelArray[j] || letter == ' ')
				{
					newWord += manSentence.charAt(i);
					check = true;
					break;
				}

			}
			if(check == false && Character.isLetter(letter))
			{
				newWord += "*";
				
			}
			else if (check == false)
			{
				newWord += letter;
			}
			
		}
		
		return newWord;	
		
	}

}
