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

	public int insert(Departments d) {
		int code = 0;
		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
		Object[] params = { d.getDepartmentId(), d.getDepartmentName(), d.getManagerId(), d.getLoactionId() };
		code = dao.update(sql, params);
		return code;
	}

}
