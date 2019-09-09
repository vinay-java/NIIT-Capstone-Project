package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDao 
{


	public int add(Product product);
	public int delete(int id);
	public int update(Product product);
	public Product getProduct(int id);
	public List<Product> getProducts(int categoryId);
	public List<Product> getAllProducts();
	
	
}
