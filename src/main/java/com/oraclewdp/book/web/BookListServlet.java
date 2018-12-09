package com.oraclewdp.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.book.biz.BookBiz;
import com.oraclewdp.book.biz.impl.BookBizImpl;
import com.oraclewdp.book.util.PageConstant;
import com.oraclewdp.book.model.Book;


@WebServlet(name="bookList",value="/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strCurrentPage=request.getParameter("currentPage");
		if(strCurrentPage==null) {//没有选择时
			strCurrentPage="1";//默认第一页
		}
		int currentPage=Integer.parseInt(strCurrentPage);
		//name ,sid
		String name=request.getParameter("name");
		String strSid=request.getParameter("sid")==null?"-1":request.getParameter("sid");
		int sid=Integer.parseInt(strSid);
		String strBid=request.getParameter("bid")==null?"-1":request.getParameter("bid");
		int bid=Integer.parseInt(strBid);

		 BookBiz bookBiz=new BookBizImpl();  
		 List<Book> ls=bookBiz.findAll(currentPage,name,sid);
		 int totalRow=bookBiz.totalRow(name, sid);
		 int totalPage=totalRow%PageConstant.PAGE_SIZE==0?totalRow/PageConstant.PAGE_SIZE:totalRow/PageConstant.PAGE_SIZE+1;
		 request.setAttribute("totalPage", totalPage);
		 request.setAttribute("currentPage", currentPage);
		 request.setAttribute("ls", ls);
		 request.setAttribute("bid", bid);
		 request.setAttribute("sid", sid);
		 request.getRequestDispatcher("ListBook.jsp").forward(request, response);
		 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
