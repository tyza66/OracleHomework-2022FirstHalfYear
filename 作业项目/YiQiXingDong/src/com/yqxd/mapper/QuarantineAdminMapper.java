package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yqxd.entity.QuarantineAdmin;
import com.yqxd.util.BaseDao;

public class QuarantineAdminMapper {
	BaseDao bd = new BaseDao();

	public List<QuarantineAdmin> selectAll() {
		List<QuarantineAdmin> list = new ArrayList<QuarantineAdmin>();
		String sql = "Select * from quarantine_admin";
		ResultSet rs = bd.query(sql, null);
		try {
			while (rs.next()) {
				int admin_id = rs.getInt(1);
				String admin_name = rs.getString(2);
				String admin_sex = rs.getString(3);
				String admin_number = rs.getString(4);
				String admin_workDate = rs.getString(5);
				String admin_workCondition = rs.getString(6);
				int department_id = rs.getInt(8);
				QuarantineAdmin a = new QuarantineAdmin(admin_id, admin_name, admin_sex, admin_number, admin_workDate,
						admin_workCondition, null, department_id);
				list.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll();
		}
		return list;
	}

	public int insert(QuarantineAdmin a) {
		String sql = "insert into quarantine_admin values(ID_quarantine_admin.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		Object[] params = { a.getAdmin_name(), a.getAdmin_sex(), a.getAdmin_number(), a.getAdmin_workDate(),
				a.getAdmin_workCondition(), a.getAdmin_password(), a.getDepartment_id() };
		return bd.update(sql, params);
	}

	public int updateById(QuarantineAdmin a) {
		String sql = "UPDATE quarantine_admin SET admin_name = ?,admin_sex = ?,admin_number = ?,admin_workDate = to_date(?,'yyyy-mm-dd'),admin_workCondition = ?,admin_password = ?,department_id = ? WHERE admin_id = ?";
		Object[] params = { a.getAdmin_name(), a.getAdmin_sex(), a.getAdmin_number(), a.getAdmin_workDate(),
				a.getAdmin_workCondition(), a.getAdmin_password(), a.getDepartment_id(), a.getAdmin_id() };
		return bd.update(sql, params);
	}

	public int deleteById(int id) {
		String sql = "delete from quarantine_admin where admin_id = ?";
		Object[] params = { id };
		return bd.update(sql, params);
	}

	public QuarantineAdmin selectById(int id) {
		String sql = "Select * from quarantine_admin where admin_id = ?";
		Object[] params = { id };
		ResultSet rs = bd.query(sql, params);
		QuarantineAdmin quarantineAdmin = null;
		try {
			while (rs.next()) {
				int admin_id = rs.getInt(1);
				String admin_name = rs.getString(2);
				String admin_sex = rs.getString(3);
				String admin_number = rs.getString(4);
				String admin_workDate = rs.getString(5);
				String admin_workCondition = rs.getString(6);
				String admin_password = rs.getString(7);
				int department_id = rs.getInt(8);
				quarantineAdmin = new QuarantineAdmin(admin_id, admin_name, admin_sex, admin_number, admin_workDate,
						admin_workCondition, admin_password, department_id);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll();
		}
		return quarantineAdmin;
	}

	public QuarantineAdmin selectByName(String name) {
		String sql = "Select * from quarantine_admin where admin_name = ?";
		Object[] params = { name };
		ResultSet rs = bd.query(sql, params);
		QuarantineAdmin quarantineAdmin = null;

		try {
			while (rs.next()) {
				int admin_id = rs.getInt(1);
				String admin_name = rs.getString(2);
				String admin_sex = rs.getString(3);
				String admin_number = rs.getString(4);
				String admin_workDate = rs.getString(5);
				String admin_workCondition = rs.getString(6);
				String admin_password = rs.getString(7);
				int department_id = rs.getInt(8);
				quarantineAdmin = new QuarantineAdmin(admin_id, admin_name, admin_sex, admin_number, admin_workDate,
						admin_workCondition, admin_password, department_id);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll();
		}
		return quarantineAdmin;
	}
}
