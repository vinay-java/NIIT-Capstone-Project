package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
import com.dao.UserDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  private  UserBean userbean;
	  private UserDao userdao;
	 private HttpSession session;
	  private RequestDispatcher requestdispather;
	  public String message="";
	  public String loginmsg=""; 
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		userbean =new UserBean();
	    session = request.getSession();
		 
		userbean.setUsername(uname);
		userbean.setPassword(pass);
		
		userdao=new UserDaoImpl();
		
		loginmsg=userdao.validatebyusername(userbean);
	
		
		if(loginmsg.equalsIgnoreCase("success"))
		{
		
			session.setAttribute("password",userbean.getPassword());
		    session.setAttribute("contact",userbean.getContact());
		    session.setAttribute("email",userbean.getEmail());
		    session.setAttribute("address",userbean.getAddress());
	     
	     session.setAttribute("true",userbean.getUsername());
	     requestdispather=request.getRequestDispatcher("/home.jsp");
		 requestdispather.forward(request, response);
	     
		}
		else
		{
			message="Either Name Or Password Is Wrong! ";
			request.setAttribute("false",message);
			requestdispather=request.getRequestDispatcher("/index.jsp");
		    requestdispather.forward(request, response);
		}
		
		
		
	}

}
