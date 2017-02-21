package com.sqli.formation.dao;

import java.util.List;

import com.sqli.formation.model.Personne;

public interface PersonneDAO 
{
	public void insert(Personne personne);
	
	public void insertNamedParameter(Personne personne);
			
	public void insertBatch(List<Personne> personne);
	
	public void insertBatchNamedParameter(List<Personne> personne);
	
	public void insertBatchNamedParameter2(List<Personne> personne);
			
	public void insertBatchSQL(String sql);
	
	public Personne findByPersonneId(int id);
	
	public Personne findByPersonneId2(int id);

	public List<Personne> findAll();
	
	public List<Personne> findAll2();
	
	public String findPersonneNameById(int id);
	
	public int findTotalPersonne();
	
}




