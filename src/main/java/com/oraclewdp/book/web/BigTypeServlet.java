package com.oraclewdp.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.book.biz.BigTypeBiz;
import com.oraclewdp.book.biz.impl.BigTypeImpl;



/**
 * Servlet implementation class BigTypeServlet
 */
@WebServlet("/bigType")
public class BigTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//让填写存到数据库
		String name=request.getParameter("name");
		  
		BigTypeBiz bizTypeAdd=new BigTypeImpl();
		boolean  resut=bizTypeAdd.save(name);
		
		if(resut) {
			response.sendRedirect("main.jsp");
		}else {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/bigTypeAdd.jsp").forward(request, response);
		}
	}

}
