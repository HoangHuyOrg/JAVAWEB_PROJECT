package com.javaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingResponsitory;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectDbUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingResponsitoryImpl implements BuildingRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;

	public void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		String staffId = Objects.toString(buildingSearchBuilder.getStaffIc(), null);

		if (!StringUtil.checkEmptyString(staffId)) {
			sql.append(" join assignmentbuilding a on a.buildingid = b.id ");
		}

		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if (typeCode != null && typeCode.size() != 0) {
			sql.append(" join buildingrenttype br on br.buildingid = b.id\r\n "
					+ " join renttype r on r.id = br.renttypeid ");
		}

		String rentAreaFrom = Objects.toString(buildingSearchBuilder.getAreafrom(), null);
		String rentAreaTo = Objects.toString(buildingSearchBuilder.getAreaTo(), null);

		if (!StringUtil.checkEmptyString(rentAreaFrom) || !StringUtil.checkEmptyString(rentAreaTo)) {
			sql.append(" join rentarea ra on ra.buildingid = b.id ");
		}

	}

	public void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area")
						&& !fieldName.startsWith("rentPrice")) {
//					String value = item.get(buildingSearchBuilder) != null ? item.get(buildingSearchBuilder).toString()c: null;
					String value = Objects.toString(item.get(buildingSearchBuilder), null);
					if (!StringUtil.checkEmptyString(value)) {
						if (NumberUtil.isNumber(value)) {
							where.append(" and b." + fieldName + " = " + value);
						} else {
							where.append(" and b." + fieldName + " like '%" + value + "%'");
						}
					}
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

//		for (Map.Entry<String, Object> item : params.entrySet()) {
//			if (!item.getKey().equals("staffId") && !item.getKey().equals("typeCode")
//					&& !item.getKey().startsWith("area") && !item.getKey().startsWith("rentPrice")) {
//				String value = item.getValue().toString();
//				if (!StringUtils.checkEmptyString(value)) {
//					where.append(" and b." + item.getKey() + " = " + value);
//				} else {
//					where.append(" and b." + item.getKey() + " like '%" + value + "'%");
//				}
//			}
//		}
	}

	public void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		Long staffId = buildingSearchBuilder.getStaffIc();
		if (staffId != null) {
			where.append(" and a.staffid = " + staffId);
		}

		Long rentAreaFrom = buildingSearchBuilder.getAreafrom();
		Long rentAreaTo = buildingSearchBuilder.getAreaTo();
		if (rentAreaFrom != null) {
			where.append(" and ra.value >= " + rentAreaFrom);
		}
		if (rentAreaTo != null) {
			where.append(" and ra.value <= " + rentAreaTo);
		}

		Long rentPriceaFrom = buildingSearchBuilder.getRentPricefrom();
		Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		if (rentPriceaFrom != null) {
			where.append(" and b.rentprice >= " + rentPriceaFrom);
		}
		if (rentPriceTo != null) {
			where.append(" and b.rentprice <= " + rentPriceTo);
		}

//		if (typeCode != null && typeCode.size() != 0) {
//			List<String> code = new ArrayList<String>();
//			for(String item: typeCode) {
//				code.add("'" + item + "'");
//			}
//			where.append(" and r.code in (" + String.join(",", code) + ")");
//
//		}

		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if (typeCode != null && typeCode.size() != 0) {
			where.append(" and (");
			String sql = typeCode.stream().map(item -> "r.code like " + "'%" + item + "%'")
					.collect(Collectors.joining(" or "));
			where.append(sql);
			where.append(" )");
		}
	}

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {

		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder sql = new StringBuilder(
				"select distinct b.* from building b");
		
//		StringBuilder sql = new StringBuilder(
//				"select distinct b.* from building b");
//		
		StringBuilder where = new StringBuilder(" where 1 = 1");

		joinTable(buildingSearchBuilder, sql);

		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);

		sql.append(where);
		System.out.println(sql);
		// Kiểm tra entityManager
	    if (entityManager == null) {
	        throw new IllegalStateException("EntityManager is null");
	    }
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);

		return query.getResultList();
	}

}
