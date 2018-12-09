package com.oraclewdp.book.biz;

import java.util.List;

import com.oraclewdp.book.model.BigType;

public interface BigTypeBiz {



	List<BigType> findAllBigType();

	boolean save(String name);
   
}
