package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_1Test {
	public static void main(String[] args) throws Throwable {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("select * from testing");
		while(result.next()) {
			System.out.println(result.getString(1)+""+result.getString(2)+" "+result.getString(3));
		}
	
		
		
	}
}
