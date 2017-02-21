package com.sqli.formation.bo.impl;

import com.sqli.formation.bo.ProductBo;
import com.sqli.formation.bo.ProductQohBo;
import com.sqli.formation.dao.ProductDao;
import com.sqli.formation.model.Product;
import com.sqli.formation.model.ProductQoh;

public class ProductBoImpl implements ProductBo{
	
	ProductDao productDao;
	ProductQohBo productQohBo;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void setProductQohBo(ProductQohBo productQohBo) {
		this.productQohBo = productQohBo;
	}

	public void save(Product product, int qoh){
		
		productDao.save(product);
		System.out.println("Product Inserted");
		
		ProductQoh productQoh = new ProductQoh();
		productQoh.setProductId(product.getProductId());
		productQoh.setQty(qoh);
		
		//productQoh.setProductId(123);
		
		productQohBo.save(productQoh);
		System.out.println("ProductQoh Inserted");
		
	}

}
