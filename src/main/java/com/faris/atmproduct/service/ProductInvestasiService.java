package com.faris.atmproduct.service;

import java.util.List;

import com.faris.atmproduct.entity.ProductInvestasi;

public interface ProductInvestasiService {
	public List<ProductInvestasi> findAll();
	
	public ProductInvestasi findById(int theId);
	
	public void save(ProductInvestasi theProduct);
	
	public void deleteById(int theId);

	public List<ProductInvestasi> searchBy(String theName);
}
