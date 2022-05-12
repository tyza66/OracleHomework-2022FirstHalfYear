package com.sdm.service;

import java.util.List;

import com.sdm.entity.Bumen;

public interface BumenService {
	List<Bumen> bumenInfo();
	int bumenAdd(Bumen bumen);
	int bumenUpdate(Bumen bumen);
	int bumenDelete(int id);
}
