package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.*;

import com.mysql.jdbc.Driver;

public class TestyantraTest {

	public static void main(String[] args) throws Throwable{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51","root","root");
		System.out.println("connection is done");
		Statement state = con.createStatement();
		System.out.println("enter the name");
		try (Scanner sc = new Scanner(System.in)) {
			String name=sc.nextLine();
			System.out.println("enter the id");
			int n=sc.nextInt();
			String query = "select * from testyantra where name='"+name+"';";
			ResultSet result = state.executeQuery(query);
			if(name.contains("name")) 
			{
				System.out.println("present");
			}
			while(result.next()) 
			{
				String val = "insert into testyantra values("+n+",'"+name+"')";
				int result1 = state.executeUpdate(val);
				System.out.println("not present and now only created ");
				System.out.println("values------->"+result.getString(1)+"------->"+result.getString(2));
			}
		}



	}

}
