package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Contact;
import com.utility.ConnectionProvider;

public class ContactDAO {
	private Connection con = null;
	public boolean addContact(Contact c,int sid) throws SQLException {
		boolean res = false;
		
		final String QUERRY = "INSERT INTO CONTACT(cname,email,phone,details,sid) values(?,?,?,?,?)";
		if(con == null)
			con = ConnectionProvider.getCon();
		PreparedStatement pst = con.prepareStatement(QUERRY);
		pst.setString(1, c.getCname());
		pst.setString(2, c.getCmail());
		pst.setString(3, c.getPhone());
		pst.setString(4, c.getAbout());
		pst.setInt(5, sid);
		int i = pst.executeUpdate();
		if(i == 1)
			res = true;
		return res;
	}
	public boolean editContact(Contact c) throws SQLException {
		boolean res = false;
		final String QUERRY = "UPDATE CONTACT SET CNAME=?,EMAIL=?,PHONE=?,DETAILS=? WHERE CID = ?";
		if(con == null)
			con = ConnectionProvider.getCon();
		PreparedStatement pst = con.prepareStatement(QUERRY);
		pst.setString(1, c.getCname());
		pst.setString(2, c.getCmail());
		pst.setString(3, c.getPhone());
		pst.setString(4, c.getAbout());
		pst.setInt(5, c.getCid());
		int i = pst.executeUpdate();
		if(i == 1)
			res = true;
		return res;
	}
	public List<Contact> getContacts(int userId) throws SQLException{
		List<Contact> l = new ArrayList<Contact>();
		if(con == null)
			con = ConnectionProvider.getCon();
		final String QUERRY = "SELECT * FROM CONTACT WHERE SID = ?";
		PreparedStatement ps = con.prepareStatement(QUERRY);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Contact c = new Contact();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setPhone(rs.getString("phone"));
			c.setCmail(rs.getString("email"));
			c.setAbout(rs.getString("details"));
			l.add(c);
		}
		return l;
	}
	public Contact getContactById(int id) throws SQLException {
		Contact c = new Contact();
		if(con == null)
			con = ConnectionProvider.getCon();
		final String QUERRY = "SELECT * FROM CONTACT WHERE CID = ?";
		PreparedStatement ps = con.prepareStatement(QUERRY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setPhone(rs.getString("phone"));
			c.setCmail(rs.getString("email"));
			c.setAbout(rs.getString("details"));
		}
		return c;
	}
	public boolean deleteContact(int id) throws SQLException {
		boolean b = false;
		if(con == null)
			con = ConnectionProvider.getCon();
		final String QUERRY = "DELETE FROM CONTACT WHERE CID = ?";
		PreparedStatement ps = con.prepareStatement(QUERRY);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		if(i > 0)
			b = true;
		return b;
	}
}
