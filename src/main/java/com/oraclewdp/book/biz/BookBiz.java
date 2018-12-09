package com.oraclewdp.book.biz;

import java.util.List;

import com.oraclewdp.book.model.Book;


public interface BookBiz {

	boolean save(Book book);

//	List<Book> findAll();



	List<Book> findAll(int currentPage, String name, int sid);


	int totalRow(String name, int sid);

	int delById(int id);

	Book findBookById(int id);

    boolean update(Book book);
}
