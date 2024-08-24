package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingResponsitory;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
@Primary
public class BuildingResponsitoryImpl implements BuildingResponsitory{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		//JPQL
//		String sql = "select b from BuildingEntity b ";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class);
//		return query.getResultList();
		
		//sql Native
		String sql = "select * from building b where b.name like '%building%'";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}

}
