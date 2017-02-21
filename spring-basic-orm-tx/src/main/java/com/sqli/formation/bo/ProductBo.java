package com.sqli.formation.bo;

import com.sqli.formation.model.Product;

public interface ProductBo {
	
	void save(Product product, int qoh);
	
}
