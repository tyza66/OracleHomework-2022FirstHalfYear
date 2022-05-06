package com.sdm.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Departments;
import com.sdm.util.BaseDao;

//封装了对Departments表数据的操作
public class DepartmrntsDao {
	// 所有方法都需要baseDao将其升级为属性
	BaseDao dao = new BaseDao();

	public List<Departments> selectAll() {
		List<Departments> list = new ArrayList();
		String sql = "select * from departments";
		ResultSet rs = dao.query(sql, null);
		
		return list;
	}

	public int insert(Departments d) {
		int code = 0;
		String sql = "INSERT INTO DEPARTMENTS VALUES(?,?,?,?)";
		Object[] params = { d.getDepartmentId(), d.getDepartmentName(), d.getManagerId(), d.getLoactionId() };
		code = dao.update(sql, params);
		return code;
	}

}
