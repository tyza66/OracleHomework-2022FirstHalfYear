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
	
	public int updateById(Employees e) {
		String sql = "UPDATE employees SET FIRST_NAME = ?,LAST_NAME = ?,EMAIL = ?,PHONE_NUMBER = ?,JOB_ID = ?,SALARY = ?,COMMISSION_PCT = ?,MANAGER_ID = ?,DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";
		Object[] params = { e.getFirstName(),e.getFirstName(),e.getEmail(),e.getPhoneNumber(),e.getJobId(),e.getSalary(),e.getCommissionPct(),e.getManagerId(),e.getDepartmentId(),e.getEmployeeId()};
		return baseDao.update(sql, params);
	} 
	
	public int deleteById(int id) {
		String sql = "delete from employees where EMPLOYEE_ID = ?";
		Object[] params = { id };
		return baseDao.update(sql, params);
	}
	
	public Employees selectById(int id){
		String sql = "Select * from employees where employee_id = ?";
		Object[] params = { id };
		ResultSet rs = baseDao.query(sql, params);
		Employees employees = null;
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
				employees = new Employees(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId,
						salary, commissionPct, managerId, departmentId);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return employees;
	}
}
