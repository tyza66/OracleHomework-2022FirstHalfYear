package com.yqxd.service;

import java.util.List;

import com.yqxd.entity.QuarantineQuarantine;

public interface QuarantineQuarantineService {
	List<QuarantineQuarantine> getQuarantineQuarantine();
	
	int addQuarantineQuarantine(QuarantineQuarantine a);
	
	int deleteQuarantineQuarantine(String id);
	
	int updateQuarantineQuarantine(QuarantineQuarantine a);
}
