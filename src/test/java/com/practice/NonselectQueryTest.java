package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonselectQueryTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement state = con.createStatement();
		String create = "insert into timetable values('API',003,'Bangalore');";
		int result = state.executeUpdate(create);
		if(result==1) {
			System.out.println("data is created");
		}
		else {
			System.out.println("data is not created");
		}
		

	}

}
