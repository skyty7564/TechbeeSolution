package com.techbeesolution.stringmanipulation;

public class LastLetterCount {
	public LastLetterCount()
	{}
	
	public void switchWord(String sentence)
	{
		sentence.trim();
		String wordReplace = null;
		 int count =0;
		 int first = -1;
		 boolean switchWord = false;
		String[] listWord =  sentence.trim().split(" ");
		 for (int i = 0 ; i < listWord.length;i++)
			{
				int lastChar = listWord[i].length() - 1;
				char charCheck = listWord[i].charAt(lastChar);
				System.out.println(listWord[i] + ":" + charCheck);
				if(charCheck == 's' ||  charCheck == 'y' )
					{
						if(first == -1)
						{	
							first = i;
						
						}
						else if(charCheck != listWord[first].charAt(listWord[first].length()-1)  && switchWord == false)
						{
			
							listWord[first] = listWord[i];
							listWord[i] = wordReplace; 
							switchWord = true;
						}
						
				count++;
					}
			}



		 String newSentence ="";
		 for (int i = 0; i < listWord.length;i++)
		 {
			 newSentence += listWord[i] + " ";
		 }
		
		System.out.println("Number of of Word ending with 's' and 'y':" + count);
		System.out.println(newSentence);
		
	}
	
}
