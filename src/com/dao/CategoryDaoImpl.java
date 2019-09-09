package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Category;

import utility.ConnectionProvider;

public class CategoryDaoImpl implements CategoryDao
{
	private Connection connection;
	private List<Category> categoryList;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	private Category category;
	private int status;

	

	@Override
	public int add(Category category) 
	{
		
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "insert into category values(?,?)";
			preparedStatement = connection.prepareStatement(query);
	
			preparedStatement.setInt(1, category.getId());
			preparedStatement.setString(2, category.getName());
			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("exception in category daoimpl add()");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println(" CONNECTION CLOSING ");
				e.printStackTrace();
			}
		}
		
		return status;
	}

		
		
	

	@Override
	public int delete(int categoryid)
	{
		
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  ="SELECT * FROM PRODUCT WHERE CATEGORY_ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, categoryid);
			resultSet 		  = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				return status;
			}

			query			  = "DELETE FROM CATEGORY WHERE CATEGORY_ID=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, categoryid);

			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("category daoimpl DELETE()");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("CATEGORYDAOIMPL DELETE() CONNECTION CLOSING ");
				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public List<Category> getAll() {
	
		try
		{
			connection		  = ConnectionProvider.getConnection();
			categoryList  	  = new ArrayList<Category>();
			query			  = "select * from category";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				category = new Category();
				category.setId  (resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				categoryList.add(category);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println(" CATEGORYDAOIMPL  GETALL()");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println(" CATEGORYDAOIMPL GETALL() CONNECTION CLOSING");
				e.printStackTrace();
			}
		}
		
			
		return categoryList;
	}



}
