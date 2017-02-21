package com.sqli.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	 
        PersonneDAO personneDAO = (PersonneDAO) context.getBean("personneDAO");
        Personne personne = new Personne(9, "Ali",28);
        personneDAO.insert(personne);
    	
        Personne personne1 = personneDAO.findByPersonneId(1);
        System.out.println(personne1);
         
        ((AbstractApplicationContext) context).close();
        
    }
}
