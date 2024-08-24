package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectDbUtil;

public class RentAreaRepositoryImpl {
//	@Override
//	public List<RentAreaEntity> getValueByBuildingId(Long id) {
//		List<RentAreaEntity> rentAreas = new ArrayList<>();
//		try (Connection conn = ConnectDbUtil.getConnection()) {
//			StringBuilder sql = new StringBuilder("select * from rentarea where buildingid = " + id);
//			PreparedStatement stm = conn.prepareStatement(sql.toString());
//			ResultSet rs = stm.executeQuery();
//			
//			while(rs.next()) {
//				RentAreaEntity r = new RentAreaEntity();
//				r.setId(rs.getLong("id"));
//				r.setValue(rs.getString("value"));
//				rentAreas.add(r);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rentAreas;
//	}

}
