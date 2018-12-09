package com.oraclewdp.book.biz;

import java.util.List;

import com.oraclewdp.book.model.SmallType;

public interface SmallTypeBiz {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

    int findBidById(int sid);
}
