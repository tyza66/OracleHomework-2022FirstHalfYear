package com.yqxd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yqxd.entity.MessageInfo;
import com.yqxd.entity.Vegetables;
import com.yqxd.util.BaseDao;

public class MessageMapper {
	BaseDao bd = new BaseDao();

	public List<MessageInfo> selectAll() {
		List<MessageInfo> list = new ArrayList<MessageInfo>();
		String sql = "Select * from message_info";
		ResultSet rs = bd.query(sql, null);
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String phone = rs.getString(2);
				String time = rs.getString(3);
				String passage = rs.getString(4);
				MessageInfo a = new MessageInfo(id,phone,time,passage);
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
	public int addToMessage(MessageInfo v) {
		String sql = "insert into message_info values(?,?,?,?)";
		Object[] params= {v.getId(),v.getPhone(),v.getTime(),v.getPassage()};
		return bd.update(sql, params);
	}
	
	public int deleteMessageById(int id) {
		String sql = "delete from message_info where m_id = ?";
		Object[] params = { id };
		return bd.update(sql, params);
	}
	
	public int updateById(MessageInfo v) {
		String sql = "UPDATE Message_Info SET phone = ?,m_time = ?,passage = ? WHERE m_id = ?";
		Object[] params = {v.getPhone(),v.getTime(),v.getPassage(),v.getTime()};
		return bd.update(sql, params);
	} 
}
