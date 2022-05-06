package com.sdm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdm.entity.Departments;
import com.sdm.entity.Yuangong;
import com.sdm.util.BaseDao;

public class YuangongDao {
	BaseDao dao = new BaseDao();

	// 1.查看员工信息列表
	public List<Yuangong> selectAll() {
		List<Yuangong> list = new ArrayList<Yuangong>();
		String sql = "select * from yuangong";
		ResultSet rs = dao.query(sql, null);
		try {
			while (rs.next()) {
				int yuangongID = rs.getInt("YUANGONGID");
				String yuangongName = rs.getString("YUANGONGNAME");
				String yuangongZhiwei = rs.getString("YUANGONGZHIWEI");
				int jingliId = rs.getInt("JINGLIID");
				String ruzhiRiqi = rs.getString("RUZHIRIQI");
				int jibengongzi = rs.getInt("JIBENGONGZI");
				int jiangjin = rs.getInt("JIANGJINd");
				int bumenId = rs.getInt("BUMENID");
				Yuangong yuangong = new Yuangong(yuangongID, yuangongName, yuangongZhiwei, jingliId, ruzhiRiqi,
						jibengongzi, jiangjin, bumenId);
				list.add(yuangong);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.新增员工信息
	public int insert(Yuangong yg) {
		int code = 0;
		String sql = "INSERT INTO yuangong VALUES(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		Object[] params = { yg.getYuangongID(), yg.getYuangongName(), yg.getYuangongZhiwei(), yg.getJingliId(),
				yg.getRuzhiRiqi(), yg.getJibengongzi(), yg.getJiangjin(), yg.getBumenId() };
		code = dao.update(sql, params);
		return code;
	}

	// 3.输入员工编号查询该员工信息
	public List<Yuangong> selectById(int id) {
		List<Yuangong> list = new ArrayList<Yuangong>();
		String sql = "SELECT * FROM yuangong WHERE YUANGONGID = ?";
		Object[] params = { id };
		ResultSet rs = dao.query(sql, params);
		try {
			while (rs.next()) {
				int yuangongID = rs.getInt("YUANGONGID");
				String yuangongName = rs.getString("YUANGONGNAME");
				String yuangongZhiwei = rs.getString("YUANGONGZHIWEI");
				int jingliId = rs.getInt("JINGLIID");
				String ruzhiRiqi = rs.getString("RUZHIRIQI");
				int jibengongzi = rs.getInt("JIBENGONGZI");
				int jiangjin = rs.getInt("JIANGJINd");
				int bumenId = rs.getInt("BUMENID");
				Yuangong yuangong = new Yuangong(yuangongID, yuangongName, yuangongZhiwei, jingliId, ruzhiRiqi,
						jibengongzi, jiangjin, bumenId);
				list.add(yuangong);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 4.输入员工编号修改员工工资
	public int updateGongziById(int id,int gongzi) {
		String sql = "UPDATE yuangong SET JIBENGONGZI = ? WHERE YUANGONGID = ?";
		Object[] params = { gongzi,id };
		return dao.update(sql, params);
	}
	// 5.输入两个工资，查询工资在其范围内的员工的信息
	public List<Yuangong> selectByTwoGongzi(int z1,int z2) {
		int min,max;
		if(z1<=z2) {
			min = z1;
			max = z2;
		}else {
			min = z2;
			max = z1;
		}
		List<Yuangong> list = new ArrayList<Yuangong>();
		String sql = "SELECT * FROM yuangong WHERE JIBENGONGZI BETWEEN ? AND ?";
		Object[] params = { min,max };
		ResultSet rs = dao.query(sql, params);
		try {
			while (rs.next()) {
				int yuangongID = rs.getInt("YUANGONGID");
				String yuangongName = rs.getString("YUANGONGNAME");
				String yuangongZhiwei = rs.getString("YUANGONGZHIWEI");
				int jingliId = rs.getInt("JINGLIID");
				String ruzhiRiqi = rs.getString("RUZHIRIQI");
				int jibengongzi = rs.getInt("JIBENGONGZI");
				int jiangjin = rs.getInt("JIANGJINd");
				int bumenId = rs.getInt("BUMENID");
				Yuangong yuangong = new Yuangong(yuangongID, yuangongName, yuangongZhiwei, jingliId, ruzhiRiqi,
						jibengongzi, jiangjin, bumenId);
				list.add(yuangong);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 6.输入编号，删除员工信息
	// 7.按照员工姓名模糊搜索员工信息
	// 8.批量删除员工【提高】
}
