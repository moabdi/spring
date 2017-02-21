package com.sqli.formation.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sqli.formation.bo.ProductBo;
import com.sqli.formation.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	Product product = new Product();
    	product.setProductCode("ABC");
    	product.setProductDesc("This is product ABC");
    	
    	ProductBo productBo = (ProductBo)appContext.getBean("productBoProxy");
    	productBo.save(product, 100);
    	
    	
    }
}
