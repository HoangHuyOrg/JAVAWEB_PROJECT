package com.javaweb.repository.entity;

public class BuildingEntity {

	private Long id;
	private Long numberOfBasement;
	private String name;
	private String ward;
	private String street;
	private DistrictEntity district;
	private String managerName;
	private String managerPhoneNumber;
	private Long floorArea;
	private String emptyArea;
	private Long rentPrice;
	private String serviceFee;
	private Long brokerageFee;
	private String rentarea;

	public BuildingEntity() {
		super();
	}

	public BuildingEntity(Long id) {
		super();
		this.id = id;
	}

	
	
	public BuildingEntity(Long id, Long numberOfBasement, String name, String ward, String street,
			DistrictEntity district, String managerName, String managerPhoneNumber, Long floorArea, String emptyArea,
			Long rentPrice, String serviceFee, Long brokerageFee, String rentarea) {
		super();
		this.id = id;
		this.numberOfBasement = numberOfBasement;
		this.name = name;
		this.ward = ward;
		this.street = street;
		this.district = district;
		this.managerName = managerName;
		this.managerPhoneNumber = managerPhoneNumber;
		this.floorArea = floorArea;
		this.emptyArea = emptyArea;
		this.rentPrice = rentPrice;
		this.serviceFee = serviceFee;
		this.brokerageFee = brokerageFee;
		this.rentarea = rentarea;
	}

	public String getRentarea() {
		return rentarea;
	}

	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public String getEmptyArea() {
		return emptyArea;
	}

	public void setEmptyArea(String emptyArea) {
		this.emptyArea = emptyArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

}
