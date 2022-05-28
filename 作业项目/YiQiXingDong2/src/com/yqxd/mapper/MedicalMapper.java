package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yqxd.entity.Medical;
import com.yqxd.entity.Vegetables;
import com.yqxd.util.BaseDao;

public class MedicalMapper {
	BaseDao bd = new BaseDao();

	public List<Medical> selectAll() {
		List<Medical> list = new ArrayList<Medical>();
		String sql = "Select * from Medical";
		ResultSet rs = bd.query(sql, null);
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String time = rs.getString(2);
				String pname = rs.getString(3);
				String dname = rs.getString(4);
				String classify = rs.getString(5);
				Medical a = new Medical(id,time,pname,dname,classify);
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
	
	public int addToMedical(Medical v) {
		String sql = "insert into Medical values(?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		Object[] params= {v.getId(),v.getTime(),v.getPname(),v.getDname(),v.getClassify()};
		return bd.update(sql, params);
	}
	
	public int deleteMedicalById(int id) {
		String sql = "delete from Medical where me_id = ?";
		Object[] params = { id };
		return bd.update(sql, params);
	}
	
	public int updateById(Medical v) {
		String sql = "UPDATE Medical SET m_time = to_date(?,'YYYY-MM-DD HH24:MI:SS'),patient_name = ?,doctor_name = ?,classify = ? WHERE me_id = ?";
		Object[] params = {v.getTime(),v.getPname(),v.getDname(),v.getClassify(),v.getId()};
		return bd.update(sql, params);
	} 
}
