package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc练习2
 * 
 * @author shun_ 准备jdk1.8+eclipse环境 java se技术平台 创建Java项目 src文件
 */
public class Demo3 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("注册成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("注册失败 检查jar包和驱动名");
		}
		// 连接信息
		String url = "jdbc:oracle:thin:@localhost:1521/helowin";
		String root = "test";
		String pwd = "test";
		// 查询信息
		int bumenId = 11;
		String sql = "DELETE FROM BUMEN WHERE bumenId = " + bumenId;
		try {
			Connection con = DriverManager.getConnection(url, root, pwd);
			System.out.println("连接成功");
			Statement st = con.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println(count + "条数据被删除");
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败，请检查url，用户名，密码是否正确，数据库是否启动");
		} finally {

		}

	}

}
