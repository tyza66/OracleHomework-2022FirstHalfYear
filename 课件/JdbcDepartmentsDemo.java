package com.chinasoft.wxx.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.wxx.entity.Departments;

/**
 * 封装 对departments表的操作 
 * @author xiaoxi
 *
 */
public class JdbcDepartmentsDemo {
	
	//修饰符 返回值类型  方法名(参数列表){ 方法体 }
	
	/*List 存储数据，有顺序 且可重复
	 * Set  不可以重复
	 * Map   键值对形式存储
	 */
//	将查询部门表所有数据封装成一个方法
	//额外声明 该返回值类型 是一个 存放 Departments对象 的集合
	public List<Departments> selectAll() {
		//创建List集合 用于存放 所有的部门 对象
		List<Departments> list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url, "scott", "orcl");
			String sql = "select  * from departments";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
				
//				将以上根据字段名取出的数据 组装成一个部门对象,此处的参数顺序 与实体类中的带参构造参数顺序 一一对应
				Departments  departments = new Departments(departmentId,departmentName,managerId,locationId);
//				将上述对象存放到集合中
				list.add(departments);
			}
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
//		返回组装好的list集合
		return list;
	}
	
	//将增加部门信息 封装为一个方法
	public int insert(Departments d) {
//		定义变量存放数据增加的条数
		int code = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url, "scott", "orcl");
			String sql = "insert into departments values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
//			将传进来的参数 部门对象 中的数据 一一拼装到 sql语句中
			ps.setInt(1, d.getDepartmentId());
			ps.setString(2, d.getDepartmentName());
			ps.setInt(3, d.getManagerId());
			ps.setInt(4, d.getLocationId());
			
			code = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
}
