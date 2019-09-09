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


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		
		session=request.getSession(true);
		UserBean userbean=new UserBean();
		userbean.setUsername((String)session.getAttribute("true"));
		UserDao userdao=new UserDaoImpl();
	    boolean check=userdao.delete(userbean);
		if(check==true)
		{
			String successmsg="You Are Successfully Deleted";	
		    request.setAttribute("true", successmsg);
		    RequestDispatcher requestdispather=request.getRequestDispatcher("signup.jsp");
		    requestdispather.forward(request,response);
			
			
		}else
		{
			
			  RequestDispatcher requestdispather=request.getRequestDispatcher("home.jsp");
			  requestdispather.forward(request,response);
		}
		
		
	}



}
