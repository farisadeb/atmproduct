package com.faris.atmproduct.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_tipe_produk")
public class Product {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="history_dt")
	private LocalDateTime historyDt;
	
	@Column(name="cre_name")
	private String creName;

	// define constructor
	public Product() {
		
	}
	
	public Product(int id, String nama, LocalDateTime historyDt, String creName) {
		super();
		this.id = id;
		this.nama = nama;
		this.historyDt = historyDt;
		this.creName = creName;
	}
	
	public Product(String nama, LocalDateTime historyDt, String creName) {
		super();
		this.nama = nama;
		this.historyDt = historyDt;
		this.creName = creName;
	}

	// define getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public LocalDateTime getHistoryDt() {
		return historyDt;
	}

	public void setHistoryDt(LocalDateTime historyDt) {
		this.historyDt = historyDt;
	}

	public String getCreName() {
		return creName;
	}

	public void setCreName(String creName) {
		this.creName = creName;
	}
}
