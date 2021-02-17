package com.techbeesolution.bankaccount;
import java.util.Scanner;
public class FrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankUserDao newTest  = new BankUserDao();
		
	
		BankAccount BaoNguyen =  new BankAccount(123456789,50.00,"Bao","Nguyen","Skyty7564@yahoo.com", 9413218567L);
		BankAccount BaNguyen =  new BankAccount(123456789,50.00,"Ba","Nguyen","Skyty7564@yahoo.com", 9413218567L);
		BankAccount BoNguyen =  new BankAccount(123456789,50.00,"Bo","Nguyen","Skyty7564@yahoo.com", 9413218567L);
		BankAccount aoNguyen =  new BankAccount(123456789,50.00,"ao","Nguyen","Skyty7564@yahoo.com", 9413218567L);
		newTest.addUser(BaoNguyen);
		newTest.addUser(BaNguyen);
		newTest.addUser(BoNguyen);
		newTest.addUser(aoNguyen);
		
		for (BankAccount user : newTest.getAllUsers())
		{
			System.out.println("User:" + user.getfName() +" : Email: "+user.getEmail());
		}
		
		System.out.println("*************************************");
		
	
		
		
	
		int mainInput = -1;
		Scanner userInput = new Scanner(System.in);
			do {
				System.out.println("Main Menu \n 1: Withdraw Fund \n 2: Deposit Fund \n 3: Display user Info \n 4: quit" );
					//check for valid option
					if( userInput.hasNextInt())
					{
						mainInput = userInput.nextInt();
						double fundAmount =0;
						
						boolean validTran= false;
						do
						{
						
							switch (mainInput)
							{
								case 1:
									System.out.println("Enter Withdraw Amount:");
									//check for valid input
									if(userInput.hasNextDouble())
									{
										fundAmount = userInput.nextDouble();
										newTest.withdrawFunds(BaoNguyen,fundAmount);
										validTran = true;
									
									}
									else
									{
										System.out.println("Invalid Value");
										System.out.println("-------------------------------------");
										userInput.next();
									}												
									break;
								case 2:
									System.out.println("Enter Deposit Amount:");
									if(userInput.hasNextDouble())
									{
										fundAmount = userInput.nextDouble();
										newTest.depositFunds(BaoNguyen,fundAmount);
										validTran = true;
									
									}
									else
									{
										System.out.println("Invalid Value");
										System.out.println("-------------------------------------");
										userInput.next();
									}
									break;
								case 3:
									newTest.displayInfo(BaoNguyen);
									validTran = true;
									break;
							
								default:
									validTran = true;
									userInput.nextLine();
								
							}
							
						}while (validTran != true);
						System.out.println("-------------------------------------");
					
					}
					else
					{
						System.out.println("Invalid Input");
						System.out.println("-------------------------------------");
						userInput.nextLine();
					}
				
			}while (mainInput != 4);

			System.out.println("Thank you for using our service!");

	
			userInput.close();
		
		

	
	}

}
