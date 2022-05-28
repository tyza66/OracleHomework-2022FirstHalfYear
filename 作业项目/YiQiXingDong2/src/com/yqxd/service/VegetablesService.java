package com.yqxd.service;

import java.util.List;

import com.yqxd.entity.Vegetables;

public interface VegetablesService {
	List<Vegetables> getAllVegetable();
	int addVegetable(Vegetables v);
	int deleteVegetable(int id);
	int updateVegetable(Vegetables v);
}
