package com.controller.categoryoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;

@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private int categoryid;
	private CategoryDao categorydao;
	private int status;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			categoryid  = Integer.parseInt(request.getParameter("id"));
			categorydao = new CategoryDaoImpl();
			status 	    = categorydao.delete(categoryid);
			
			if(status == 1)
			{
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
			}
			else
			{
				System.out.println("not deleted");
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("inside deleteCategory sewrvlet");
			e.printStackTrace();
		}
	}


}
