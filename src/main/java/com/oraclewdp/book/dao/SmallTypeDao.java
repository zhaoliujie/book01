package com.oraclewdp.book.dao;

import java.util.List;

import com.oraclewdp.book.model.SmallType;


public interface SmallTypeDao {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

	int findBidById(int sid);
}
