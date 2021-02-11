package com.techbeesolution.stringmanipulation;

public class LastLetterCount {
	public LastLetterCount()
	{}
	
	public void switchWord(String sentence)
	{
		sentence.trim();
		String wordReplace = null;
		 int count =0;
		 int firstOccurance = 0;
		 boolean switchWord = false;
		String[] listWord =  sentence.trim().split(" ");
		 for (int i = 0 ; i < listWord.length;i++)
			{
				int lastChar = listWord[i].length() - 1;
				if(listWord[i].charAt(lastChar) == 's' ||  listWord[i].charAt(lastChar) == 'y' )
					{
						if(wordReplace == null)
						{	
							firstOccurance = i;
							wordReplace = listWord[i];
						
						}
						else if(listWord[i].charAt(lastChar) != wordReplace.charAt(wordReplace.length() -1) && switchWord == false)
						{
			
							listWord[firstOccurance] = listWord[i];
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
