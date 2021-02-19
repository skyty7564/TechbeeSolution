package com.techbeesolution.bankaccount;
import java.util.Scanner;
public class FrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankUserDao daoUserList  = new BankUserDao();
		
		Scanner userCheck = new Scanner(System.in);
		System.out.println("Enter name:");
		String userN = null;
		userN = userCheck.nextLine();
		
		do {
					
				boolean userExist = daoUserList.checkUser(userN);			
			
				System.out.println("Check User \n-------------------------------");
				System.out.println(userExist);
				if(userExist)
				{
					int mainInput = -1;
					
					BankAccount user;
					user = daoUserList.retrieveUser(userN);
					do {
						System.out.println("Main Menu \n 1: Withdraw Fund \n 2: Deposit Fund \n 3: Display user Info \n 4: Add User \n 6: quit" );
							//check for valid option
							if( userCheck.hasNextInt())
							{
								mainInput = userCheck.nextInt();
								double fundAmount = 0;
								
								boolean validTran= false;
								do
								{
								
									switch (mainInput)
									{
										case 1:
											System.out.println("Enter Withdraw Amount:");
											//check for valid input
											if(userCheck.hasNextDouble())
											{
												fundAmount = userCheck.nextDouble();
												daoUserList.withdrawFunds(user,fundAmount);
												validTran = true;
											
											}
											else
											{
												System.out.println("Invalid Value");
												System.out.println("-------------------------------------");
												userCheck.next();
											}												
											break;
										case 2:
											System.out.println("Enter Deposit Amount:");
											if(userCheck.hasNextDouble())
											{
												fundAmount = userCheck.nextDouble();
												daoUserList.depositFunds(user,fundAmount);
												validTran = true;
											
											}
											else
											{
												System.out.println("Invalid Value");
												System.out.println("-------------------------------------");
												userCheck.next();
											}
											break;
										case 3:
											daoUserList.displayInfo(user);
											validTran = true;
											break;
										case 4:
										{
											System.out.println("Please Enter First Name:");
											String fName = userCheck.next();
											System.out.println("Please Enter last Name:");
											String lName = userCheck.next();
											System.out.println("Please Enter Account Number:");
											int accNum = userCheck.nextInt();
											System.out.println("Please Enter Email:");
											String email = userCheck.next();
											System.out.println("Please Enter PhoneNumber:");
											long phoneNum = userCheck.nextLong();
											System.out.println("Please Enter Balance:");
											double balance = userCheck.nextDouble();
											
											BankAccount newUser = new BankAccount(accNum,balance,fName,lName,email,phoneNum);
											daoUserList.addUser(newUser);
										}
										default:
											validTran = true;
											userCheck.nextLine();
										
									}
									
								}while (validTran != true);
								System.out.println("-------------------------------------");
							
							}
							else
							{
								System.out.println("Invalid Input");
								System.out.println("-------------------------------------");
								userCheck.nextLine();
								
							}
						
					}while (mainInput != 6);

					System.out.println("log Out");
					System.out.println("Enter name:");
					userN = userCheck.nextLine();
					
				
				}
				else
				{
					System.out.println("Enter name:");
					userN = userCheck.nextLine();	
				}
	
			
				

			
		}while (!userN.equals("Quit"));
		System.out.println("Thank you for using our service!");
		userCheck.close();
		

	
	}

	

}
