package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder convertToBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
				.setName(MapUtil.getObject(params, "name", String.class))
				.setFloorArea(MapUtil.getObject(params, "floorarea", Long.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setStreet(MapUtil.getObject(params, "street", String.class))
				.setDistrictcode(MapUtil.getObject(params, "districtid", String.class))
				.setNumberOfBasement(MapUtil.getObject(params, "numberofbasement", Integer.class)).setTypeCode(typeCode)
				.setManagerName(MapUtil.getObject(params, "managername", String.class))
				.setManagerPhoneNumber(MapUtil.getObject(params, "managerphonenumber", String.class))
				.setRentPriceTo(MapUtil.getObject(params, "rentPriceTo", Long.class))
				.setRentPricefrom(MapUtil.getObject(params, "rentPriceFrom", Long.class))
				.setAreafrom(MapUtil.getObject(params, "areaFrom", Long.class))
				.setAreaTo(MapUtil.getObject(params, "areaTo", Long.class))
				.setStaffIc(MapUtil.getObject(params, "staffId", Long.class)).getNewBuilding();

		return buildingSearchBuilder;
	}
}
