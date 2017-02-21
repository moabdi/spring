package com.sqli.formation.bo.impl;

import com.sqli.formation.bo.ProductQohBo;
import com.sqli.formation.dao.ProductQohDao;
import com.sqli.formation.model.ProductQoh;

public class ProductQohBoImpl implements ProductQohBo{
	
	ProductQohDao productQohDao;
	
	public void setProductQohDao(ProductQohDao productQohDao) {
		this.productQohDao = productQohDao;
	}

	public void save(ProductQoh productQoh){
		productQohDao.save(productQoh);
	}

}
