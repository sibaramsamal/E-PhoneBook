package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider{
	public static Connection getCon(){
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/e-phonebook";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		System.out.println(ConnectionProvider.getCon());
	}
}
