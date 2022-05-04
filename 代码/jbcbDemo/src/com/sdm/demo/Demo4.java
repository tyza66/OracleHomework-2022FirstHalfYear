package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM BUMEN";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int bumenId = rs.getInt("bumenId");
				String bumenName = rs.getString("bumenName");
				String bumenDiZhi = rs.getString("bumenDizhi");
				System.out.println(bumenId+","+bumenName+","+bumenDiZhi);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("注册失败");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作数据库失败");
		}
	}
}
