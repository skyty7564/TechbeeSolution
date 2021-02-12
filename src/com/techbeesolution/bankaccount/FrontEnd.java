package com.techbeesolution.bankaccount;
import java.util.Scanner;
public class FrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount BaoNguyen =  new BankAccount(123456789,50.00,"Bao","Nguyen","Skyty7564@yahoo.com", 9413218567L);
		int mainInput = -1;
		Scanner userInput = new Scanner(System.in);
			do {
				System.out.println("Main Menu \n 1: Withdraw Fund \n 2: Deposit Fund \n 3: Display user Info \n 4: quit" );
				
			
					
		/*			if( userInput.hasNextInt())
					{
						mainInput = userInput.nextInt();
						double fundAmount;
						switch (mainInput)
						{
							case 1:
								System.out.println("Enter Withdraw Amount:");
								fundAmount = userInput.nextDouble();
								BaoNguyen.withdrawFunds(fundAmount);
								break;
							case 2:
								System.out.println("Enter Deposit Amount:");
								fundAmount = userInput.nextDouble();
								BaoNguyen.depositFunds(fundAmount);
								break;
							case 3:
								BaoNguyen.displayInfo();
								break;
						}
					}
					else
					{
						System.out.println("Invalid Input");
						userInput.nextLine();
					}
				*/
				
				try
				{
					mainInput = userInput.nextInt();
					double fundAmount;
					switch (mainInput)
					{
						case 1:
							System.out.println("Enter Withdraw Amount:");
							fundAmount = userInput.nextDouble();
							BaoNguyen.withdrawFunds(fundAmount);
							break;
						case 2:
							System.out.println("Enter Deposit Amount:");
							fundAmount = userInput.nextDouble();
							BaoNguyen.depositFunds(fundAmount);
							break;
						case 3:
							BaoNguyen.displayInfo();
							break;
					}
					
				}
				catch (Exception E)
				{
					System.out.println("Invalid Input");
					userInput.nextLine();
				}
				
					
				
				
				
			}while (mainInput != 4);
			System.out.println("Thank you for using our service");
	
			userInput.close();
		
		
		
	
	}

}
