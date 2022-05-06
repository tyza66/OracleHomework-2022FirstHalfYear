package com.sdm.test;

import java.sql.ResultSet;

import com.sdm.util.BaseDao;

public class BaseDaoTest {
	public static void main(String[] args) {
		BaseDao dao = new BaseDao();
		//测试增加
//		String sql = "insert into bumen values(?,?,?)";
//		Object[] params = { 99, "测试部门", "滨海小区" };
//		int dode = dao.update(sql, params);
//		System.out.println(dao);
		//测试查询
		String sql= "select * from bumen";
		ResultSet rs = dao.query(sql, null);
		while(rs.next()){
			
		}
	}
}
