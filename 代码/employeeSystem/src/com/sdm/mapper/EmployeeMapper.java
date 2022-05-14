package com.sdm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Employees;
import com.sdm.util.BaseDao;

public class EmployeeMapper {
	BaseDao baseDao = new BaseDao();

	// 查询所有员工信息
	public List<Employees> selectAll() {
		List<Employees> list = new ArrayList<Employees>();
		String sql = "Select * from Employees";
		ResultSet rs = baseDao.query(sql, null);
		try {
			while (rs.next()) {
				int employeeId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String phoneNumber = rs.getString(5);
				String hireDate = rs.getString(6);
				String jobId = rs.getString(7);
				double salary = rs.getDouble(8);
				double commissionPct = rs.getDouble(9);
				int managerId = rs.getInt(10);
				int departmentId = rs.getInt(11);
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

	public int insert(Employees e) {
		String sql = "insert into employees values(?,?,?,?,?,sysdate,?,?,?,?,?)";
		Object[] params= {e.getEmployeeId(),e.getFirstName(),e.getLastName(),e.getEmail(),e.getPhoneNumber(),e.getJobId(),e.getSalary(),e.getCommissionPct(),e.getManagerId(),e.getDepartmentId()};
		return baseDao.update(sql, params);
	}
}
