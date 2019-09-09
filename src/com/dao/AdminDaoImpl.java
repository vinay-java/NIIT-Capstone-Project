package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bean.AdminBean;

import utility.ConnectionProvider;

public class AdminDaoImpl implements AdminDao {

	
	

	
		private Connection connection;
		private PreparedStatement preparedstatement;
		private String query;
		public boolean flag=false;
		public String loginmsg="";
		
		//add user method of UserDao
		
				@Override
		public String validatebyId(AdminBean adminbean) 
		{
			try
			{
				
	       query="select * from admin where adminid=? and password=?";	
	       connection =ConnectionProvider.getConnection();
	       preparedstatement =connection.prepareStatement(query);
	   
	       
	       preparedstatement.setInt(1,adminbean.getAdminid());
	       preparedstatement.setString(2, adminbean.getPassword());
	    
	     
	       ResultSet resultset=preparedstatement.executeQuery();
	     
	    
	     if(resultset.next())
	     {
	   
	    	  loginmsg="success";
	    
	     }
	     else
	     {
	    	 loginmsg="failure";
	     }
	     
	       return loginmsg;
			}
			catch(SQLException e)
			{
				System.out.println("--------EXCEPTION IN ADMIN DAO IMPL  VALIDATE EBY USER NAME---------");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try
				{
					if(connection!=null)
					{
						connection.close();
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			return loginmsg;
		}
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	