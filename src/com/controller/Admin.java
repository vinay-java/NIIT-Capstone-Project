package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;





@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private AdminBean adminbean;
	  private AdminDao admindao;
	  private HttpSession session;
	  private RequestDispatcher requestdispather;
	  public String message="";
	  public String loginmsg=""; 
	 
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

		
		
			response.setContentType("text/html");
			int uid=Integer.parseInt(request.getParameter("uid"));
			String pass=request.getParameter("upass");
			
			adminbean =new AdminBean();
		    session = request.getSession();
			 
			adminbean.setAdminid(uid);
			adminbean.setPassword(pass);
			
			admindao=new AdminDaoImpl();
			
			loginmsg=admindao.validatebyId(adminbean);
		    
			
			System.out.println(loginmsg);
			
			if(loginmsg.equalsIgnoreCase("success"))
			{
		     message="you are valid Admin...";
		     session.setAttribute("true",message);
		     requestdispather=request.getRequestDispatcher("/adminhome.jsp");
			 requestdispather.forward(request, response);
		     
			}
			else
			{
				message="Either Name Or Password Is Wrong! ";
				request.setAttribute("false",message);
				requestdispather=request.getRequestDispatcher("/adminlogin.jsp");
			    requestdispather.forward(request, response);
			}
			
			
			
		}

	
	
	

}
