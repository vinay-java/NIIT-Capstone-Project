package com.dao;

import java.util.List;

import com.bean.Category;

public interface CategoryDao {
	
	public int add(Category category);
	public int delete(int categoryId);
	public List<Category> getAll();
}
