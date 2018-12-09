package com.oraclewdp.book.dao;

import java.util.List;

import com.oraclewdp.book.model.BigType;



public interface BigTypeDao {

	
	List<BigType> findAll();

	boolean save(String name);


}
