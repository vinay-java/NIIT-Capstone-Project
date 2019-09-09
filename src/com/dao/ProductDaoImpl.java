package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Product;

import utility.ConnectionProvider;

public class ProductDaoImpl implements ProductDao{

	private Connection connection;
	private List<Product> products;
	private PreparedStatement preparedStatement;
	private Product product;
	private ResultSet resultSet;
	private String query;
	private int check;
	
	
	@Override
	public int add(Product product)
	{
		try 
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "insert into product values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);	
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(5, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt(6, product.getQuantity());
			preparedStatement.setInt(4, product.getCategoryId());
			preparedStatement.setString(7, product.getImage());
			check = preparedStatement.executeUpdate();
		} 
		
		catch (SQLException e) 
		{
			System.out.println("exception in productdaoimpl");
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
				System.out.println("productdaoimpl connection closing");
				e.printStackTrace();
			}
		}

		return check;
	}


	
////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public int delete(int id) {
	
		return 0;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public List<Product> getProducts(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
