package com.jbk.Product.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

	public Supplier(int supplierId, String supplierName, String supplierAddress) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
	}

	@Id
	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	
	public int getSupplierId() {
		return supplierId;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierAddress="
				+ supplierAddress + "]";
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
}
