package com.java1234.jdbc.chap03.sec03;

import java.sql.Connection;
import java.sql.Statement;

import com.java1234.jdbc.DbUtil;
import com.java1234.jdbc.model.Book;

public class Demo1 {
	private static DbUtil du = new DbUtil();
	
	private static int updateBook(Book book) throws Exception {
		Connection con = du.getCon();
		String sql = "update t_book set type='" + book.getType() + "',auther='" + book.getAuther() + "',price="
				+ book.getPrice() + " where id="+book.getId();
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		du.close(stmt, con);
		return result;
	}

	public static void main(String[] args) throws Exception {
		Book book = new Book(1,"zhengzhi", "zhen", 7);
		int result = updateBook(book);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
}
