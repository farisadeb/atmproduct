package com.faris.atmproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faris.atmproduct.entity.ProductInvestasi;

@Repository
public interface ProductInvestasiRepository extends JpaRepository<ProductInvestasi, Integer> {

	@Query(value="SELECT p.* FROM tbl_produk_investasi p "
			+ "ORDER BY nama ASC",
			nativeQuery=true)
	public List<ProductInvestasi> findAllByOrderNameAsc();
	
	@Query(value="SELECT p.* FROM tbl_produk_investasi p "
			+ "WHERE p.nama LIKE %?1%",
			nativeQuery=true)
	public List<ProductInvestasi> findByContainsName(String name);
}
