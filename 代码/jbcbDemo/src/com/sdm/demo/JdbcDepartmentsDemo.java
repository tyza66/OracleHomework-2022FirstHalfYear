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
	//查询
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
	//插入
	public int insert(Departments departments) {
		int code = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			String sql = "INSERT INTO departments VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, departments.getDepartmentId());
			ps.setString(2, departments.getDepartmentName());
			ps.setInt(3, departments.getManagerId());
			ps.setInt(4, departments.getLoactionId());
			code = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	//修改
	public int updateByDepartmentId(int departmentId,String departmentName,int managerId,int loactionId) {
		int code = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			String sql = "UPDATE departments SET department_name = ?,manager_id = ?,location_id= ? WHERE department_id = ?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, departmentName);
			ps.setInt(2, managerId);
			ps.setInt(3, loactionId);
			ps.setInt(4, departmentId);
			code = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	//删除
	public int deleteByDepartmentId(int departmentId) {
		int code = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			String sql = "DELETE FROM departments WHERE department_id = ?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, departmentId);
			code = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	
}
