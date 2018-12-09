package com.oraclewdp.book.web;

import com.oraclewdp.book.biz.BookBiz;
import com.oraclewdp.book.biz.impl.BookBizImpl;
import com.oraclewdp.book.biz.impl.SmallTypeBizImpl;
import com.oraclewdp.book.biz.SmallTypeBiz;
import com.oraclewdp.book.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToBookEditServlet", value = "/toBookEdit")

public class ToBookEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);
/*
String StrBid=request.getParameter("bid");
int bid=Integer.parseInt(StrBid);*/

        BookBiz bookBiz = new BookBizImpl();
        Book book = bookBiz.findBookById(id);
        SmallTypeBiz smallTypeBiz = new SmallTypeBizImpl();
        int bid = smallTypeBiz.findBidById(book.getSid());
        //回填数据的bid
        request.setAttribute("book", book);
        request.setAttribute("bid", bid);
        request.getRequestDispatcher("/bookEdit.jsp").forward(request, response);


    }
}
