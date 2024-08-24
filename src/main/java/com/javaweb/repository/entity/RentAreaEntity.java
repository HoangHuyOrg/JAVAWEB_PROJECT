package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity building;

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

	public BuildingEntity getBuildingEntity() {
		return building;
	}

	public void setBuildingEntity(BuildingEntity buildingEntity) {
		this.building = buildingEntity;
	}

	
}
