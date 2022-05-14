package com.sdm.service;

import java.util.List;

import com.sdm.entity.Employees;

public interface EmployeesService {
	List<Employees> employeeInfo();

	int employeeAdd(Employees e);

	int employeeUpdate(Employees e);

	int employeeDelete(int id);
	/*
	 * @param id 用户名
	 * @param pwd 密码
	 * @return 200登陆成功 404用户名不存在
	 */
	int login(int id,String pwd);
}
