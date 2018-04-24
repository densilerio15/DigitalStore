package com.pccw.digitalstore.product.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductImageDTO {
	
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
	private String imagePath;
	private MultipartFile image;
	
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "ProductImageDTO [sku=" + sku + ", name=" + name + ", attributeSetId=" + attributeSetId + ", price="
				+ price + ", status=" + status + ", visibility=" + visibility + ", typeId=" + typeId + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", weight=" + weight + ", imagePath=" + imagePath
				+ ", image=" + image + "]";
	}
	
}
