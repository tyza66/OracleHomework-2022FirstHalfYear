package com.sdm.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc练习1
 * @author shun_
 * 准备jdk1.8+eclipse环境  java se技术平台
 * 创建Java项目 src文件
 */
public class Demo1 {
//alt+?
	//jar包拖进src,右键bulid path
	//注册驱动
	//建立连接
	//执行sql语句
	//关闭资源
	public static void main(String[] args) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("注册成功");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("注册失败 检查jar包和驱动名");
			}
			try {
			      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/helowin","test","test");
			      System.out.println("连接成功");
			      Statement st = con.createStatement();
			      ResultSet rs = st.executeQuery ("SELECT * FROM Student");	
			      while (rs.next()) {
			             int x = rs.getInt("a");
			             String s = rs.getString("b");
			      }
			      rs.close();
			      st.close();
			      con.close();
			} catch (SQLException e) {
			      e.printStackTrace();
			      System.out.println("连接失败，请检查url，用户名，密码是否正确，数据库是否启动");
			}

	}

}
