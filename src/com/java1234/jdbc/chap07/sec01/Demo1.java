package com.java1234.jdbc.chap07.sec01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	
	private static DbUtil du = new DbUtil();
	
	private static String getAuther(int id) throws Exception {
		Connection con = du.getCon();
		String sql = "{CALL pro_getBook(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.execute();
		String auther = cstmt.getString("bn");
		du.close(cstmt, con);
		return auther;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getAuther(3));
	}
}
