package com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.UserBean;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
  private  UserBean userbean;
  private UserDao userdao;
  private RequestDispatcher requestdispather;
  private boolean workchecker;
  public String message=""; 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
		
		response.setContentType("text/html");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String uemail=request.getParameter("email");
		Long cno=Long.parseLong(request.getParameter("contact"));
		String addr=request.getParameter("address");
		 
		
		
		userbean =new UserBean();
		
		userbean.setUsername(uname);
		userbean.setPassword(pass);
		userbean.setEmail(uemail);
		userbean.setContact(cno);
		userbean.setAddress(addr);
		
		userdao=new UserDaoImpl();
		
		workchecker=userdao.addUser(userbean);
		
			if(workchecker==true)
			{
		     message=uname+" "+" successfully registerd";
		     request.setAttribute("true",message);
		     requestdispather =request.getRequestDispatcher("/index.jsp");
		     requestdispather.forward(request, response);
			}
			else
			{
				message="something went wrong!!";
				request.setAttribute("false",message);
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
			}
	   
	
		
	}

}
