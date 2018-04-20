package com.pccw.digitalstore.category.dto;

public class CategoryPutDTO {
	
	CategoryPutDTO(){
	}
	
	public CategoryPutDTO(String name){
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
