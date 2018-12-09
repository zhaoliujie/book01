package com.oraclewdp.book.biz.impl;

import java.util.List;

import com.oraclewdp.book.biz.BookBiz;
import com.oraclewdp.book.dao.BookDao;
import com.oraclewdp.book.dao.impl.BookDaoImpl;
import com.oraclewdp.book.model.Book;

public class BookBizImpl implements BookBiz {

	@Override
	public boolean save(Book book) {
		BookDao bookAddDao=new BookDaoImpl();
		
		return bookAddDao.save(book);
	}
	@Override
	public List<Book> findAll(int currentPage,String name,int sid) {
		BookDao bookAddDao=new BookDaoImpl();
	return bookAddDao.findAll(currentPage,name,sid);
	}
@Override
	public int totalRow(String name, int sid) {
		BookDao bookAddDao=new BookDaoImpl();
		return bookAddDao.total(name,sid);
	}
@Override
public int delById(int id) {
	BookDao bookAddDao=new BookDaoImpl();
	return bookAddDao.del(id);
}

	@Override
	public Book findBookById(int id) {
		BookDao bookAddDao=new BookDaoImpl();
		return bookAddDao.find(id);
	}

	@Override
	public boolean update(Book book) {
		BookDao bookAddDao=new BookDaoImpl();
		return  bookAddDao.update(book);
	}


}
