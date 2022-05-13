package com.sdm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Employees;
import com.sdm.util.BaseDao;

public class EmployeeMapper {
	BaseDao baseDao = new BaseDao();

	public List<Employees> selectAll() {
		List<Employees> list = new ArrayList<Employees>();
		String sql = "Select * from Employees";
		ResultSet rs = baseDao.query(sql, null);
		try {
			while (rs.next()) {
				int bumenId = rs.getInt("bumenID");
				int employeeId = rs.getInt(0);
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);
				String phoneNumber = rs.getString(4);
				String hireDate = rs.getString(5);
				String jobId = rs.getString(6);
				double salary = rs.getDouble(7);
				double commissionPct = rs.getDouble(8);
				int managerId = rs.getInt(9);
				int departmentId = rs.getInt(10);
				Employees e = new Employees(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId,
						salary, commissionPct, managerId, departmentId);
				list.add(e);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return list;
	}
}
