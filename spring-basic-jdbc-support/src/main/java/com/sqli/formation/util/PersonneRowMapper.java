package com.sqli.formation.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sqli.formation.model.Personne;

public class PersonneRowMapper implements RowMapper<Personne>
{
	public Personne mapRow(ResultSet rs, int rowNum) throws SQLException {
		Personne customer = new Personne();
		customer.setId(rs.getLong("ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getInt("AGE"));
		return customer;
	}
	
}
