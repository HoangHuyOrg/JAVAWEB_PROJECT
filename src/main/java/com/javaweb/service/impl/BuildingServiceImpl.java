package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Sides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingResponsitory;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingResponsitory buildingResponsitory;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long districtid) {
		List<BuildingEntity> buildingEntities = buildingResponsitory.findAll(name, districtid);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		//ủa hom xuong dc repo luôn 
		for(BuildingEntity b: buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(b.getName());
			building.setNumberOfBasement(b.getNumberOfBasement());
			building.setAddress(b.getStreet() + " " + b.getWard());
			result.add(building);
			System.out.println(building);
		}
		return result; 
	}
	
}
