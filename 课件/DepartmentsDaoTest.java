package com.chinasoft.wxx.test;

import com.chinasoft.wxx.dao.DepartmentsDao;

/**
 * DepartmentsDao的测试
 * @author xiaoxi
 *
 */
public class DepartmentsDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentsDao dao = new DepartmentsDao();
		//删除
		System.out.println(dao.deleteById(15));
		//查询
		System.out.println(dao.selectAll());
	}

}
