package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yqxd.entity.QuarantineQuarantine;
import com.yqxd.util.BaseDao;

public class QuarantineQuarantineMapper {
	BaseDao bd = new BaseDao();

	public List<QuarantineQuarantine> getQuarantineQuarantine() {
		List<QuarantineQuarantine> list = new ArrayList<QuarantineQuarantine>();
		String sql = "Select * from quarantine_quarantine3";
		ResultSet rs = bd.query(sql, null);
		try {
			while (rs.next()) {
				String quarantineId=rs.getString("quarantine_id");
				String quarantineName=rs.getString("quarantine_name");
				String quarantineSex=rs.getString("quarantine_sex");
				int quarantineAge=rs.getInt("quarantine_age");
				String quarantineNumber=rs.getString("quarantine_number");
				String quarantineSymptom=rs.getString("quarantine_symptom");
				String quarantineCheckDate=rs.getString("quarantine_checkDate");
				String quarantineQuarantineDate=rs.getString("quarantine_quarantineDate");
				String quarantineTravelPath=rs.getString("quarantine_travelPath");
				String quarantinePassword=rs.getString("quarantine_password");
				int departmentId=rs.getInt("department_id");
				String roomId=rs.getString("room_id");
				String nucleicAcidResult=rs.getString("nucleicAcidResult");
				QuarantineQuarantine a = new QuarantineQuarantine(quarantineId,quarantineName,quarantineSex,
						quarantineAge,quarantineNumber,quarantineSymptom,quarantineCheckDate,quarantineQuarantineDate,
						quarantineTravelPath,quarantinePassword,departmentId,roomId,nucleicAcidResult);
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
	
	public int addToQuarantineQuarantine(QuarantineQuarantine a) {
		//如何在插入时自动插入当前系统时间   并自动插入隔离天数  就好像  你输入身份证号，自动填写你的生日信息
		String sql = "insert into Quarantine_Quarantine3 values(?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),sysdate,?,?,?,?,?)";
		Object[] params= {a.getQuarantine_id(),a.getQuarantine_name(),a.getQuarantine_sex(),
				a.getQuarantine_age(),a.getQuarantine_number(),
			a.getQuarantine_symptom(),a.getQuarantine_checkDate(),a.getQuarantine_travelPath(),a.getQuarantine_password()
			,a.getDepartment_id(),a.getRoom_id(),a.getNucleicAcidResult()};
		
		
		return bd.update(sql, params);
	}
	
	public int deleteQuarantineQuarantineById(String id) {
		String sql = "delete from Quarantine_Quarantine3 where quarantine_id = ?";
		Object[] params = { id };
		return bd.update(sql, params);
	}
	
	public int updateById(QuarantineQuarantine a) {
		String sql = "UPDATE Quarantine_Quarantine3 SET quarantine_id = ?,quarantine_name = ?,quarantine_sex = ? ,quarantine_age=?,quarantine_number=?,quarantine_symptom=?,quarantine_checkDate=to_date(?,'YYYY-MM-DD HH24:MI:SS'),quarantine_quarantineDate=to_date(?,'YYYY-MM-DD HH24:MI:SS'),"
				+ "quarantine_travelPath=?,quarantine_password=?,department_id=?,room_id=?,nucleicAcidResult=? WHERE quarantine_id = ?";
		Object[] params = {a.getQuarantine_id(),a.getQuarantine_name(),a.getQuarantine_sex(),a.getQuarantine_age(),a.getQuarantine_number(),
				a.getQuarantine_symptom(),a.getQuarantine_checkDate(),a.getQuarantine_quarantineDate(),a.getQuarantine_travelPath(),a.getQuarantine_password(),a.getDepartment_id(),a.getRoom_id(),a.getNucleicAcidResult(),a.getQuarantine_id()};
		return bd.update(sql, params);
	} 


}
