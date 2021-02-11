package com.techbeesolution.basic;

public class helloworld {

	public static void main(String[] args) {
		System.out.println("hello my name is bao");
		person Newperson = new person ();
		
		Newperson.echoname("John");
		int x=1;
		int result = x;
		System.out.println(result);
		result++;
		System.out.println(result);
		++result;
		System.out.println(result);
		System.out.println(result);
		System.out.println("------------------------------------------");
		
		for (int i = 0; i <5; ++i)
		{
			
			System.out.println("Loop:" + i);
		}
	
		
		System.out.println("------------------------------------------");
		for (int i = 0; i <5; i++)
		{
			
			System.out.println("Loop:" + i);
		}
		
	}

}
