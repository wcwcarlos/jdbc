package com.java1234.jdbc.chap08.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		DbUtil du = new DbUtil();
		Connection con = du.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSetMetaData rsmd = pstmt.getMetaData();
		int num = rsmd.getColumnCount();
		for(int i=1; i<=num; i++) {
			System.out.println(rsmd.getColumnName(i) + "," + rsmd.getColumnTypeName(i));
		}
	}
}
