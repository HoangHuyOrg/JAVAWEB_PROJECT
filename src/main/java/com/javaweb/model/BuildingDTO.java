package com.javaweb.model;

import com.javaweb.repository.entity.DistrictEntity;

//Data Transfer Object
public class BuildingDTO {
	private Long id;
	private String name;
	private Long numberOfBasement;
	private String address;
	private String rentArea;
	private DistrictDTO districtDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public DistrictDTO getDistrictDTO() {
		return districtDTO;
	}

	public void setDistrictDTO(DistrictDTO districtDTO) {
		this.districtDTO = districtDTO;
	}

	@Override
	public String toString() {
		return "BuildingDTO [name=" + name + ", numberOfBasement=" + numberOfBasement + ", address=" + address
				+ ", rentArea=" + rentArea + "]";
	}

}
