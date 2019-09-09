package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOutUserServlet")
public class LogOutUserServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		session=request.getSession(false);
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); 
        		
		if(session != null)
		{
			session.invalidate();
		}
		//request.getRequestDispatcher("/UpdateApplication").include(request, response);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


	
	
	
}
