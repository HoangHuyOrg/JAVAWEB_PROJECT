package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.ConnectDbUtil;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntity findByID(Long districtId) {
		DistrictEntity result = new DistrictEntity();
		try (Connection conn = ConnectDbUtil.getConnection()) {
			StringBuilder sql = new StringBuilder("select * from district d where id = " + districtId);

			PreparedStatement stm = conn.prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				result.setId(rs.getLong("id"));
				result.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			System.out.println("Lỗi SQL: " + e.getMessage());
			System.out.println("Connected database failed...");
		}
		return result;
	}

}
