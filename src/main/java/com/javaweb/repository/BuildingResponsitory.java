package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public interface BuildingResponsitory extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom{
	BuildingEntity findById(Long id);
	void deleteByIdIn(Long[] ids);
	List<BuildingEntity> findByNameContainingAndStreet(String name, String street);
}
