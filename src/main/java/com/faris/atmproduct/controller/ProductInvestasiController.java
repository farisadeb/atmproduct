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
import com.faris.atmproduct.entity.ProductInvestasi;
import com.faris.atmproduct.service.ProductInvestasiService;
import com.faris.atmproduct.service.ProductService;

@RestController
@RequestMapping("api/v1/product")
public class ProductInvestasiController {
	
	private ProductInvestasiService productInvestasiService;
	
	@Autowired
	public ProductInvestasiController(ProductInvestasiService prodService)
	{
		productInvestasiService = prodService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductInvestasi>> getListTipeProduct()
	{
		List<ProductInvestasi> listProduct = null;
		
		try {
			listProduct = productInvestasiService.findAll();
			
			return new ResponseEntity<>(listProduct, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<ProductInvestasi> searchTipeProductById(@PathVariable("id") int id)
	{
		ProductInvestasi product = null;
		
		try {
			product = productInvestasiService.findById(id);
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTipeProduct(@RequestBody ProductInvestasi prod)
	{
		try {
			prod.setHistoryDt(LocalDateTime.now());
			productInvestasiService.save(prod);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody ProductInvestasi product) {
		ProductInvestasi prodData = null;

		try {
			prodData = productInvestasiService.findById(id);
			
			ProductInvestasi _product = prodData;
			_product.setNama(product.getNama());
			_product.setTpId(product.getTpId());
			_product.setMinInvestasi(product.getMinInvestasi());
			_product.setReturnYear(product.getReturnYear());
			_product.setReturnPersenYear(product.getReturnPersenYear());
			_product.setHistoryDt(LocalDateTime.now());
			_product.setCreName(product.getCreName());
			productInvestasiService.save(_product);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductInvestasi(@PathVariable("id") int id)
	{
		try {
			productInvestasiService.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchorder")
	public ResponseEntity<List<ProductInvestasi>> getListTipeProductByContainsNameAndOrderByNameAsc(@RequestParam("name") String name)
	{
		List<ProductInvestasi> listProduct = null;
		List<ProductInvestasi> finalListProduct = null;
		
		try {
			listProduct = productInvestasiService.searchBy(name);
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
