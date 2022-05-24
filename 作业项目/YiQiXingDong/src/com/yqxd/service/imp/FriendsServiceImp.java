package com.yqxd.service.imp;

import com.yqxd.entity.Friends;
import com.yqxd.mapper.FriendsMapper;
import com.yqxd.service.FriendsService;

public class FriendsServiceImp implements FriendsService {
	FriendsMapper fm = new FriendsMapper();

	@Override
	public Friends getFriends() {
		return fm.getFriends();
	}

	@Override
	public int pushFriends(Friends f) {
		return fm.updateById(f);
	}

}
