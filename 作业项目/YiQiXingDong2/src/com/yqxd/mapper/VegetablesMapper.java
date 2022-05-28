package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yqxd.entity.Vegetables;
import com.yqxd.util.BaseDao;

public class VegetablesMapper {
	BaseDao bd = new BaseDao();

	public List<Vegetables> selectAll() {
		List<Vegetables> list = new ArrayList<Vegetables>();
		String sql = "Select * from Vegetable";
		ResultSet rs = bd.query(sql, null);
		try {
			while (rs.next()) {
				int vegetable_id = rs.getInt(1);
				String vegetable_kinds = rs.getString(2);
				int vegetable_number = rs.getInt(3);
				String vegetable_place = rs.getString(4);
				Vegetables a = new Vegetables(vegetable_id,vegetable_kinds,vegetable_number,vegetable_place);
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
	
	public int addToVegetable(Vegetables v) {
		String sql = "insert into Vegetable values(?,?,?,?)";
		Object[] params= {v.getVegetable_id(),v.getVegetable_kinds(),v.getVegetable_number(),v.getVegetable_place()};
		return bd.update(sql, params);
	}
	
	public int deleteVegetableById(int id) {
		String sql = "delete from Vegetable where vegetable_id = ?";
		Object[] params = { id };
		return bd.update(sql, params);
	}
	
	public int updateById(Vegetables v) {
		String sql = "UPDATE Vegetable SET vegetable_kinds = ?,vegetable_number = ?,vegetable_place = ? WHERE vegetable_id = ?";
		Object[] params = {v.getVegetable_kinds(),v.getVegetable_number(),v.getVegetable_place(),v.getVegetable_id()};
		return bd.update(sql, params);
	} 
}
