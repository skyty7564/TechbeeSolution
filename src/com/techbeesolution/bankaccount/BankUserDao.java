package com.techbeesolution.bankaccount;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class BankUserDao {
	
	final String JDBC_DRIVER =  "com.mysql.cj.jdbc.Driver";
	final String DB_URL ="jdbc:mysql://userdb.cbyib0kp0daq.us-east-2.rds.amazonaws.com/BankDemo";
	final String USER = "Admin";
	final String PASSWORD = "Password";
	private Connection conn = null;
	private PreparedStatement preStmt = null;
	private ArrayList<BankAccount> listUser;
	
	
	public void DBOpen()
	{
		System.out.println("Connecting to Database");	
		try
		{
			Class.forName(JDBC_DRIVER);	
		
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
		}

		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	public BankUserDao()
	{
		listUser = new ArrayList<BankAccount>();
		BankAccount Admin = new BankAccount (1,"Admin","Admin");
		listUser.add(Admin);
	}
	
	public List<BankAccount> getAllUsers()
	{
		String sql  = "Select * From usersDB";
		
		return listUser;
	}
	
	public BankAccount retrieveUser(int Acc)
	{

	
		DBOpen();
		try {
			preStmt = conn.prepareStatement("Select * from usersDB Where AccNum = ?");
			preStmt.setInt(1, Acc);
			ResultSet result = preStmt.executeQuery();
			BankAccount user = new BankAccount();;
			while(result.next())
			{
				user.setfName(result.getString("FirstName"));
				user.setlName(result.getString("LastName"));
				user.setAccNum(result.getInt("AccNum"));
				user.setPhoneNumber(result.getLong("PhoneNumber"));
				user.setfName(result.getString("email"));
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
	public void addUser(BankAccount user)
	{
		listUser.add(user);
		
	}
	
	public void updateDatabase()
	{
		DBOpen();
		for(BankAccount user : listUser )
		{
			try {
				preStmt = conn.prepareStatement("INSERT INTO usersDB (AccNum,FirstName,LastName,Balance,email,PhoneNumber) Values (?,?,?,?,?,?)");
				
				preStmt.setInt(1, user.getAccNum());
				preStmt.setString(2, user.getfName());
				preStmt.setString(3, user.getlName());
				preStmt.setDouble(4, user.getBalance());
				preStmt.setString(5, user.getEmail());
				preStmt.setLong(6, user.getPhoneNumber());
			
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
