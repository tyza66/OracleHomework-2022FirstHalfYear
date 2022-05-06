package com.sdm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sdm.entity.Departments;
import com.sdm.util.BaseDao;

//封装了对Departments表数据的操作
public class DepartmrntsDao {
	// 所有方法都需要baseDao将其升级为属性
	BaseDao dao = new BaseDao();

	// 查
	public List<Departments> selectAll() {
		List<Departments> list = new ArrayList<Departments>();
		String sql = "select * from departments";
		ResultSet rs = dao.query(sql, null);
		try {
			while (rs.next()) {
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
				Departments departments = new Departments(departmentId, departmentName, managerId, locationId);
				list.add(departments);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 增
	public int insert(Departments d) {
		int code = 0;
		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
		Object[] params = { d.getDepartmentId(), d.getDepartmentName(), d.getManagerId(), d.getLoactionId() };
		code = dao.update(sql, params);
		return code;
	}

	// 删
	public int deleteById(int id) {
		String sql = "delete from departments where department_id = ?";
		Object[] params = { id };
		return dao.update(sql, params);
	}

	// 改
	public int updateById(int id, Departments d) {
		String sql = "UPDATE DEPARTMENTS SET department_name = ?,manager_id = ?,location_id = ? WHERE department_id = ?";
		Object[] params = { d.getDepartmentName(), d.getManagerId(), d.getLoactionId(), id };
		return dao.update(sql, params);
	}
}
