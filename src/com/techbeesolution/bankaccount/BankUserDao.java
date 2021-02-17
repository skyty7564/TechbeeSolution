package com.techbeesolution.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class BankUserDao {

	private ArrayList<BankAccount> listUser;
	
	public BankUserDao()
	{
		listUser = new ArrayList<BankAccount>();
	}
	
	public List<BankAccount> getAllUsers()
	{
		return listUser;
	}
	
	public void retrieveUser()
	{
		//code for adding user from database
		
	}
	public void addUser(BankAccount user)
	{
		listUser.add(user);
	}
	public void depositFunds(BankAccount user, double amount)
	{
		double balance = user.getBalance();
		user.setBalance(balance + amount);
		displayFunds(user,"Fund deposited!");
	}
	
	public void withdrawFunds(BankAccount user, double amount)
	{
		double balance = user.getBalance();
		double tempValue = balance - amount;
		
		if (tempValue < 0)
		{
			displayFunds(user,"Insufficent fund!");
		}
		else
		{
			user.setBalance(tempValue);
			displayFunds(user,"Fund Successfully Withdrawed!");
		}
	}
	
	public void displayFunds(BankAccount user,String Message)
	{
		System.out.println("Bank Account User:" +user.getfName()+ " " + user.getlName());
		System.out.println(Message);
		System.out.println("Bank Balance:$" + String.format("%,.2f",user.getBalance()));
		
	}
	
	public void displayInfo(BankAccount user)
	{
		System.out.println("Bank Account Number:"+user.getAccNum());
		System.out.println("Customer Name:" + user.getfName() + " " + user.getlName());
		System.out.println("Bank Account Fund:$" + user.getBalance());
		}
	
	
}
