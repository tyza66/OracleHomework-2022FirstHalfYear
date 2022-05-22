package com.yqxd.service;

import com.yqxd.entity.QuarantineAdmin;

public interface QuarantineAdminService {
	int login(String name, String pwd);
	int register(QuarantineAdmin q);
}
