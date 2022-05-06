package com.sdm.test;

import java.util.List;

import com.sdm.dao.YuangongDao;
import com.sdm.entity.Yuangong;

public class YuangongDaoTest {
	public static void main(String[] args) {
		YuangongDao yd = new YuangongDao();
		yd.insert(new Yuangong(1234,"ll","123",111,"2011-01-01",9999,999,32));
		List l = yd.selectAll();
		for(int i = 0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
	}

}
