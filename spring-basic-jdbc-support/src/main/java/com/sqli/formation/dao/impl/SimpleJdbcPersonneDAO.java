package com.sqli.formation.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;
import com.sqli.formation.util.PersonneParameterizedRowMapper;


public class SimpleJdbcPersonneDAO extends SimpleJdbcDaoSupport implements PersonneDAO
{
	//insert example
	public void insert(Personne personne){
		
		String sql = "INSERT INTO PERSONNE " +
			"(ID, NAME, AGE) VALUES (?, ?, ?)";
			 
		getSimpleJdbcTemplate().update(sql, personne.getId(),
					personne.getName(),personne.getAge()  
		);
			
	}
	
	//insert with named parameter
	public void insertNamedParameter(Personne personne){
		
		String sql = "INSERT INTO PERSONNE " +
			"(ID, NAME, AGE) VALUES (:id, :name, :age)";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", personne.getId());
		parameters.put("name", personne.getName());
		parameters.put("age", personne.getAge());
		
		getSimpleJdbcTemplate().update(sql, parameters);
			
	}
	
	
	//insert batch example
	public void insertBatch(final List<Personne> personnes){
		
		String sql = "INSERT INTO PERSONNE " +
			"(ID, NAME, AGE) VALUES (?, ?, ?)";
			
		List<Object[]> parameters = new ArrayList<Object[]>();
        for (Personne cust : personnes) {
            parameters.add(new Object[] {cust.getId(), cust.getName(), cust.getAge()});
        }
        getSimpleJdbcTemplate().batchUpdate(sql, parameters);
        
	}

	//insert batch with named parameter
	public void insertBatchNamedParameter(final List<Personne> personnes){
		
		String sql = "INSERT INTO PERSONNE " +
			"(ID, NAME, AGE) VALUES (:id, :name, :age)";
			
		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
        for (Personne cust : personnes) {
        	
        	parameters.add(new BeanPropertySqlParameterSource(cust));
           
        }
        getSimpleJdbcTemplate().batchUpdate(sql,
        		parameters.toArray(new SqlParameterSource[0]));
	}
	
	//insert batch with named parameter
	public void insertBatchNamedParameter2(final List<Personne> personnes){
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(personnes.toArray());
        getSimpleJdbcTemplate().batchUpdate(
                "INSERT INTO PERSONNE (ID, NAME, AGE) VALUES (:id, :name, :age)",
                params);
    
	}
	
	//insert batch example with SQL
	public void insertBatchSQL(final String sql){
		
		getJdbcTemplate().batchUpdate(new String[]{sql});
		
	}
	
	//query single row with ParameterizedRowMapper
	public Personne findByPersonneId(int id){
		 
		String sql = "SELECT * FROM PERSONNE WHERE ID = ?";
 
		Personne personne = getSimpleJdbcTemplate().queryForObject(
				sql,  new PersonneParameterizedRowMapper(), id);
	
		return personne;
	}
	
	//query single row with ParameterizedBeanPropertyRowMapper (Personne.class)
	public Personne findByPersonneId2(int id){
		 
		String sql = "SELECT * FROM PERSONNE WHERE ID = ?";
 
		Personne personne = getSimpleJdbcTemplate().queryForObject(
				sql,ParameterizedBeanPropertyRowMapper.newInstance(Personne.class), id);
	
		return personne;
	}
	
	//query mutiple rows with ParameterizedBeanPropertyRowMapper (Personne.class)
	public List<Personne> findAll(){
		
		String sql = "SELECT * FROM PERSONNE";
		 
		List<Personne> personnes = 
			getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Personne.class));
		
		return personnes;
	}
	
	//query mutiple rows with ParameterizedBeanPropertyRowMapper (Personne.class)
	public List<Personne> findAll2(){
		
		String sql = "SELECT * FROM PERSONNE";
		
		List<Personne> personnes = 
			getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Personne.class));
		
		return personnes;
	}
	
	public String findPersonneNameById(int id){
		
		String sql = "SELECT NAME FROM PERSONNE WHERE ID = ?";
		 
		String name = getSimpleJdbcTemplate().queryForObject(
				sql, String.class, id);
	
		return name;
		
	}
	
	public int findTotalPersonne(){
		
		String sql = "SELECT COUNT(*) FROM PERSONNE";
		 
		int total = getSimpleJdbcTemplate().queryForInt(sql);
				
		return total;
	}
	
	
}
