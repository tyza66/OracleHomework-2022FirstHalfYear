package com.yqxd.service;

import java.util.List;

import com.yqxd.entity.QuarantineAdmin;


public interface QuarantineAdminService {
	int login(String phone, String pwd);
	int register(QuarantineAdmin q);
	String getUsername(String phone);
	
	List<QuarantineAdmin> getAllAdmin();
	int addQuarantineAdmin(QuarantineAdmin v);
	int deleteQuarantineAdmin(int id);
	int updateQuarantineAdmin(QuarantineAdmin v);
}
