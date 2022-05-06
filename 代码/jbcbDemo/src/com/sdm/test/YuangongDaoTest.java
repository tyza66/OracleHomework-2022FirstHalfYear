package com.sdm.test;

import java.util.List;

import com.sdm.dao.YuangongDao;

public class YuangongDaoTest {
	public static void main(String[] args) {
		YuangongDao yd = new YuangongDao();
		List l = yd.selectAll();
		for(int i = 0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
	}

}
