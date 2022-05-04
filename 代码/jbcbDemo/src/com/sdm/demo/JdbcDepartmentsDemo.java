package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Departments;

public class JdbcDepartmentsDemo {
	public static void main(String[] args) {
	}

	public List<Departments> selectAll() {
		List<Departments> list = new ArrayList<Departments>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			String sql = "SELECT * FROM DEPARTMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
				Departments departments = new Departments(departmentId,departmentName,managerId,locationId);
				list.add(departments);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
