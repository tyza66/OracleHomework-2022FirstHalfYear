package com.chinasoft.wxx.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.wxx.util.BaseDao;

/**
 * 测试BaseDao工具
 * @author xiaoxi
 *
 */
public class BaseDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//以操作部门表为例子
		BaseDao dao = new BaseDao();
		//测试增加
//		String  sql = "insert into bumen values(?,?,?)";
//		Object[] params = {99,"测试部门","滨海小区"};
//		
//		int code = dao.update(sql, params);
//		System.out.println(code);
		
		//测试查询
		String sql = "select * from bumen";
		ResultSet rs = dao.query(sql, null);
		
		try {
			while(rs.next()) {
				int bumenId = rs.getInt("bumenid");
				String bumenName = rs.getString("bumenname");
				String bumenDiZhi = rs.getString("bumendizhi");
				System.out.println(bumenId+","+bumenName+","+bumenDiZhi);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
