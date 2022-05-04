package com.sdm.demo;

import java.util.List;

import com.sdm.entity.Departments;

public class DepartmentMenu {
	public static void main(String[] args) {
		JdbcDepartmentsDemo  demo = new JdbcDepartmentsDemo();
		List<Departments> list =  demo.selectAll();
		System.out.println(list);
	}
}
