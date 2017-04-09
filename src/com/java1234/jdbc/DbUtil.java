package com.java1234.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class DbUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_bank";
	private static String dbUserName = "root";
	private static String dbPassword = "root";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	public void close(CallableStatement cstmt, Connection con) throws Exception {
		if(cstmt!=null) {
			cstmt.close();
			if(con!=null) {
			con.close();
			}
		}	
	}
	
	public void close(PreparedStatement pstmt, Connection con) throws Exception {
		if(pstmt!=null) {
			pstmt.close();
			if(con!=null) {
			con.close();
			}
		}	
	}
	
	public void close(Statement stmt, Connection con) throws Exception {
		if(stmt!=null) {
			stmt.close();
			if(con!=null) {
			con.close();
			}
		}	
	}
}
