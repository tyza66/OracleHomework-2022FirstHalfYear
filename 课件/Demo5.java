package com.chinasoft.wxx.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc练习5 --- PreparedStatement
 * Statement存在的问题
 * 	sql语句的拼接 非常的不友好
 *  sql注入式攻击
 *  
 *  为了解决以上的问题 sun公司 给Statement接口 提供了一个子接口PreparedStatement
 * @author xiaoxi
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url,"scott","orcl");
			//条件查询  根据部门编号 查询部门信息  使用占位符? 来临时表示 动态数据
			String sql = "select * from bumen where bumenid =?";
			//通过conn 并且还有 sql语句 一起获取到 PreparedStatement 对象 以实现 sql的预编译
			PreparedStatement ps = conn.prepareStatement(sql);
			//通过 ps对象的setXXX(问号的位置，问号对应的数据)方法  进行sql的动态拼接
			ps.setInt(1, 10);
			
			//sql拼接好后  执行并获取对应的结果  【注】此时sql已经存在于ps对象中 顾不能再次传sql语句
			ResultSet rs = ps.executeQuery();
			
			//遍历结果集并输出
			while(rs.next()) {
				//取出结果集的一条数据   根据字段名取出对应的数据
				int bumenId = rs.getInt("bumenid");  //调用的方法根据字段的数据类型对应
				String bumenName = rs.getString("bumenname");
				String bumenDiZhi = rs.getString("bumendizhi");
				System.out.println(bumenId+","+bumenName+","+bumenDiZhi);
			}
			//关闭资源
			rs.close();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
