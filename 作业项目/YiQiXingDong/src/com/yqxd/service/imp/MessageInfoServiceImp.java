package com.yqxd.service.imp;

import java.util.List;

import com.yqxd.entity.MessageInfo;
import com.yqxd.mapper.MessageMapper;
import com.yqxd.service.MessageInfoService;

public class MessageInfoServiceImp  implements MessageInfoService{
	MessageMapper me=new MessageMapper();

	@Override
	public List<MessageInfo> getAllMessage() {
		// TODO 自动生成的方法存根
		return me.selectAll();
	}

	@Override
	public int addMessage(MessageInfo v) {
		// TODO 自动生成的方法存根
		return me.addToMessage(v);
	}

	@Override
	public int deleteMessage(int id) {
		// TODO 自动生成的方法存根
		return me.deleteMessageById(id);
	}

	@Override
	public int updateMessage(MessageInfo v) {
		// TODO 自动生成的方法存根
		return me.updateById(v);
	}
}
