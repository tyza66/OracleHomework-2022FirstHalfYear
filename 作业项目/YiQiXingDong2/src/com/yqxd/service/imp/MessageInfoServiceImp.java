package com.yqxd.service.imp;

import java.util.List;

import com.yqxd.entity.MessageInfo;
import com.yqxd.mapper.MessageMapper;
import com.yqxd.service.MessageInfoService;

public class MessageInfoServiceImp implements MessageInfoService {
	MessageMapper me = new MessageMapper();

	@Override
	public List<MessageInfo> getAllMessage() {
		// TODO �Զ����ɵķ������
		return me.selectAll();
	}

	@Override
	public int addMessage(MessageInfo v) {
		// TODO �Զ����ɵķ������
		return me.addToMessage(v);
	}

	@Override
	public int deleteMessage(int id) {
		// TODO �Զ����ɵķ������
		return me.deleteMessageById(id);
	}

	@Override
	public int updateMessage(MessageInfo v) {
		// TODO �Զ����ɵķ������
		return me.updateById(v);
	}
}
