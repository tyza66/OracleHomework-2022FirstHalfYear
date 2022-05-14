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

	@Override
	public int employeeAdd(Employees e) {
		return employeeMapper.insert(e);
	}

	@Override
	public int employeeUpdate(Employees e) {
		return employeeMapper.updateById(e);
	}

	@Override
	public int employeeDelete(int id) {
		return employeeMapper.deleteById(id);
	}

	@Override
	public int login(int id, String pwd) {
		// 调用mapper层的方法进行条件查询
		Employees employees = employeeMapper.selectById(id);
		if (employees == null) {
			// 若结果为空则该用户不存在返回404
			return 404;
		} else if (!employees.getFirstName().equals(pwd)) {
			// 若用户存在但是密码错误，则返回500
			return 500;
		} else {
			//若以上两个条件均不成立则登陆成功
			return 200;
		}
	}

}
