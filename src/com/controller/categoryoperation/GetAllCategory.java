package com.controller.categoryoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;

@WebServlet("/GetAllCategory")
public class GetAllCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryDao categorydao;
	private HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			categorydao = new CategoryDaoImpl();
			session = request.getSession(false);
			
			if(session != null)
			   session.setAttribute("categories", categorydao.getAll());
               request.getRequestDispatcher("/category.jsp").forward(request, response);
		}
		
		catch(Exception exception)
		{
			System.out.println("getAllCategory.java servlet");
			exception.printStackTrace();
		}
		
	}


}
