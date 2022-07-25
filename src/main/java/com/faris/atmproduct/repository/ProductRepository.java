package com.faris.atmproduct.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faris.atmproduct.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value="SELECT p.* FROM tbl_tipe_produk p "
			+ "ORDER BY nama ASC",
			nativeQuery=true)
	public List<Product> findAllByOrderNameAsc();
	
	@Query(value="SELECT p.* FROM tbl_tipe_produk p "
			+ "WHERE p.nama LIKE %?1%",
			nativeQuery=true)
	public List<Product> findByContainsName(String name);
	
}
