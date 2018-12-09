package com.oraclewdp.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclewdp.book.biz.SmallTypeBiz;
import com.oraclewdp.book.biz.impl.SmallTypeBizImpl;
import com.oraclewdp.book.util.MyBeanUtils;
import com.oraclewdp.book.model.SmallType;


/**
 * Servlet implementation class SmallTypeServlet
 */
@WebServlet("/smallType")
public class SmallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmallTypeServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 SmallType smallType=new SmallType();
		 MyBeanUtils.populate(smallType, request.getParameterMap());
		
		  SmallTypeBiz simTypeAdd=new SmallTypeBizImpl();
		 
		   boolean resut=simTypeAdd.save(smallType);
		   if(resut) {
			   response.sendRedirect("main.jsp");
		   }else {
			   request.setAttribute("simTypeAdd", simTypeAdd);
			   request.getRequestDispatcher("/smallTypeAdd.jsp").forward(request, response);
		   }
		 
	}

}
