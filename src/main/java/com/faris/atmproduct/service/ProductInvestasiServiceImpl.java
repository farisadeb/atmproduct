package com.faris.atmproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faris.atmproduct.entity.ProductInvestasi;
import com.faris.atmproduct.repository.ProductInvestasiRepository;

@Service
public class ProductInvestasiServiceImpl implements ProductInvestasiService {
	private ProductInvestasiRepository productInvestasiRepository;
	
	@Autowired
	public ProductInvestasiServiceImpl(ProductInvestasiRepository prodInvRepository)
	{
		productInvestasiRepository = prodInvRepository;
	}
	
	@Override
	public List<ProductInvestasi> findAll() {
		return productInvestasiRepository.findAllByOrderNameAsc();
	}

	@Override
	public ProductInvestasi findById(int theId) {
		Optional<ProductInvestasi> result = productInvestasiRepository.findById(theId);
		
		ProductInvestasi theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			throw new RuntimeException("Did not find Product Investasi id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(ProductInvestasi theProduct) {
		productInvestasiRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productInvestasiRepository.deleteById(theId);
	}

	@Override
	public List<ProductInvestasi> searchBy(String theName) {
		
		List<ProductInvestasi> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = productInvestasiRepository.findByContainsName(theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
}
