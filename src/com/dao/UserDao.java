package com.dao;

import java.util.List;

import com.bean.UserBean;

public interface UserDao 
{

public boolean addUser(UserBean userbean);	
public  String validatebyusername(UserBean userbean);
public boolean delete(UserBean userbean);
public boolean update(UserBean userbean,String email);
public UserBean getCustomer(String email);
public List<UserBean> getAllCustomers();
public boolean updatePassword(String email,String newPassword);
	
}
