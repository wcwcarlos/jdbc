package com.java1234.jdbc.chap02.sec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private static String dbUserName = "root";
	private static String dbPassword = "root";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("haha");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hehe");
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
