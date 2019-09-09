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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");	
		String password=request.getParameter("password");
		long contact=Long.parseLong(request.getParameter("contact"));
		String address=request.getParameter("address");
	
		UserBean userbean=new UserBean();
		
		session=request.getSession();
		
		String email=(String)session.getAttribute("email");
		
		userbean.setUsername(username);
		userbean.setPassword(password);
		userbean.setContact(contact);
		userbean.setAddress(address);
		
		
		
		UserDao userdao =new UserDaoImpl();
	
		boolean flag=userdao.update(userbean, email);
		
		if(flag==true)
		{
			
		String successmsg="Data is successfully Updated Login Again";	
	    request.setAttribute("true", successmsg);
	    RequestDispatcher requestdispather=request.getRequestDispatcher("index.jsp");
	    requestdispather.forward(request,response);
		
			
		}
		else
		{
			  String msg="something went wrong in update data";
			  request.setAttribute("false",msg);
			  RequestDispatcher requestdispather=request.getRequestDispatcher("UpdateUser.jsp");
			  requestdispather.forward(request,response);
		}
		
	
		
	}


}
