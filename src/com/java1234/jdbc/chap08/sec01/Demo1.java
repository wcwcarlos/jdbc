package com.java1234.jdbc.chap08.sec01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.java1234.jdbc.DbUtil;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		DbUtil du = new DbUtil();
		Connection con = du.getCon();
		DatabaseMetaData dmd = con.getMetaData();
		System.out.println(dmd.getDatabaseProductName());
		System.out.println(dmd.getDatabaseMajorVersion() + "." + dmd.getDatabaseMinorVersion());
	}
}
