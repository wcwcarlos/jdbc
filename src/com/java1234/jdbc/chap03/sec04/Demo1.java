package com.java1234.jdbc.chap03.sec04;

import java.sql.Connection;
import java.sql.Statement;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	private static DbUtil du = new DbUtil();
	
	private static int deleteBook(int id) throws Exception {
		Connection con = du.getCon();
		String sql = "delete from t_book where id="+id;
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		du.close(stmt, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = deleteBook(4);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
}
