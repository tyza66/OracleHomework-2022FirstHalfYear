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
		} finally {
			baseDao.closeAll();
		}
		return list;
	}

	public int insert(Bumen bumen) {
		int code = 0;
		String sql = "INSERT INTO bumen VALUES(?,?,?)";
		Object[] params = { bumen.getBumenId(), bumen.getBumenName(), bumen.getBumenDiZhi() };
		code = baseDao.update(sql, params);
		return code;
	}

	public int updateById(Bumen bumen) {
		int code = 0;
		String sql = "update bumen set bumenname = ?,BUMENDIZHI = ? where bumenID = ?";
		Object[] params = { bumen.getBumenName(), bumen.getBumenDiZhi(), bumen.getBumenId() };
		code = baseDao.update(sql, params);
		return code;
	}

	public int delete(int bumenId) {
		int code = 0;
		String sql = "delete from bumen where bumenID = ?";
		Object[] params = { bumenId };
		code = baseDao.update(sql, params);
		return code;
	}
}
