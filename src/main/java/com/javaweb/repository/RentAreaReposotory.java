package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.RentAreaEntity;

public interface RentAreaReposotory {
	List<RentAreaEntity> getValueByBuildingId(Long id);
}
