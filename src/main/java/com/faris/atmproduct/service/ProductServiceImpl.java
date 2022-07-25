package com.faris.atmproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faris.atmproduct.entity.Product;
import com.faris.atmproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository prodRepository)
	{
		productRepository = prodRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAllByOrderNameAsc();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		
		Product theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			throw new RuntimeException("Did not find Product id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

	@Override
	public List<Product> searchBy(String theName) {
		
		List<Product> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = productRepository.findByContainsName(theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
	
}
