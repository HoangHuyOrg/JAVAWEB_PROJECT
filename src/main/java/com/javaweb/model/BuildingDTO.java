package com.javaweb.model;

//Data Transfer Object
public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BuildingDTO [name=" + name + ", numberOfBasement=" + numberOfBasement + ", address=" + address + "]";
	}

	

}
