package com.chinasoft.wxx.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc练习4 ---查询
 * @author xiaoxi
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url, "scott", "orcl");
			String sql = "select * from bumen";
			Statement st = conn.createStatement();			
			//利用st对象执行 查询语句
			ResultSet rs = st.executeQuery(sql);
			/*for while  do while 三种语句均可以表示所有的循环
			 * for 适用于，循环次数已知，且先判断 后执行
			 * while 适用于  循环次数未知 且先判断后执行
			 * do while 适用于  循环次数未知 且先执行 后判断
			 * foreach--for (集合元素类型 集合元素名字 : 集合名字){}
			 */
//			next()方法 返回是否存在 未被遍历到的元素  返回值类型为boolean
			System.out.println("以下为查询结果");
			while(rs.next()) {
				//取出结果集的一条数据   根据字段名取出对应的数据
				int bumenId = rs.getInt("bumenid");  //调用的方法根据字段的数据类型对应
				String bumenName = rs.getString("bumenname");
				String bumenDiZhi = rs.getString("bumendizhi");
				System.out.println(bumenId+","+bumenName+","+bumenDiZhi);
			}
			//关闭资源
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("注册失败！！！！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("操作数据库失败！！！！");
		}
		
	}

}
