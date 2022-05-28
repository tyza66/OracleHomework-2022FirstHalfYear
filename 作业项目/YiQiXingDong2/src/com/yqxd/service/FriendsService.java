package com.yqxd.service;

import com.yqxd.entity.Friends;

public interface FriendsService {
	public Friends getFriends();
	public int pushFriends(Friends f);
}
