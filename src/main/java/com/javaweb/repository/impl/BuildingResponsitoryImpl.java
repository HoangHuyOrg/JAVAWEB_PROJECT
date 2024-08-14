package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingResponsitory;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingResponsitoryImpl implements BuildingResponsitory {
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=estatebasic;encrypt=true;trustServerCertificate=true";
	static final String USER = "sa";
	static final String PASS = "123";//;))
	

	@Override
	public List<BuildingEntity> findAll(String name, Long districtid) {

		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			StringBuilder sql = new StringBuilder("select * from building where 1 = 1");
			
			if(name != null && !name.equals("")) {
				sql .append("and name like '%" + name + "%'");
			}
			
			if(districtid != null && !districtid.equals("")) {
				sql .append("and districtid like '%" + districtid + "%'");
			}
			
			PreparedStatement stm = conn
					.prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				BuildingEntity b = new BuildingEntity();
				b.setName(rs.getString("name"));
				b.setStreet(rs.getString("street"));
				b.setWard(rs.getString("ward"));
				b.setNumberOfBasement(rs.getInt("numberOfBasement"));
				buildingEntities.add(b);
			}
			
			return buildingEntities;
		} catch (SQLException e) {
			System.out.println("Lỗi SQL: " + e.getMessage());
			System.out.println("Connected database failed...");
		}
		return null;
	}

}
