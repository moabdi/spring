package com.sqli.formation.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sqli.formation.dao.ProductDao;
import com.sqli.formation.dao.ProductQohDao;
import com.sqli.formation.model.Product;
import com.sqli.formation.model.ProductQoh;

public class ProductQohDaoImpl extends HibernateDaoSupport implements ProductQohDao{
	
	public void save(ProductQoh productQoh){
		getHibernateTemplate().save(productQoh);
	}
	
}