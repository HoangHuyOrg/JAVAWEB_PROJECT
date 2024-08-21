package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private String districtid;
	private Integer numberOfBasement;
	private List<String> typeCode = new ArrayList<>();
	private String managerName;
	private String managerPhoneNumber;
	private Long rentPricefrom;
	private Long rentPriceTo;
	private Long areafrom;
	private Long areaTo;
	private Long staffId;
	
	public BuildingSearchBuilder(Builder b) {
		super();
		this.name = b.name;
		this.floorArea = b.floorArea;
		this.ward = b.ward;
		this.street = b.street;
		this.districtid = b.districtid;
		this.numberOfBasement = b.numberOfBasement;
		this.typeCode = b.typeCode;
		this.managerName = b.managerName;
		this.managerPhoneNumber = b.managerPhoneNumber;
		this.rentPricefrom = b.rentPricefrom;
		this.rentPriceTo = b.rentPriceTo;
		this.areafrom = b.areafrom;
		this.areaTo = b.areaTo;
		this.staffId = b.staffId;
	}
	public String getName() {
		return name;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public String getDistrictcode() {
		return districtid;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	public String getManagerName() {
		return managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public Long getRentPricefrom() {
		return rentPricefrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public Long getAreafrom() {
		return areafrom;
	}
	public Long getAreaTo() {
		return areaTo;
	}
	public Long getStaffIc() {
		return staffId;
	}
	
	public static class Builder {
		private String name;
		private Long floorArea;
		private String ward;
		private String street;
		private String districtid;
		private Integer numberOfBasement;
		private List<String> typeCode = new ArrayList<>();
		private String managerName;
		private String managerPhoneNumber;
		private Long rentPricefrom;
		private Long rentPriceTo;
		private Long areafrom;
		private Long areaTo;
		private Long staffId;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setDistrictcode(String districtid) {
			this.districtid = districtid;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}
		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}
		public Builder setRentPricefrom(Long rentPricefrom) {
			this.rentPricefrom = rentPricefrom;
			return this;
		}
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setAreafrom(Long areafrom) {
			this.areafrom = areafrom;
			return this;
		}
		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}
		public Builder setStaffIc(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		public BuildingSearchBuilder getNewBuilding() {
			return new BuildingSearchBuilder(this);
		}
	}
}
