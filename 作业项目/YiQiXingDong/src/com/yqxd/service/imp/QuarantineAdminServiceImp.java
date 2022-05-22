package com.yqxd.service.imp;

import com.yqxd.entity.QuarantineAdmin;
import com.yqxd.mapper.QuarantineAdminMapper;
import com.yqxd.service.QuarantineAdminService;

public class QuarantineAdminServiceImp implements QuarantineAdminService {
	QuarantineAdminMapper qam = new QuarantineAdminMapper();
	@Override
	public int login(String name, String pwd) {
		QuarantineAdmin quarantineAdmin = qam.selectByName(name);
		if (quarantineAdmin == null) {
			// 若结果为空则该用户不存在返回404
			return 404;
		} else if (!quarantineAdmin.getAdmin_password().equals(pwd)) {
			// 若用户存在但是密码错误，则返回500
			return 500;
		} else {
			//若以上两个条件均不成立则登陆成功
			return 200;
		}
	}
	@Override
	public int register(QuarantineAdmin q) {
		return qam.insert(q);
	}
}
