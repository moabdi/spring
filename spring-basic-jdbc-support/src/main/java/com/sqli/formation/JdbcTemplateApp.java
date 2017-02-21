package com.sqli.formation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sqli.formation.dao.PersonneDAO;
import com.sqli.formation.model.Personne;

public class JdbcTemplateApp 
{
    public static void main( String[] args )
    {
    	//if you have time, 
    	//it's better to create an unit test rather than testing like this :)
    	
    	 ApplicationContext context = 
    		new ClassPathXmlApplicationContext("applicationContext.xml");
    	 
    	 PersonneDAO personneDAO = (PersonneDAO) context.getBean("personneDAO");
         Personne personne1 = new Personne("PERSONNE1",21);
         Personne personne3 = new Personne("PERSONNE2",22);
         Personne personne2 = new Personne("PERSONNE3",23);
  
         List<Personne>personnes = new ArrayList<Personne>();
         personnes.add(personne1);
         personnes.add(personne2);
         personnes.add(personne3);
  
         personneDAO.insertBatch(personnes);

         String sql = "UPDATE PERSONNE SET NAME ='BATCHUPDATE'";
         personneDAO.insertBatchSQL(sql);
         
         System.out.println("Batch Insert Done!");
         
         Personne personneA = personneDAO.findByPersonneId(22);
         System.out.println("Personne A : " + personneA);
         
         Personne personneB = personneDAO.findByPersonneId2(21);
         System.out.println("Personne B : " + personneB);
         
         List<Personne> personneAs = personneDAO.findAll();
         for(Personne cust: personneAs){
         	 System.out.println("Personne As : " + personneAs);
         }
        
         List<Personne> personneBs = personneDAO.findAll2();
         for(Personne cust: personneBs){
         	 System.out.println("Personne Bs : " + personneBs);
         }
         
         String personneName = personneDAO.findPersonneNameById(1);
         System.out.println("Personne Name : " + personneName);
         
         int total = personneDAO.findTotalPersonne();
         System.out.println("Total : " + total);
         
         //delete all records
         personneDAO.insertBatchSQL("DELETE FROM PERSONNE");
         System.out.println("Records Deleted!");
         
       
    }
}
