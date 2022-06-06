package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.utility.ConnectionProvider;

public class UserDAO {
	Connection con;
	public boolean registerUser(User u) throws SQLException {
		boolean result = false;
		final String SQL = "INSERT INTO USER(UNAME,EMAIL,PASSWORD) VALUES(?,?,?)" ;
		if(con == null)
			con = ConnectionProvider.getCon();
		PreparedStatement pst = con.prepareStatement(SQL);
		pst.setString(1, u.getUname());
		pst.setString(2, u.getEmail());
		pst.setString(3, u.getPassword());
		int i = pst.executeUpdate();
		if(i > 0)
			result = true;
		return result;
	}
	public User loginUser(String id, String pass) {
		User u = null;
		if(con == null)
			con = ConnectionProvider.getCon();
		final String SQL = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
