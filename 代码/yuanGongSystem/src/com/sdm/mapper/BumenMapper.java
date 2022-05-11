package com.sdm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Bumen;
import com.sdm.util.BaseDao;

//负责实现数据库与实体类之间的映射关系
//这里是对部门表的所有操作
public class BumenMapper {
	BaseDao baseDao = new BaseDao();

	public List<Bumen> selectAll() {
		List<Bumen> list = new ArrayList<Bumen>();
		String sql = "Select * from bumen";
		ResultSet rs = baseDao.query(sql, null);
		try {
			while (rs.next()) {
				int bumenId = rs.getInt("bumenID");
				String bumenName = rs.getString("bumenname");
				String bumenDizhi = rs.getString("BUMENDIZHI");
				Bumen bumen = new Bumen(bumenId, bumenName, bumenDizhi);
				list.add(bumen);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int insert(Bumen bumen) {
		return 0;
	}

	public int update(Bumen bumen) {
		return 0;
	}

	public int delete(int bumenId) {
		return 0;
	}
}
