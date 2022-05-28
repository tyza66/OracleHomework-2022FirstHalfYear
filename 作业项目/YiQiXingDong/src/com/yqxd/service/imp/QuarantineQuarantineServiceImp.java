package com.yqxd.service.imp;

import java.util.List;

import com.yqxd.entity.QuarantineQuarantine;
import com.yqxd.mapper.QuarantineQuarantineMapper;
import com.yqxd.service.QuarantineQuarantineService;

public class QuarantineQuarantineServiceImp implements QuarantineQuarantineService {
	QuarantineQuarantineMapper qqm=new QuarantineQuarantineMapper();
	@Override
	public List<QuarantineQuarantine> getQuarantineQuarantine() {
		// TODO Auto-generated method stub
		return qqm.getQuarantineQuarantine();
	}

	@Override
	public int addQuarantineQuarantine(QuarantineQuarantine a) {
		// TODO Auto-generated method stub
		return qqm.addToQuarantineQuarantine(a);
	}

	@Override
	public int deleteQuarantineQuarantine(String id) {
		// TODO Auto-generated method stub
		return qqm.deleteQuarantineQuarantineById(id);
	}

	@Override
	public int updateQuarantineQuarantine(QuarantineQuarantine a) {
		// TODO Auto-generated method stub
		return qqm.updateById(a);
	}
}
