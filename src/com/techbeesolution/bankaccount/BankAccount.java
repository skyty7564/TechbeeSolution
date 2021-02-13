package com.techbeesolution.bankaccount;

public class BankAccount {
	
	public BankAccount()
	{}
	
	public BankAccount(int accNum, double balance, String fName, String lName, String email, long phoneNumber) {
		super();			
			this.accNum = accNum;
			this.balance = balance;
			this.fName = fName;
			this.lName = lName;
			this.email = email;
			this.phoneNumber = phoneNumber;
		

	}
	private int accNum;
	private double balance;
	private String fName;
	private String lName;
	private String email;
	private long phoneNumber;
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance > 0)
			this.balance = balance;
		else
			System.out.println("Invalid Input");
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		if(checkRange(fName.length(),2))
			this.fName = fName;
		else
			System.out.println("Name must be greate than 2 character");
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		
		if(checkRange(lName.length(),2))
			this.lName = lName;
		else
			System.out.println("Name must be greate than 2 character");
			
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		String s = Long.toString(phoneNumber);
		if(checkRange(s.length(),10))
			this.phoneNumber = phoneNumber;
		else
			System.out.println("Name must be greate than 10 character");
	}

	
	public void depositFunds(double amount)
	{
		balance += amount;
		displayFunds("Fund deposited!");
	}
	private static boolean checkRange(int value, int numLength)
	{
		if (value < numLength)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	
	public void withdrawFunds(double amount)
	{
		double tempValue = balance - amount;
		
		if (tempValue < 0)
		{
			displayFunds("Insufficent fund!");
		}
		else
		{
			balance = tempValue;
			displayFunds("Fund Successfully Withdrawed!");
		}
	}
	
	public void displayFunds(String Message)
	{
		System.out.println("Bank Account User:" + fName+ " " + lName);
		System.out.println(Message);
		System.out.println("Bank Balance:$" + String.format("%,.2f",balance));
		
	}
	
	public void displayInfo()
	{
		System.out.println("Bank Account Number:"+accNum);
		System.out.println("Customer Name:" + fName + " " + lName);
		System.out.println("Bank Account Fund:$" + balance);
		}
	
}
