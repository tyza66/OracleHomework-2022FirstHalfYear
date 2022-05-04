package com.sdm.demo;

import java.util.List;

import com.sdm.entity.Departments;

public class DepartmentMenu {
	public static void main(String[] args) {
		JdbcDepartmentsDemo  demo = new JdbcDepartmentsDemo();
//		Departments d = new Departments(1,"2",200,1700);
//		demo.insert(d);
//		demo.deleteByDepartmentId(1);
		demo.updateByDepartmentId(1, "giao", 200, 1700);
		List<Departments> list =  demo.selectAll();
		System.out.println(list);
	}
}
