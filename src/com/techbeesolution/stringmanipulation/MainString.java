package com.techbeesolution.stringmanipulation;
import java.util.Scanner;
public class MainString {

	public static void main(String[] args) {
		
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("Vowel:Please enter a Sentence or Word:");
			String sentWord =  userInput.nextLine();
			Vowels testVowel = new Vowels();
			String messReturn = "Number of Vowel in the sentence:";
			System.out.println(messReturn + testVowel.ReturnCount(sentWord));
			
			System.out.println("WordsCount:Please enter a Sentence or Word:");
			sentWord =  userInput.nextLine();
			Words testWords = new Words();
			messReturn = "Number of Word in the sentence:";
			System.out.println(messReturn + testWords.ReturnCount(sentWord));
			
			System.out.println("Consosnants:Please enter a Sentence or Word:");
			sentWord =  userInput.nextLine();
			Consonants testConsosnants = new Consonants();
			messReturn ="Number of Consontant in the sentence:";
			System.out.println(messReturn + testConsosnants.ReturnCount(sentWord));
			System.out.println(testConsosnants.ReturnString(sentWord));
			
			System.out.println("Palindrome:Please enter a Sentence or Word:");
			sentWord =  userInput.nextLine();
			Palindrome testPalindrome = new Palindrome();
			testPalindrome.returnPalindrome(sentWord);
			
			System.out.println("LastLetter:Please enter a Sentence or Word:");
			sentWord =  userInput.nextLine();
			LastLetterCount testLastLetterCount = new LastLetterCount();
			testLastLetterCount.switchWord(sentWord);
			
			userInput.close();
			

	}

}
