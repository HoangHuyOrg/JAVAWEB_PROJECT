package com.javaweb.model;

import com.javaweb.repository.entity.DistrictEntity;

//Data Transfer Object
public class BuildingDTO {
	private String name;
	private Long numberOfBasement;
	private String address;
	private String rentArea;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

	@Override
	public String toString() {
		return "BuildingDTO [name=" + name + ", numberOfBasement=" + numberOfBasement + ", address=" + address
				+ ", rentArea=" + rentArea + "]";
	}

	
}
