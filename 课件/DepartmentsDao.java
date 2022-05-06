package com.chinasoft.wxx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.wxx.entity.Departments;
import com.chinasoft.wxx.util.BaseDao;

/**
 * 利用BaseDao 对JdbcDepartmentsDemo实现优化
 * 后续的项目中 格式均雷同
 * 
 * 封装了 对departments表数据的操作
 * @author xiaoxi
 *
 */
public class DepartmentsDao {
//	由于所有方法均需要BaseDao,故将其升级为属性
	BaseDao dao =  new BaseDao();
	//查询全部
	public List<Departments> selectAll() {
		//定义sql
		String sql = "select  * from departments";
		ResultSet rs = dao.query(sql, null);
		//准备集合 用于存放 所有的部门对象
		List<Departments> list = new ArrayList();
		//对rs进行处理 并组装
		try {
			while(rs.next()) {
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				int managerId = rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
				
//			将以上根据字段名取出的数据 组装成一个部门对象,此处的参数顺序 与实体类中的带参构造参数顺序 一一对应
				Departments  departments = new Departments(departmentId,departmentName,managerId,locationId);
//			将上述对象存放到集合中
				list.add(departments);
			}
			//rs使用完 直接关闭
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭资源
			dao.closeAll();
		}
		return list;
	}
	//增加
	public int insert(Departments d) {
		//定义 sql语句 及 参数数组
		String sql = "insert into departments values(?,?,?,?)";
		Object[] params = {d.getDepartmentId(),d.getDepartmentName(),d.getManagerId(),d.getLocationId()};
		//调用方法执行并返回
		return dao.update(sql, params);
	}
	//修改
	public int updateName(int id,String name) {
		return 0;
	}
	//删除
	public int deleteById(int id) {
		//定义 sql语句 及 参数数组
		String sql = "delete from departments where department_id=?";
		Object[] params = {id};
		//调用方法执行并返回
		return dao.update(sql, params);
	}
}
