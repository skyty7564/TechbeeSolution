package com.techbeesolution.bankaccount;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class BankUserDao {
	
	final static String JDBC_DRIVER =  "com.mysql.cj.jdbc.Driver";
	final static String DB_URL ="jdbc:mysql://userdb.cbyib0kp0daq.us-east-2.rds.amazonaws.com/BankDemo";
	final static String USER = "Admin";
	final static String PASSWORD = "Password";
	private static Connection conn = null;
	private static PreparedStatement preStmt = null;
	private ArrayList<BankAccount> listUser = new ArrayList<BankAccount>();
	
	//open the DB connection
	public static void DBOpen()
	{
		System.out.println("Connecting to Database");	
		try
		{
			Class.forName(JDBC_DRIVER);	
		
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
		}

		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection CLose");
		}
	
	}
	
	
	

	
	public List<BankAccount> getAllUsers()
	{
		String sql  = "Select * From usersDB";
		
		return listUser;
	}
	//check to see account exist
	public static BankAccount retrieveUser(int Acc)
	{
		DBOpen();
		try {
			preStmt = conn.prepareStatement("Select * from usersDB Where AccNum = ?");
			preStmt.setInt(1, Acc);
			ResultSet result = preStmt.executeQuery();
			BankAccount user = new BankAccount();
			while(result.next())
			{
				user.setfName(result.getString("FirstName"));
				user.setlName(result.getString("LastName"));
				user.setAccNum(result.getInt("AccNum"));
				user.setPhoneNumber(result.getLong("PhoneNumber"));
				user.setEmail(result.getString("email"));
				user.setBalance(result.getDouble("Balance"));
				
			}
			
			
			conn.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//check to see if the user exist before adding current new user
	public static boolean retrieveUser(BankAccount Acc)
	{
		DBOpen();
		try {
			preStmt = conn.prepareStatement("Select 1 from usersDB Where AccNum = ?");
			preStmt.setInt(1, Acc.getAccNum());
			ResultSet result = preStmt.executeQuery();
			
			if(result.next())
			{
		       return true;
				
			}
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//add user to list before adding the database
	public void addUser(BankAccount user)
	{
	
		listUser.add(user);
		
	}
	
	//update the database;
	public void updateDatabase()
	{
		DBOpen();
		if(listUser == null)
		{
			return;
		}
		for(BankAccount user : listUser )
		{
		
			try {
				boolean userExist = retrieveUser(user);
				
				if(!userExist)
				{
					preStmt = conn.prepareStatement("INSERT INTO usersDB (AccNum,FirstName,LastName,Balance,email,PhoneNumber) Values (?,?,?,?,?,?)");
					
					preStmt.setInt(1, user.getAccNum());
					preStmt.setString(2, user.getfName());
					preStmt.setString(3, user.getlName());
					preStmt.setDouble(4, user.getBalance());
					preStmt.setString(5, user.getEmail());
					preStmt.setLong(6, user.getPhoneNumber());
					
					preStmt.executeUpdate();
					System.out.println("Entered into database:"+user.getfName());
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}
	
	//display the current user info
	public void depositFunds(BankAccount user, double amount)
	{
	
		double balance = user.getBalance();
		user.setBalance(balance + amount);
		displayFunds(user,"Fund deposited!");
		DBOpen();
		
		try {
			preStmt = conn.prepareStatement("Update usersDB Set Balance = value Where AccNum =  AccNum");
			preStmt.setDouble(1,user.getBalance());
			preStmt.setInt(2, user.getAccNum());
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean checkUser(int Acc)
	{
		DBOpen();
		try {
			preStmt = conn.prepareStatement("Select 1 from usersDB Where AccNum = ?");
			preStmt.setInt(1, Acc);
			ResultSet result = preStmt.executeQuery();
			if (result != null)
			{
				return true;
			}
			else
				
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	//withdraw money
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
			
			try {
				preStmt = conn.prepareStatement("Update usersDB Set Balance = value Where AccNum =  AccNum");
				preStmt.setDouble(1,user.getBalance());
				preStmt.setInt(2, user.getAccNum());
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		System.out.println("Customer Email:" + user.getEmail());
		System.out.println("Customer Phone Number:" + user.getPhoneNumber());
		
		}
	
	
}
