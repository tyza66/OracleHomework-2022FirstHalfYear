package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yqxd.entity.Friends;
import com.yqxd.util.BaseDao;

public class FriendsMapper {
	BaseDao bd = new BaseDao();
	public Friends getFriends() {
		String sql = "Select * from Friends";
		ResultSet rs = bd.query(sql, null);
		Friends f = null;
		try {
			while (rs.next()) {
				int pk = rs.getInt(1);
				int z1 = rs.getInt(2);
				int z2 = rs.getInt(3);
				int z3 = rs.getInt(4);
				int z4 = rs.getInt(5);
				int z5 = rs.getInt(6);
				int z6 = rs.getInt(7);
				int z7 = rs.getInt(8);
				int z8 = rs.getInt(9);
				int z9 = rs.getInt(10);
				int z10 = rs.getInt(11);
				f = new Friends(pk,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll();
		}
		return f;
	}
	
	public int updateById(Friends f) {
		String sql = "UPDATE Friends set z1=?,z2=?,z3=?,z4=?,z5=?,z6=?,z7=?,z8=?,z9=?,z10=? where zid=1";
		Object[] params = {f.getZ1(),f.getZ2(),f.getZ3(),f.getZ4(),f.getZ5(),f.getZ6(),f.getZ7(),f.getZ8(),f.getZ9(),f.getZ10()};
		return bd.update(sql, params);
	} 
}
