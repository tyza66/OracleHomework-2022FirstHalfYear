package com.sdm.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sdm.util.BaseDao;

public class BaseDaoTest {
	public static void main(String[] args) {
		BaseDao dao = new BaseDao();
		// 测试增加
		// String sql = "insert into bumen values(?,?,?)";
		// Object[] params = { 99, "测试部门", "滨海小区" };
		// int dode = dao.update(sql, params);
		// System.out.println(dao);
		// 测试查询
		String sql = "select * from bumen";
		ResultSet rs = dao.query(sql, null);
		try {
			while (rs.next()) {
				int bumenId = rs.getInt("bumenid");
				String bumenName = rs.getString("bumenname");
				String bumenDiZhi = rs.getString("bumendizhi");
				System.out.println(bumenId + "," + bumenName + "," + bumenDiZhi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
