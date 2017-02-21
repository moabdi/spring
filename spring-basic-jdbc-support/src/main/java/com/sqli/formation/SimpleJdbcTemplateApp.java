package com.sqli.formation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;

public class SimpleJdbcTemplateApp 
{
    public static void main( String[] args )
    {
    	//if you have time, 
    	//it's better to create an unit test rather than testing like this :)
    	
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	PersonneDAO personneSimpleDAO = (PersonneDAO) context.getBean("personneSimpleDAO");
        Personne personne1 = new Personne("PERSONNE1",21);
        Personne personne3 = new Personne("PERSONNE2",22);
        Personne personne2 = new Personne("PERSONNE3",23);
 
        List<Personne>personnes = new ArrayList<Personne>();
        personnes.add(personne1);
        personnes.add(personne2);
        personnes.add(personne3);
 
        personneSimpleDAO.insertBatch(personnes);

        String sql = "UPDATE PERSONNE SET NAME ='BATCHUPDATE'";
        personneSimpleDAO.insertBatchSQL(sql);
        
        System.out.println("Batch Insert Done!");
    	
        Personne personneA = personneSimpleDAO.findByPersonneId(1);
        System.out.println("Personne A : " + personneA);
        
        Personne personneB = personneSimpleDAO.findByPersonneId2(1);
        System.out.println("Personne B : " + personneB);
        
        List<Personne> personneAs = personneSimpleDAO.findAll();
        for(Personne cust: personneAs){
        	 System.out.println("Personne As : " + personneAs);
        }
       
        List<Personne> personneBs = personneSimpleDAO.findAll2();
        for(Personne cust: personneBs){
        	 System.out.println("Personne Bs : " + personneBs);
        }
        
        String personneName = personneSimpleDAO.findPersonneNameById(1);
        System.out.println("Personne Name : " + personneName);
        
        int total = personneSimpleDAO.findTotalPersonne();
        System.out.println("Total : " + total);
        
        
        Personne personne4 = new Personne("PERSONNE4",24);
        Personne personne5 = new Personne("PERSONNE5",25);
        Personne personne6 = new Personne("PERSONNE6",26);
 
        List<Personne>personnes2 = new ArrayList<Personne>();
        personnes2.add(personne4);
        personnes2.add(personne5);
        personnes2.add(personne6);
        
        personneSimpleDAO.insertBatchNamedParameter2(personnes2);
        
        //delete all records
        personneSimpleDAO.insertBatchSQL("DELETE FROM PERSONNE");
        System.out.println("Records Deleted!");
    }
}
