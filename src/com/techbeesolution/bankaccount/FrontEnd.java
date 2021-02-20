package com.techbeesolution.bankaccount;
import java.util.Scanner;

public class FrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankUserDao daoUserList  = new BankUserDao();
		
		Scanner userCheck = new Scanner(System.in);
		System.out.println("Enter Account Number:");
		String userN = null;
		userN = userCheck.nextLine();
		
		do {
					
			
				BankAccount user;
				System.out.println(userN);
				int AccNumber = 0;
				try
				{
					AccNumber = Integer.parseInt(userN);
					user = daoUserList.retrieveUser(AccNumber);
				}
				catch (Exception e)
				{
					System.out.println("Invalid Account Number/Entry");
					user = null;
				}
				
			
			
				System.out.println("Check User \n-------------------------------");

				if(user != null)
				{
					int mainInput = -1;
					
					
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
											String userAddInput = null;
											userAddInput = userCheck.nextLine();
											do
											{
									
												System.out.println("Please Enter First Name:");
												String fName = userCheck.next();
												System.out.println("Please Enter last Name:");
												String lName = userCheck.next();
												System.out.println("Please Enter Account Number:");
												String accNum = userCheck.next();
												System.out.println("Please Enter Email:");
												String email = userCheck.next();
												System.out.println("Please Enter PhoneNumber:");
												String phoneNum = userCheck.next();
												System.out.println("Please Enter Balance:");
												String balance = userCheck.next();
												
											try {
													BankAccount newUser = new BankAccount();
													newUser.setAccNum(Integer.parseInt(accNum));
													newUser.setfName(fName);
													newUser.setlName(lName);
													newUser.setBalance(Double.parseDouble(balance));
													newUser.setEmail(email);
													newUser.setPhoneNumber(Long.parseLong(phoneNum));
													
													System.out.println(newUser.getfName()+":"+newUser.getlName()+":"+newUser.getAccNum()+":"+newUser.getBalance()+":"+newUser.getEmail()+":"+newUser.getPhoneNumber());
													daoUserList.addUser(newUser);
											}
											catch (Exception E)
											{
												System.out.println("Invalid Input");
											}
												System.out.println("******************Enter End Any time to stop adding user***********");
												System.out.println("Do you want to continue adding user y/n:");
												userAddInput = userCheck.next();
											}while (!userAddInput.equals("n"));
											
											daoUserList.updateDatabase();
											
											
											
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
					System.out.println("Enter Account Number:");
					userN = userCheck.nextLine();
					
				
				}
				else
				{
					System.out.println("Enter Account Number:");
					userN = userCheck.nextLine();	
				}
	
			
				

			
		}while (!userN.equals("Quit"));
		System.out.println("Thank you for using our service!");
		userCheck.close();
		

	
	}

	

}
