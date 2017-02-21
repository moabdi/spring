package com.sqli.formation.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sqli.formation.dao.ProductDao;
import com.sqli.formation.model.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
	
	public void save(Product product){
		getHibernateTemplate().save(product);
	}
	
}