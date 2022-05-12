package com.sdm.service.imp;

import java.util.List;

import com.sdm.entity.Bumen;
import com.sdm.mapper.BumenMapper;
import com.sdm.service.BumenService;

public class BumenServiceImp implements BumenService {
	BumenMapper bumenMapper = new BumenMapper();

	@Override
	public List<Bumen> bumenInfo() {
		return bumenMapper.selectAll();
	}
	
	@Override
	public int bumenAdd(Bumen bumen) {
		return bumenMapper.insert(bumen);
	}
}
