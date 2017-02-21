package com.sqli.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;

public class JdbcPersonneDAO implements PersonneDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * insert
	 */
	public void insert(Personne personne){
		
		String sql = "INSERT INTO PERSONNE " +
				"(ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, personne.getCustId());
			ps.setString(2, personne.getName());
			ps.setInt(3, personne.getAge());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	/**
	 * find by personne
	 */
	public Personne findByPersonneId(int id){
		
		String sql = "SELECT * FROM PERSONNE WHERE ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Personne personne = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				personne = new Personne(
						rs.getInt("ID"),
						rs.getString("NAME"), 
						rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return personne;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}




