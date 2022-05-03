package com.chinasoft.wxx.demo;
/**
 * jdbc练习2---修改
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) {
//		jdbc模板代码
//		注册驱动---通过驱动类名注册oracle驱动
		try {      //右键  ---> surround with ----> try/catch block
			//try 代码块 放可能有异常的代码
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("注册成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			若try代码块 代码抛出异常，catch代码块 根据指定的异常类型去捕获异常 并执行对应的代码
			//打印异常的栈轨迹
			e.printStackTrace();
			System.out.println("注册失败 请检查驱动jar包 及驱动名");
		}
		
//		建立连接   【要连接的数据库的地址   用户名  密码】
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String root = "scott";
		String pwd = "orcl";
		try {
			// Ctrl键 + Shift键 + O键  引包 Java.sql包
			Connection conn = DriverManager.getConnection(url, root, pwd);
			System.out.println("连接成功");
//			执行sql语句
//			sql语句字符串拼接
			int bumenId = 12;
			String bumenName = "杨婷婷集团";
			String sql = "update bumen set bumenname ='"+bumenName+"' where bumenid ="+bumenId;
			// 通过 已经建立好的连接  来获取Statement 对象 
			Statement st = conn.createStatement();
//			通过st对象 来进而执行sql语句
//			【DML】 结果仅有 多少行数据被更改的记录
//			jdbc 自动提交事务
			int count = st.executeUpdate(sql);
			System.out.println(count+"条数据被修改");
//			处理结果集【dml没有结果集】
//			关闭资源
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败 请检查url，用户名，密码是否正确，数据库服务是否启动");
		}
		

	}
}
