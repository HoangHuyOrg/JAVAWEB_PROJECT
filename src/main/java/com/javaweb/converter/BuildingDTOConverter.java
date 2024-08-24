package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.DistrictDTO;
import com.javaweb.repository.BuildingResponsitory;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private BuildingResponsitory buildingResponsitory;
	
	@Autowired
	private DistrictRepository districtRepository;

//	@Autowired
//	private RentAreaRepository rentAreaRepository;
//	@Autowired
//	private DistrictRepository districtRepository;

	@Autowired
	private ModelMapper mapper;

	public BuildingDTO convertToBuildingDTO(BuildingEntity b) {
//		BuildingDTO building = mapper.map(b, BuildingDTO.class);
		
		BuildingDTO building = new BuildingDTO();
		building.setId(b.getId());
		building.setName(b.getName());
		building.setNumberOfBasement(b.getNumberOfBasement());
		building.setAddress(b.getStreet() + " " + b.getWard() + " " + b.getDistrictEntity().getName());
		
		DistrictDTO districtDTO = new DistrictDTO();
		districtDTO.setId(b.getDistrictEntity().getId());
		districtDTO.setName(b.getDistrictEntity().getName());
		
		building.setDistrictDTO(districtDTO);
		List<RentAreaEntity> rentAreaEntities = b.getRentAreaEntities();
		String stringOfRentAreas = rentAreaEntities.stream().map(item -> item.getValue().toString()).collect(Collectors.joining(", "));
		building.setRentArea(stringOfRentAreas);
		return building;
	}

}
