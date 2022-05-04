package com.chinasoft.wxx.demo;

import java.util.List;

import com.chinasoft.wxx.entity.Departments;

public class DepaertmentsMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcDepartmentsDemo demo = new JdbcDepartmentsDemo();
		
		//测试增加
		Departments d = new Departments(15,"鲁仲建工作组",200,1700);
		demo.insert(d);
//		在主程序实现查询功能
		
		System.out.println(demo.selectAll());
		
		
		
		
	}

}
