package com.pccw.digitalstore.brand.dto;

public class BrandPutDTO {
	
	BrandPutDTO(){
	}
	
	public BrandPutDTO(String name){
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
