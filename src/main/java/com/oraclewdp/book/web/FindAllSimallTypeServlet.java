package com.oraclewdp.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oraclewdp.book.biz.SmallTypeBiz;
import com.oraclewdp.book.biz.impl.SmallTypeBizImpl;
import com.oraclewdp.book.model.SmallType;


/**
 * Servlet implementation class FindAllSimallTypeServlet
 */
@WebServlet("/findAllSimallType")
public class FindAllSimallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindAllSimallTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("bid");
		int bid=Integer.parseInt(str);
		String callBack=request.getParameter("callback");
		SmallTypeBiz simTypeAdd=new SmallTypeBizImpl();
		
		List<SmallType> ls=simTypeAdd.findAllByBid(bid);
		
		//告诉客户端发送的是js
				response.setContentType("text/javascript;charset=utf-8");
				//发出去用流
				PrintWriter out=response.getWriter();
				JSONArray jsonArray=new JSONArray(ls);
				//服务器返回的js调用客户端的某个函数,用JSON格式填充 
				 //又称jsonp
				out.println(callBack+"("+jsonArray.toString()+")");
				out.flush();
	}

}
