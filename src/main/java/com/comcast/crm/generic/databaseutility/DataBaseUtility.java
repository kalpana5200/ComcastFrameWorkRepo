package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDbConnection(String url,String un, String pwd) throws Throwable {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn=DriverManager.getConnection(url,un,pwd);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void getDbConnection() throws Throwable {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","root"
				);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void closeDbconnection() throws Throwable {
		try {
		conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ResultSet executeConSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
		Statement stat=conn.createStatement();
		 result=stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int executeNonSelectQuery(String query) throws Throwable {
		int result=0;
		try {
		Statement stat=conn.createStatement();
		 result=stat.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
