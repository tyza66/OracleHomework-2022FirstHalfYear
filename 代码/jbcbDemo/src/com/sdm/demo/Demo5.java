package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo5 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			String sql = "SELECT * FROM BUMEN WHERE BUMENid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 32);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int bumenId = rs.getInt("bumenId");
				String bumenName = rs.getString("bumenName");
				String bumenDiZhi = rs.getString("bumenDizhi");
				System.out.println(bumenId+","+bumenName+","+bumenDiZhi);
			}
			rs.close();
			ps.close();
			con.close();
			con.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("注册失败");
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("操作数据库失败");
		}
	}
}
