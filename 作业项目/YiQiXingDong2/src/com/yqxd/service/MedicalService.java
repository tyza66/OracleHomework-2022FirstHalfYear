package com.yqxd.service;

import java.util.List;

import com.yqxd.entity.Medical;

public interface MedicalService {
	List<Medical> getAllMedical();
	int addMedical(Medical v);
	int deleteMedical(int id);
	int updateMedical(Medical v);
}
