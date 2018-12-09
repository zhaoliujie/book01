package com.oraclewdp.book.biz.impl;

import java.util.List;

import com.oraclewdp.book.biz.BigTypeBiz;
import com.oraclewdp.book.dao.BigTypeDao;
import com.oraclewdp.book.dao.impl.BigTypeDaoImpl;
import com.oraclewdp.book.model.BigType;



public class BigTypeImpl implements BigTypeBiz {

	@Override
	public boolean save(String name) {
		
		BigTypeDao bizTypeDao=new BigTypeDaoImpl();
		return bizTypeDao.save(name);
	}

	@Override
	public List<BigType> findAllBigType() {
		BigTypeDao bizTypeDao=new BigTypeDaoImpl();
		return bizTypeDao.findAll();
	}

}
