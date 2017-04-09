package com.java1234.jdbc.chap09.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	private static DbUtil du = new DbUtil();
	
	private static void outCount(Connection con, String accountName, int count) throws Exception {
		String sql = "update t_account set accountBalance=accountBalance-? where accountName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();
		pstmt.close();
	}

	private static void inCount(Connection con, String accountName, int count) throws Exception {
		String sql = "update t_account set accountBalance=accountBalance+? where accountName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public static void main(String[] args) {
		Connection con = null;
		Savepoint sp = null;
		try {
			con = du.getCon();
			con.setAutoCommit(false);
			System.out.println("start");
			int count = 500;
			outCount(con, "zhangsan", count);
			sp = con.setSavepoint();
			inCount(con, "lisi", count);
			System.out.println("end");
		} catch (Exception e) {
			try {
				con.rollback(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
