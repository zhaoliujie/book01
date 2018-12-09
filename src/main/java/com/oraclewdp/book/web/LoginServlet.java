package com.oraclewdp.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.oraclewdp.book.biz.AdminBiz;
import com.oraclewdp.book.biz.impl.AdminBizImp;
import com.oraclewdp.book.model.Admin;
import com.oraclewdp.book.util.MyBeanUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		Admin admin=new Admin();
		//接收用户输入的属性放到user中
		MyBeanUtils.populate(admin, request.getParameterMap());
		//如果验证码不对， 流程不走
		String vcode=request.getParameter("vcode");
	String serverVcde= (String) request.getSession().getAttribute("validateCode");
	/*
	//不区分大小写

		if( !serverVcde.equalsIgnoreCase(vcode)){
			request.setAttribute("msg","验证码有误");
			request.setAttribute("admin", admin);//把用户填的信息带过去
			//注册未成功，继续进入注册页面。回填 jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//登陆校验
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		//违反约束
		Set<ConstraintViolation<Admin>> constraintViolations = validator.validate(admin);
//判断
		if (constraintViolations.size() >0){
			Map<String, String> errors=new HashMap<String, String>();
			for (ConstraintViolation<Admin> con:
					constraintViolations) {
				errors.put(con.getPropertyPath().toString(),con.getMessage());
			}
			request.setAttribute("errors",errors);
			request.setAttribute("admin", admin);//把用户填的信息带过去
			//注册未成功，继续进入注册页面。回填 jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
*/
	//把验证码， 登陆三个信息放在一起验证
		Map<String, String> errors=new HashMap<String, String>();
		if( !serverVcde.equalsIgnoreCase(vcode)) {
			errors.put("vcode","验证码错误");
		}
		//登陆校验
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		//违反约束
		Set<ConstraintViolation<Admin>> constraintViolations = validator.validate(admin);
//判断
		if (constraintViolations.size() >0) {

			for (ConstraintViolation<Admin> con : constraintViolations) {
				errors.put(con.getPropertyPath().toString(), con.getMessage());
			}
		}
		if (errors.size()>0){
			request.setAttribute("errors",errors);
			request.setAttribute("admin", admin);//把用户填的信息带过去
			//注册未成功，继续进入注册页面。回填 jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}




//		数据库比对 
		AdminBiz adminBiz=new AdminBizImp();
		boolean b= adminBiz.findAdmin(admin);
		if(b) {
			request.getSession().setAttribute("hasLogined","true");
			//进入登陆成功网页
			request.getRequestDispatcher("main.jsp").forward(request, response);

	}else {
			//通过Session把信息带过去


		request.setAttribute("admin", admin);//把用户填的信息带过去
			//注册未成功，继续进入注册页面。回填 jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}
		
	}
		
	}


