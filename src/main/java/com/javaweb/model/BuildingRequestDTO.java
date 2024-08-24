package com.javaweb.model;

public class BuildingRequestDTO {
	private Long id;
	private String name;
	private String ward;
	private String street;
	private Long districtid;
	private Long retnprice;

	
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
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	public Long getRetnprice() {
		return retnprice;
	}
	public void setRetnprice(Long retnprice) {
		this.retnprice = retnprice;
	}
	
	
}
