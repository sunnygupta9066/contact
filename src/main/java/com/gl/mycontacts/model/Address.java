package com.gl.mycontacts.model;

import com.gl.mycontacts.util.Validator;

public class Address {

	private String label;
	private String address;
	
	public Address(String label, String address) throws Exception {
		if(label == null || label.isBlank() || label.length()> 255 || Validator.containsNumber(label)){
			throw new RuntimeException();
		}
		this.label = label;
		this.address =address;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String getAddress() {
		return this.address;
	}
}
