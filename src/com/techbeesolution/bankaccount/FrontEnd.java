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
										BaoNguyen.withdrawFunds(fundAmount);
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
										BaoNguyen.depositFunds(fundAmount);
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
									BaoNguyen.displayInfo();
									validTran = true;
									break;
								case 4:
									System.out.println("Thank you for using our service!");
									validTran = true;
									break;
								default:
									userInput.nextLine();
								
							}
							
						}while (validTran != true);
					
					}
					else
					{
						System.out.println("Invalid Input");
						System.out.println("-------------------------------------");
						userInput.nextLine();
					}
							
			/*	try
				{
					boolean validTran = false;
					do	
					{
						mainInput = userInput.nextInt();
						double fundAmount = 0;
						switch (mainInput)
						{	
						case 1:
							System.out.println("Enter Withdraw Amount:");
							try {
								fundAmount = userInput.nextDouble();
								BaoNguyen.withdrawFunds(fundAmount);
							}
							catch (Exception E)
							{
								System.out.println("Invalid Input");
							}
						
							
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
					}while (validTran == true);
					
					
					
				}
				catch (Exception E)
				{
					System.out.println("Invalid Input");
					userInput.nextLine();
				}
				
					
				
				*/
				
			}while (mainInput != 4);
			System.out.println("Thank you for using our service");
	
			userInput.close();
		
		

	
	}

}
