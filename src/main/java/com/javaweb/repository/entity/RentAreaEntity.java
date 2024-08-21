package com.javaweb.repository.entity;

public class RentAreaEntity {
	private long id;
	private String value;
	public RentAreaEntity() {
		super();
	}
	public RentAreaEntity(long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
