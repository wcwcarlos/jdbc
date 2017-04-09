package com.java1234.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		DbUtil du = new DbUtil();
		String sql = "insert into t_book values(null,'dili','wu',87.6)";
		Connection con = du.getCon();
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println(result);
		stmt.close();
		con.close();
	}
}
