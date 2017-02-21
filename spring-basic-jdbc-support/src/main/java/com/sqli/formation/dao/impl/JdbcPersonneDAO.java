package com.sqli.formation.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;
import com.sqli.formation.util.PersonneRowMapper;

public class JdbcPersonneDAO extends JdbcDaoSupport implements PersonneDAO
{
	//insert example
	public void insert(Personne personne){
		
		String sql = "INSERT INTO PERSONNE " +
			"(ID, NAME, AGE) VALUES (?, ?, ?)";
			 
		getJdbcTemplate().update(sql, new Object[] { personne.getId(),
					personne.getName(),personne.getAge()  
		});
			
	}
	
	//insert with named parameter
	public void insertNamedParameter(Personne personne){
		
		//not supported
			
	}
	
	//insert batch example
	public void insertBatch(final List<Personne> personnes){
		
		String sql = "INSERT INTO PERSONNE " +
			"(NAME, AGE) VALUES (?, ?)";
			
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Personne personne = personnes.get(i);
				ps.setString(1, personne.getName());
				ps.setInt(2, personne.getAge() );
			}
			
			public int getBatchSize() {
				return personnes.size();
			}
		});
	}

	//insert batch with named parameter
	public void insertBatchNamedParameter(final List<Personne> personnes){
		
		//not supported
	}	
	
	//insert batch with named parameter
	public void insertBatchNamedParameter2(final List<Personne> personnes){
		
		//not supported
	}	
	
	//insert batch example with SQL
	public void insertBatchSQL(final String sql){
		
		getJdbcTemplate().batchUpdate(new String[]{sql});
		
	}
	
	//query single row with RowMapper
	public Personne findByPersonneId(int id){
		 
		String sql = "SELECT * FROM PERSONNE WHERE ID = ?";
 
		Personne personne = (Personne)getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, new PersonneRowMapper());
	
		return personne;
	}
	
	//query single row with BeanPropertyRowMapper (Personne.class)
	public Personne findByPersonneId2(int id){
		 
		String sql = "SELECT * FROM PERSONNE WHERE ID = ?";
 
		Personne personne = (Personne)getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, 
				new BeanPropertyRowMapper(Personne.class));
	
		return personne;
	}
	
	//query mutiple rows with manual mapping
	public List<Personne> findAll(){
		
		String sql = "SELECT * FROM PERSONNE";
		 
		List<Personne> personnes = new ArrayList<Personne>();
	
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) { 
			Personne personne = new Personne();
			personne.setId((Long)(row.get("ID")));
			personne.setName((String)row.get("NAME"));
			personne.setAge((Integer)row.get("AGE"));
			personnes.add(personne);
		}
		
		return personnes;
	}
	
	//query mutiple rows with BeanPropertyRowMapper (Personne.class)
	public List<Personne> findAll2(){
		
		String sql = "SELECT * FROM PERSONNE";
		
		List<Personne> personnes  = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Personne.class));
		
		return personnes;
	}
	
	public String findPersonneNameById(int id){
		
		String sql = "SELECT NAME FROM PERSONNE WHERE ID = ?";
		 
		String name = (String)getJdbcTemplate().queryForObject(
				sql, new Object[] { id }, String.class);
	
		return name;
		
	}
	
	public int findTotalPersonne(){
		
		String sql = "SELECT COUNT(*) FROM PERSONNE";
		 
		int total = getJdbcTemplate().queryForInt(sql);
				
		return total;
	}
	
	
}
