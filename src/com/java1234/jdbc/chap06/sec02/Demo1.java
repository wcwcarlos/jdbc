package com.java1234.jdbc.chap06.sec02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.jdbc.DbUtil;
import com.java1234.jdbc.model.Book;

public class Demo1 {
	
	private static DbUtil du = new DbUtil();
	
	private static int addBook(Book book) throws Exception {
		Connection con = du.getCon();
		String sql = "insert into t_book values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getType());
		pstmt.setString(2, book.getAuther());
		pstmt.setFloat(3, book.getPrice());
		File context = book.getContext();
		InputStream is = new FileInputStream(context);
		pstmt.setAsciiStream(4, is, context.length());
		File pic = book.getPic();
		InputStream is2 = new FileInputStream(pic);
		pstmt.setBinaryStream(5, is2, pic.length());
		int result = pstmt.executeUpdate();
		du.close(pstmt, con);
		return result;
	}
	
	private static void getBook(int id) throws Exception {
		Connection con = du.getCon();
		String sql = "select * from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String type = rs.getString("type");
			String auther = rs.getString("auther");
			float price = rs.getFloat("price");
			Clob c = rs.getClob("context");
			String context = c.getSubString(1, (int)c.length());
			Blob b = rs.getBlob("pic");
			FileOutputStream fos = new FileOutputStream(new File("f:/pic2.jpg"));
			fos.write(b.getBytes(1, (int)b.length()));
			fos.close();
			System.out.println(type);
			System.out.println(auther);
			System.out.println(price);
			System.out.println(context);
		}
		du.close(pstmt, con);
	}

	public static void main(String[] args)	throws Exception {
		/*File context = new File("f:/HelloWorld.txt");
		File pic = new File("f:/pic.jpg");
		Book book = new Book("zhengzhi", "zhen", 7, context, pic);
		int result = addBook(book);
		if (result == 1) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}*/
		getBook(5);
	}
}
