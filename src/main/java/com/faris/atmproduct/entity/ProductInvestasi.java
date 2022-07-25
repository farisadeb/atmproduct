package com.faris.atmproduct.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_produk_investasi")
public class ProductInvestasi {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="tp_id")
	private int tpId;
	
	@Column(name="min_investasi")
	private Double minInvestasi;
	
	@Column(name="return_year")
	private int returnYear;
	
	@Column(name="return_persen_year")
	private int returnPersenYear;
	
	@Column(name="history_dt")
	private LocalDateTime historyDt;
	
	@Column(name="cre_name")
	private String creName;
		
	
	// define constructor
	public ProductInvestasi() {
		
	}


	public ProductInvestasi(int id, String nama, int tpId, Double minInvestasi, int returnYear, int returnPersenYear,
			LocalDateTime historyDt, String creName) {
		super();
		this.id = id;
		this.nama = nama;
		this.tpId = tpId;
		this.minInvestasi = minInvestasi;
		this.returnYear = returnYear;
		this.returnPersenYear = returnPersenYear;
		this.historyDt = historyDt;
		this.creName = creName;
	}
	
	public ProductInvestasi(String nama, int tpId, Double minInvestasi, int returnYear, int returnPersenYear,
			LocalDateTime historyDt, String creName) {
		super();
		this.nama = nama;
		this.tpId = tpId;
		this.minInvestasi = minInvestasi;
		this.returnYear = returnYear;
		this.returnPersenYear = returnPersenYear;
		this.historyDt = historyDt;
		this.creName = creName;
	}

	// define getter setter
	

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


	public int getTpId() {
		return tpId;
	}


	public void setTpId(int tpId) {
		this.tpId = tpId;
	}


	public Double getMinInvestasi() {
		return minInvestasi;
	}


	public void setMinInvestasi(Double minInvestasi) {
		this.minInvestasi = minInvestasi;
	}


	public int getReturnYear() {
		return returnYear;
	}


	public void setReturnYear(int returnYear) {
		this.returnYear = returnYear;
	}


	public int getReturnPersenYear() {
		return returnPersenYear;
	}


	public void setReturnPersenYear(int returnPersenYear) {
		this.returnPersenYear = returnPersenYear;
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


	//define toString
	@Override
	public String toString() {
		return "ProductInvestasi [id=" + id + ", nama=" + nama + ", tpId=" + tpId + ", minInvestasi=" + minInvestasi
				+ ", returnYear=" + returnYear + ", returnPersenYear=" + returnPersenYear + ", historyDt=" + historyDt
				+ ", creName=" + creName + "]";
	}
	
}
