package com.java1234.jdbc.chap04.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java1234.jdbc.DbUtil;
import com.java1234.jdbc.model.Book;

public class Demo1 {
	private static DbUtil du = new DbUtil();
	
	private static int addBook(Book book) throws Exception {
		Connection con = du.getCon();
		String sql = "insert into t_book values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getType());
		pstmt.setString(2, book.getAuther());
		pstmt.setFloat(3, book.getPrice());
		int result = pstmt.executeUpdate();
		du.close(pstmt, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		Book book = new Book("zhengzhi", "zhen", 7);
		int result = addBook(book);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
}
