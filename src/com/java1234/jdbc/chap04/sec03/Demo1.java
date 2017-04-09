package com.java1234.jdbc.chap04.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
private static DbUtil du = new DbUtil();
	
	private static int deleteBook(int id) throws Exception {
		Connection con = du.getCon();
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		du.close(pstmt, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		int result = deleteBook(2);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}

}
