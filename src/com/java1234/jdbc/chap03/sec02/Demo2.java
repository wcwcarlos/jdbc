package com.java1234.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.java1234.jdbc.DbUtil;
import com.java1234.jdbc.model.Book;

public class Demo2 {
	private static DbUtil du = new DbUtil();

	private static int addBook2(Book book) throws Exception {
		Connection con = du.getCon();
		String sql = "insert into t_book values(null,'" + book.getType() + "','" + book.getAuther() + "',"
				+ book.getPrice()+")";
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		du.close(stmt, con);
		return result;
	}
	/*
	 * private static int addBook(String type, String auther, float price)
	 * throws Exception { Connection con = du.getCon(); String sql =
	 * "insert into t_book values(null,'"+type+"','"+auther+"',"+price+")";
	 * Statement stmt = con.createStatement(); int result =
	 * stmt.executeUpdate(sql); du.close(stmt, con); return result; }
	 */

	public static void main(String[] args) throws Exception {
		/*
		 * int result = addBook("shengwu","wu",8); if(result==1) {
		 * System.out.println("ok"); }else { System.out.println("no"); }
		 */
		Book book = new Book("zhengzhi", "zhen", 8);
		int result = addBook2(book);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
}
