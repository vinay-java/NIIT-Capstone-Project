package com.controller.categoryoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.Category;
import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int categoryid;
	private String categoryname;
	private Category category;
     private CategoryDao categorydao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	


		    categoryid=Integer.parseInt(request.getParameter("categoryid"));
			categoryname		= request.getParameter("categoryname");
			category			= new Category();
		
			category.setId(categoryid);
			category.setName(categoryname);
			
			categorydao		= new CategoryDaoImpl();
			
			try 
			{
				if(categorydao.add(category) == 1)
				{
				    
					request.getRequestDispatcher("/GetAllCategory").forward(request, response);
				}
				else 
				{   
					request.getRequestDispatcher("/GetAllCategory").forward(request, response);
				}
			}
			
			catch (Exception exception) 
			{
				System.out.println("addcategory method in addcategory.java");
				exception.printStackTrace();
			}
		}

		


}
