package com.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;



@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String password;
	private String email;
	private RequestDispatcher requestdispathcher;
	private UserDao userdao;
	private boolean status;
	public String msg="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			email		 = request.getParameter("uemail");
			password  	 = request.getParameter("newupass");
			userdao = new UserDaoImpl();
			status 		 = userdao.updatePassword(email, password);
			
			
			if(status == true)
			{
				msg="Password Forgoted Successfully";
				request.setAttribute("true", msg);
				requestdispathcher=request.getRequestDispatcher("/index.jsp");
				requestdispathcher.forward(request, response);
			}
			else
			{
				msg="Sorry your Email is Wrong!!";
				request.setAttribute("false", msg);
				requestdispathcher=request.getRequestDispatcher("/updatepassword.jsp");
				requestdispathcher.forward(request, response);
			}
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("exception from update password catch block");
			exception.printStackTrace();
		}
	}

}
