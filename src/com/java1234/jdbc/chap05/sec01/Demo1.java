package com.java1234.jdbc.chap05.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.jdbc.DbUtil;
import com.java1234.jdbc.model.Book;


public class Demo1 {
	private static DbUtil du = new DbUtil();
	/*
	private static void listBook() throws Exception {
		Connection con = du.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String type = rs.getString(2);
			String auther = rs.getString(3);
			Float price = rs.getFloat(4);
			System.out.println(id + type + auther + price);
			System.out.println("==========================");
		}
	}
	*/
	
	/*
	private static void listBook2() throws Exception {
		Connection con = du.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String auther = rs.getString("auther");
			Float price = rs.getFloat("price");
			System.out.println(id + type + auther + price);
			System.out.println("==========================");
		}
	}
	*/
	
	private static List<Book> listBook3() throws Exception {
		List<Book> bl = new ArrayList<Book>();
		Connection con = du.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String auther = rs.getString("auther");
			Float price = rs.getFloat("price");
			Book book = new Book(id, type, auther, price);
			bl.add(book);
		}
		return bl;
	}
	public static void main(String[] args) throws Exception {
		//listBook();
		//listBook2();
		List<Book> bl = listBook3();
		for (Book book : bl) {
			System.out.println(book);
		}
	}
}
