package com.yqxd.service;

import java.util.List;

import com.yqxd.entity.MessageInfo;
import com.yqxd.entity.Vegetables;

public interface MessageInfoService {
	List<MessageInfo> getAllMessage();
	int addMessage(MessageInfo v);
	int deleteMessage(int id);
	int updateMessage(MessageInfo v);
}
