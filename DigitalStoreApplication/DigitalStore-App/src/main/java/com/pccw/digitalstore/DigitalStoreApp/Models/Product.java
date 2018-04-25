package com.pccw.digitalstore.DigitalStoreApp.Models;

public class Product {
	private Long id;
	private String sku;
	private String name;
	private Integer attributeSetId;
	private Double price;
	private Integer status;
	private Integer visibility;
	private String typeId;
	private String createdAt;
	private String updatedAt;
	private Double weight;
	
	public Product(String sku, String name, Double price, Double weight, Integer status, Integer visibility) {
		this.sku = sku;
		this.name = name;;
		this.price = price;
		this.weight = weight;
		this.status = status;
		this.visibility = visibility;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAttributeSetId() {
		return attributeSetId;
	}
	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
