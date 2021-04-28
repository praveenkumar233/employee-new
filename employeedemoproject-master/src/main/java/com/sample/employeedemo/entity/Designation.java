package com.sample.employeedemo.entity;

public enum Designation {
	ASSOCIATE("ASSOCIATE"),
	MANAGER("MANAGER"),
	ARCHITECT("ARCHITECT");
	
	private final String designation;
	Designation(String designation){
		this.designation=designation;
	}
}