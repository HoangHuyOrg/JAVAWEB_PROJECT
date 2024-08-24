package com.javaweb.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numberofbasement")
	private Long numberOfBasement;

	@Column(name = "name")
	private String name;

	@Column(name = "ward")
	private String ward;

	@Column(name = "street")
	private String street;

	@Column(name = "managerName")
	private String managerName;

	@Column(name = "managerPhoneNumber")
	private String managerPhoneNumber;

	@Column(name = "floorArea")
	private Long floorArea;

	@Column(name = "emptyArea")
	private String emptyArea;

	@Column(name = "rentPrice")
	private Long rentPrice;

	@Column(name = "serviceFee")
	private String serviceFee;

	@Column(name = "brokerageFee")
	private Long brokerageFee;

	@Column(name = "rentarea")
	private String rentarea;

	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;

	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreaEntities;

	public BuildingEntity() {
		super();
	}

	public BuildingEntity(Long id) {
		super();
		this.id = id;
	}

	

	public BuildingEntity(Long id, Long numberOfBasement, String name, String ward, String street, String managerName,
			String managerPhoneNumber, Long floorArea, String emptyArea, Long rentPrice, String serviceFee,
			Long brokerageFee, String rentarea, DistrictEntity district, List<RentAreaEntity> rentAreaEntities) {
		super();
		this.id = id;
		this.numberOfBasement = numberOfBasement;
		this.name = name;
		this.ward = ward;
		this.street = street;
		this.managerName = managerName;
		this.managerPhoneNumber = managerPhoneNumber;
		this.floorArea = floorArea;
		this.emptyArea = emptyArea;
		this.rentPrice = rentPrice;
		this.serviceFee = serviceFee;
		this.brokerageFee = brokerageFee;
		this.rentarea = rentarea;
		this.district = district;
		this.rentAreaEntities = rentAreaEntities;
	}

	public DistrictEntity getDistrictEntity() {
		return district;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.district = districtEntity;
	}

	public String getRentarea() {
		return rentarea;
	}

	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
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

	public List<RentAreaEntity> getRentAreaEntities() {
		return rentAreaEntities;
	}

	public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
		this.rentAreaEntities = rentAreaEntities;
	}

}
