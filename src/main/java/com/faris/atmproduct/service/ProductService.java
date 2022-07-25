package com.faris.atmproduct.service;

import java.util.List;

import com.faris.atmproduct.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);

	public List<Product> searchBy(String theName);
}
