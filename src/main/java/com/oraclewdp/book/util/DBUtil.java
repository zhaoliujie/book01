package com.oraclewdp.book.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
private static Properties pro;

	static {
try {
	pro=new Properties();
	pro.load(DBUtil.class.getResourceAsStream("db.properties"));
} catch (IOException e) {
	e.printStackTrace();
}
	}
//	注册是一次
	static {
		try {
			Class.forName(pro.getProperty("driverClass"));
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(pro.getProperty("url"),
					pro.getProperty("user"),pro.getProperty("pwd"));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
		
	}

	public static void free(Statement stmt,Connection conn) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}
	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}
	}

