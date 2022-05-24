package com.yqxd.service.imp;

import java.util.List;

import com.yqxd.entity.Medical;
import com.yqxd.mapper.MedicalMapper;
import com.yqxd.service.MedicalService;

public class MedicalServiceImp implements MedicalService{
	MedicalMapper me = new MedicalMapper();

	@Override
	public List<Medical> getAllMedical() {
		// TODO 自动生成的方法存根
		return me.selectAll();
	}

	@Override
	public int addMedical(Medical v) {
		// TODO 自动生成的方法存根
		return me.addToMedical(v);
	}

	@Override
	public int deleteMedical(int id) {
		// TODO 自动生成的方法存根
		return me.deleteMedicalById(id);
	}

	@Override
	public int updateMedical(Medical v) {
		// TODO 自动生成的方法存根
		return me.updateById(v);
	}
}
