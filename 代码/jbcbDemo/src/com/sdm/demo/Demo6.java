package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo6 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/helowin";
			String root = "test";
			String pwd = "test";
			Connection con = DriverManager.getConnection(url, root, pwd);
			Statement st = con.createStatement();
			//输入
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String yhm = sc.next();
			System.out.println("请输入密码：");
			String mm = sc.next();
			String sql = "SELECT * FROM EMPLOYEES WHERE first_name = '"+ yhm +"' AND last_name = '"+ mm +"'";
			//查询
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
			//关闭资源
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
