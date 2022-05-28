package com.yqxd.service.imp;

import java.util.List;

import com.yqxd.entity.Vegetables;
import com.yqxd.mapper.VegetablesMapper;
import com.yqxd.service.VegetablesService;

public class VegetablesServiceImp implements VegetablesService {
	VegetablesMapper vm = new VegetablesMapper();

	@Override
	public List<Vegetables> getAllVegetable() {
		return vm.selectAll();
	}

	@Override
	public int addVegetable(Vegetables v) {
		return vm.addToVegetable(v);
	}

	@Override
	public int deleteVegetable(int id) {
		return vm.deleteVegetableById(id);
	}

	@Override
	public int updateVegetable(Vegetables v) {
		return vm.updateById(v);
	}

}
