package com.faris.atmproduct.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faris.atmproduct.entity.Product;
import com.faris.atmproduct.service.ProductService;

@RestController
@RequestMapping("api/v1/tipeproduct")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService prodService)
	{
		productService = prodService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getListTipeProduct()
	{
		List<Product> listProduct = null;
		
		try {
			listProduct = productService.findAll();
			
			return new ResponseEntity<>(listProduct, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Product> searchTipeProductById(@PathVariable("id") int id)
	{
		Product product = null;
		
		try {
			product = productService.findById(id);
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTipeProduct(@RequestBody Product prod)
	{
		try {
			prod.setHistoryDt(LocalDateTime.now());
			productService.save(prod);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		Product prodData = null;

		try {
			prodData = productService.findById(id);
			
			Product _product = prodData;
			_product.setNama(product.getNama());
			_product.setHistoryDt(LocalDateTime.now());
			_product.setCreName(product.getCreName());
			productService.save(_product);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteTipeProduct(@PathVariable("id") int id)
	{
		try {
			productService.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchorder")
	public ResponseEntity<List<Product>> getListTipeProductByContainsNameAndOrderByNameAsc(@RequestParam("name") String name)
	{
		List<Product> listProduct = null;
		List<Product> finalListProduct = null;
		
		try {
			listProduct = productService.searchBy(name);
			finalListProduct = listProduct.stream().sorted().collect(Collectors.toList());
			
			return new ResponseEntity<>(finalListProduct ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		finally {
			listProduct = null;
		}
	}
}
