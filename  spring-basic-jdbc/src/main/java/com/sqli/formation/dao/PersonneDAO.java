package com.sqli.formation.dao;

import com.sqli.formation.model.Personne;

public interface PersonneDAO 
{
	public void insert(Personne personne);
	public Personne findByPersonneId(int id);
}




