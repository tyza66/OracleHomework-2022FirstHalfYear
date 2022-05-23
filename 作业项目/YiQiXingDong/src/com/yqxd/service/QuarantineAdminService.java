package com.yqxd.service;

import com.yqxd.entity.QuarantineAdmin;

public interface QuarantineAdminService {
	int login(String phone, String pwd);
	int register(QuarantineAdmin q);
	String getUsername(String phone);
}
