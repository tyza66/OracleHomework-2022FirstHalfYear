package com.sdm.service.imp;

import java.util.List;

import com.sdm.entity.Employees;
import com.sdm.mapper.EmployeeMapper;
import com.sdm.service.EmployeesService;

public class EmployeesServiceImp implements EmployeesService {

		EmployeeMapper employeeMapper = new EmployeeMapper();
	@Override
	public List<Employees> employeeInfo() {
		return employeeMapper.selectAll();
	}

}
